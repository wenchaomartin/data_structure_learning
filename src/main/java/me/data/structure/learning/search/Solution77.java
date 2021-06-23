package me.data.structure.learning.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class Solution77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        if (n < k) return result;

        Deque<Integer> ans = new ArrayDeque();
        dfs(n, k, 1, ans, result);
        return result;
    }

    private void dfs(int n, int k, int depth, Deque<Integer> ans, List<List<Integer>> result) {
        if (ans.size() == k) {
            result.add(new ArrayList<>(ans));
            return;
        }

        for (int i = depth; i <= n; i++) {
            ans.addLast(i);
            dfs(n, k, i + 1, ans, result);
            ans.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution77 solution47 = new Solution77();

        System.out.println(solution47.combine(4, 2));
    }
}

