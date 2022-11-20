package string;

public class PalindromeCheck {

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        boolean isPalindrome = true;

        while(left <= right) {
                if (s.charAt(left++) != s.charAt(right--)) {
                    isPalindrome = false;
                }
        }

        return isPalindrome;
    }

    public static void main(String[] args) {
        System.out.println("is Palindrome: " + isPalindrome("ABCCDBA"));
    }

}
