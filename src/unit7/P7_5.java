package unit7;

/**
 * 배열을 입력받아 OUtput[t]가자신을 제외한나머지 모든 엘리먼트의 곱셈 결과가 되도록 출력하라
 * 입력 [1, 3, 5, 7]
 * 출력 [105, 35, 21, 15]
 * 주의 나눗셈을 하지 않고 0(n)에 풀이하라.
 */

public class P7_5 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7};
        Solution(nums);
    }

    private static int[] Solution(int[] nums) {
        int[] result = new int[nums.length];
        int p = 1;
        for(int i=0; i<nums.length; i++) {
            result[i] = p;
            p *= nums[i];
        }
//      1,

        p = 1;
        for(int i=nums.length -1; i>=0; i--) {
            result[i] *= p;
            p *= nums[i];
        }
        return result;
    }
}
