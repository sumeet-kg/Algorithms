public class AString {

    /**
     *1. Longestt common subsequence of two string
     *2. lowest-cost to tranform one string to another
     *3. all occurance of pattern string within a string text.
     */
    private int[][] mat;

    public String LCS(String s1, String s2){
        int[][] l = LCS_table(s1, s2);
        return assemble_LCS(s1, s2, l, s1.length(), s2.length());

        
    }
    public String assemble_LCS(String x, String y,int[][] mat, int i,int j){
        if(mat[i][j]==0)return "";
        else {
            if(s1.charAt(i)==s2.charAt(j)) {
                return assemble_LCS(x, y, mat, i-1, j-1)+s1.charAt(i);
            }else {
                if(mat[i][j-1] > mat[i-1][j]){
                    return assemble_LCS(x, y, mat, i, j-1);
                }else{
                    return assemble_LCS(x, y, mat, i-1, j);
                }
            }
        }
    }
    public int[][] LCS_table(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        mat = new int[n][m];
        for(int i = 0 ; i < n ;i++)mat[i][0] = 0;
        for(int i = 0 ; i < m ;i++)mat[0][i] = 0;

        for(int i = 1 ;i < n; i++){
            for(int j = 1 ; j < m ; j++){
                if(s1.charAt(i)==s2.charAt(j)) mat[i][j] = mat[i-1][j-1]+1;
                else {
                    mat[i][j] = Math.max(mat[i-1][j],mat[i][j-1]);
                }
            }
        }
                
        return mat;
    }
}