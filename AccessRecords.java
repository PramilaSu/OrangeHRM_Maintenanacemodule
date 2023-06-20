package com.testng.OrangeHRM_MaintenanceModule;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccessRecords {
	
	WebDriver driver;
	Properties p;
		
		@BeforeMethod
		
		public void beforemethod() {
			
			driver = new ChromeDriver();
			System.out.println(">> Chrome Browser Launched");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		  
			try {
				FileInputStream fis = new FileInputStream("D:\\ExcelR\\Selenium 4Jan Batch\\Tentngdemo\\src\\test\\java\\com\\utils\\TestNg\\access_records.properties");
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
			    String accessrecordsloc=p.getProperty("access_records_loc");
			    
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
		        driver.findElement(By.xpath(administratorAccessCancelbuttonloc)).click();  
		        driver.findElement(By.xpath(maintainancetabloc)).click();
		        driver.findElement(By.name(adminpasswordloc)).sendKeys(password);	
		        Thread.sleep(3000);
		        driver.findElement(By.xpath(administratorconfirmbuttonloc)).click();
		        driver.findElement(By.xpath(accessrecordsloc)).click();
   	      	    System.out.println(">> Download Personal Data page opens succesfully");
			    }
			
			  catch(Exception e) {
				}
		}
		
		@AfterMethod
         public void aftermethod() {
			driver.quit();
		 }
            @Test(priority=2)
		  public void searchWithInvalidData() {
		try {
			String InvalidEmpname= p.getProperty("employeename");
		    String accessrecordsloc=p.getProperty("access_records_loc");
		    String employeenameloc=p.getProperty("employee_name_loc");
		    String searchbuttonloc=p.getProperty("search_button_loc");
		    
             driver.findElement(By.xpath(accessrecordsloc)).click();
	      	 System.out.println(">> Download Personal Data page opens succesfully");
	      	  
	      	WebElement EmpName = driver.findElement(By.cssSelector(employeenameloc));
	      	EmpName.sendKeys(InvalidEmpname);
	      	Thread.sleep(3000);
	      	driver.findElement(By.xpath(searchbuttonloc)).click();
	      	System.out.println(">> Invalid Error message displayed");
	      	
	   	   }  
	      	  catch(Exception e) {
	      	  }
	 	 }

	      @Test(priority=1)
		  public void searchWithValidData() {
	    		try {
	    			String Empname= p.getProperty("employeename");
	    		    String accessrecordsloc=p.getProperty("access_records_loc");
	    		    String employeenameloc=p.getProperty("employee_name_loc");
	    		    String searchbuttonloc=p.getProperty("search_button_loc");
	    		    
	                 driver.findElement(By.xpath(accessrecordsloc)).click();
	    	      	 System.out.println(">> Download Personal Data page opens succesfully");
	    	      	  
	    	      	WebElement EmployeeName = driver.findElement(By.cssSelector(employeenameloc));
	    	      	EmployeeName.sendKeys(Empname);
	    	      	Thread.sleep(3000);
	    	      	driver.findElement(By.xpath(searchbuttonloc)).click();
	    	      	System.out.println(">> Search result is displayed");
	    	      	
	    	   	   }  
	    	      	  catch(Exception e) {
	    	      	  }
	           }

	 
		 @Test(priority=0)
		  public void downLoadPersonalData() {
		
		  try {
		    String Empname= p.getProperty("employeename");
		    String accessrecordsloc=p.getProperty("access_records_loc");
		    String employeenameloc=p.getProperty("employee_name_loc");
		    String autoselectloc=p.getProperty("auto_select_loc");
		    String searchbuttonloc=p.getProperty("search_button_loc");
		    String downloadbuttonloc=p.getProperty("download_button_loc");

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
	      	 driver.findElement(By.xpath(downloadbuttonloc)).click();
	      	 System.out.println(">> Employee data is Downloaded successfully");
	      	  Thread.sleep(5000);
	 	}
     
		 catch(Exception e){
     	  }
		}  

	 }


 
