package marriageVerse;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

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

public class addProfiles {

	WebDriver driver;
	DataGen dg;

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		dg = new DataGen();
		driver.get("https://mverse-7ed6d.web.app");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	// for Male

	@Test
	public void addProfiles() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("//a[@routerlink='/signup']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter Email']")).sendKeys(dg.getEmail());
		driver.findElement(By.xpath(
				"/html/body/app-root/ion-app/ion-router-outlet/app-signup/ion-content/div/form/app-input-floating[2]/ion-item/div/ion-input/input"))
				.sendKeys(dg.getNumber());
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys(dg.getPassword());
		driver.findElement(By.xpath("//ion-button[@type='button']")).click();
		driver.findElement(By.xpath("//ion-segment-button[@value='MALE']")).click();

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

		firstName.sendKeys(dg.getFirstName());
		driver.findElement(By.xpath("//input[@placeholder='Enter your Last Name']")).sendKeys(dg.getLastName());
		driver.findElement(By.xpath(
				"/html/body/app-root/ion-app/ion-router-outlet/app-signup2/ion-content/form/app-input-floating[3]/ion-item/ion-input/input"))
				.click();

		Thread.sleep(2000);
		SearchContext sal = driver.findElement(By.cssSelector(
				"#select-custom-search > app-select-search > ion-content > cdk-virtual-scroll-viewport > div.cdk-virtual-scroll-content-wrapper > ion-item:nth-child(3) > span > ion-checkbox"))
				.getShadowRoot();
		Thread.sleep(2000);
		WebElement salary = sal.findElement(By.cssSelector("#ion-cb-2"));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", salary);
		Thread.sleep(2000);
		WebElement occ = driver.findElement(By.xpath("//*[@id=\"ion-input-11-lbl\"]"));
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", occ);

		// occupation
//	 Thread.sleep(2000);
//	 WebElement  Manager= sal.findElement(By.cssSelector("#select-custom-search > app-select-search > ion-content > cdk-virtual-scroll-viewport > div.cdk-virtual-scroll-content-wrapper > ion-item:nth-child(1) > span > ion-checkbox"));
//	 Thread.sleep(2000);
//	// WebElement Manager=  M.findElement(By.cssSelector("label:contains('Manager')"));
//	 Thread.sleep(2000);
//	((JavascriptExecutor) driver).executeScript("arguments[0].click();", Manager);

		// This Element is inside single shadow DOM.
//	String cssSelectorForHost1 = "body > app-root:nth-child(3) > ion-app:nth-child(1) > ion-modal:nth-child(3) > app-select-search:nth-child(1) > ion-content:nth-child(2) > cdk-virtual-scroll-viewport:nth-child(1) > div:nth-child(1) > ion-item:nth-child(1) > span:nth-child(1) > ion-checkbox:nth-child(1)";
		Thread.sleep(1000);
		SearchContext shadow = driver.findElement(By.cssSelector(
				"body > app-root:nth-child(3) > ion-app:nth-child(1) > ion-modal:nth-child(3) > app-select-search:nth-child(1) > ion-content:nth-child(2) > cdk-virtual-scroll-viewport:nth-child(1) > div:nth-child(1) > ion-item:nth-child(1) > span:nth-child(1) > ion-checkbox:nth-child(1)"))
				.getShadowRoot();
		Thread.sleep(1000);
		// WebElement
		// manager=shadow.findElement(By.cssSelector("label:contains('Manager')"));
		WebElement manager = (WebElement) ((JavascriptExecutor) driver).executeScript(
				"return Array.from(arguments[0].querySelectorAll('label')).find(el => el.textContent.trim() === 'Manager');",
				shadow);

		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", manager);

		Thread.sleep(1000);
		firstName.sendKeys(Keys.PAGE_DOWN);
		// select Religion

		Thread.sleep(1000);
		WebElement rel = driver.findElement(By.xpath("//app-input-floating[@formcontrlname='religion']"));
		rel.click();
		Thread.sleep(1000);

		// select sect

		// This Element is inside single shadow DOM.
		// This Element is inside single shadow DOM.
		// This Element is inside single shadow DOM.
		// This Element is inside single shadow DOM.
		// This Element is inside single shadow DOM.

		String cssSelectorForHost1 = "body > app-root:nth-child(3) > ion-app:nth-child(1) > ion-modal:nth-child(3) > app-select-search:nth-child(1) > ion-content:nth-child(2) > cdk-virtual-scroll-viewport:nth-child(1) > div:nth-child(1) > ion-item:nth-child(2) > span:nth-child(1) > ion-checkbox:nth-child(1)";
		Thread.sleep(1000);
		SearchContext shadow1 = driver.findElement(By.cssSelector(
				"body > app-root:nth-child(3) > ion-app:nth-child(1) > ion-modal:nth-child(3) > app-select-search:nth-child(1) > ion-content:nth-child(2) > cdk-virtual-scroll-viewport:nth-child(1) > div:nth-child(1) > ion-item:nth-child(2) > span:nth-child(1) > ion-checkbox:nth-child(1)"))
				.getShadowRoot();
		Thread.sleep(1000);
		// shadow1.findElement(By.cssSelector("label[for='ion-cb-1']")).click();

		/*
		 * WebElement label = (WebElement) ((JavascriptExecutor) driver) .executeScript(
		 * "return Array.from(document.querySelectorAll('label')).find(el => el.textContent.trim() === 'Muslim-Shia');"
		 * ,shadow1);
		 */
		WebElement label = (WebElement) ((JavascriptExecutor) driver).executeScript(
				"return Array.from(arguments[0].querySelectorAll('label')).find(el => el.textContent.trim() === 'Muslim-Shia');",
				shadow1);
		System.out.println("Label--> " + label);
		label.click();
