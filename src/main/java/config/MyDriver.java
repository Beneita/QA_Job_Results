package config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyDriver {

	private static final String PATH_CHROME_DRIVER = "C:\\chromedriver_win32\\chromedriver.exe";
	public static WebDriver driver;

	public MyDriver() {
		System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
		driver = new ChromeDriver();
	}
}
