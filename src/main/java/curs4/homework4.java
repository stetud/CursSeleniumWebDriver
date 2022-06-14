package curs4;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

public class homework4 {
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
	public void searchBook() throws InterruptedException {
		WebElement searchIcon = driver.findElement(By.cssSelector("div[class='search_form_wrap']"));
		WebElement searchInput = driver.findElement(By.cssSelector("input[class='search_field']"));

		searchIcon.click();
		searchInput.sendKeys("The story about me");
		searchInput.sendKeys(Keys.RETURN);
		
		WebElement loadMoreButton = driver.findElement(By.cssSelector("a[class*='viewmore_button']"));
		loadMoreButton.click();
		Thread.sleep(2000);
		
		WebElement book = driver.findElement(By.cssSelector("div[data-title='The story about me']"));
		book.click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/the-story-about-me/");	
		Thread.sleep(2000);

		WebElement addToCart = driver.findElement(By.cssSelector("button[name='add-to-cart']"));
		addToCart.click();
		
		WebElement message = driver.findElement(By.cssSelector("div[class='woocommerce-message']"));
		assertTrue(message.isDisplayed());	
		assertTrue(message.getText().contains("“The story about me” has been added to your cart."));
		WebElement viewCart = driver.findElement(By.cssSelector("a[tabindex='1']"));
		viewCart.click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/cart/");

	}
	
	@Test
	public void updateCart() throws InterruptedException  {
		WebElement addAnotherBook = driver.findElement(By.cssSelector(".q_inc"));
		addAnotherBook.click();
		
		WebElement updateCart = driver.findElement(By.cssSelector("button[name='update_cart']"));
		updateCart.click();
		Thread.sleep(2000);
		WebElement message = driver.findElement(By.cssSelector("div[class='woocommerce-message']"));
		assertTrue(message.isDisplayed());	
		assertTrue(message.getText().contains("Cart updated."));
		
		WebElement proceedToCheckout = driver.findElement(By.cssSelector("a.checkout-button"));
		proceedToCheckout.click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/checkout/");	
		
		WebElement billingDetails = driver.findElement(By.cssSelector("div[class='woocommerce-billing-fields']"));
		assertTrue(billingDetails.isDisplayed());	
		
		WebElement additionalInformation = driver.findElement(By.cssSelector("div[class='woocommerce-additional-fields']"));
		assertTrue(additionalInformation.isDisplayed());	
		
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
}
