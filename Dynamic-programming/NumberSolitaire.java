class Solution {
    public int solution(int[] A) {
        final int MIN = -10001;
        int ans = A[0];
        int skip = 0;
        int maxskip = MIN;
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
                    idxskip = skip;
                }
                if (skip >= 6)  {
                    ans += maxskip;
                    skip = 6 - idxskip;
                    maxskip = MIN;
                }
            }
        }
        return ans+A[A.length-1];
    }
}
