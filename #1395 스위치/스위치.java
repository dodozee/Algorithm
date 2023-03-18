import java.io.*;
import java.util.*;

class Main {/* 미래의 서버 개발자 박두지 화이팅! 갓천대 컴공 화이팅!!

[문제 요약]

1. A번부터 B번까지 스위치 상태를 반전
2. C부터 D까지 스위치 중 켜져있는 상태의 스위치 개수를 세는 것.
3. N은 스위치의 갯수 M은 처리할 일의 갯수
4. 0 S T 또는 1 S T가 입력된다. 0이면 S부터 T까지 스위치를 반전하는 것이고 1이면 S부터 T까지 켜져 있는 스위치의 갯수를 물어보는 것.

[첫번째 틀린이유 : 시간 초과]
틀린 코드를 보면 알겠지만 처음엔 배열로 그냥 -1 또는 1을 2가지 상태로 넣고 단순 로직으로 짰는데
인텔리제이 IDE에서는 테스트 케이스가 잘 나왔다. 그래서 솔직히 내심 너무 쉽게 푼거같아서
안될거 예상했다. 예상대로 10퍼센트까지만 가다가 시간초과. 

[두번쨰 틀린이유 : 런타임에러(ArrayIndexOutOfBoundsException)]
lazy 배열을 선언할때 배열의 크기를 작게 한거같다. -> 노드를 배열에 저장하기 위해서는 "2n<트리의 노드배열 <4n" 이라고 한다. 최대로 설정하는게 배열을 벗어나지 않을거거같다.


문제 해석:
어떻게 풀지 모를 때는 가장 먼저 문제 아래 알고리즘 분류에 보니 lazy propagation segment tree에 관한 알고리즘이였다.
그래서 유튜브 알고리즘 영상과 lazy propagation에 대한 작동 원리를 블로그 같은데서 몇군데 찾아보다가
많이 어려웠지만 이해는 했다. 우선 segment tree는 complete tree(완전트리)로 이루어져 있는 알고리즘이다.
segment tree는 가장 basic한 것으론 일차 배열을(알고리즘 대회에선 이차배열도 있다.) 미리 sum, min, max, gcd같은 것을 자식노드가 합쳐지면서
빠른 연산처리를 도와주는 알고리즘인데 치명적인 단점은 하나의 leafNode를 쿼리(조회)하는 것은 빠르지만
구간의 합(합 말고도 최소값, 최대값, 최소공배수 등)을 구할 때는 리프에 위에 있는 영향이 닿는 모든 노드를
업데이트 해줘야하기때문에 수행시간 O(logN+k)이다. k는 구간의 크기이므로 구간이 커지면 오히려 느려지는 단점이 있어서
이걸 보완 하기위해서 업데이트하려는 구간에 당장 조회를 하지 않는다면 최대한 아주 최대한 느리게 업데이트(MergeBlock) 하는 세그먼트 트리이다.
구간 업데이트도 완전히 구간에 들어가는 중간 노드에 대해서는 Block을 하고 leafNode까지는 안 닿고 바로 return node를 해준다.
완전 구간에 들어가져 있지 않는 양 끝간 중간 노드들은 그전에 갱신하지 않고 대기해놨던 MergeBlock을 PushDown을하여
갱신을 시킨다.

개괄적인 해석은 이렇고 이에 적용하여 문제 방향을 제시하자면 3가지 경우를 먼저 말해주자면
lazy propagation을 하는 조건은 query 메서드가 [left, right]에 접근할때이다.
조회query 구간이 그 전 update 구간에 완벽하게 속할때 이다[left <= leftNode && right<=right]
mergeSum 메서드가 [left, right]구간에 접근할때 lazy propagation을 한다.
그리고 해당 노드가 lazy로 되어있다면 업데이트 해준다. 상태는 0,1 두가지 이기때문에 업데이트 갯수가 홀수인 경우에만
update를 실행해준다. 이유는 0->1->0  짝수는 결국 다시 제자리 상태로 돌아오기 때문이다.(lazy%2=1 만 업데이트)
leatNode인 경우에는 lazy propagtion은 필요없다. leafNode(말단 노드)가 아닌 경우 자식 노드들에게 lazy propagation를 물려준다.

[어려운점] 솔직히 작년 알고리즘 수업시간에 배운게 많이 도움 되었다.  lazy propagation segment tree 대해서는 배우지 않았지만
segment tree에 대해서는 배워서 비교적 다시 공부하기는 수월했다. recursive한 것도 이해하는데 좀 어려웠다.
한달이나 두달 뒤에 한번더 풀어봐야겠다.
*/
    static int[] tree;
    static int[] lazy;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        tree = new int[4 * n]; //tree는 원래 n크기 배열을 트리로 만들기때문에 complete tree 로는 2*n<노드 개수< 4*n 로 보기 때문에 안전하게 4*n을 잡는게 좋다.
        lazy = new int[4 * n]; //lazy도 똑같이 n*4해야하는 것이다. 2n이 최소라고 생각해서 혹시했는데 ArrayIndexOutOfBoundsException이 나왔다...

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String play = st.nextToken();
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            switch (play) { //스위치 반대로 누르는건지 개수를 묻는건지 따지는 곳.
                case "0":
                    updateQuery(1,n,1,S,T);
                    break;

                case "1":
                    sb.append(mergeSum(1, n,1,S,T)).append("\n");
            }

        }
        System.out.println(sb);
    }
   
    static void updateQuery(int left, int right, int node, int leftNode, int rightNode ){
        lazyPropagation(left, right, node);
        if (right < leftNode || rightNode < left) //업데이트 범위를 벗어났을 땐 return 을 한다.
            return;
        if(leftNode<=left && right<=rightNode){//업데이트 하려는 범위안에 완벽하게 속하면 
            lazy[node] = 1; 
            lazyPropagation(left,right,node);//recursive 
            return ;
        }
        int mid = left + (right -left)/2;
        updateQuery(left, mid, node*2, leftNode, rightNode);
        updateQuery(mid + 1, right, node * 2 + 1, leftNode, rightNode);
        tree[node] = tree[node * 2 ] + tree[node * 2+1];
     }

    static int mergeSum(int left, int right, int node, int leftNode, int rightNode) {
        lazyPropagation(left, right, node); // lazy를 해준다.
        if (right < leftNode || rightNode < left) { //합하려는 범위를 벗어났을 땐 return 0을 한다.
            return 0;
        }
        if (leftNode <= left && right <= rightNode) { //합치려는 범위 안에 완벽하게 속할땐 mergeSum메서드를 하지말고 바로 tree[node]로 반환시킨다.
            return tree[node];
        }
        int mid = left + (right -left)/2; // 그외 중간을 구한다 또 다른 공식은 mid = (left+right)2로 해도된다.
        return mergeSum(left, mid, node * 2, leftNode, rightNode) + mergeSum(mid + 1, right, node * 2 + 1, leftNode, rightNode);
        // 왼쪽 아래 자식 아랫부분의 node 번호는 완전 트리의 특징에 따라 node *2하면 노드 번호이고 오른쪽 node 번호는 node*2하고 +1 해준다.
    }
    static void lazyPropagation(int left, int right, int node) { //lazy 하는건 
        if(lazy[node] % 2 == 1){ // 만약 lazy된 노드가 홀수이면 
            if (left!= right) { //왼쪽 노드와 오른쪽 노드가 다르다면
                lazy[node * 2] += lazy[node];// 더해준다
                lazy[node * 2 + 1] += lazy[node];// 위쪽 노드에 더해준다.
            }
            tree[node] = right-left - tree[node]+1;
            lazy[node] = 0;
        }
    }

}

