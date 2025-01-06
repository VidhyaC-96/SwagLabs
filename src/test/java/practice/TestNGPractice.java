package practice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestNGPractice {
@Test(priority=1,invocationCount=3)
	public void sampleTest() {
		System.out.println("sampleText");
	}
@Test(priority=2)
public void demo() {
	System.out.println("demo");
}
@Test
public void hello() {
	//Assert.fail();
	System.out.println("hello");
}
@Test(/*dependsOnMethods="hello"*/enabled=false)
public void hi() {
	System.out.println("hi");
}
@Test(dataProvider="getData")
public void addProduct(String name,int qty) {
	System.out.println(name+"->"+qty+"->"+"product added");
}
@DataProvider
public Object[][] getData(){
	Object[][]d=new Object[3][2];
		d[0][0]="iphone";
		d[0][1]=10;	
		
		d[1][0]="Pixel";
		d[1][1]=20;
		
		d[2][0]="Samsung";
		d[2][1]=30;
		
		return d;
	

	
}
}
