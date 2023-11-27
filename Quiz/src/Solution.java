/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/11/16 18:59 星期四
 */

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numList = {2, 3, 4, 5};
        System.out.println(solution.longestAlternatingSubarray(numList, 5));
    }

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int result = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            if (nums[end] % 2 == 0) {
                threshold -= nums[end];
            }

            while (threshold < 0) {
                if (nums[start] % 2 == 0) {
                    threshold += nums[start];
                }
                start++;
            }

            result = Math.max(result, end - start + 1);
        }

        return result;
    }
}
