package io.wilder.topcoder.srm703div2;

import org.junit.*;


public class TestGCDGraph {
	@Test
	public void TestGCDGraph1(){
		GCDGraph gcdGraph = new GCDGraph();
		Assert.assertEquals(GCDGraph.POSSIBLE, gcdGraph.possible(12, 2, 8, 9));
	}

	@Test
	public void TestGCDGraph2(){
		GCDGraph gcdGraph = new GCDGraph();
		Assert.assertEquals(GCDGraph.IMPOSSIBLE, gcdGraph.possible(12, 2, 11, 12));
	}

	@Test
	public void TestGCDGraph3(){
		GCDGraph gcdGraph = new GCDGraph();
		Assert.assertEquals(GCDGraph.POSSIBLE, gcdGraph.possible(12, 2, 11, 11));
	}

	@Test
	public void TestGCDGraph4(){
		GCDGraph gcdGraph = new GCDGraph();
		Assert.assertEquals(GCDGraph.IMPOSSIBLE, gcdGraph.possible(10, 2, 8, 9));
	}

	@Test
	public void TestGCDGraph5(){
		GCDGraph gcdGraph = new GCDGraph();
		Assert.assertEquals(GCDGraph.POSSIBLE, gcdGraph.possible(1000000, 1000, 12345, 54321));
	}

//	@Test
//	public void TestGCDGraph6(){
//		GCDGraph gcdGraph = new GCDGraph();
//		Assert.assertEquals(GCDGraph.IMPOSSIBLE, gcdGraph.possible(1000000, 2000, 12345, 54321));
//	}
//
	@Test
	public void TestGCDGraph7(){
		GCDGraph gcdGraph = new GCDGraph();
		Assert.assertEquals(GCDGraph.POSSIBLE, gcdGraph.possible(2, 0, 1, 2));
	}
}