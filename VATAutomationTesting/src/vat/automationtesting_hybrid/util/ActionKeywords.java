package vat.automationtesting_hybrid.util;

import static vat.automationtesting_hybrid.ExecutionScript.OR;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.google.common.base.Function;

import vat.automationtesting_hybrid.ExecutionScript;

public class ActionKeywords {
	public static WebDriver driver;

	public static WebElement element1;
	public static WebElement element2;
	public static List<WebElement> listElement;
	public static ByLocator getObj = new ByLocator();
	public static By ObjLocation;
	public static String errMessageResult;
	
//[KEYWORD] this will open browser
public static void openBrowser(String object, String objectType, String data){		
	Log.info("Opening Browser");
	try{				
		if(data.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gecko.driver", Constants.Path_Firefox);
			 // DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			driver = new FirefoxDriver();
			Log.info("Firefox browser started");	
			}
		else if(data.equals("IE")){
			System.setProperty("webdriver.ie.driver", Constants.Path_IEDriver);
			driver = new InternetExplorerDriver();
			Log.info("IE browser started");
			}
		else if(data.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", Constants.Path_ChromeDriver);
			driver=new ChromeDriver();
			Log.info("Chrome browser started");
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.waitTime, TimeUnit.SECONDS);
	}catch (Exception e){
		errMessageResult = Log.error("Unable to open browser --- " + data +
									 " --- " + e.getMessage());
		ExecutionScript.bResult = false;
	}
}

//[KEYWORD] navigate to URL
public static void gotoURL(String object, String objectType, String data){
	try{

		driver.manage().timeouts().pageLoadTimeout(Constants.pagewaitTime, TimeUnit.SECONDS);
		driver.navigate().to(data);
		Log.info("Navigating to URL " + data);
	}catch(Exception e){
		errMessageResult = Log.error("Unable to navigate --- " + e.getMessage());
		ExecutionScript.bResult = false;
	}
}

//[KEYWORD] navigate back to one page on the browser's history
public static void backPage(String object, String objectType, String data){
	try{
		//driver.manage().timeouts().pageLoadTimeout(Constants.waitTime, TimeUnit.SECONDS);
		driver.navigate().back();
		Log.info("Navigating backward to one page --- " + driver.getCurrentUrl());
	}catch(Exception e){
		errMessageResult = Log.error("Unable to navigate backward --- " + e.getMessage());
		ExecutionScript.bResult = false;
	}
}

//[KEYWORD] navigate forward to one page on the browser's history
public static void forwardPage(String object, String objectType, String data){
	try{
		driver.manage().timeouts().pageLoadTimeout(Constants.waitTime, TimeUnit.SECONDS);
		driver.navigate().forward();
		Log.info("Navigating forward to one page --- " + driver.getCurrentUrl());
	}catch(Exception e){
		errMessageResult = Log.error("Unable to navigate forward --- " + e.getMessage());
		ExecutionScript.bResult = false;
	}
}

//[KEYWORD] refresh current page
public static void refreshPage(String object, String objectType, String data){
	try{
		driver.manage().timeouts().pageLoadTimeout(Constants.waitTime, TimeUnit.SECONDS);
		driver.navigate().refresh();
		Log.info("Page refreshed --- " + driver.getCurrentUrl());
	}catch(Exception e){
		errMessageResult = Log.error("Unable to refresh page --- " + e.getMessage());
		ExecutionScript.bResult = false;
	}
}

//[KEYWORD] delete all cookies
public static void deleteAllCookies(String object, String objectType, String data){
	try{
		driver.manage().deleteAllCookies();
		Log.info("All cookies deleted --- " + driver.getCurrentUrl());
	}catch(Exception e){
		errMessageResult = Log.error("Unable to delete all cookies --- " + e.getMessage());
		ExecutionScript.bResult = false;
	}
}

//[KEYWORD] check specific cookie
public static void checkCookie(String object, String objectType, String data){
	try{
        Set<Cookie> cookies = driver.manage().getCookies();

        Iterator<Cookie> itr = cookies.iterator();
        while (itr.hasNext()) {
            Cookie cookie = itr.next();
            if (data.equals(cookie.getName())){
                Log.info("Cookie found --- " + data +
               		 "Path: " + cookie.getPath() +
               		 "Domain: " + cookie.getDomain() +
               		 "Value: " + cookie.getValue() +
               		 "Expiry: " + cookie.getExpiry());
            	break;
            }
        }
	}catch(Exception e){
		errMessageResult = Log.error("Unable to find cookie --- " + e.getMessage());
		ExecutionScript.bResult = false;
	}
	
}

//[KEYWORD] webdriver pause
public static void threadSleep(String object,String objectType, String data){
	try{
		long msec;
		msec = TimeUnit.SECONDS.toMillis(Integer.parseInt(data));
		Thread.sleep(msec);
		Log.info("Webdriver sleep for " + data +" ms");
	}catch(Exception e){
		errMessageResult = Log.error("Unable to sleep webdriver --- " + e.getMessage());
		ExecutionScript.bResult = false;
    }
}

//[KEYWORD] click the object
public static void click(String object,String objectType, String data){
	try{
		Log.info("Click on " + object);
		ObjLocation = getObj.getObject(OR.getProperty(object), objectType);
		fluentWait(ObjLocation).click();
	}catch(Exception e){
		errMessageResult = Log.error("Unable to click --- " + object +
									 " --- " + e.getMessage());
		ExecutionScript.bResult = false;
    }
}

//[KEYWORD] double click the object
public static void doubleClick(String object,String objectType, String data){
	try{
		Log.info("Double click on " + object);
		Actions action = new Actions(driver);
		ObjLocation = getObj.getObject(OR.getProperty(object), objectType);
		action.moveToElement(fluentWait(ObjLocation)).doubleClick().build().perform();
	}catch(Exception e){
		errMessageResult = Log.error("Unable to double click --- " + object +
									 " --- " + e.getMessage());
		ExecutionScript.bResult = false;
    }
	
}

//[KEYWORD] mouseover
public static void mouseOver(String object,String objectType, String data){
	try{
		Log.info("Mouse over on " + object);
		
		Actions action = new Actions(driver);
		ObjLocation = getObj.getObject(OR.getProperty(object), objectType);
		action.moveToElement(fluentWait(ObjLocation)).build().perform();
	}catch(Exception e){
		errMessageResult = Log.error("Unable to mouse over --- " + object +
									 " --- " + e.getMessage());
		ExecutionScript.bResult = false;
    }
	
}

//[KEYWORD] Specific area to scroll down
public static void scrollDown(String object,String objectType, String data){
	try{
		Log.info("Scroll down on " + object);
		ObjLocation = getObj.getObject(OR.getProperty(object), objectType);
		//fluentWait(ObjLocation).sendKeys(Keys.PAGE_DOWN);
		Actions actions = new Actions(driver);
		actions.moveToElement(fluentWait(ObjLocation));
		actions.click();
		actions.sendKeys(Keys.PAGE_DOWN);
		actions.build().perform();
	}catch(Exception e){
		errMessageResult = Log.error("Unable to scroll down --- " + object +
									 " --- " + e.getMessage());
		ExecutionScript.bResult = false;
  }
}

//[KEYWORD] Scroll down current page
public static void pagescrollDown(String object,String objectType, String data){
	try{
		Log.info("Page scroll down on " + object);
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
	}catch(Exception e){
		errMessageResult = Log.error("Unable to scroll down page--- " + object +
									 " --- " + e.getMessage());
		ExecutionScript.bResult = false;
  }
}

//[KEYWORD] input text/upload file in object
public static void input(String object, String objectType, String data){
	try{
		ObjLocation = getObj.getObject(OR.getProperty(object), objectType);
		fluentWait(ObjLocation).sendKeys(data);
		Log.info("Input data in " + object);
	 }catch(Exception e){
		 errMessageResult = Log.error("Unable to input data --- " + object +
				 					  " --- " + e.getMessage());
		 ExecutionScript.bResult = false;
	 	}
}


//[KEYWORD] clear text in the object
public static void clearText(String object, String objectType, String data){
	try{
		ObjLocation = getObj.getObject(OR.getProperty(object), objectType);
		fluentWait(ObjLocation).clear();
		Log.info("Cleared text in " + object);
	 }catch(Exception e){
		 errMessageResult = Log.error("Unable to clear text --- " + object +
				 					  " ---" + e.getMessage());
		 ExecutionScript.bResult = false;
	 }
}

//[KEYWORD] select drop down list
public static void selectDropDwn(String object, String objectType, String data){
	try{
		ObjLocation = getObj.getObject(OR.getProperty(object), objectType);
		element1 = fluentWait(ObjLocation);
		Select sel = new Select(element1);
		sel.selectByIndex(Integer.parseInt(data));
		Log.info("Dropdown list selected in --- " + object + " Value: " +
				 sel.getFirstSelectedOption().getText());
	}catch(Exception e){
		errMessageResult = Log.error("Unable to select in list --- " + object +
									 " ---" + e.getMessage());
		ExecutionScript.bResult = false;
	}
}

//[KEYWORD] wait for an asynchronous script to finish execution
public static void timeoutScript(String object, String objectType, String data){
	try{
		driver.manage().timeouts().setScriptTimeout(Long.parseLong(data), TimeUnit.SECONDS);
		Log.info("Wait for script to load " + data + " seconds");
	 }catch(Exception e){
		 errMessageResult = Log.error("Error occur while waiting script to load --- " + e.getMessage());
		 ExecutionScript.bResult = false;
     }
}

//[KEYWORD] wait for a page load to complete
public static void timeoutPageLoad(String object, String objectType, String data){
	try{
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(data), TimeUnit.SECONDS);
		Log.info("Wait for page to load " + data + " seconds");
	 }catch(Exception e){
		 errMessageResult = Log.error("Error occur while waiting page to load --- " + e.getMessage());
		 ExecutionScript.bResult = false;
     }
}

