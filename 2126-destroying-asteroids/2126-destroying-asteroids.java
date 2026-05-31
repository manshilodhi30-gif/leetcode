import java.util.*;
class Solution{
    public boolean asteroidsDestroyed(int mass,int[] asteroids){
        Arrays.sort(asteroids);
        long planet=mass;
        for(int a:asteroids){
            if(planet<a)return false;
            planet+=a;
        }
        return true;
    }
}
