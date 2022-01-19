package com.spacex.data.structure.test.list;

import com.spacex.data.structure.test.CustomArrayListTest;
import com.spacex.data.structure.test.CustomDoubleLinkedListTest;
import com.spacex.data.structure.test.CustomSingleLinkedListTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CustomArrayListTest.class, CustomSingleLinkedListTest.class, CustomDoubleLinkedListTest.class})
public class CustomListTestSuite {

}