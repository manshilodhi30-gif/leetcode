class Solution {
    public int compress(char[] chars) {
         int write = 0; // position to write compressed characters
        int read = 0;  // position to read characters

        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;

            // Count consecutive occurrences
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            // Write the character
            chars[write++] = currentChar;

            // Write the count if > 1
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}