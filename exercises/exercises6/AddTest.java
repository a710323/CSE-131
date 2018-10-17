package exercises6;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddTest {

	@Test
	public void test() {
		assertEquals(0, Add.add(0, 0));
		//
		// write other test cases here:
		//
		for (int i = 0; i < 100; i++) {
			assertEquals(i, Add.add(0,i));
			assertEquals(i, Add.add(i,0));
		}
	}
	@Test
	public void test2() {
		for (int i=0; i<100; i++) {
			for (int j = 0; j<200; j++) {
				assertEquals(i+j, Add.add(i, j));
			}
		}
	}
	@Test
	public void test3() {
		assertEquals(-2,Add.addAny(2, -4));
		for(int i=-100;i<100;i++) {
			for(int j =-100; j<100;j++) {
				assertEquals(i+j, Add.addAny(i, j));
			}
		}
	}

}
