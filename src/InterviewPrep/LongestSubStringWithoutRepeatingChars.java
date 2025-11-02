package InterviewPrep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingChars {
    public static void main(String[] args) {
//        lengthOfLongestSubstring("abcabcbb");
        System.out.println(lengthOfLongestSubstringTraversal("abcabcbb"));
    }

    public static Integer lengthOfLongestSubstringTraversal(String s){
        int n = s.length();
        int left = 0, right = 0;
        int answer = 0;
        int [] lastIndexArray = new int[256];
        Arrays.fill(lastIndexArray, -1);

        for(; right < n; right++){
            char c = s.charAt(right);

            if(lastIndexArray[c] >= left) {
                left = lastIndexArray[c] + 1;
            }
            lastIndexArray[c] = right;
            answer = Integer.max(answer, right - left + 1);
        }
        return answer;
    }

    /**
     * Sliding window + HashMap
     * @param s
     */
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
