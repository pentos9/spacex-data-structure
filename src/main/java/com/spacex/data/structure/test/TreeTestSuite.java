package com.spacex.data.structure.test;

import com.spacex.data.structure.test.tree.BinarySearchTreeTest;
import com.spacex.data.structure.test.tree.RedBlackTreeTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({BinarySearchTreeTest.class, RedBlackTreeTest.class})
public class TreeTestSuite {

}
