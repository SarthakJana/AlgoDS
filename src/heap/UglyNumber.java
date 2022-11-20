package heap;


public class UglyNumber {
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        int i2, i3, i5, i, m2, m3, m5;
        i2 = i3 = i5 = 0;
        uglyNumbers[0] = 1;
        i = 1;

        while (i < n) {
            m2 = uglyNumbers[i2] * 2;
            m3 = uglyNumbers[i3] * 3;
            m5 = uglyNumbers[i5] * 5;

            int min = Math.min(Math.min(m2, m3), m5);

            if (min == m2) {
                i2++;
            }
            if (min == m3) {
                i3++;
            }
            if (min == m5) {
                i5++;
            }

            uglyNumbers[i] = min;
            i++;
        }

        return uglyNumbers[n - 1];
    }

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        System.out.println(uglyNumber.nthUglyNumber(10));
    }
}
