package com.spacex.data.structure.test.list;

import com.spacex.data.structure.list.CustomArrayList;
import com.spacex.data.structure.list.CustomConcurrentArrayList;
import org.junit.jupiter.api.BeforeEach;

public class CustomConcurrentArrayListTest extends AbstractCustomListTest {

    @BeforeEach
    @Override
    protected void init() {
        this.customList = new CustomConcurrentArrayList<>(new CustomArrayList<>());
    }
}
