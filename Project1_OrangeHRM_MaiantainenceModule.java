package com.testng.examples;
    
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

	public class Project1_OrangeHRM_MaiantainenceModule {
	WebDriver driver;
		
		@BeforeMethod
		void beforeTestExecution() {
			driver = new ChromeDriver();
			System.out.println(">> Chrome Browser Launched");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  }
		 @AfterMethod
		 void afterTestExecution() {
			System.out.println("Maintainence/Purge Records executed succesfully");
		 }
	  @Test
	  public void verifyOrangeHRMLogin() {
			try {
				FileInputStream fis = new FileInputStream("D:\\ExcelR\\Selenium 4Jan Batch\\Tentngdemo\\src\\test\\java\\com\\utils\\TestNg\\data1.properties");
				Properties p = new Properties();
				p.load(fis);
			    String username= p.getProperty("user");
				String password= p.getProperty("passwd");
				String Empname= p.getProperty("employeename");
				String Vacancy= p.getProperty("vacancy");
				
				String usernameloc= p.getProperty("username_loc");
				String passwordloc= p.getProperty("password_loc");
				String loginloc= p.getProperty("login_loc");
				
				String maintainancetabloc= p.getProperty("maintainance_tab_loc");
				String administratorAccessCancelbuttonloc= p.getProperty("administrator_Access_Cancel_button_loc");
				String adminpasswordloc= p.getProperty("admin_password_loc");
			    String administratorconfirmbuttonloc= p.getProperty("administrator_confirm_button_loc");
			    
			    String accessrecordsloc=p.getProperty("access_records_loc");
			    String employeenameloc=p.getProperty("employee_name_loc");
			    String autoselectloc=p.getProperty("auto_select_loc");
			    String searchbuttonloc=p.getProperty("search_button_loc");
			    String downloadbuttonloc=p.getProperty("download_button_loc");
			    
			    String purgerecordsloc=p.getProperty("purge_records_loc");
			    String purgerecordsdropdownloc=p.getProperty("purge_records_dropdown_loc");
			    String vacancyfieldloc=p.getProperty("vacancy_field_loc");
			    String searchresultsloc=p.getProperty("search_results_loc");
			    String purgeallloc=p.getProperty("purge_all_loc");
			    String nocancelalertboxloc=p.getProperty("no_cancel_alert_box_loc");
			    String yesacceptalertboxloc=p.getProperty("yes_accept_alert_box_loc");
			    
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
	    
		     
		         //Access Records
		    	driver.findElement(By.xpath(accessrecordsloc)).click();
		      	 System.out.println(">> Download Personal Data page opens succesfully");
		      	  
		      
			    WebElement EmployeeName = driver.findElement(By.cssSelector(employeenameloc));
		      	EmployeeName.sendKeys(Empname);
		      	Thread.sleep(3000);
		      	System.out.println(">> Employee name selected succesfully");
		      	
		   	   List<WebElement> elements = driver.findElements(By.xpath(autoselectloc));
		   	
		   	     System.out.println(elements.size());
		   	    
		   	    for (WebElement b:elements) {
		   	      String element = b.getText();
		   	      System.out.println(element); 
		   	      
		   	      if(element.equalsIgnoreCase(Empname)) {
		   	    	  b.click();
		   	    	Thread.sleep(5000);
		   	    	  break;
		   	     }
		        }
		   	    
		   	    
		        driver.findElement(By.xpath(searchbuttonloc)).click();
		      	 System.out.println(">> Search results: Employee Full name, Employee id and Download option displayed succesfully");
		      	 
		      	driver.findElement(By.xpath(downloadbuttonloc)).click();
		      	 System.out.println(">> Employee data is Downloaded successfully");
		      	Thread.sleep(5000);
		      	
		       //Purge Records
				driver.findElement(By.xpath(purgerecordsloc)).click();
		
			    List<WebElement> list= driver.findElements(By.xpath(purgerecordsdropdownloc));	
			      System.out.println(list.size());
			   
			      Iterator<WebElement> iterator1 = list.iterator();
				   while(iterator1.hasNext()) {
				   	      
				   WebElement webElement =(WebElement) iterator1.next();
				    System.out.println(webElement.getText());
				   	       
				  	if(webElement.getText().equals("Candidate Records")){
				        webElement.click();
			      
			   	     }
				    
				    driver.findElement(By.cssSelector(vacancyfieldloc)).sendKeys(Vacancy);
				    Thread.sleep(4000);
				    System.out.println(">> Vacancy is displayed succesfully");
				    driver.findElement(By.xpath(searchresultsloc)).click();
				    System.out.println(">> Search results: Candidate name, Date of Application and status is displayed succesfully");
				    
					driver.findElement(By.xpath(purgeallloc)).click();                    //Purge All
					driver.findElement(By.xpath(nocancelalertboxloc)).click();            //dismiss alert
					System.out.println(">>Purge Candidate alert box: No Cancel selected");
					
					
					driver.findElement(By.xpath(purgeallloc)).click();                     //Purge All
					driver.findElement(By.xpath(yesacceptalertboxloc)).click();           //accepting alert
					System.out.println(">>Purge Candidate alert box: Yes Purge selected");
					
				}
			}
					
			  catch(Exception e) {
			}
	   }
	}
	
	  
