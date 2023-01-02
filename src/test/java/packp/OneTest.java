package packp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.apache.logging.log4j.LogManager;

public class OneTest implements ILogger{
	WebDriver driver;
	
	
  
  
  @BeforeClass
  public void openBrowser() {
	    System.setProperty("webdriver.chrome.driver\"", "/home/josh/eclipse-workspace/SeleniumDemo/Resources/chromedriver.exe");
	  //ChromeOptions options = new ChromeOptions();
	  		  System.out.println("1 pass");

	//options.setExperimentalOption("useAutomationExtension", false);
		driver = new ChromeDriver();
	  		  System.out.println("2 PASS");

		driver.get("http://qatechhub.com");
	  		  System.out.println("3 PASS");

		driver.manage().window().maximize();
	  		  System.out.println("4 PASS");

  }  
  
  @Test
  public void testOne() {
	  String acttitle = driver.getTitle();
	  if(acttitle.equalsIgnoreCase("QA Automation Tools Trainings and Tutorials | QA Tech Hub")){
		  System.out.println("PASS");
	  }
	  else {
		  System.out.println("FAIL");
	  }
  }
  

  @AfterTest
  public void afterTest() {
	  driver.navigate().to("https://www.facebook.com");
	  System.out.println("Navigated to facebook");
	  driver.navigate().back();
	  System.out.println("Navigated back to QAtechhub");
	  System.out.println("URL is: "+driver.getCurrentUrl());
	  driver.navigate().forward();
	  System.out.println("Navigated forward to facebook again");
	  driver.navigate().refresh();
  }
  
  @AfterSuite
  public void close() {
	  driver.close();
  }
  
}
