package marriageVerse;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.DataGen;
import utils.ExcelUti;

public class addProfile2 {
	
	
	// Geneder Xpaht -> //ion-segment-button[@value='FEMALE']

static	WebDriver driver;
static	DataGen dg;
	 
	 
static	 String sheetName="Sheet1";
static	 String fileName;
static	 int row=0;
	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		dg = new DataGen();
		driver.get("https://mverse-7ed6d.web.app");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 fileName = ExcelUti.createExcelFile();

        // Add data to the file
       
	}
	
	@Test
	public void enterMaleAndFemalePro() throws InterruptedException, AWTException
	{
		int mp=0;
		int fp=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("How many male profiles you want to create");
		mp=sc.nextInt();
		
		System.out.println("How many female profile you want to create");
		fp=sc.nextInt();
		
		System.out.println(mp +" "+fp);
		
		for(int i=0;i<mp;i++)
		{
			addProfiles("//ion-segment-button[@value='MALE']");
		}
		
		for(int i=0;i<fp;i++)
		{
			addProfiles("//ion-segment-button[@value='FEMALE']");
		}
		
	}

	// for Male and female 


	public static void addProfiles(String gen) throws InterruptedException, AWTException {
	
	int col=0;
		driver.findElement(By.xpath("//a[@routerlink='/signup']")).click();
		String email=dg.getEmail();
		driver.findElement(By.xpath("//input[@placeholder='Enter Email']")).sendKeys(email);
		ExcelUti.addDataToExcel(fileName, sheetName, row, col++, email);
		
		String number=dg.getNumber();
		driver.findElement(By.xpath(
				"/html/body/app-root/ion-app/ion-router-outlet/app-signup/ion-content/div/form/app-input-floating[2]/ion-item/div/ion-input/input"))
				.sendKeys(number);
		
		ExcelUti.addDataToExcel(fileName, sheetName, row, col++, number);
		String pass=dg.getPassword();
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys(pass);
		ExcelUti.addDataToExcel(fileName, sheetName, row, col++, pass);
		
		
		driver.findElement(By.xpath("//ion-button[@type='button']")).click();
		driver.findElement(By.xpath(gen)).click();
		ExcelUti.addDataToExcel(fileName, sheetName, row, col++, "Male");
		// driver.findElement(By.cssSelector("div.wheel-order-month-first >
		// ion-picker-internal >
		// ion-picker-column-internal.day-column.ion-color.ion-color-primary.md.hydrated"))
		SearchContext c1 = driver.findElement(By.cssSelector(
				"body > app-root > ion-app > ion-router-outlet > app-signup1 > ion-content > div.date-input-container > ion-datetime"))
				.getShadowRoot();
		SearchContext c2 = c1.findElement(By.cssSelector(
				"div.wheel-order-month-first > ion-picker-internal > ion-picker-column-internal.day-column.ion-color.ion-color-primary.md.hydrated"))
				.getShadowRoot();
		c2.findElement(By.cssSelector("button:nth-child(5)")).click();

		// button

		SearchContext b1 = driver.findElement(By.cssSelector(
				"body > app-root > ion-app > ion-router-outlet > app-signup1 > ion-footer > ion-toolbar > div > ion-button"))
				.getShadowRoot();
		Thread.sleep(2000);
		WebElement button = b1.findElement(By.cssSelector("button.button-native[part='native']"));
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

		// new page information

		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='Enter your First Name']"));
         String fname=dg.getFirstName();
		firstName.sendKeys(fname);
		ExcelUti.addDataToExcel(fileName, sheetName, row, col++, fname);
		 
		/* @Last Name */
		String lname=dg.getLastName();
		driver.findElement(By.xpath("//input[@placeholder='Enter your Last Name']")).sendKeys(lname);
		ExcelUti.addDataToExcel(fileName, sheetName, row, col++, lname);
		driver.findElement(By.xpath(
				"/html/body/app-root/ion-app/ion-router-outlet/app-signup2/ion-content/form/app-input-floating[3]/ion-item/ion-input/input"))
				.click();

		Thread.sleep(2000);
		
