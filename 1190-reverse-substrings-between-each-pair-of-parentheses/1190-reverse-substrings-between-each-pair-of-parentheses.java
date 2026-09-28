class Solution{
    public String reverseParentheses(String s){
        StringBuilder sb=new StringBuilder();
        Stack<StringBuilder> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('){
                stack.push(sb);
                sb=new StringBuilder();
            }else if(c==')'){
                StringBuilder temp=sb.reverse();
                sb=stack.pop().append(temp);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
