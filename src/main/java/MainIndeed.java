import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainIndeed {
	public static WebDriver driver;

	public static void main(String[] args) {
		/*
		 * System.out.println("coucou Imène"); private static final String URL =
		 * "https://www.indeed.fr/"; private static final String PATH_CHROME_DRIVER =
		 * "C:\\chromedriver_win32\\chromedriver.exe";
		 */

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.indeed.fr/");

	}
}
