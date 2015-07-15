import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        int front=0, back=A.length-1;
        int min = back == 0 ? Math.abs(A[0]) : 2000000000;
        while( front != back )  {
            min = Math.min( Math.abs(A[front]+A[back]), min );            
            if( Math.abs(A[front]) > Math.abs(A[back]) )
                front++;
            else 
                back--;
        }
        return min;
    }
}
