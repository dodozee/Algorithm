import java.io.*;
import java.util.*;

class Main {/* 박두지 화이팅! 갓천대 화이팅!!
트라이를 이용하여 풀었다. 작년에 학교 수업 자료구조시간에 배워 익숙한듯하면서 다소 생소했지만
다시 책을 펼쳐 공부를 하고 풀어보니 풀만 했다.
 */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        TrieNode trie = new TrieNode();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j = Integer.parseInt(st.nextToken());

            StringBuilder sb = new StringBuilder(); //한번에 출력하기 위해 sb 생성.
            for (int k = 1; k < j + 1; k++) {
                sb.append(st.nextToken() + ","); //
            }
            trie.insert(sb.toString());

        }
        trie.print(trie, 0);
    }

    static class TrieNode {
        HashMap<String, TrieNode> childNode = new HashMap<>(); //TrieNode 의 자식 노드를 저장한다.

        TrieNode() {//기본생성자

        }

        public void insert(String string) { //입력은 루트 노드부터 시작된다.
            TrieNode trieNode = this; //지금 인스턴스를 넣어줘서 가리키게된다.
            String[] str = string.split(","); // string을 ,단위로 쪼개어 문자열에 저장한다.
            for (int i = 0; i < str.length; i++) {

                trieNode.childNode.putIfAbsent(str[i], new TrieNode());// key값이 없다면 key, value를 추가한다.
                trieNode = trieNode.childNode.get(str[i]); //그리고 추가한 key값에 대응하는 value값을 trieNode의 자식에 넣는다.
            }
        }

        public void print(TrieNode current, int depth) {// 모두 순회하기 위해서 재귀적으로 접근한다. 노드들의 깊이에 따라서 --를 추가하면된다.
            TrieNode trieNode = current;
            if (trieNode.childNode != null) {//자식노드가 null이기 직전까지.
                ArrayList<String> list = new ArrayList<>(trieNode.childNode.keySet());//해당 맵의 키값을 가져와준다->ArrayList로 만듦.
                Collections.sort(list);//사전적 순서를 출력하기 위한 정렬
                for (String str : list) {
                    for (int j = 0; j < depth; j++) {
                        System.out.print("--"); //한 층씩 깊어질 때마다 "--" 붙힌다.
                    }
                    System.out.println(str); //list를 순차적으로 출력
                    print(trieNode.childNode.get(str), depth + 1);//재귀함수
                }
            }
        }

    }
}
