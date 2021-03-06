package myTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class SwitchToAlert {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://formy-project.herokuapp.com/switch-window");
		//alert button
		WebElement allertButton = driver.findElement(By.id("alert-button"));	
		allertButton.click();
		//switch to alert button
		Alert alert = driver.switchTo().alert();
		//close the alert button
		alert.accept();
		
		driver.quit();
	}	
}
