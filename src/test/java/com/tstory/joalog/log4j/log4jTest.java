package com.tstory.joalog.log4j;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Stack;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class log4jTest {

	static final Logger logger = 
		LoggerFactory.getLogger(log4jTest.class);
	
	@Rule public MethodRule watchman = new TestWatchman() {
	    public void starting(FrameworkMethod method) {
	    	logger.info("Run Test {}...", method.getName());
	    }
	    public void succeeded(FrameworkMethod method) {
	    	logger.info("Test {} succeeded.", method.getName());
	    }
	    public void failed(Throwable e, FrameworkMethod method) {
	    	logger.error("Test {} failed with {}.", method.getName(), e);
	    }
	};
	
	Stack<String> stack;
	
	@Before public void createEmptyStack() {
		stack = new Stack<String>();
		stack.push("Item One");
	}
	
	// the sample test demonstrate logging of a succeeded test.
	@Test public void ApushOneElementInEmptyStack() {
		stack.push("Item Two");
		assertThat(stack.size(), is(2));
	}
	
	// the sample test demonstrate logging of a failed test 
	// with an EmptyStackException
	@Test public void BpopElementFromEmptyStack() {
		stack.pop();
		assertThat(stack.size(), is(0));
	}
	
}