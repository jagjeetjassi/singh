package bookingTickets.AirCanada2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.lib.util.Xls_Reader;


public class SignIn extends Application{
	
	Xls_Reader reader;
	
	public SignIn() throws IOException {
		super();
				
	}

	@Test(dataProvider="excelCall")
	public void gettingData (String title,String firstname,String lastname,String birthday,String birthmonth,String birthyear,String phone,String email,String password){
		
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		driver.manage().deleteAllCookies();
		
		driver.findElement(By.xpath("//a[@class='close-banner']")).click();
		driver.findElement(By.xpath("//a[@class='button secondary']")).click();
		
		org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(driver.findElement(By.xpath("//select[@id='sutitle']")));
		select.selectByVisibleText(title);
		driver.findElement(By.xpath("//input[@id='sufirst']")).clear();
        driver.findElement(By.xpath("//input[@id='sufirst']")).sendKeys(firstname);
        
        driver.findElement(By.xpath("//input[@id='sulast']")).clear();
        driver.findElement(By.xpath("//input[@id='sulast']")).sendKeys(lastname);
        
        org.openqa.selenium.support.ui.Select select1 = new org.openqa.selenium.support.ui.Select(driver.findElement(By.xpath("//select[@id='subirthday']")));
        select1.selectByValue("8");
        org.openqa.selenium.support.ui.Select select2 = new org.openqa.selenium.support.ui.Select(driver.findElement(By.xpath("//select[@id='subirthmonth']")));
        select2.selectByValue("10");
        org.openqa.selenium.support.ui.Select select3 = new org.openqa.selenium.support.ui.Select(driver.findElement(By.xpath("//select[@id='subirthyear']")));
        select3.selectByValue("2020");
        
        driver.findElement(By.xpath("//input[@id='suphone']")).clear();
        driver.findElement(By.xpath("//input[@id='suphone']")).sendKeys(phone);
        
        driver.findElement(By.xpath("//input[@id='suemail']")).clear();
        driver.findElement(By.xpath("//input[@id='suemail']")).sendKeys(email);
       
        driver.findElement(By.xpath("//input[@id='supassword']")).clear();
        driver.findElement(By.xpath("//input[@id='supassword']")).sendKeys(password);
        
        driver.findElement(By.xpath("//label[@for='suterms']")).click();
        
        driver.findElement(By.xpath("//span[@class='icon loading']")).click();
}
	@DataProvider
	public Iterator<Object[]> excelCall () {
		
		ArrayList<Object[]> Sighupdata = new ArrayList<Object[]>();
		reader = new Xls_Reader("C:\\Users\\Administrator\\eclipse-workspace\\AirCanada2\\src\\test\\java\\bookingTickets\\AirCanada2\\SwoopAirline.xlsx");
	    int rowCount = reader.getRowCount("Swoop");
	    for (int i = 0; i < rowCount; i++) {
			String title = reader.getCellData("Swoop", "Title", i);
			String firstname = reader.getCellData("Swoop", "Firstname", i);
			String lastname = reader.getCellData("Swoop", "Lastname", i);
			String birthday = reader.getCellData("Swoop", "Birthday", i);
			String birthmonth = reader.getCellData("Swoop", "Birthmonth", i);
			String birthyear = reader.getCellData("Swoop", "Birthyear", i);
			String phone = reader.getCellData("Swoop", "Phone", i);
			String email = reader.getCellData("Swoop", "Email", i);
			String password = reader.getCellData("Swoop", "Password", i);
			Object ob[] = {title,firstname,lastname,birthday,birthmonth,birthyear,phone,email,password}; 
			Sighupdata.add(ob);
					}
	    return Sighupdata.iterator();
	}
	
}