//[KEYWORD] notify webdriver instance to wait for specific time
public static void waitImplicit(String object, String objectType, String data){
	try{
		Log.info("Wait for " + data + " seconds");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(data), TimeUnit.SECONDS);
	 }catch(Exception e){
		 errMessageResult = Log.error("Error occur while waiting to load --- " + e.getMessage());
		 ExecutionScript.bResult = false;
     }
}

/*
 *[KEYWORD] used to advise the WebDriver instance to stand by
 *the execution till the time of certain condition is met or the maximum wait time is elapsed
 */
@SuppressWarnings("deprecation")
public static void waitExplicit(String object, String objectType, String data) {
	try{
		WebDriverWait wait = new WebDriverWait(driver, Constants.explicitWaitTime);
		String[] datas = new String[3];
		String datas1 = null;
		String datas2 = null;
		if (data.contains(",")){
			datas = data.split(",", 2);
			datas1 = datas[0];
			datas2 = datas[1];
		} else {
			datas1 = data;
		}

		switch(datas1){
			case "titleIs":
				wait.until(ExpectedConditions.
	                      titleIs(datas2));
				Log.info("Explicit wait used within ---" +
						 Constants.explicitWaitTime + "seconds for " +
						 datas1 + ": " + datas2);
				break;
			case "urlToBe":
				wait.until(ExpectedConditions.
	                      urlToBe(datas2));
				Log.info("Explicit wait used within ---" +
						 Constants.explicitWaitTime + "seconds for " +
						 datas1 + ": " + datas2);
				break;
			case "elementClickable":
				ObjLocation = getObj.getObject(OR.getProperty(object), objectType);
				wait.until(ExpectedConditions.elementToBeClickable(ObjLocation));
				Log.info("Explicit wait used within ---" +
						 Constants.explicitWaitTime + "seconds for " +
						 datas1 + ": " + object);
				break;
			case "textPresent":
				ObjLocation = getObj.getObject(OR.getProperty(object), objectType);
				wait.until(ExpectedConditions.textToBePresentInElement(ObjLocation , datas2));
				Log.info("Explicit wait used within ---" +
						 Constants.explicitWaitTime + "seconds for " +
						 datas1 + ": " + object);
				break;
			case "visibilityElement":
				ObjLocation = getObj.getObject(OR.getProperty(object), objectType);
				wait.until(ExpectedConditions.visibilityOfElementLocated(ObjLocation));
				Log.info("Explicit wait used within ---" +
						 Constants.explicitWaitTime + "seconds for " +
						 datas1 + ": " + object);
				break;
			case "invisibilityElement":
				ObjLocation = getObj.getObject(OR.getProperty(object), objectType);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(ObjLocation));
				Log.info("Explicit wait used within ---" +
						 Constants.explicitWaitTime + "seconds for " +
						 datas1 + ": " + object);
				break;
			case "alertPresent":
				Alert alert = wait.until(ExpectedConditions.alertIsPresent());
				if(alert != null) {
					if (data.equalsIgnoreCase(Constants.KEYWORD_CANCEL)){
						Log.info("Alert message --- " + alert.getText() +
								" " +
								Constants.KEYWORD_CANCEL + " button pressed");
						driver.switchTo().alert().dismiss();
					} else {
						Log.info("Alert message --- " + alert.getText() +
								" " +
								Constants.KEYWORD_OK + " button pressed");
						driver.switchTo().alert().accept();
					}
				} else {
					throw new Exception();
				}
				break;
			default:
				errMessageResult = Log.error("Incorrect data --- " + data + " ---");
				ExecutionScript.bResult = false;
				break;
		}
	 }catch(Exception e){
		 errMessageResult = Log.error("Error occur while explicitly waiting --- " +
				 object + ": " +
				 data + " ---" +
				 e.getMessage());
		 ExecutionScript.bResult = false;
     }
}

