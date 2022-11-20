package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class LetterRemoval {

    public static String solution(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> subStrings = Arrays.asList("AB", "BA", "CD", "DC");

        for (char c : S.toCharArray()) {
            stringBuilder.append(c);
            int size = stringBuilder.length();
            if (size >= 2 && subStrings.contains(stringBuilder.substring(size - 2))) {
               stringBuilder.delete(size - 2, size);
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(LetterRemoval.solution("ACBDACBD"));
    }
}
