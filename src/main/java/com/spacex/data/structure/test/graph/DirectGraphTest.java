package com.spacex.data.structure.test.graph;

import com.spacex.data.structure.graph.IDirectGraph;
import com.spacex.data.structure.graph.ListDirectGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DirectGraphTest {
    private IDirectGraph<String> directGraph;

    @BeforeEach
    public void init() {
        directGraph = new ListDirectGraph<>();
    }

    @Test
    public void testAddVertex() {
        
    }
}
