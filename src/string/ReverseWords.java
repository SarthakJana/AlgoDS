package string;

import java.util.Arrays;

public class ReverseWords {

    public static void reverseWords(char[] words) {
        int start = 0;

        for (int end = 0; end < words.length; end++) {
            if (words[end] == ' '){
                reverse(words, start, end - 1);
                start = end + 1;
            }
        }

        reverse(words, start, words.length - 1);
        reverse(words, 0, words.length - 1);

        System.out.println("Reversed word: " + words);
    }

    private static void reverse(char[] words, int start, int end) {

        while (start < end) {
            char temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String s = "I love coding";
        char[] str = s.toCharArray();
        reverseWords(str);
        System.out.println(str);
    }
}
