package myTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;	

public class KeyboardAndMouseinput {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://formy-project.herokuapp.com/keypress");
		//textbox
		WebElement name = driver.findElement(By.id("name"));
		//click textbox
		name.click();
		//enter denmark tan
		name.sendKeys("Denmark Tan");
		//button
		WebElement button = driver.findElement(By.id("button"));
		//click button
		button.click();
		driver.quit();
	}
}