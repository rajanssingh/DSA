package Leetcode.Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _02_SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("Rajan"));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        char[] charArray = s.toCharArray();

        for(char c: charArray){
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        pq.addAll(charMap.entrySet());

        StringBuilder result = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> poll = pq.poll();
            result.append(String.valueOf(poll.getKey()).repeat(poll.getValue()));
        }
        return result.toString();
    }
}
