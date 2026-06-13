class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            int weightSum = 0;
            for (char c : word.toCharArray()) {
                weightSum += weights[c - 'a'];
            }
            
            int modResult = weightSum % 26;
            char mappedChar = (char) ('z' - modResult);
            result.append(mappedChar);
        }
        
        return result.toString();
    }
}