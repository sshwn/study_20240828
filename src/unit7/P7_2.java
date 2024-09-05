package unit7;

/**
 * 높이를 입력받아 비 온 후 얼마나 많은 물이 쌓일 수 있는지 계산하라.
 * 입력 [1,1,0,2,1,0,1,3,2,1,2,1]
 * 출력 6
 */
public class P7_2 {
    public static void main(String[] args) {
        // 빗물 트래핑
        int[] height = {1,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(Solution(height));
        System.out.println(Solution2(height));
    }

    private static int Solution2(int[] height) {
        int answer = 0;
        for(int i=1; i<height.length; i++) {
            if(height[i-1] > height[i]) {
                answer += height[i-1] - height[i];
            }
        }
        return answer;
    }

    private static int Solution(int[] height) {
        int volume = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        // 투 포인터가 서로 겹칠 때까지 반복
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);  // 0
            rightMax = Math.max(height[right], rightMax);   // 1
            // 더 높은 쪽을 향해 투 포인터 이동
            if (leftMax <= rightMax) {
                // 왼쪽 막대 최대 높이와의 차이를 더하고 왼쪽 포인터 이동
                volume += leftMax - height[left];
                left += 1;
            } else {
                // 오른쪽 막대 최대 높이와의 차이를 더하고 오른쪽 포인터 이동
                volume += rightMax - height[right];
                right -= 1;
            }
        }
        return volume;

    }
}
