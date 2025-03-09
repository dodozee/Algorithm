class Solution {
    public int solution(int[][] sizes) {
            int answer = 0;
        int biggestOfBigger = 0;
        int biggestOfSmaller = 0;


        int size = sizes.length;

        for (int i = 0; i < size; i++) {
            int i1 = sizes[i][0];
            int i2 = sizes[i][1];

            int v = Math.max(i1, i2);
            int h = Math.min(i1, i2);

            biggestOfBigger = Math.max(biggestOfBigger, v);
            biggestOfSmaller = Math.max(biggestOfSmaller, h);
            
        }

        answer = biggestOfBigger * biggestOfSmaller;

        return answer;
    }
}