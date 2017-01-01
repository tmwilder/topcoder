package io.wilder.topcoder.srm703div2;

import org.junit.*;

public class TestAlternatingString {
	@Test
	public void testAlternatingString1(){
		AlternatingString alternatingString = new AlternatingString();
		int maxLength = alternatingString.maxLength("111101111");
		Assert.assertEquals(3, maxLength);
	}

	@Test
	public void testAlternatingString2(){
		AlternatingString alternatingString = new AlternatingString();
		int maxLength = alternatingString.maxLength("000011110000");
		Assert.assertEquals(2, maxLength);
	}

	@Test
	public void testAlternatingString3(){
		AlternatingString alternatingString = new AlternatingString();
		int maxLength = alternatingString.maxLength("1011011110101010010101");
		Assert.assertEquals(8, maxLength);
	}

	@Test
	public void testAlternatingString4(){
		AlternatingString alternatingString = new AlternatingString();
		int maxLength = alternatingString.maxLength("0");
		Assert.assertEquals(1, maxLength);
	}

	@Test
	public void testAlternatingString5(){
		AlternatingString alternatingString = new AlternatingString();
		int maxLength = alternatingString.maxLength("1010101");
		Assert.assertEquals(7, maxLength);
	}
}
