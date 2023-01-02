package packp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtendReportDemo {
	WebDriver driver;
	ExtentReports e;
	@BeforeMethod
	public void beforeMethod() {
		String file = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(file);
		report.config().setReportName("Extent Report QA Techhub");
		report.config().setDocumentTitle("Extent Report");
		
		e = new ExtentReports();
		e.attachReporter(report);
		e.setSystemInfo("OS", "Ubuntu");
	}
	
	@Test
	public void test() {
		ExtentTest etest = e.createTest("Test started");
		etest.info("Chrome launched");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://qatechhub.com");
		driver.manage().window().maximize();
		etest.info("Navigated to qatechhub");
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
		e.flush();
	}

}