//[KEYWORD] css value font weight
public static void cssFontWeight(String object, String objectType, String data){
	
	try{
		String fw = null;
		ObjLocation = getObj.getObject(OR.getProperty(object), objectType);
		fw = fluentWait(ObjLocation).getCssValue("font-weight");
		switch(fw){
			case "normal":
			case "lighter":
			case "100":
			case "200":
			case "300":
			case "400":
			case "500":
			case "initial":
				fw = String.valueOf("normal");
				break;
			case "600":
			case "700":
			case "800":
			case "900":
			case "bold":
			case "bolder":
				fw = String.valueOf("bold");
				break;
			default:
				fw = null;
				break;
		}
		if ( (!fw.equalsIgnoreCase(data)) ||
			(fw == null) ){
			throw new Exception();
		}
		Log.info("Font weight of " + object + "is " + fw);
	 }catch(Exception e){
		 errMessageResult = Log.error("Error in font weight  --- " + object +
				 					  " --- " + data + " --- "
				 					  + e.getMessage());
		 ExecutionScript.bResult = false;
	}
}

//[KEYWORD] css value color
public static void cssColor(String object, String objectType, String data){
	try{
		String fw = null;
		ObjLocation = getObj.getObject(OR.getProperty(object), objectType);
		fw = fluentWait(ObjLocation).getCssValue("color");
		if ( (fw.equalsIgnoreCase(data)) ||
				(fw == null) ){
				throw new Exception();
			}
			Log.info("Color of " + object + "is not" + fw);
	}catch(Exception e){
		 errMessageResult = Log.error("Error in color  --- " + object +
				  " --- " + data + " --- "
				  + e.getMessage());
		 ExecutionScript.bResult = false;
	}
}

