package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import Pages.LoginPage;

public class LoginTest extends BaseClass{
	
	
	
	@Test
	
	public void LoginFailureTest() {
		
				
				//test = report.startTest("LoginFailureTest");	
				LoginPage login = new LoginPage();
				login.LoginFunction("xyx@abc.com","Abc@1234");
				
				WebElement ErrorMsg = driver.findElement(By.id("msg_box")); 
				
				String ActualMsg = ErrorMsg.getText();
				String ExpMsg = "The email or password you have entered is invalid.";
				
				Assert.assertEquals(ActualMsg, ExpMsg);
				//report.endTest(test);
		
		}
	
	@Test
	
	public void LoginSuccessTest() {
		
		//test = report.startTest("LoginSuccessTest");
		LoginPage login = new LoginPage();
			login.LoginFunction("akepati.prashanti@gmail.com","79154hkq");
			//report.endTest(test);
		}
	
	
	@Test
	@Parameters({"Param1","Param2"})
	public void ParameterizedTest(String UserNameVal, String PasswordVal) {
		
		//test = report.startTest("ParameterizedTest");
		LoginPage login = new LoginPage();
		login.LoginFunction(UserNameVal,PasswordVal);	
		//report.endTest(test);
	}

	
	@Test
	public void ExternalDataTest() {
		
		String UserNameVal= sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal= sheet.getRow(1).getCell(1).getStringCellValue();
		
		
		//test = report.startTest("ExternalDataTest");
		LoginPage login = new LoginPage();
		login.LoginFunction(UserNameVal,PasswordVal);	
		//report.endTest(test);
	}
}
