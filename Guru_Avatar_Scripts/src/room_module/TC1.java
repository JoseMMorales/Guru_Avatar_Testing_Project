package room_module;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC1 {

	static WebDriver driver;
	
	public static void main(String[] args) throws IOException, Exception {
		
		System.setProperty("webdriver.chrome.driver","/........./chromedriver");
		driver = new ChromeDriver();
		
		driver.get("https://www.myguruavatar.com/demo/");
		
		WebDriverWait wait = new WebDriverWait(driver, 2);
		
		WebElement Username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"modlgn-username\"]")));
		Username.sendKeys("josemulamorales33@hotmail.com");
		
		WebElement Password = driver.findElement(By.xpath("//*[@id=\"modlgn-passwd\"]"));
		Password.sendKeys("Jose Morales");
		
		WebElement Checkbutton = driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div/p[2]/input"));
		Checkbutton.click();
	
		WebElement Login = driver.findElement(By.xpath("//*[@id=\"hmelogin\"]"));
		Login.click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 2);
		
		WebElement Dropdown = wait1.until(ExpectedConditions.elementToBeClickable(By.id("swithbtn")));
		Dropdown.click();
		
		Thread.sleep(6000);
		
		takeScreenshot("TC1");

	}

	public static void takeScreenshot (String fileName) throws IOException {
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("/Users/jose/Desktop/Software Testing/Selenium/eclipse-workspace/Guru Avatar/Screenshots/"+fileName+".png"));
		
	}
	
}