//	//	SearchContext sal = driver.findElement(By.cssSelector(
//				"#select-custom-search > app-select-search > ion-content > cdk-virtual-scroll-viewport > div.cdk-virtual-scroll-content-wrapper > ion-item:nth-child(3) > span > ion-checkbox"))
//	//			.getShadowRoot();
////		Thread.sleep(2000);
		
		/* @salary */
		
		int salNum=DataGen.selectRandomSalary();
		//System.out.println("SalNumber --> "+salNum);
		
		System.out.println("Generated Xpath --> "+"//body//app-root//ion-item["+salNum+"]");
		WebElement salary = driver.findElement(By.xpath("//body//app-root//ion-item["+salNum+"]"));
		salary.click();
		 
		System.out.println("Salary --> "+salary.getText());
		ExcelUti.addDataToExcel(fileName, sheetName, row, col++, salary.getText());
		//#############occupation 
		Thread.sleep(2000);
		WebElement occ = driver.findElement(By.xpath("//*[@id=\"ion-input-11-lbl\"]"));
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", occ);

		
		// @ OCCUPATION

		int ocu=DataGen.selectRandomOccupation();
		Thread.sleep(1000);
	WebElement oc=	driver.findElement(By.xpath("//body//app-root//ion-item["+ocu+"]"));
		oc.click();
		
		ExcelUti.addDataToExcel(fileName, sheetName, row, col++,oc.getText() );
		Thread.sleep(1000);
		firstName.sendKeys(Keys.PAGE_DOWN);
		
		
		// select Religion

		Thread.sleep(1000);
		WebElement rel = driver.findElement(By.xpath("//app-input-floating[@formcontrlname='religion']"));
		rel.click();
		Thread.sleep(1000);
        
	
		int reli=DataGen.generateRandomReligion();
	WebElement relig=	driver.findElement(By.xpath("//body//app-root//ion-item["+reli+"]"));
	relig.click();
	
	ExcelUti.addDataToExcel(fileName, sheetName, row, col++, relig.getText());
		
		// -->  //body//app-root//ion-item[12

		
		// ############## Select Occupation 
		
		
		// ### SELECT CASTE
		
		
		driver.findElement(By.xpath(
				"//ion-input[@class='full-click-input ion-no-border ng-untouched ng-pristine ng-valid sc-ion-input-ios-h sc-ion-input-ios-s ios legacy-input hydrated ion-untouched ion-pristine ion-valid']"))
				.click();
		int cast=DataGen.selectRandomSalary();
	WebElement castR=	driver.findElement(By.xpath("//body//app-root//ion-item["+cast+"]"));
		castR.click();
		
		ExcelUti.addDataToExcel(fileName, sheetName, row, col++, castR.getText());
		System.out.println("***********");
		//#### SELECT MOTHER TONGUE
		WebElement mt = driver.findElement(By.xpath(
				"/html/body/app-root/ion-app/ion-router-outlet/app-signup2/ion-content/form/app-input-floating[7]/ion-item/ion-input"));
	  mt.click();
	  int lang=DataGen.selectRandomLanguage();
	WebElement lan=  driver.findElement(By.xpath("//body//app-root//ion-item["+lang+"]"));
	lan.click();
	  ExcelUti.addDataToExcel(fileName, sheetName, row, col++, lan.getText());
	  
	//click on location 
	  Thread.sleep(2000);
		WebElement cLoc = driver.findElement(By.cssSelector("input[placeholder='Current Location']"));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", cLoc);

		// type some address
        String city=DataGen.generateThreeCharacters();
		WebElement input = driver.findElement(By.cssSelector("div[class='address'] input"));
		input.sendKeys(city);
		System.out.println("Location "+input.getText());
		Thread.sleep(2000);
		input.sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		input.sendKeys(Keys.ENTER);
		System.out.println("CLOC1---------> "+cLoc.getText());
		Thread.sleep(2000);
		String gLoc=	driver.findElement(By.xpath("//input[@placeholder='Current Location']")).getText();
		System.out.println("gLoc --------> "+gLoc);	
		System.out.println("Input getText  "+input.getText());

		WebElement confirmClick = driver.findElement(By.cssSelector(
				"ion-buttons[class='buttons-last-slot sc-ion-buttons-ios-h sc-ion-buttons-ios-s ios hydrated'] ion-button[class='ios button button-clear in-toolbar in-buttons ion-activatable ion-focusable hydrated']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirmClick);
		Thread.sleep(1000);
		
	

	
		
		//slect next
		String cssSelectorForHost133 = "body > app-root:nth-child(3) > ion-app:nth-child(1) > ion-router-outlet:nth-child(1) > app-signup2:nth-child(4) > ion-footer:nth-child(3) > ion-toolbar:nth-child(1) > div:nth-child(1) > ion-button:nth-child(2)";
		Thread.sleep(1000);
		SearchContext shadowHost = driver.findElement(By.cssSelector(
				"body > app-root:nth-child(3) > ion-app:nth-child(1) > ion-router-outlet:nth-child(1) > app-signup2:nth-child(4) > ion-footer:nth-child(3) > ion-toolbar:nth-child(1) > div:nth-child(1) > ion-button:nth-child(2)"))
				.getShadowRoot();
		Thread.sleep(1000);
		WebElement next = shadowHost.findElement(By.cssSelector(".button-inner"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", next);

		// upload photo

		Thread.sleep(1000);
		driver.findElement(By.cssSelector(
				"body > app-root:nth-child(3) > ion-app:nth-child(1) > ion-router-outlet:nth-child(1) > app-signup3:nth-child(5) > ion-content:nth-child(2) > div:nth-child(1) > app-photo-edit:nth-child(2) > div:nth-child(1) > div:nth-child(1)"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(
				"body > app-root:nth-child(3) > ion-app:nth-child(1) > ion-action-sheet:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > button:nth-child(2)"))
				.click();

		Thread.sleep(1000);
		// Simulate typing the file path
//	String filePath = "C:/Users/Hustler/eclipse-workspace/MarriageVerse/Pictures/M4.jpg";
//	for (char c : filePath.toCharArray()) {
//	    int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
//	    robot.keyPress(keyCode);
//	    robot.keyRelease(keyCode);
//	}
//
//	// Simulate pressing Enter
//	robot.keyPress(KeyEvent.VK_ENTER);
//	robot.keyRelease(KeyEvent.VK_ENTER);
		
		String filePath = "C:\\Users\\Hustler\\eclipse-workspace\\MarriageVerse\\Pictures\\M4.jpg";
		if(gen.contains("FEMALE"))
		{
			filePath = "C:\\Users\\Hustler\\eclipse-workspace\\MarriageVerse\\Pictures\\F8.jpg";
		}
	
		
        Robot robot = new Robot();

        for (char c : filePath.toCharArray()) {
            int keyCode = getKeyEvent(c);

            // Handle uppercase letters and special cases
            if (Character.isUpperCase(c) || c == ':') {
                robot.keyPress(KeyEvent.VK_SHIFT);
            }

            // Press and release the key
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);

            // Release SHIFT if pressed
            if (Character.isUpperCase(c) || c == ':') {
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }

            // Delay to ensure proper key processing
            Thread.sleep(100);
        }

        // Simulate pressing Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    
//  
		Thread.sleep(3000);

		// This Element is inside single shadow DOM.
//	String cssSelectorForHost1 = "body > app-root:nth-child(3) > ion-app:nth-child(1) > ion-router-outlet:nth-child(1) > app-signup3:nth-child(5) > ion-footer:nth-child(3) > ion-toolbar:nth-child(1) > div:nth-child(1) > ion-button:nth-child(2)";
		Thread.sleep(2000);
		SearchContext nextHost = driver.findElement(By.cssSelector(
				"body > app-root:nth-child(3) > ion-app:nth-child(1) > ion-router-outlet:nth-child(1) > app-signup3:nth-child(5) > ion-footer:nth-child(3) > ion-toolbar:nth-child(1) > div:nth-child(1) > ion-button:nth-child(2)"))
				.getShadowRoot();
		Thread.sleep(1000);
  WebElement afterImage=nextHost.findElement(By.cssSelector(".button-inner"));
  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", afterImage);

  
  //click next no prefrences 
  
//This Element is inside single shadow DOM.
//String cssSelectorForHost1 = "ion-button[class='btn-primary next-btn md button button-block button-solid in-toolbar ion-activatable ion-focusable hydrated'][routerdirection='forward']";
Thread.sleep(1000);
SearchContext noPref = driver.findElement(By.cssSelector("ion-button[class='btn-primary next-btn md button button-block button-solid in-toolbar ion-activatable ion-focusable hydrated'][routerdirection='forward']")).getShadowRoot();
Thread.sleep(1000);
WebElement np=noPref.findElement(By.cssSelector(".button-native"));
((JavascriptExecutor) driver).executeScript("arguments[0].click();", np);


//############ Generate Ai 

Thread.sleep(2000);
driver.findElement(By.cssSelector("ion-button[class='btn-primary md button button-block button-solid ion-activatable ion-focusable hydrated']")).click();

Thread.sleep(3500);


//########### Afetr Ai next

//This Element is inside single shadow DOM.
//String cssSelectorForHost1 = "body > app-root:nth-child(3) > ion-app:nth-child(1) > ion-router-outlet:nth-child(1) > app-signup5:nth-child(3) > ion-footer:nth-child(3) > ion-toolbar:nth-child(1) > div:nth-child(1) > ion-button:nth-child(2)";


//This Element is inside single shadow DOM.
//String cssSelectorForHost1 = ".btn-primary.next-btn.md.button.button-block.button-solid.in-toolbar.ion-activatable.ion-focusable.hydrated";
Thread.sleep(1000);
List<WebElement>  li=driver.findElements(By.cssSelector(".btn-primary.next-btn.md.button.button-block.button-solid.in-toolbar.ion-activatable.ion-focusable.hydrated"));

System.out.println("########  "+li.size());

SearchContext afterAi = li.get(4).getShadowRoot();
Thread.sleep(1000);

WebElement AfterAiNext=afterAi.findElement(By.cssSelector(".button-native"));
((JavascriptExecutor) driver).executeScript("arguments[0].click();", AfterAiNext);   
	
	
	//########################### LETS GO BUTTON 

//This Element is inside single shadow DOM.
///String cssSelectorForHost1 = ".btn-primary.sign-in-btn.width-small-btn.md.button.button-block.button-solid.in-toolbar.ion-activatable.ion-focusable.hydrated";
Thread.sleep(1000);
List<WebElement> l2=driver.findElements(By.cssSelector(".btn-primary.sign-in-btn.width-small-btn.md.button.button-block.button-solid.in-toolbar.ion-activatable.ion-focusable.hydrated"));
SearchContext lg = l2.get(1).getShadowRoot();
Thread.sleep(1000);
WebElement lgbtn=lg.findElement(By.cssSelector(".button-inner"));
((JavascriptExecutor) driver).executeScript("arguments[0].click();", lgbtn);   	
	
	

Thread.sleep(1000);
Actions actions=new Actions(driver);
actions.sendKeys(Keys.ESCAPE).perform();




//#### click on profile 

//This Element is inside single shadow DOM.
//String cssSelectorForHost1 = "#tab-button-tab5";
Thread.sleep(1000);
SearchContext profile = driver.findElement(By.cssSelector("#tab-button-tab5")).getShadowRoot();
Thread.sleep(1000);
WebElement pf=profile.findElement(By.cssSelector(".button-inner"));
((JavascriptExecutor) driver).executeScript("arguments[0].click();", pf);   	

//############### click on logout

WebElement Logout=driver.findElement(By.cssSelector("body > app-root > ion-app > ion-router-outlet > app-tabs > ion-tabs > div > ion-router-outlet > app-tab5 > ion-content > div:nth-child(6) > div:nth-child(2)"));
((JavascriptExecutor) driver).executeScript("arguments[0].click();", Logout);   	


//click yes on logout

driver.findElement(By.xpath("//button[@class='alert-button ion-focusable ion-activatable alert-button-role-confirm sc-ion-alert-ios']")).click();
	row++;
	}
	

    private static int getKeyEvent(char c) {
        switch (c) {
            case ':':
                return KeyEvent.VK_SEMICOLON; // Requires SHIFT
            case '\\':
                return KeyEvent.VK_BACK_SLASH;
            case '.':
                return KeyEvent.VK_PERIOD;
            case '-':
                return KeyEvent.VK_MINUS;
            default:
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                if (keyCode == KeyEvent.VK_UNDEFINED) {
                    throw new IllegalArgumentException("Cannot type character: " + c);
                }
                return keyCode;
        }

	}

	
	

}


