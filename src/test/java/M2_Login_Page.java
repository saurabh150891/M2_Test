import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class M2_Login_Page {
    WebDriver driver = new ChromeDriver();


    @Test
    public void loginPage() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://company503155.monday.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("user_email")).sendKeys("tester@company.com");
        driver.findElement(By.id("user_password")).sendKeys("Pass@4321$");
        driver.findElement(By.xpath("//*[@id=\"login-monday-container\"]/div/div[2]/div/div[1]/div/div[4]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"row-footer-currentBoard-1229077367-1229077367_new_group43041--focus-name-withadditem\"]/div/div[1]/div/div/input")).sendKeys("TestTask");

        performAction(driver);

        Thread.sleep(3000);

        clickOnASpecificElementFromTheList(".multiple-person-cell-component");
        driver.findElement(By.xpath("//*[@id=\"combobox-item-45697786\"]/div[2]/div/span")).click();

        clickOnASpecificElementFromTheList(".date-cell-component");
        driver.findElement(By.xpath("//*[@id=\"board-wrapper-first-level-content\"]/div[6]/div/div/div/div/div/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[6]/td[1]/button")).click();

        clickOnASpecificElementFromTheList("div[id*='notplaceholder-focus-project_status-']");
        driver.findElement(By.xpath("//*[@id=\"1229077367_project_status_1\"]/div/div/span")).click();
    }

    public void performAction(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER);
        actions.perform();
    }

    public void clickOnASpecificElementFromTheList(String locator){
        List<WebElement> webElements = driver.findElements(By.cssSelector(locator));
        int webElementCount = webElements.size();
        webElements.get(webElementCount - 1).click();

    }
}
