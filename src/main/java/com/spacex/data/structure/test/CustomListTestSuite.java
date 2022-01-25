package com.spacex.data.structure.test;

import com.spacex.data.structure.test.list.CustomArrayListTest;
import com.spacex.data.structure.test.list.CustomConcurrentArrayListTest;
import com.spacex.data.structure.test.list.CustomDoubleLinkedListTest;
import com.spacex.data.structure.test.list.CustomSingleLinkedListTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CustomArrayListTest.class, CustomSingleLinkedListTest.class, CustomDoubleLinkedListTest.class, CustomConcurrentArrayListTest.class})
public class CustomListTestSuite {

}