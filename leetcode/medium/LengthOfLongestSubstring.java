import java.util.HashSet;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> longestSubstring = new HashSet<Character>(); 

        int lengthOfLongestSubstring = 0, l = 0, r = 0;

        
        for (; r < s.length(); r++) {
            
            while (longestSubstring.contains(s.charAt(r))) {
                longestSubstring.remove(s.charAt(l));
                l++;
            }

            longestSubstring.add(s.charAt(r));

            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, r - l + 1);
        }

        return lengthOfLongestSubstring;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
    }
}