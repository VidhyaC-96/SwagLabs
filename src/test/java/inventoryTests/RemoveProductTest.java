package inventoryTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
@Listeners(genericUtilities.ListenerImplementation.class)
public class RemoveProductTest extends BaseClass  {
@Test(groups="RegressionSuite",retryAnalyzer=genericUtilities.IRetryAnalyserImplementation.class)
	public void tc_002_RemoveProductFromCart() {
	
	//Assert.fail();
	System.out.println("Removed");
	}

@Test
public void RemoveProduct(){   /* to check maven command line particular method*/
	System.out.println("Success");
}
}