//[KEYWORD] is element enabled
public static void elementEnabled(String object, String objectType, String data){
	try{
		ObjLocation = getObj.getObject(OR.getProperty(object), objectType);
		fluentWait(ObjLocation).isEnabled();
		Log.info("Element --- " + object + " --- is active");
	} catch (Exception e){
		 errMessageResult = Log.error("Element is not active --- " +
				 object + e.getMessage());
		 ExecutionScript.bResult = false;
	}
}

//[KEYWORD] screenshot web browser content
public static void screenshot(String object, String objectType, String data){
	try {
		if(data.isEmpty()){
			Datetime.dateTime();
			data =  ExecutionScript.sTestCaseID + "_" +
					ExecutionScript.sTestStepID + "_" +
					Datetime.sdateTime;
		} 
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS)
		  		  .withName(data).withTitle(browserName)
		  		  .save(OR.getProperty("Path_scrshot"));
		  				  //Constants.Path_Screenshot);
		Log.info("Screenshot of " + data + " taken");
	} catch (Exception e) {
		errMessageResult = Log.error("Unable to take screenshot --- " + data +
									 " ---" + e.getMessage());
		ExecutionScript.bResult = false;
	}
}

//[KEYWORD] drag and drop per object
public static void dragDropSingle(String object, String objectType, String data){
	try{
		ObjLocation = getObj.getObject(OR.getProperty(object), objectType);
		element2 = fluentWait(ObjLocation);
		//WebElement fromObj = driver.findElement(By.xpath("//*[@id='draggableview']"));
		ObjLocation = getObj.getObject(OR.getProperty(data), objectType);
		element1 = fluentWait(ObjLocation);
		//WebElement toObj = driver.findElement(By.xpath("//*[@id='droppableview']"));
		Actions builder = new Actions(driver);
		    builder.clickAndHold(element1).moveToElement(element2).release().build().perform();
	} catch (Exception e){
		errMessageResult = Log.error("Unable to drag and drop --- " + e.getMessage());
		ExecutionScript.bResult = false;
	}
}


