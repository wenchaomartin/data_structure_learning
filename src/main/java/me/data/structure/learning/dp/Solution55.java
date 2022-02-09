package me.data.structure.learning.dp;

/**
 * house robber
 */
class Solution55 {

    public boolean canJump(int[] nums) {
        //表示dp[i] 能否到达
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && nums[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
}