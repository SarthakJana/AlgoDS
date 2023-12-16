package array;

public class Anagram {

    public static boolean isAnagram(String s, String t) {

        final int CHAR = 256;
        int[] count = new int[CHAR];
        boolean isAnagram = true;

        if (s.length() != t.length()) {
           isAnagram = false;
        }

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
            count[t.charAt(i)]--;
        }

        for (int i = 0; i < CHAR; i++) {
            if (count[i] != 0) {
               isAnagram = false;
            }
        }

        return isAnagram;
    }

    public static void main(String[] args) {
        System.out.println("Is anagram " + isAnagram("silent", "listen"));

    }
}
