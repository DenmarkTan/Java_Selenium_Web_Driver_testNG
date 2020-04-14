package myTest;
//instantiates driver onto browser
import org.openqa.selenium.chrome.ChromeDriver;
//driver.get 
import org.openqa.selenium.WebDriver;
//assign to webelement
import org.openqa.selenium.WebElement;
//locate element with specified selector
import org.openqa.selenium.By;


public class TestSample {
	public static void main(String[] args) {
		//Set the property for webdriver.chrome.driver to be the location to your local download of chromedriver
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		
		//create new instance of chromedriver
		WebDriver driver = new ChromeDriver();
		
		//Visit google
		driver.get("https://www.google.com");
		
		//Find the text input element by its name
		WebElement element = driver.findElement(By.name("q"));
	//perform actions	
		//Enter something to search for
		element.sendKeys("Cheese");
		
		//Submit form
		element.submit();
		
		//close browser
		driver.quit();
	}

}
