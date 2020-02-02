package room_module;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC11 {
	
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "/......./chromedriver");
		driver = new ChromeDriver();
		
		driver.navigate().to("https://www.myguruavatar.com/demo/");
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.manage().window().fullscreen();
		
		WebElement Username = driver.findElement(By.xpath("//*[@id=\"modlgn-username\"]"));
		Username.sendKeys("josemulamorales33@hotmail.com");
		
		WebElement Password = driver.findElement(By.xpath("//*[@id=\"modlgn-passwd\"]"));
		Password.sendKeys("Jose Morales");
		
		WebElement Checkbutton = driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div/p[1]/input"));
		Checkbutton.click();
	
		WebElement Login = driver.findElement(By.xpath("//*[@id=\"hmelogin\"]"));
		Login.click();
		
		Thread.sleep(3000);
		
		WebElement Switch = driver.findElement(By.xpath("//*[@id=\"swithbtn\"]"));
		Switch.click();
		
		WebElement Goto = driver.findElement(By.xpath("//*[@id=\"swithbtn\"]/option[2]"));
		Goto.click();
		
		Thread.sleep(3000); 
		
		WebElement Edit = driver.findElement(By.xpath("//*[@id=\"ja-content-main\"]/div[2]/div[1]/div/a/span"));
		
		Edit.click();
		
		Thread.sleep(3000);
		
		takeScreenshoot("TC11");
		
	}

	public static void takeScreenshoot(String fileName) throws IOException {

		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("/Users/jose/Desktop/Software Testing/Selenium/eclipse-workspace/Guru Avatar/Screenshots/"+fileName+".png"));
		
	}

}
