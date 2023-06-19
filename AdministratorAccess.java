package com.testng.OrangeHRM_MaintenanceModule;
    
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdministratorAccess {
WebDriver driver;
		
		@BeforeMethod
		public void beforemethod() {
			
			driver = new ChromeDriver();
			System.out.println(">> Chrome Browser Launched");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			}
		
		 @AfterMethod
		 void aftermethod() {
			//driver.quit(); 
			 }
		 
	  @Test
	  public void administratorLogin() {
			try {
				FileInputStream fis = new FileInputStream("D:\\ExcelR\\Selenium 4Jan Batch\\Tentngdemo\\src\\test\\java\\com\\utils\\TestNg\\administrator_access.properties");
				Properties p = new Properties();
				p.load(fis);
				String url= p.getProperty("mainURL");
			    String username= p.getProperty("user");
				String password= p.getProperty("passwd");
                String usernameloc= p.getProperty("username_loc");
				String passwordloc= p.getProperty("password_loc");
				String loginloc= p.getProperty("login_loc");
				String maintainancetabloc= p.getProperty("maintainance_tab_loc");
				String administratorAccessCancelbuttonloc= p.getProperty("administrator_Access_Cancel_button_loc");
				String adminpasswordloc= p.getProperty("admin_password_loc");
			    String administratorconfirmbuttonloc= p.getProperty("administrator_confirm_button_loc");
			    
			    driver.get(url);
				driver.findElement(By.name(usernameloc)).sendKeys(username);	
				System.out.println(">> Username entered succesfully"); 
				driver.findElement(By.name(passwordloc)).sendKeys(password);
				System.out.println(">> Password entered succesfully"); 
				Thread.sleep(3000);
		        driver.findElement(By.xpath(loginloc)).click();
		        System.out.println(">> Login succesfully"); 
		        Thread.sleep(3000);
		        
		        //Maintenance tab access
		        driver.findElement(By.xpath(maintainancetabloc)).click();
		        System.out.println(">> Maintenance module access succesfully");
		        
		       //Administrator Access_Cancel button
		        driver.findElement(By.xpath(administratorAccessCancelbuttonloc)).click();  
		        System.out.println(">> Verfied Administrator Acess Cancel succesfully");
		        
		      //Administrator Access_Confirm button
		        driver.findElement(By.xpath(maintainancetabloc)).click();
		        driver.findElement(By.name(adminpasswordloc)).sendKeys(password);	
		        Thread.sleep(3000);
		        driver.findElement(By.xpath(administratorconfirmbuttonloc)).click();
		         System.out.println(">> Administrator Access Login succesfully");
			    
			    }
			  catch(Exception e) {
				}
			
	    }
	}
	
	  
