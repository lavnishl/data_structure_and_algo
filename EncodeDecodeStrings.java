import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Iterator;


/**
 * https://prepfortech.io/leetcode-solutions/encode-and-decode-strings 
 * 
 */
public class EncodeDecodeStrings {
    public static void main(String args[]) {
        //String array[] = {"hello","duniya"};
        //String array[] = {"hello"};
        String array[] = {};
        if (array.length>0)
        {
            String encoded_string = encode_string(array);
            System.out.println("encoded string = "+encoded_string);
            decode_string(encoded_string);
        }else {
            System.out.println("array of length is 0");
        }
    }
    public static String encode_string(String arr[]) {
        String encodedString = "";
        for(int i=0;i<arr.length;i++) {
            //System.out.println(arr[i]);
            encodedString = encodedString+arr[i].length()+"#"+arr[i];
            //System.out.println(encodedString);
        }
        return encodedString;
    }
   
    public static void decode_string(String encoded_string) {
        encoded_string = encoded_string.substring(1); // remove first character which is always a number 
        // String arr[] = {};
        List<String> list = new ArrayList<String>();

        // NOTE : https://www.javatpoint.com/java-string-substring 
        StringTokenizer st1 = new StringTokenizer(encoded_string, "#");
        while (st1.hasMoreTokens()) {
            // Getting next tokens
            // System.out.println(st1.nextToken());
            String s = st1.nextToken();
            s = s.replaceAll("[^a-zA-Z]", "");
            list.add(s);
        }
        // NOTE : https://www.w3schools.com/java/java_iterator.asp 
        // Iterator i = list.iterator();
        // Get the iterator
        Iterator<String> it = list.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }

    }
   
}
