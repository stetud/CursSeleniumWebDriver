package curs3;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class homework3 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://keybooks.ro/");
	}

	@Test
	public void checkIfTheBookIsPresent() {		
		List<WebElement> meniuri =  driver.findElements(By.cssSelector("li.sc_tabs_title"));
		WebElement carteaForest = driver.findElement((By.xpath("//a[@href='the-forest']")));
		for(WebElement meniu : meniuri) {
			assertTrue(carteaForest.isDisplayed());
			meniu.click();
		}
		carteaForest.click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/the-forest/");	
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
}
	
