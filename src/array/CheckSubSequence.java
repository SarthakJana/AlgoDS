package array;

public class CheckSubSequence {

    public static boolean isSubSequence(String s, String sub) {
        int j = 0;

        for (int i = 0; i < s.length() && j < sub.length(); i++) {
            if (s.charAt(i) == sub.charAt(j)) {
                j++;
            }
        }

        return j == sub.length();
    }

    public static void main(String[] args) {
        System.out.println("is subsequence: " + isSubSequence("ABCDEF", "ACF"));
    }
}
