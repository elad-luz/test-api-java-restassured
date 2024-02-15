package tempTBD;

import static org.testng.Assert.assertTrue;
import java.time.Duration;
// import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium {

	public static void main(String[] args) throws InterruptedException {
	/** Perform these steps as a 'Test Scenario' */
		// 0. use WebDriverManager to set & init Chrome in 'full screen' (with max wait for 5 sec)…
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		// 1. browse to 'URL'…
		driver.get("https://www.saucedemo.com");
		String username = "standard_user";
		String password = "secret_sauce";
		// Find the User \ Pass Fields elements using the 'CSS expression' -and- input the username & password into fields & Enter (to submit)…
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#user-name"))).sendKeys(username);
		driver.findElement(By.cssSelector("#password")).sendKeys(password, Keys.ENTER); // Enter is like clicking LoginBtn
		// Assert on Title that its the 'Official Video'…!
		String appLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".app_logo"))).getText();
		assertTrue(appLogo.toLowerCase().contains("swag labs"), "appLogo don't match condition!");
		System.out.println(appLogo + " is indicating successfull login !\n===========================================");
		driver.quit();
	}
}