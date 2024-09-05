package unit7;

import java.util.Arrays;

/**
 * n개의 페어를 이용한mtn(a, b)의 합으로 만들수 있는 가장큰수를출력하라.
 * 입력 [1, 3, 4, 2]
 * 출력 4
 * 주의 n은 2가 되며. 최대 합은4다. mtn(l, 2) + mtn(3, 4) = 4
 */
public class P7_4 {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2};
        Solution(nums);
    }

    private static int Solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            if(i % 2 != 0) answer += Math.min(nums[i], nums[i-1]);
        }
        return answer;
    }
}
