class Solution{
public int minPathSum(int[][] g){
int m=g.length,n=g[0].length;
for(int i=1;i<m;i++)g[i][0]+=g[i-1][0];
for(int j=1;j<n;j++)g[0][j]+=g[0][j-1];
for(int i=1;i<m;i++)for(int j=1;j<n;j++)g[i][j]+=Math.min(g[i-1][j],g[i][j-1]);
return g[m-1][n-1];
}
}
