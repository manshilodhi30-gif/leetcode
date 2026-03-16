class Solution {
    public String predictPartyVictory(String senate) {
       Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();
        
        // Fill queues with initial positions
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }
        
        // Simulate rounds
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.poll();
            int d = dire.poll();
            if (r < d) {
                radiant.add(r + n); // Radiant bans Dire
            } else {
                dire.add(d + n); // Dire bans Radiant
            }
        }
        
        return radiant.isEmpty() ? "Dire" : "Radiant";
     
    }
}