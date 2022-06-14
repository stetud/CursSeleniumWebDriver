package curs5;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.NavMenuPage;
import pages.SingleAuthorPage;
import utils.BaseTest;

public class homework6 extends BaseTest {
	
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
	public void skills() {
		
        SingleAuthorPage singleAuthorPage = new NavMenuPage(driver).navToSingleAuthorPage();
        String dramaValue = singleAuthorPage.objectValue(singleAuthorPage.dramaSkill);
        String biographyValue = singleAuthorPage.objectValue(singleAuthorPage.biographySkill);
        String cooksbookValue = singleAuthorPage.objectValue(singleAuthorPage.cookbooksSkill);

        assertEquals(dramaValue, "95%");
        assertEquals(biographyValue, "75%");
        assertEquals(cooksbookValue, "82%");

	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
}
