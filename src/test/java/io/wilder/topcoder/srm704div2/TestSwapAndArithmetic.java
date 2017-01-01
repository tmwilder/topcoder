package io.wilder.topcoder.srm704div2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestSwapAndArithmetic {
	@Test
	public void tcTest(){
		SwapAndArithmetic swapAndArithmetic = new SwapAndArithmetic();
		int[] test = {1, 2, 3};
		String output = swapAndArithmetic.able(test);
		assertEquals(SwapAndArithmetic.POSSIBLE, output);
	}

	@Test
	public void tcTest2(){
		SwapAndArithmetic swapAndArithmetic = new SwapAndArithmetic();
		int[] test = {2, 1, 5, 4, 3};
		String output = swapAndArithmetic.able(test);
		assertEquals(SwapAndArithmetic.POSSIBLE, output);
	}

	@Test
	public void tcTest3(){
		SwapAndArithmetic swapAndArithmetic = new SwapAndArithmetic();
		int[] test = {3, 1, 2};
		String output = swapAndArithmetic.able(test);
		assertEquals(SwapAndArithmetic.POSSIBLE, output);
	}

	@Test
	public void tcTest4(){
		SwapAndArithmetic swapAndArithmetic = new SwapAndArithmetic();
		int[] test = {1, 1, 1, 1, 1, 1};
		String output = swapAndArithmetic.able(test);
		assertEquals(SwapAndArithmetic.POSSIBLE, output);
	}

	@Test
	public void tcTest5(){
		SwapAndArithmetic swapAndArithmetic = new SwapAndArithmetic();
		int[] test = {7, 3, 11, 5, 1, 9};
		String output = swapAndArithmetic.able(test);
		assertEquals(SwapAndArithmetic.POSSIBLE, output);
	}

	@Test
	public void tcTest6(){
		SwapAndArithmetic swapAndArithmetic = new SwapAndArithmetic();
		int[] test = {1000, 704, 1};
		String output = swapAndArithmetic.able(test);
		assertEquals(SwapAndArithmetic.IMPOSSIBLE, output);
	}
}
