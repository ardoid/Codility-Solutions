class Solution {
    public int solution(int[] A) {
        //int[] sum = new int[A.length+1];
        final int MIN = -10001;
        int ans = A[0];
        int skip = 0;
        int maxskip = MIN, nexskip = MIN;
        int idxskip = 0;
        for (int i=1; i<A.length-1; ++i)  {
            if (A[i] >= 0) {
                ans += A[i];
                skip = 0;
                maxskip = MIN;
            } else {
                skip++;
                if (A[i] >= maxskip)  {
                    maxskip = A[i];
                    nexskip = MIN;
                    idxskip = skip;
                } else {
                    nexskip = Math.max(A[i], nexskip);
                }
                if (skip >= 6)  {
                    ans += maxskip;
                    skip = 6 - idxskip;
                    maxskip = nexskip;
                    nexskip = MIN;
                }
            }
        }
        return ans+A[A.length-1];
    }
}
