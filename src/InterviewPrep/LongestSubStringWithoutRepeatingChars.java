package InterviewPrep;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingChars {
    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }

    public static void lengthOfLongestSubstring(String s) {
        int longestSubStringLength = Integer.MIN_VALUE;
        int length = s.length();
        Set<Character> set = new HashSet<>();
        int windowsStart = 0, windowEnd = 0;

        while(windowsStart < length && windowEnd < length){
            if(! set.contains(s.charAt(windowEnd))){
                set.add(s.charAt(windowEnd++));
                longestSubStringLength = Math.max(longestSubStringLength, windowEnd - windowsStart);
            }
            else{
                set.remove(s.charAt(windowsStart++));
            }
        }

        System.out.println(longestSubStringLength);
    }
}
