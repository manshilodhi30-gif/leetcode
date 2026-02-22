class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        String[] rows = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = "";
        }
        int currentRow = 0;
        boolean goingDown = true;
            for (int i = 0; i < s.length(); i++) {
            rows[currentRow] += s.charAt(i);
            if (currentRow == numRows - 1) {
                goingDown = false;
            }
            if (currentRow == 0) {
                goingDown = true;
            }
            if (goingDown) {
                currentRow++;
            } else {
                currentRow--;
            }
        }
        String result = "";
        for (int i = 0; i < numRows; i++) {
            result += rows[i];
        }
        return result;
    }
}