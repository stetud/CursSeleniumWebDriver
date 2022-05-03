package curs2;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class homework2 {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://keybooks.ro");
	}
	
	@Test
	public void loginElements() throws InterruptedException {
		WebElement loginMenu = driver.findElement(By.className("menu_user_login"));
		WebElement username = driver.findElement(By.id("log"));
		WebElement password = driver.findElement(By.id("password"));

		Thread.sleep(4000);
		assertTrue(loginMenu.isDisplayed());
		assertTrue(!username.isDisplayed());
		assertTrue(!password.isDisplayed());
		
		loginMenu.click();
		assertTrue(username.isDisplayed());
		assertTrue(password.isDisplayed());
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
}
