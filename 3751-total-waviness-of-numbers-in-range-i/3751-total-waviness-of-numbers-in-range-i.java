class Solution {
    public int totalWaviness(int num1, int num2) {
        int totalWaviness = 0;
        for (int i = num1; i <= num2; i++) {
            totalWaviness += getWaviness(i);
        }
        return totalWaviness;
    }

    private int getWaviness(int n) {
        String s = String.valueOf(n);
        if (s.length() < 3) {
            return 0;
        }
        
        int waviness = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            int prev = s.charAt(i - 1) - '0';
            int curr = s.charAt(i) - '0';
            int next = s.charAt(i + 1) - '0';
            
            if (curr > prev && curr > next) {
                waviness++;
            }
            else if (curr < prev && curr < next) {
                waviness++;
            }
        }
        return waviness;
    }
}