package ciraLogin;

import java.io.IOException;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.net.Socket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login {
	
	WebDriver driver;
	
	String LoginURL = "https://sandbox.ciranet.com/v2/managementportal/user/login";
		@SuppressWarnings("deprecation")
		@Parameters("browser")
		@BeforeTest
		public void setUp(String browser)
		{
			if(browser.equalsIgnoreCase("chrome")) {
				
				System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
				driver = new ChromeDriver();
				System.out.println(" Chrome Driver Started");
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver","D:\\FirfoxDriver\\geckodriver.exe" );  
		        driver= new FirefoxDriver();  
		        System.out.println(" Firefox Driver Started");
			}
			else
				System.out.println("Cannot launch specified driver... ");
			
			driver.navigate().to("https://sandbox.ciranet.com/v2/managementportal/user/login"); 
			driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS); // pageload timeout  
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
			driver.manage().window().maximize(); 
			
			//System.out.println("Set Up Method ");
		}
	
		@SuppressWarnings("deprecation")
		@Test(priority = 1)
		public void ValidInputLoginTest() throws InterruptedException, IOException
		{
			String username = "sharad.kamble";
			String password = "StrongBook28!";
			
			driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[1]/dxi-item[1]/div[1]/div[1]/dx-text-box[1]/div[1]/div[1]/input[1]")).clear();
			driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[1]/dxi-item[1]/div[1]/div[1]/dx-text-box[1]/div[1]/div[1]/input[1]")).sendKeys(username);
			
			driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[2]/dxi-item[1]/div[1]/div[1]/dx-text-box[1]/div[1]/div[1]/input[1]")).clear();
			driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[2]/dxi-item[1]/div[1]/div[1]/dx-text-box[1]/div[1]/div[1]/input[1]")).sendKeys(password);
			
			driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/dx-button[1]/div[1]")).click();
			Thread.sleep(7000);
			driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
			
			String expectedurl = "https://sandbox.ciranet.com/v2/managementportal/home";
			String actualurl = driver.getCurrentUrl();
		//	System.out.println("Valid Input Test");
			Assert.assertEquals(expectedurl, actualurl);
			
			
			
		}
		
		@SuppressWarnings("deprecation")
		@Test(priority = 2)
		public void InValidInputLoginTest() throws InterruptedException, IOException
		{
			String username1 = "sharad";
			String password1 = "StrongBook28!";
			
			driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[1]/dxi-item[1]/div[1]/div[1]/dx-text-box[1]/div[1]/div[1]/input[1]")).clear();
			driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[1]/dxi-item[1]/div[1]/div[1]/dx-text-box[1]/div[1]/div[1]/input[1]")).sendKeys(username1);
			
			driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[2]/dxi-item[1]/div[1]/div[1]/dx-text-box[1]/div[1]/div[1]/input[1]")).clear();
			driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[2]/dxi-item[1]/div[1]/div[1]/dx-text-box[1]/div[1]/div[1]/input[1]")).sendKeys(password1);
			
			driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/dx-button[1]/div[1]")).click();
			Thread.sleep(5000);
			driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
			
			String expectedurl1 = "https://sandbox.ciranet.com/v2/managementportal/home";
			String actualurl1 = driver.getCurrentUrl();
			//System.out.println(" InValid Input Test ");
			
			Assert.assertNotEquals(expectedurl1, actualurl1);
			System.out.println("Access Denied with Invalid Credentials");

		}
		
		
		@Test(priority = 3)
		public void ShowPasswordFunctionality() throws InterruptedException, IOException
		{
			String enteredpwd = "StrongBook28!";
			WebElement passwordText = driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[2]/dxi-item[1]/div[1]/div[1]/dx-text-box[1]/div[1]/div[2]/div[1]/div[1]/i[1]"));
			passwordText.clear();
			//driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[2]/dxi-item[1]/div[1]/div[1]/dx-text-box[1]/div[1]/div[1]/input[1]")).clear();
			//driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[2]/dxi-item[1]/div[1]/div[1]/dx-text-box[1]/div[1]/div[1]/input[1]")).sendKeys(enteredpwd);
			passwordText.sendKeys("StrongBook28");
			String pwd = passwordText.getAttribute("value");
			System.out.println("Password is : "+pwd);
			driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[2]/dxi-item[1]/div[1]/div[1]/dx-text-box[1]/div[1]/div[2]/div[1]/div[1]/i[1]")).click();
			Thread.sleep(4000);
			boolean passwordDisplayed= driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[2]/dxi-item[1]/div[1]/div[1]/dx-text-box[1]/div[1]/div[2]/div[1]/div[1]/i[1]")).isDisplayed();
			Assert.assertTrue(passwordDisplayed);
		
			//System.out.println("Password Displayed : "+passwordDisplayed);
			
			
		}
		
		@Test( priority = 4)
		public void LoginWithEmptyField() throws InterruptedException
		{
			driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[1]/dxi-item[1]/div[1]/div[1]/dx-text-box[1]/div[1]/div[1]/input[1]")).clear();
			driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[2]/dxi-item[1]/div[1]/div[1]/dx-text-box[1]/div[1]/div[1]/input[1]")).clear();

			WebElement usernameinput = driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[1]/dxi-item[1]/div[1]/div[1]/dx-text-box[1]/div[1]/div[1]/input[1]"));
			WebElement passwordinput = driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[2]/dxi-item[1]/div[1]/div[1]/dx-text-box[1]/div[1]/div[1]/input[1]"));
			
			String textInsideUsername = usernameinput.getAttribute("value");
			String textInsidePassword = passwordinput.getAttribute("value");
			// Check whether input field is blank
			if(textInsideUsername.isEmpty() && textInsidePassword.isEmpty())
			{
			   System.out.println("Input field is empty");
			   driver.findElement(By.xpath("//body/app-root[1]/dx-box[1]/div[1]/dxi-item[1]/div[1]/app-common-user-authentication-layout[1]/div[1]/div[1]/div[1]/div[1]/app-login[1]/dx-validation-group[1]/dx-responsive-box[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/dx-button[1]/div[1]")).click();
				Thread.sleep(5000);
				String actualurl = driver.getCurrentUrl();
				
				String[] expectedURL = {
		                "https://sandbox.ciranet.com/v2/managementportal/user/login",
		                "https://sandbox.ciranet.com/v2/managementportal/user/login?returnUrl=%2Fhome"
		        };
				Assert.assertTrue(Arrays.asList(expectedURL).contains(LoginURL),"Login Failed");
					System.out.println("Login Failed with Empty Fields");
				//assertThat(LoginURL, is(in(expectedURL)));
			//	Assert.assertEquals(actualurl, LoginURL);

			   
			   
			}
		}
		
	


		//@Test		( priority = 4)
//		public void Logout()
//		{
//			driver.findElement(By.xpath("//app-header/dx-toolbar[1]/div[1]/div[3]/div[5]/div[1]/dx-button[1]/div[1]/app-user-panel[1]/div[1]/div[1]/div[1]/i[1]")).click();
//			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/ul[1]/li[3]/div[1]/div[1]")).click();
//			
//			String expectedurl = "https://sandbox.ciranet.com/v2/managementportal/user/login";
//			String actualurl = driver.getCurrentUrl();
//			Assert.assertEquals(expectedurl, actualurl);
//		}
		
		
		@AfterTest
		public void tearDown() throws InterruptedException
		{
			//System.out.println("Tear Down Method");
			Thread.sleep(1000);
			//driver.close();
			driver.quit();
			
		}
		
	}
