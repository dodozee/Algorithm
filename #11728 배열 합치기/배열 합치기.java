import java.util.*;

public class Main {//박두지 화이팅!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 배열 A의 크기와 내용 입력 받기
        int sizeA = scanner.nextInt();
        int sizeB = scanner.nextInt();

        int[] arrayA = new int[sizeA];
        for (int i = 0; i < sizeA; i++) {
            arrayA[i] = scanner.nextInt();
        }

        // 배열 B의 크기와 내용 입력 받기
        int[] arrayB = new int[sizeB];
        for (int i = 0; i < sizeB; i++) {
            arrayB[i] = scanner.nextInt();
        }

        // 두 배열 합치기
        int[] mergedArray = mergeArrays(arrayA, arrayB);

        // 배열 정렬하기
        List<Integer> mergedList = new ArrayList<>();
        for (int num : mergedArray) {
            mergedList.add(num);
        }
        Collections.sort(mergedList);

        // 정렬된 배열 출력하기
        StringBuilder sb = new StringBuilder();
        for (int num : mergedList) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString());
    }

    // 두 배열을 합치는 메소드
    public static int[] mergeArrays(int[] arrayA, int[] arrayB) {
        int sizeA = arrayA.length;
        int sizeB = arrayB.length;
        int[] mergedArray = new int[sizeA + sizeB];

        // 배열 A 복사
        System.arraycopy(arrayA, 0, mergedArray, 0, sizeA);

        // 배열 B 복사
        System.arraycopy(arrayB, 0, mergedArray, sizeA, sizeB);

        return mergedArray;
    }
}
