package me.data.structure.learning.tree.node;

import org.junit.Test;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * Create by songwenchao on 2019-09-01
 */
public class TreeBuilderTest {

  @Test
  public void build() {
    Integer [] numbers = {1,3,2,4,9,7,5};
    TreeBuilder<Integer> builder= new TreeBuilder<>();
    TreeNode<Integer> root =builder.build(numbers);
    System.out.println(builder.preTraversal(root));

  }
}