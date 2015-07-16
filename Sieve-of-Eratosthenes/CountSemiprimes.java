class Solution {
    private int[] F;
    private int[] sp;
    
    private void arrayF(int n) {
        F = new int[n+1];
        int i = 2;
        while (i * i <= n)  {
            if (F[i] == 0)  {
                int k = i * i;
                while (k <= n)  {
                    if (F[k] == 0) F[k] = i;
                    k += i;
                }                
            }
            i++;
        }
    }
    
    private void factorize(int n)  {
        sp = new int[n+1];
        for (int i = 4; i <= n; ++i)  {
            int count = 0;
            int x = i;
            sp[i] = 1;
            while (F[x] > 0)  {
                x /= F[x];
                count++;
                if (count > 1) {
                    sp[i] = 0;
                    break;
                }
            }
            if (count < 1) sp[i] = 0;
        }
    }
    
    private void prefixsum()  {
        for (int i = 1; i < F.length; ++i)
            F[i] = F[i-1] + sp[i];
    }
    
    public int[] solution(int N, int[] P, int[] Q) {
        arrayF(N);
        factorize(N);
        prefixsum();
        int[] ans = new int[P.length];
        for (int i=0; i < P.length; ++i)
            ans[i] = F[Q[i]] - F[P[i]-1];        
        return ans;
    }
}
