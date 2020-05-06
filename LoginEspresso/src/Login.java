import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	public static void main(String[] args) {
		
		//Login
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://origin-secure.tst2.cruisingpower.com/SecureLogin.do");
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
		driver.findElement(By.cssSelector(".username")).sendKeys("cmousa");
		driver.findElement(By.cssSelector(".password")).sendKeys("TESTING123");
		driver.findElement(By.cssSelector(".loginButton")).click();
		
		//hover to booking tools
		 Actions builder = new Actions(driver);
		 WebElement element = driver.findElement(By.xpath("//*[@id='navigation']/li[2]/a"));
		 builder.moveToElement(element).build().perform();
		 
		 //go to espresso
		 driver.findElement(By.xpath("//*[@id=\"navigation\"]/li[2]/ul/li[1]/a")).click();
		 
		//select fit
		 driver.findElement(By.xpath("/html/body/div[8]/div[2]/div[2]/div/div[2]/div/a[1]")).click();
		 
		 //create fit
		 //driver.findElement(By.xpath("//*[@id=\"searchFormId\"]/section[1]/div/div[1]/div/span[4]/label/span")).click();
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 WebElement brand = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchFormId\"]/section[1]/div/div[1]/div/span[4]/label/span")));
		 brand.click();
		 WebElement ship = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".display.cart.ship.roomFieldOnChange.active")));
		 ship.click();
		
	}
}
