package curs5;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.BaseTest;

public class homework5 extends BaseTest{
	
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
	public void writeReview() throws InterruptedException {
		WebElement carteaForest = driver.findElement((By.xpath("//a[@href='the-forest']")));
		carteaForest.click();
		
		WebElement reviewsMenu = driver.findElement(By.xpath("//li[@class='reviews_tab']"));
		reviewsMenu.click();
		
		WebElement checkboxCookies = driver.findElement(By.xpath("//input[@id='wp-comment-cookies-consent']"));
		assertTrue(!checkboxCookies.isSelected());
		checkboxCookies.click();
		
		WebElement rating5stars = driver.findElement(By.xpath("//a[@class='star-5']"));
		rating5stars.click();
		
		WebElement yourReview = driver.findElement(By.xpath("//textarea[@id='comment']"));
		yourReview.click();
		yourReview.sendKeys("Carte exceptionala!");
		
		WebElement name = driver.findElement(By.xpath("//input[@id='author']"));
		name.click();
		name.sendKeys("John Doe");
		
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.click();
		email.sendKeys("johndoe@test.com");
		
		assertTrue(checkboxCookies.isSelected());
		
		WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
		submit.click();
		Thread.sleep(3000);
		
		WebElement awaitingApprovalText = driver.findElement(By.xpath("//em[@class='woocommerce-review__awaiting-approval']"));
		assertTrue(awaitingApprovalText.isDisplayed());

	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	
}
