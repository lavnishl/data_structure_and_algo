/**
 * https://leetcode.com/problems/valid-palindrome/description/ 
 * s = "A man, a plan, a canal: Panama"
 * 
 */
public class ValidPalindrome {
    public static void main (String args[]) {
        //String str = "1A man, nama1";
        //String str = "1A man, nama12";
        //String str = "1A manP nama1";
        //String str = "";
        //String str = "abcd";
        String str = "race a car";

        str = reduced_string(str);
        System.out.println(str);
        System.out.println(efficient_method_1(str));
    }
    

    public static String reduced_string(String s) {
        s=s.trim().toLowerCase();
        s = s.replaceAll("\\s+","");
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        return s;
    }
    public static boolean brute_force(String s) {
        boolean result=false;

        return result;
    }
    public static boolean efficient_method_1(String s) {
        if (s.trim().length()==0) {
            return true;
        }
        // sliding window
        boolean result=true;
        int pointer_a = 0;
        int pointer_b = s.length()-1;

        //while ( (pointer_a!=pointer_b) && (pointer_b-pointer_a) != 1) ... this condition did not work for "race a car"
        // while ( (pointer_a!=pointer_b) )  // this condition will not work for "1A man, nama1"
        while ( (pointer_a <= pointer_b) )  
        {
            System.out.println("before value pointer_a ="+pointer_a+", "+pointer_b+", charAtPointer_a="+s.charAt(pointer_a)+ ", "+s.charAt(pointer_b));
            //Character charAtPointer_a=s.charAt(0);
            //Character charAtPointer_b=s.charAt(s.length()-1);
            if (s.charAt(pointer_a)!=s.charAt(pointer_b)) {
                System.out.println(s.charAt(pointer_b)+",not equal to "+s.charAt(pointer_a));
                result=false;
                break;
            }
            pointer_a++;
            pointer_b--;
            int diff = pointer_b-pointer_a;
            System.out.println("after value pointer_a ="+pointer_a+", "+pointer_b+", pointer_b-pointer_a="+diff);
            System.out.println("After value charAtPointer_a="+s.charAt(pointer_a)+ ", "+s.charAt(pointer_b));
        }
        return result;
    }
}