//not tested if working 3-13-2017
//[KEYWORD] drag and drop multiple select
public static void dragDropMultiple(String object, String objectType, String data){
	try{
//		listElement = driver.findElements(By.xpath("html/body/ol[1]"));
//		Actions builder = new Actions(driver);
//		builder.clickAndHold(listElement.get(1)).clickAndHold(listElement.get(2));
//		.moveToElement(toElement).release().build().perform();
//		Action selectMultiple = builder.build();
//		selectMultiple.perform();
		
		WebElement toElement = fluentWait(By.xpath("html/body/ol[2]"));
		listElement = driver.findElements(By.xpath("html/body/ol[1]"));
System.out.println(listElement);
		Actions builder = new Actions(driver);
		builder.clickAndHold(listElement.get(1)).clickAndHold(listElement.get(2))
		.moveToElement(toElement).release().build().perform();
		Action selectMultiple = builder.build();
		selectMultiple.perform();

//		String[] multiSelect = data.split(",");
//		 Actions builder = new Actions(driver);
//		 ObjLocation = getObj.getObject(OR.getProperty(object), objectType);
//		Select sel = 	new Select(fluentWait(ObjLocation));
//		 for (String value : multiSelect) {
//			 sel.selectByVisibleText(value);
//		}
//		 builder.clickAndHold().moveToElement(toElement).release().build().perform();
		System.out.println("passed");
	} catch (Exception e){
		System.out.println("failed" + e);
		ExecutionScript.bResult = false;
	}
}

//[KEYWORD] multiple select drop down box
public static void multipleSelect(String object, String objectType, String data){
	try{
		String[] multiSelect = data.split(",");
		 for (String value : multiSelect) {
			 ObjLocation = getObj.getObject(OR.getProperty(object), objectType);
			new Select(fluentWait(ObjLocation)).selectByVisibleText(value);
		}
	}catch(Exception e){
		errMessageResult = Log.error("Unable to mutiple select --- " + e.getMessage());
		ExecutionScript.bResult = false;
	}
}

//[KEYWORD] close the browser
public static void closeBrowser(String object, String objectType, String data){
	try{
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
		Log.info("Closing the browser " + browserName);
		driver.quit();
	 }catch(Exception e){
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		 errMessageResult = Log.error("Unable to Close the Browser --- " + browserName +
				 					  " ---" + e.getMessage());
		 ExecutionScript.bResult = false;
     }
}

//[KEYWORD] Pop-up window
public static void transferToPopUp(String object, String objectType, String data) {
	String subWindowHandler = null;
	Set<String> handles = driver.getWindowHandles(); 
	Iterator<String> iterator = handles.iterator();
	while (iterator.hasNext()){
	    subWindowHandler = iterator.next();
	}
	driver.switchTo().window(subWindowHandler);                                         
}

//[AUTO] fluent wait process
public static WebElement fluentWait(final By locator){
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		.withTimeout(Constants.waitTime, TimeUnit.SECONDS)
        .pollingEvery(Constants.pollingTime, TimeUnit.SECONDS)
        .ignoring(NoSuchElementException.class);

	element1 = wait.until(new Function<WebDriver, WebElement>() {
		  public WebElement apply(WebDriver drvr) {
		    return drvr.findElement(locator);
		  }
		});
	return element1;
}

//[AUTO] screenshot when failed
public static void screenshotFailed(String imgName){
	try {
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    String os = cap.getPlatform().toString();
	    String browserVersion = cap.getVersion().toString();
		
	 
		Log.info("[FAILED]Auto screenshot of " + imgName + " taken");
//		if(element1 != null){
//			Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS)
//				  .highlightWithText(element1, Constants.KEYWORD_FAILED)
//				  .withName(imgName).withTitle(browserName + ":" +
//						  					   browserVersion + ":" + 
//						  						os + "[" +
//						  						driver.getTitle() + "] " +
//						  						"["+driver.getCurrentUrl()+"]")
//				  .save(OR.getProperty("Path_scrshot"));
//						  //Constants.Path_Screenshot);
//		} else {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS)
			  .withName(imgName).withTitle(browserName + ":" +
					  					   browserVersion + ":" + 
					  						os + "[" +
					  						driver.getTitle() + "] " +
					  						"["+driver.getCurrentUrl()+"]")
			  .save(OR.getProperty("Path_scrshot"));
					  //Constants.Path_Screenshot);
		//}

	} catch (Exception e) {
		Log.error("[FAILED]Unable to take auto screenshot --- " + imgName +
				  " ---" + e.getMessage());
	}
}

}
