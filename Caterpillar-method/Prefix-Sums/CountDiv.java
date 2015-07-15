class Solution {
    public int solution(int A, int B, int K) {
        int l,r;

        int left = A % K;
        if( left != 0 && A < K ) 
          l = 1;
        else if( left != 0 && A > K)
          l = A/K+1;
        else 
          l = A/K;

        int right = B % K;
        if( right != 0 )
          r = (B-right)/K;
        else
          r = B/K;

        return r - l + 1;
    }
}
