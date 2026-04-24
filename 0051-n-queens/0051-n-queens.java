import java.util.*;
class Solution{
public List<List<String>> solveNQueens(int n){
List<List<String>>res=new ArrayList<>();
char[][]b=new char[n][n];
for(int i=0;i<n;i++)Arrays.fill(b[i],'.');
dfs(res,b,0);
return res;
}
void dfs(List<List<String>>res,char[][]b,int r){
if(r==b.length){
List<String>sol=new ArrayList<>();
for(char[]row:b)sol.add(new String(row));
res.add(sol);
return;
}
for(int c=0;c<b.length;c++){
if(valid(b,r,c)){
b[r][c]='Q';
dfs(res,b,r+1);
b[r][c]='.';
}
}
}
boolean valid(char[][]b,int r,int c){
for(int i=0;i<r;i++)if(b[i][c]=='Q')return false;
for(int i=r-1,j=c-1;i>=0&&j>=0;i--,j--)if(b[i][j]=='Q')return false;
for(int i=r-1,j=c+1;i>=0&&j<b.length;i--,j++)if(b[i][j]=='Q')return false;
return true;
}
}
