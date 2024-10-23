package interviewQues;

import java.util.Arrays;
import java.util.Collections;

public class Anagram {

    // anagram
    //check whether the string contains the same letters, just rearranged.

    public static void main(String[] args) {
        String s1 = "silent";
        String s2 = "listen";

        System.out.println(isAnagram(s1,s2));
    }

    private static boolean isAnagram(String s1, String s2) {

        if(s1.length() != s2.length()){
            return false;
        }
        char[] s1c = s1.toCharArray();
        char[] s2c = s2.toCharArray();

        Arrays.sort(s1c);
        Arrays.sort(s2c);

       return Arrays.equals(s1c, s2c);
    }
}
