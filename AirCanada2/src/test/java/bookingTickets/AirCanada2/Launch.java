package bookingTickets.AirCanada2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Launch {
	WebDriver driver;
	Properties prop;
	FileInputStream file;
	public  Launch () throws IOException {
		 prop = new Properties();
		file = new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\AirCanada2\\data.properties");
		prop.load(file);
	
		String Browser = prop.getProperty("browser");
		if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
            driver = new InternetExplorerDriver();
		}

		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
	}
//    @Test
//	public void quit () {
//		driver.quit();
//	}
	
}
