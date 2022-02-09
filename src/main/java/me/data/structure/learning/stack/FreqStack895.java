package me.data.structure.learning.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class FreqStack895 {


    private Map<Integer, Integer> num2fre = null;

    private Map<Integer, LinkedList<Integer>> num2SameFreStack = null;

    private int maxFreq;

    public FreqStack895() {

        num2fre = new HashMap<>();

        num2SameFreStack = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        Integer newFreq = num2fre.getOrDefault(val, 0) + 1;
        num2fre.put(val, newFreq);

        if (maxFreq < newFreq) {
            maxFreq = newFreq;
        }
        num2SameFreStack.putIfAbsent(newFreq, new LinkedList());
        num2SameFreStack.get(newFreq).push(val);
    }

    public int pop() {
        LinkedList<Integer> stack = num2SameFreStack.get(maxFreq);
        Integer result = stack.pop();
        if (stack.isEmpty()) {
            num2SameFreStack.remove(maxFreq);
            maxFreq--;
        }
        num2fre.put(result, num2fre.get(result) - 1);
        return result;

    }
}
