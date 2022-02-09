package me.data.structure.learning.dp;

/**
 * house robber
 */
class Solution {
    public int rob(int[] nums) {
        //前j 个房子能盗窃的最大现金数 用函数dp[j]
        //j最大是的值为nums.length
        int[]dp = new int[nums.length+1];
        //前j间屋子里能获得最多金币= max( 前j-1间屋子里或者最大金币数+前j-2间屋子里获得最大金币数+nums[j] )
        // dp[j]= max(dp[j-1]+dp[j-2]+nums[j])
        if(nums.length == 1){
            return nums[0];
        }
        //dp[0] 抢劫到 0号房子，最大的收益
        dp[0]=nums[0];
        //dp[1] 抢劫到 1号 房子 最大收益
        dp[1]=Math.max(nums[0],nums[1]);
        for(int j=2;j<nums.length;j++){
            dp[j]= Math.max(dp[j-1],dp[j-2]+nums[j]);    
        }
        return dp[nums.length-1];

    }
}