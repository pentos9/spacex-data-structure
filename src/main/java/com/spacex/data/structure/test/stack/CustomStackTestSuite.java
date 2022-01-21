package com.spacex.data.structure.test.stack;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CustomArrayStackTest.class, JdkArrayListCustomStackTest.class,
        JdkLinkedListCustomStackTest.class, SingleLinkedListCustomStackTest.class,
        JdkDequeCustomStackTest.class})
public class CustomStackTestSuite {

}
