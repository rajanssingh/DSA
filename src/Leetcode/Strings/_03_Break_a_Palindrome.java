package Leetcode.Strings;

public class _03_Break_a_Palindrome {

    public static void main(String[] args) {
        System.out.println(breakPalindrome("aca"));
    }

    public static String breakPalindrome(String palindrome) {
        if (palindrome.isEmpty() || palindrome.length() == 1) {
            return "";
        }
        for (int i = 0; i < palindrome.length(); i++) {
            if (palindrome.charAt(i) != 'a' && i != palindrome.length() / 2) {
                return palindrome.substring(0, i) + "a" + palindrome.substring(i + 1);
            }
        }
        return palindrome.substring(0, palindrome.length() - 1) + "b";
    }

}
