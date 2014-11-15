package com.github.augusto1982.betelgeuse.dp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * 
 * @author Augusto
 *
 */
public class MinimumStepsToOneTest {
	
	MinimumStepsToOne msto;
	
	@Before
	public void before(){
		this.msto = new MinimumStepsToOne();
	}
	
	
	@Test
	public void testDP(){
		assertEquals(this.msto.stepsRequiredWithDP(1), 0);
		assertEquals(this.msto.stepsRequiredWithDP(9), 2);
		assertEquals(this.msto.stepsRequiredWithDP(4), 2);
		assertEquals(this.msto.stepsRequiredWithDP(0), -1);
		assertEquals(this.msto.stepsRequiredWithDP(-10), -1);
		
	}
	
	@Test
	public void testMemo(){
		assertEquals(this.msto.stepsRequiredWithMemo(1), 0);
		assertEquals(this.msto.stepsRequiredWithMemo(9), 2);
		assertEquals(this.msto.stepsRequiredWithMemo(4), 2);
		assertEquals(this.msto.stepsRequiredWithMemo(0), -1);
		assertEquals(this.msto.stepsRequiredWithMemo(-10), -1);
		
	}
	

}
