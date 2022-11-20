package stackdatastructure;

import java.util.Stack;

public class TappingRainWater {
    public int trap(int[] height) {
        int[] nearestGreaterToRight = nearestGreaterToRight(height);
        int[] nearestGreaterToLeft = nearestGreaterToLeft(height);
        int totalRainWaterTapped = 0;

        for (int i = 0; i < height.length; i++) {
            totalRainWaterTapped += Math.min(nearestGreaterToLeft[i], nearestGreaterToRight[i]) - height[i];
        }

        return totalRainWaterTapped;
    }

    private int[] nearestGreaterToLeft(int[] height) {
        int[] result = new int[height.length];
        result[0] = height[0];
        int max = height[0];

        for (int i = 1; i < height.length; i++) {
            if (height[i] >= max) {
                max = height[i];
            }
            result[i] = max;
        }
        return result;
    }

    private int[] nearestGreaterToRight(int[] height) {
        int[] result = new int[height.length];
        result[height.length - 1] = height[height.length - 1];
        int max = height[height.length - 1];

        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] >= max) {
                max = height[i];
            }
            result[i] = max;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new TappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
