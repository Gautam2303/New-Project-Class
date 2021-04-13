package org.sample;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Sample2 {
	@Test
	private void tc1() {
     System.out.println("Methods 1");
	}
	@Test
	private void tc2() {
     System.out.println("Methods 2");
	}
	@Test
	private void tc3() {
     System.out.println("Methods 3");
     Assert.assertTrue(false);
	}
	@Test
	private void tc4() {
      System.out.println("Methods 4");
	}

}
