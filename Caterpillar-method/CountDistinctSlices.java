class Solution {
    public int solution(int M, int[] A) {
        boolean seen[] = new boolean[M+1];
        int b=0, f=0, l=A.length;
        int sum=0;
        final int max=1000000000;
        while ( f < l && b < l )  {
            while ( f < l && !seen[A[f]] )  {
                sum += (f-b) + 1;
                if ( sum > max ) return max;
                seen[A[f]] = true;
                f++;
            }
            while ( f < l && seen[A[f]] )  {
                seen[A[b]] = false;
                b++;
            }
        }
        return sum;
    }
}
