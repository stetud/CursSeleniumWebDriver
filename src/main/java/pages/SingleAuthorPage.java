package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingleAuthorPage {
	
	public WebDriver driver;
	
	public SingleAuthorPage(WebDriver driver) {
		this.driver = driver;	
	}
	
	public By dramaSkill = By.xpath("//div[contains(text(),'Drama')]/following::div[@class='sc_skills_total'][1]");
	public By biographySkill = By.xpath("//div[contains(text(),'Biography')]/following::div[@class='sc_skills_total'][1]");
	public By cookbooksSkill = By.xpath("//div[contains(text(),'Cookbooks')]/following::div[@class='sc_skills_total'][1]");
	
    public String objectValue(By object) {
        WebElement element = driver.findElement(object);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
        return element.getText();
    }

}