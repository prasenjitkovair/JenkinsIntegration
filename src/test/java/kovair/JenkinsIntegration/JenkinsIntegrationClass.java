package kovair.JenkinsIntegration;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JenkinsIntegrationClass {
  
	
  @Test
  public void Test1() {
	  System.out.println("In Test 1");
	  Assert.assertTrue(true);
  }
  
  
  @Test
  public void Test2() {
	  System.out.println("In Test 2");
	  Assert.fail();
	  //Assert.assertTrue(true);
	  
  }
  
  @Test
  public void Test3() {
	  System.out.println("In Test 3");
	  Assert.assertTrue(true);
  }
}
