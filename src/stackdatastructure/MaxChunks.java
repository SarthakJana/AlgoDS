package stackdatastructure;

public class MaxChunks {

    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }

            if (max == i) {
                chunks++;
            }
        }

        return chunks;
    }
}
