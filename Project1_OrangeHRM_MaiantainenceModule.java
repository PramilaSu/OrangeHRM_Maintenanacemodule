package com.testng.examples;
    
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
			System.out.println("Maintainence/Purge Records displayed succesfully");
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
				
				driver.findElement(By.name("username")).sendKeys(username);	
				System.out.println(">> Username entered succesfully"); 
				driver.findElement(By.name("password")).sendKeys(password);
				System.out.println(">> Password entered succesfully"); 
				Thread.sleep(3000);
		        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		        System.out.println(">> Login succesfully"); 
		        Thread.sleep(3000);
		        
		        //Maintenance tab access
		        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[10]/a")).click();
		     
		         System.out.println(">> Maintenance module access succesfully");
		        
		       //Administrator Access_Cancel button
		        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/form/div[4]/button[1]")).click();  
		        System.out.println(">> Verfied Administrator Acess Cancel succesfully");
		        
		      //Administrator Access_Confirm button
		        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[10]/a")).click();
		        driver.findElement(By.name("password")).sendKeys(password);	
		        Thread.sleep(3000);
		        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/form/div[4]/button[2]")).click();
		         System.out.println(">> Administrator Access Login succesfully");
	    
		     
		         //Access Records
		    	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a")).click();
		      	 System.out.println(">> Download Personal Data page opens succesfully");
		      	  
		      
			    WebElement EmployeeName = driver.findElement(By.cssSelector("input[placeholder='Type for hints...']"));
		      	EmployeeName.sendKeys(Empname);
		      	Thread.sleep(3000);
		      	System.out.println(">> Employee name selected succesfully");
		      	
		   	   List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/form/div[1]/div/div/div/div[2]/div/div/input"));
		   	
		   	     System.out.println(elements.size());
		   	    
		   	    for (WebElement b:elements) {
		   	      String element = b.getText();
		   	      System.out.println(element); 
		   	      
		   	      if(element.equalsIgnoreCase("Odis Adalwin")) {
		   	    	  b.click();
		   	    	  break;
		   	     }
		        }
		   	    
		   	    
		        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/form/div[2]/button")).click();
		      	 System.out.println(">> Search results: Employee Full name, Employee id and Download option displayed succesfully");
		      	 
		      	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/div/form/div[2]/button")).click();
		      	 System.out.println(">> Employee data is Downloaded successfully");
		      	 
		     //Purge Records
				 List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/span/i"));
				 
			      		
				   int count = list.size();
				   System.out.println(count);
				    list.get(count).click();
				      
				   Iterator<WebElement> iterator = list.iterator();
				    while(iterator.hasNext()) {
				   	      
				   WebElement webElement =(WebElement) iterator.next();
				    System.out.println(webElement.getText());
				   	       
				   	  if(webElement.getText().equals("Candidate Records")){
				   	      webElement.click();
				   	        	
				   	 WebElement Candidaterecord = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/form/div[1]/div/div/div/div[2]/div/div/input"));
				   	Candidaterecord.sendKeys(Vacancy);
			      	Thread.sleep(3000);
			      	System.out.println(">> Candidaterecord displayed succesfully");    
			      	
			      	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click(); //Purge All
				   	   }
				  	  }
		      	
				}	
			catch(Exception e) {
			}
	  }
	 
}
	
	  
