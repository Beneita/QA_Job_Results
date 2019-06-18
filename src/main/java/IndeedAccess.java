import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IndeedAccess {

	private static final String URL = "https://www.indeed.fr/";
	private static final String PATH_CHROME_DRIVER = "C:\\chromedriver_win32\\chromedriver.exe";
	public static WebDriver driver;

	public IndeedAccess() {

	}

	public static void openIndeed() {
		System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
		driver = new ChromeDriver();
		driver.get(URL);
	}
}
