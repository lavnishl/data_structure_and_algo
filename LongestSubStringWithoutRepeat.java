import java.util.Set;
import java.util.HashSet;

/**
 * Problem : https://leetcode.com/problems/longest-substring-without-repeating-characters/description/ 
 * Type : Medium 
 * Good video explaination : https://www.youtube.com/watch?v=GS9TyovoU4c
 */
public class LongestSubStringWithoutRepeat {
    public static void main(String[] args) {
        String s = "abcdabcbb";
        //String s = "bbb";
        int max = brute_force(s);
        //int max = efficient_method(s);
        System.out.println("\n longest substring size ="+max);
    }

    static int brute_force(String s){
        // find every sub string : using 2 for loops
        // does substring have any repeating character ?
        //      Y : move to next sub string 
        //      N : continue loop 
        // check if it is max 
        int maxLen = 0;

        for (int i=0;i<s.length();i++) {
            // keep on adding character to subString until we find a character that repeates 
            StringBuilder current_substring  = new StringBuilder();
            for (int j=i;j<s.length();j++) { // start at i , to handle case if "bbbb" and max sub string is "b" 
                // check if current_substring has existing character if yes break out , else add it 
                if (current_substring.indexOf(String.valueOf(s.charAt(j))) != -1 ) {
                    // if index is not -1 , then we have a repeated character 
                    break;
                }
                // not repeated character , so add it in sub string 
                current_substring.append(s.charAt(j)); 
                // maxLen = Math.max(maxLen,current_substring.length());
                if(current_substring.length() > maxLen) {
                        maxLen = current_substring.length();
                }

            }
        }

        return maxLen;
    }
    static int efficient_method(String s) {
        int a_pointer = 0;
        int b_pointer=0;
        int max = 0;
        Set <Character> hash_set = new HashSet();

        while (b_pointer< s.length()) {
           // one loop , hence O(n) ... inner loop can be removed by HashSet
            if(!hash_set.contains(s.charAt(b_pointer))) { 
                // found a new character , add in hash set 
                hash_set.add(s.charAt(b_pointer));
                // expand window 
                b_pointer++; 
                max = Math.max(hash_set.size(),max);
            } else { // found a repeated character
                hash_set.remove(s.charAt(a_pointer));
                // remove repeated character 
                a_pointer++;
            }
        }
        return max;
    }
}
