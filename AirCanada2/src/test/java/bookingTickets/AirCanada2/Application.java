package bookingTickets.AirCanada2;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Application extends Launch {

	public Application() throws IOException {
		super();
		
	}
    @Test
	public void AirCanadaLaunch () {
		String Url = prop.getProperty("url");
    	driver.get(Url);
	     String title = driver.getTitle();
	     System.out.println(title);
	    if (title.equalsIgnoreCase("Ultra-Low Fare Airline - Official Site | Swoop")) {
			System.out.println("we are on the official website of swoop");
		} else {
               System.out.println("we are not on the official website of swoop");
		}
	    
	}
    @Test
	public void getlinks () {
		
		List<WebElement> Links = driver.findElements(By.xpath("//a"));
		int size = Links.size();
		System.out.println(size);
//		for (int i = 1; i <= size; i++) {
//			String Linkname = Links.get(i).getText();
//			System.out.println("Link Name is----->"+Linkname);
//			
//		}

	}
}
