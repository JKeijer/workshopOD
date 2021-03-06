package selenium;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactForm {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost:8080/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testContact() throws Exception {
        driver.get(baseUrl + "/ubercoaching/webapp");
        driver.findElement(By.xpath("//a[3]/li")).click();
        driver.findElement(By.linkText("contact form")).click();
        driver.findElement(By.id("cd-name")).clear();
        driver.findElement(By.id("cd-name")).sendKeys("Cas");
        driver.findElement(By.id("cd-company")).clear();
        driver.findElement(By.id("cd-company")).sendKeys(
                "Information regarding registration");
        driver.findElement(By.id("cd-email")).clear();
        driver.findElement(By.id("cd-email")).sendKeys(
                "c.g.j.putman@student.utwente.nl");
        driver.findElement(By.id("cd-textarea")).clear();
        driver.findElement(By.id("cd-textarea")).sendKeys(
                "Hello, I would like some information.");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        assertEquals("Thank you for your feedback.", closeAlertAndGetItsText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
