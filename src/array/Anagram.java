package array;

public class Anagram {

    public static boolean isAnagram(String a, String b) {

        final int CHAR = 256;
        int[] count = new int[CHAR];
        boolean isAnagram = true;

        if (a.length() != b.length()) {
           isAnagram = false;
        }

        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i)]++;
            count[b.charAt(i)]--;
        }

        for (int i = 0; i < CHAR; i++) {
            if (count[i] != 0) {
               isAnagram = false;
            }
        }

        return isAnagram;
    }
}
