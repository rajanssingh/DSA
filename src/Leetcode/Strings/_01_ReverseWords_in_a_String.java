package Leetcode.Strings;

import java.util.Arrays;
import java.util.Stack;

public class _01_ReverseWords_in_a_String {
    public static void main(String[] args) {
        System.out.println(reverseWords("Hello Rajan"));
    }

    public static String reverseWords(String s) {
        String[] s1 = s.split("\\s+");
        Stack<String> stringStack = new Stack<>();
        for(String t: s1){
            stringStack.push(t);
        }
        StringBuilder result = new StringBuilder("");
        while(!stringStack.empty()){
            result.append(stringStack.pop()).append(" ");
        }

        return result.toString().trim();
    }
}
