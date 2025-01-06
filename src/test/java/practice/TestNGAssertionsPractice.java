package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGAssertionsPractice {
@Test
	public void hardAssert() {
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		Assert.assertEquals(1, 1);
		System.out.println("Step4");
		System.out.println("Step5");
	}

@Test
public void softAssert() {
	SoftAssert s=new SoftAssert();
	System.out.println("Step1");
	System.out.println("Step2");
	System.out.println("Step3");
	s.assertEquals(1, 1);
	System.out.println("Step4");
	s.assertEquals("hi", "hello");
	System.out.println("Step5");
	s.assertAll();
	
}

}
