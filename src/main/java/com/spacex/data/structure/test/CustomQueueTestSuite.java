package com.spacex.data.structure.test;

import com.spacex.data.structure.test.queue.ArrayCustomQueueTest;
import com.spacex.data.structure.test.queue.JdkLinkedListCustomQueueTest;
import com.spacex.data.structure.test.queue.SingleLinkedListCustomQueueTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ArrayCustomQueueTest.class, JdkLinkedListCustomQueueTest.class, SingleLinkedListCustomQueueTest.class})
public class CustomQueueTestSuite {
}
