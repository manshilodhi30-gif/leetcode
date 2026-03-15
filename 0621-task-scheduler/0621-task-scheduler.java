class Solution {
    public int leastInterval(char[] tasks, int n) {
         int[] freq = new int[26];
        for (char t : tasks) freq[t - 'A']++;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq){ 
            if (f > 0) { 
            maxHeap.add(f);
        }
        }
        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;
            for (int i = 0; i < cycle && !maxHeap.isEmpty(); i++) {
                temp.add(maxHeap.poll());
                }
            for (int f : temp){
             if (f - 1 > 0) {
                maxHeap.add(f - 1);
             }
             }
            if (maxHeap.isEmpty()) {
                time += temp.size();
            } else {
                time += cycle;
            }
        }
        return time;
    }
}