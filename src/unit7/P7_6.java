package unit7;

public class P7_6 {
    public static void main(String[] args) {
        int[] nums = {8,1,5,3,6,4};
        int maxPrice = 0;
        int minPrice = nums[0];
        for(int num : nums) {
            minPrice = Math.min(minPrice, num);

            maxPrice = Math.max(maxPrice, num - minPrice);
        }
    }
}
