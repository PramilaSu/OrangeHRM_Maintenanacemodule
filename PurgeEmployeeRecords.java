package com.testng.OrangeHRM_MaintenanceModule;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PurgeEmployeeRecords {
		WebDriver driver;
		Properties p;
			
			@BeforeMethod
			public void beforemethod() {
				
				driver = new ChromeDriver();
				System.out.println(">> Chrome Browser Launched");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
			  
				try {
					FileInputStream fis = new FileInputStream("D:\\ExcelR\\Selenium 4Jan Batch\\Tentngdemo\\src\\test\\java\\com\\utils\\TestNg\\purge_records_employee.properties");
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
			        driver.findElement(By.xpath(maintainancetabloc)).click();
			        System.out.println(">> Maintenance module access succesfully");
			        driver.findElement(By.xpath(administratorAccessCancelbuttonloc)).click();  
			        System.out.println(">> Verfied Administrator Acess Cancel succesfully");
			        driver.findElement(By.xpath(maintainancetabloc)).click();
			        driver.findElement(By.name(adminpasswordloc)).sendKeys(password);	
			        Thread.sleep(3000);
			        driver.findElement(By.xpath(administratorconfirmbuttonloc)).click();
			         System.out.println(">> Administrator Access Login succesfully");
				     Thread.sleep(3000);
				    }
				
				  catch(Exception e) {
					}
			}
			
			 @AfterMethod
			
			   public void aftermethod() {
				//driver.quit();
			 }
			 @Test(priority=1)
			 public void purgeEmployeeRecords() {
	      
	           try {
	            String pastemployee= p.getProperty("past_employee");
	            String pastemployeefieldloc=p.getProperty("past_employee_field_loc");
	            String searchbuttonloc=p.getProperty("search_button_loc");
	            String dropdownemprecordsloc=p.getProperty("dropdown_emprecords_loc");
	            String purgerecordsloc=p.getProperty("purge_records_loc");
	            
	            //Purge  Records
		       driver.findElement(By.xpath(purgerecordsloc)).click();

	           List<WebElement> list= driver.findElements(By.xpath(dropdownemprecordsloc));	
	             
	              Iterator<WebElement> iterator1 = list.iterator();
		           while(iterator1.hasNext()) {
		   	          WebElement webElement =(WebElement) iterator1.next();
		              System.out.println(webElement.getText());
		   	             if(webElement.getText().equals("Employee Records")){
		                   webElement.click();
		   	             }
		           }  
		 		 driver.findElement(By.cssSelector(pastemployeefieldloc)).sendKeys(pastemployee);
		         Thread.sleep(4000);
		         System.out.println("Vacancy is displayed succesfully");
		         driver.findElement(By.xpath(searchbuttonloc)).click();
		         System.out.println("Search results: Employee name and details displayed succesfully");
		           } 
		           catch(Exception e) {
		           }
	           }  
		     
		        @Test(priority=0)
				 public void searchWithInvalidData() {
		      
		          try {
		        	   String invalidpastemp= p.getProperty("invalid_pastemp");
		        	   String pastemployeefieldloc=p.getProperty("past_employee_field_loc");
			           String searchbuttonloc=p.getProperty("search_button_loc");
		               driver.findElement(By.cssSelector(pastemployeefieldloc)).sendKeys(invalidpastemp);
		  	            Thread.sleep(4000);
		  	            WebElement clk= driver.findElement(By.xpath(searchbuttonloc));
	                     clk.click();
	                   System.out.println("Invalid Error message is displayed");
		          }    
		          catch(Exception e) {
		          }
		        }
		        
		        @Test(priority=2)
				 public void verifyPurgebutton() {
		      
		          try {
		        	    String pastemployee= p.getProperty("past_employee");
			            String pastemployeefieldloc=p.getProperty("past_employee_field_loc");
			            String searchbuttonloc=p.getProperty("search_button_loc");
			            String purgeloc=p.getProperty("purge_loc");
			       	      driver.findElement(By.cssSelector(pastemployeefieldloc)).sendKeys(pastemployee);
			               Thread.sleep(4000);
			       
		  	              driver.findElement(By.xpath(searchbuttonloc)).click();
	                      driver.findElement(By.xpath(purgeloc)).click();
	                       Thread.sleep(4000);
	                   }    
		          catch(Exception e) {
		          } 
		        }
			
		        @Test(priority=3)
				 public void noCancelAlertBox() {
		      
		          try {
		        	  String pastemployee= p.getProperty("past_employee");
			          String pastemployeefieldloc=p.getProperty("past_employee_field_loc"); 
		        	  String searchbuttonloc=p.getProperty("search_button_loc");
			          String purgeloc=p.getProperty("purge_loc");;
		              String nocancelalertboxloc=p.getProperty("no_cancel_alert_box_loc");
		              
		               driver.findElement(By.cssSelector(pastemployeefieldloc)).sendKeys(pastemployee);
		               Thread.sleep(4000);
		  	           driver.findElement(By.xpath(searchbuttonloc)).click();
	                   driver.findElement(By.xpath(purgeloc)).click(); 
	                   driver.findElement(By.xpath(nocancelalertboxloc)).click();
	                   System.out.println("Purge Employee alert box: No Cancel selected");
		            }    
		          catch(Exception e) {
		          }
		        }
		    
		        @Test(priority=4)
				 public void yesAcceptAlertBox() {
		      
		          try {
		        	  String pastemployee= p.getProperty("past_employee");
			          String pastemployeefieldloc=p.getProperty("past_employee_field_loc"); 
		        	  String searchbuttonloc=p.getProperty("search_button_loc");
			          String purgeloc=p.getProperty("purge_loc");;
		              String yesacceptalertbox_loc=p.getProperty("yes_accept_alert_box_loc");
		              
		               driver.findElement(By.cssSelector(pastemployeefieldloc)).sendKeys(pastemployee);
		               Thread.sleep(4000);
		  	           driver.findElement(By.xpath(searchbuttonloc)).click();
	                   driver.findElement(By.xpath(purgeloc)).click(); 
	                   driver.findElement(By.xpath(yesacceptalertbox_loc)).click();       
	          		    System.out.println("Purge Employee alert box: Yes Purge selected");
		               }    
		          catch(Exception e) {
		          }
		        }
		  }
