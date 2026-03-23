import java.util.*;

class Twitter {
    private static int time = 0;
    private Map<Integer, Set<Integer>> fol;
    private Map<Integer, List<int[]>> tw;

    public Twitter() {
        fol = new HashMap<>();
        tw = new HashMap<>();
    }

    public void postTweet(int u, int t) {
        tw.putIfAbsent(u, new ArrayList<>());
        tw.get(u).add(new int[]{time++, t});
    }

    public List<Integer> getNewsFeed(int u) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        if (tw.containsKey(u)) pq.addAll(tw.get(u));
        if (fol.containsKey(u)) {
            for (int f : fol.get(u)) {
                if (tw.containsKey(f)) pq.addAll(tw.get(f));
            }
        }
        List<Integer> res = new ArrayList<>();
        int k = 0;
        while (!pq.isEmpty() && k < 10) {
            res.add(pq.poll()[1]);
            k++;
        }
        return res;
    }

    public void follow(int u, int f) {
        if (u == f) return;
        fol.putIfAbsent(u, new HashSet<>());
        fol.get(u).add(f);
    }

    public void unfollow(int u, int f) {
        if (fol.containsKey(u)) fol.get(u).remove(f);
    }
}


/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */