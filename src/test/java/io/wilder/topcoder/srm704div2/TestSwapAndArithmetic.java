package io.wilder.topcoder.srm704div2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestSwapAndArithmetic {
	@Test
	public void tcTest(){
		SwapAndArithmetic swapAndArithmetic = new SwapAndArithmetic();
		int[] test = {1, 2, 3};
		String output = swapAndArithmetic.able(test);
		assertEquals("Hello world!", output);
	}
}
