
package myTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import automatically using timeunit
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;	

public class ImplicitWaits {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://formy-project.herokuapp.com/autocomplete");
		
		WebElement autocomplete = driver.findElement(By.id("autocomplete"));
		autocomplete.sendKeys("1351 Northwest 12th Street, Miami, FL, USA");
		//sleep for 1 second
		//Thread.sleep(1000);
		//click result
		
		//Implicit waits
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement autocompleteResult = driver.findElement(By.className("pac-item"));
		autocompleteResult.click();
		driver.quit();
	}

}
