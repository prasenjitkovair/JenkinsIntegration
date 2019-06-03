package kovair.JenkinsIntegration;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JenkinsIntegrationClass {
  
	
  @Test
  public void Test1() {
	  System.out.println("In Test 1");
	  
  }
  
  
  @Test
  public void Test2() {
	  System.out.println("In Test 2");
	  Assert.fail();
	  
  }
  
  @Test
  public void Test3() {
	  System.out.println("In Test 3");
	  
  }
}