//scroll page

		// caste

		driver.findElement(By.xpath(
				"//ion-input[@class='full-click-input ion-no-border ng-untouched ng-pristine ng-valid sc-ion-input-ios-h sc-ion-input-ios-s ios legacy-input hydrated ion-untouched ion-pristine ion-valid']"))
				.click();

		// This Element is inside single shadow DOM.
		String cssSelectorForHost12 = "body > app-root:nth-child(3) > ion-app:nth-child(1) > ion-modal:nth-child(3) > app-select-search:nth-child(1) > ion-content:nth-child(2) > cdk-virtual-scroll-viewport:nth-child(1) > div:nth-child(1) > ion-item:nth-child(1) > span:nth-child(1) > ion-checkbox:nth-child(1)";
		Thread.sleep(2000);
		SearchContext caste = driver.findElement(By.cssSelector(
				"body > app-root:nth-child(3) > ion-app:nth-child(1) > ion-modal:nth-child(3) > app-select-search:nth-child(1) > ion-content:nth-child(2) > cdk-virtual-scroll-viewport:nth-child(1) > div:nth-child(1) > ion-item:nth-child(1) > span:nth-child(1) > ion-checkbox:nth-child(1)"))
				.getShadowRoot();
		Thread.sleep(1000);

		WebElement label2 = (WebElement) ((JavascriptExecutor) driver).executeScript(
				"return Array.from(arguments[0].querySelectorAll('label')).find(el => el.textContent.trim() === 'Muslim - Ansari');",
				caste);
		// shadow.findElement(By.cssSelector("label[for='ion-cb-13']"));
		Thread.sleep(2000);
		label2.click();

		Thread.sleep(2000);

		// Mother tongue
		WebElement mt = driver.findElement(By.xpath(
				"/html/body/app-root/ion-app/ion-router-outlet/app-signup2/ion-content/form/app-input-floating[7]/ion-item/ion-input"));

		System.out.println("Mother Tongue " + mt);
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", mt);

		Thread.sleep(1000);

		// This Element is inside single shadow DOM.
		String cssSelectorForHost3 = "body > app-root:nth-child(3) > ion-app:nth-child(1) > ion-modal:nth-child(3) > app-select-search:nth-child(1) > ion-content:nth-child(2) > cdk-virtual-scroll-viewport:nth-child(1) > div:nth-child(1) > ion-item:nth-child(1) > span:nth-child(1) > ion-checkbox:nth-child(1)";
		Thread.sleep(1000);
		SearchContext shadow3 = driver.findElement(By.cssSelector(
				"body > app-root:nth-child(3) > ion-app:nth-child(1) > ion-modal:nth-child(3) > app-select-search:nth-child(1) > ion-content:nth-child(2) > cdk-virtual-scroll-viewport:nth-child(1) > div:nth-child(1) > ion-item:nth-child(1) > span:nth-child(1) > ion-checkbox:nth-child(1)"))
				.getShadowRoot();
		Thread.sleep(1000);

		WebElement label3 = (WebElement) ((JavascriptExecutor) driver).executeScript(
				"return Array.from(arguments[0].querySelectorAll('label')).find(el => el.textContent.trim() === 'Angika');",
				shadow3);
		// shadow.findElement(By.cssSelector("label[for='ion-cb-13']"));
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", label3);

		// clickOnLocation
		Thread.sleep(2000);
		WebElement cLoc = driver.findElement(By.cssSelector("input[placeholder='Current Location']"));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", cLoc);

		// type some address

		WebElement input = driver.findElement(By.cssSelector("div[class='address'] input"));
		input.sendKeys("Hyd");
		Thread.sleep(2000);
		input.sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		input.sendKeys(Keys.ENTER);

		Thread.sleep(2000);

		WebElement confirmClick = driver.findElement(By.cssSelector(
				"ion-buttons[class='buttons-last-slot sc-ion-buttons-ios-h sc-ion-buttons-ios-s ios hydrated'] ion-button[class='ios button button-clear in-toolbar in-buttons ion-activatable ion-focusable hydrated']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirmClick);
		Thread.sleep(1000);
//		WebElement click = driver.findElement(By.cssSelector(
//				".btn-primary.next-btn.md.button.button-block.button-solid.in-toolbar.ion-activatable.ion-focusable.hydrated"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", click);

		// click on the button

		// This Element is inside single shadow DOM.

		// ((JavascriptExecutor) driver).executeScript("arguments[0].click();", next);

		// click on the next
		// Locate the button element
		// WebElement nextButton =
		// driver.findElement(By.cssSelector(".btn-primary.next-btn.md.button.button-block.button-solid.in-toolbar.ion-activatable.ion-focusable.hydrated"));

		// This Element is inside single shadow DOM.
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
