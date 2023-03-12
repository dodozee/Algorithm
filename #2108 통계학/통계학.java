import java.io.*;
import java.util.*;

public class Main { //나라사랑 가천사랑 동기사랑 !!!화티잉!!!!!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int sum =0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        System.out.println((int)Math.round((double)sum/arr.length)); //평균

        Arrays.sort(arr); //정렬 후

        int center = arr[(arr.length-1) /2];// 홀수니까 중간값이 1개뿐
        System.out.println(center);//중앙값 출력
        int ans =0; //최빈값
        int[] index = new int[8001]; //최빈값 계산할 배열 생성
        List<Integer> list = new ArrayList<>(); //-4000~4000까지 담을수 있는  리스트
        int cnt = Integer.MIN_VALUE; //최대 빈도수를 담을 그릇

        for(int i=0; i<n; i++){
           index[arr[i]+4000]++;// 값별 index에 cnt 추가
        }

        for (int i = 0; i < 8001; i++) {
            if (index[i] > cnt) {
                cnt=index[i];
            }
        }
        for (int i = 0; i < 8001; i++) {
            if (index[i]==cnt) {
                list.add(i - 4000);
            }
        }
        if (list.size() == 1) {
            System.out.println(list.get(0));
        }else{
            Collections.sort(list);
            System.out.println(list.get(1));//제일 많이 나온 숫자가 여러 개 있을 때는 최빈값이 두번째로 작은 값을 출력한다.
        }
       // System.out.println(cnt);//로그용// 최대빈도수 카운팅 확인용

        int max = arr[arr.length - 1]; //최대값
        int min = arr[0];//최소값
        int minus = max-min;//최대값-최소값

        System.out.println(minus);//젤 큰값 젤 작은값 차이 출력

        }
    }
