package me.data.structure.learning.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution47 {

    public List<List<Integer>> permute(int[] numArray) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] used = new boolean[numArray.length];
        if (numArray.length == 0) {
            return result;
        }
        dfs(numArray, numArray.length, 0, stack, used, result);
        return result;

    }

    private void dfs(int[] numArray, int length, int depth, Deque<Integer> stack, boolean[] used, List<List<Integer>> result) {
        if (depth == length) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                stack.addLast(numArray[i]);
                used[i] = true;
                dfs(numArray, length, depth + 1, stack, used, result);
                stack.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution47 solution = new Solution47();
        int[] a = new int[]{1, 2, 3};
        System.out.println(solution.permute(a));
    }
}
