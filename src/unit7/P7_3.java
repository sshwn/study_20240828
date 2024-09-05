package unit7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 배열을 입력받아 합으로0을 만들수 있는 3개의 엘리먼트를출력하라.
 * 입력 nums [-1, 0, 1, 2, -1, -5]
 * 출력 [
 *          [-1,0,1]
 *          [-1,-1,2]
 *     ]
 */
public class P7_3 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -5};
        Solution(nums);
    }

    private static List<List<Integer>> Solution(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int left, right, sum;
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {
            // 중복값 건너 뛰기
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            // 간격 좁히며 합 계산
            left = i+1;
            right = nums.length - 1;
            while(left < right) {
                sum = nums[i] + nums[left] + nums[right];
                // 합이 0보다 작다면 왼쪽 포인터 이동
                if(sum < 0) {
                    left ++;
                } else if(sum > 0) {
                    right--;
                } else {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                }
            }
        }
        return list;
    }
}
