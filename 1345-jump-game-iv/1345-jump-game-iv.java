import java.util.*;
class Solution{
public int minJumps(int[] arr){
int n=arr.length;
if(n==1)return 0;
Map<Integer,List<Integer>>map=new HashMap<>();
for(int i=0;i<n;i++)map.computeIfAbsent(arr[i],k->new ArrayList<>()).add(i);
boolean[]vis=new boolean[n];
Queue<int[]>q=new LinkedList<>();
q.offer(new int[]{0,0});
vis[0]=true;
while(!q.isEmpty()){
int[]cur=q.poll();
int idx=cur[0],steps=cur[1];
if(idx==n-1)return steps;
if(idx-1>=0&&!vis[idx-1]){
vis[idx-1]=true;
q.offer(new int[]{idx-1,steps+1});
}
if(idx+1<n&&!vis[idx+1]){
vis[idx+1]=true;
q.offer(new int[]{idx+1,steps+1});
}
if(map.containsKey(arr[idx])){
for(int nxt:map.get(arr[idx])){
if(!vis[nxt]){
vis[nxt]=true;
q.offer(new int[]{nxt,steps+1});
}
}
map.remove(arr[idx]);
}
}
return -1;
}
}
