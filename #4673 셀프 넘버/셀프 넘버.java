public class Main {//두지 화이팅!!!!
    public static void main(String[] args) {
        boolean[] selfNumbers = new boolean[10001]; // 셀프 넘버를 저장할 배열
        for (int i = 1; i <= 10000; i++) {
            int dn = d(i); // 각 숫자 i에 대해 d(n) 함수를 적용한 결과
            if (dn <= 10000) { // 결과가 10000 이하인 경우에만 셀프 넘버 배열에서 제거
                selfNumbers[dn] = true;
            }
        }
        for (int i = 1; i <= 10000; i++) {
            if (!selfNumbers[i]) { // 셀프 넘버인 경우에만 출력
                System.out.println(i);
            }
        }
    }

    public static int d(int n) {
        int sum = n;
        String str = String.valueOf(n); // 숫자를 문자열로 변환
        for (int i = 0; i < str.length(); i++) {
            sum += Character.getNumericValue(str.charAt(i)); // 각 자리수를 더함
        }
        return sum;
    }
}
