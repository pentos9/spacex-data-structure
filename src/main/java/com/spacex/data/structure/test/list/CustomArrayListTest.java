package com.spacex.data.structure.test.list;

import com.spacex.data.structure.list.CustomArrayList;
import org.junit.jupiter.api.BeforeEach;

public class CustomArrayListTest extends AbstractCustomListTest {

    @BeforeEach
    @Override
    public void init() {
        customList = new CustomArrayList();
    }
}
