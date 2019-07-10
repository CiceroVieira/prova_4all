package teste.commons;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRule {
	private static WebDriver driver;

	public static void afterCenario() {
		if (driver != null) {
			driver.close();
			driver = null;
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public TestRule() {
		super();
	}

	public static void openApplication(String application, String url) {
		switch (application) {
		case "Chrome":
			openApplicationChrome(url);
			break;
		case "Edge":
			openApplicationEdge(url);
			break;
		case "Firefox":
			openApplicationFireFox(url);
			break;
		default:
			Assert.fail(application + " -> driver application não encontrado");
			break;
		}
	}

	public static void openApplicationChrome(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}

	public static void openApplicationFireFox(String url) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}

	public static void openApplicationEdge(String url) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}

}
