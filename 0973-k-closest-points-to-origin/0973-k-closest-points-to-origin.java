class Triplet implements Comparable<Triplet>{
    int dist;
    int x,y;
    Triplet(int dist,int x,int y){
        this.dist=dist;
        this.x=x;
        this.y=y;
    }
    public int compareTo(Triplet t){
        return this.dist-t.dist;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Triplet> t=new PriorityQueue<>(Collections.reverseOrder());
        for(int[]pt: points){
            int x=pt[0];
            int y=pt[1];
            int dist=x*x+y*y;
            t.add(new Triplet(dist,x,y));
            if(t.size()>k)t.remove();
        }
        int[][] res=new int[k][2];
        for(int i=0;i<k;i++){
            Triplet r=t.remove();
            res[i][0]=r.x;
            res[i][1]=r.y;
        }
        return res;
    
    }
}

