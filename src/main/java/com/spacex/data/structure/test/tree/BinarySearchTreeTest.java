package com.spacex.data.structure.test.tree;

import com.spacex.data.structure.customtree.BinarySearchTree;
import org.junit.jupiter.api.BeforeEach;

public class BinarySearchTreeTest extends AbstractBinarySearchTreeTest {

    @BeforeEach
    @Override
    public void init() {
        this.tree = new BinarySearchTree();
    }
}
