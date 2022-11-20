package string;

public class NaivePatternMatching {

    public static void naivePatternMatching(String s, String p) {

        int lenS = s.length();
        int lenP = p.length();

        for (int i = 0; i <= lenS - lenP; i++) {
            for (int j = 0; j < lenP; j++) {
                if (p.charAt(j) != s.charAt(j + i)) {
                    break;
                }
                if (j == lenP - 1) {
                    System.out.println(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        naivePatternMatching("ABCDABFAABAABBA", "ABC");
    }
}
