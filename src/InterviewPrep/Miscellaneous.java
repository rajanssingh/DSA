package InterviewPrep;

import java.util.*;

public class Miscellaneous {
    public static void main(String[] args) {
//        System.out.println(isHappy(7));
//        System.out.println(isValid("([)]"));
//        letterCombinations("23");
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        int originalNumber = x;
        if(x < 0){
            return false;
        }
        if(x/10 == 0){
            return true;
        }
        int digits = (int)(Math.log10(x) + 1);

        int answer = 0;
        while(x>0){
            int d = x%10;
            // No need of power here, can be handled within the loop like below
//            answer += (d * (int)(Math.pow(10,--digits)));
            answer = answer*10 + d;
            x/=10;
        }
        return answer == originalNumber;
    }

    public static int digit_sum(int n){
        int sum= 0 ;
        while(n>0){
            int d = n%10;
            n/=10;
            sum += d*d;
        }
        return sum;
    }

    public static boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while(n!=1){
            if(!visited.contains(n)){
                visited.add(n);
                n=digit_sum(n);
            }
            else{
                break;
            }
        }
        return n==1? true: false;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stack.add(ch);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if((ch == ')' && top == '(') || (ch == '}' && top == '{') || (ch == ']' && top == '[')){
                    continue;
                }
                else {
                    return false;
                }
            }
        }
        return stack.isEmpty()? true : false;
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if(digits == null || digits.isEmpty()) {
            return res;
        }
        StringBuilder path = new StringBuilder();
        helperBacktrack(digits, 0, path, res);

        res.stream().forEach(System.out::println);
        return res;
    }

    private static final String[] MAP = {
            "",    // 0
            "",    // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs",// 7
            "tuv", // 8
            "wxyz" // 9
    };

    public static void helperBacktrack(String digits, int index, StringBuilder path, List<String> result){
        // Base case
        if(index == digits.length()){
            result.add(path.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = MAP[digit];

        for(int i=0;i<letters.length();i++){
            path.append(letters.charAt(i));
            helperBacktrack(digits, index+1, path, result);
            path.deleteCharAt(path.length()-1);
        }
    }


}
