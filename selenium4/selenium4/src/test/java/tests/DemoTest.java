package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CalcPage;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class DemoTest {
    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("https://web2.0calc.com/ ");
    }

    @Test
    public void AplusCalculation() throws InterruptedException {
        CalcPage calcPage = new CalcPage(driver);
        calcPage.clickClearButton();
        calcPage.clickNumericButton(2);
        calcPage.clickPlusButton();
        calcPage.clickNumericButton(3);
        calcPage.clickCalcButton();
        assertEquals("5", calcPage.getResultText());
    }

    @Test
    public void BMinusCalculation() throws InterruptedException {
        CalcPage calcPage = new CalcPage(driver);
        calcPage.clickClearButton();
        calcPage.clickNumericButton(1);
        calcPage.clickNumericButton(0);
        calcPage.clickMinusButton();
        calcPage.clickNumericButton(2);
        calcPage.clickCalcButton();
        assertEquals("8", calcPage.getResultText());
    }

    @Test
    public void CSinCalculation() throws InterruptedException {
        CalcPage calcPage = new CalcPage(driver);
        calcPage.clickClearButton();
        calcPage.clickNumericButton(3);
        calcPage.clickNumericButton(0);
        calcPage.clickSinButton();
        calcPage.clickCalcButton();
        assertEquals("0.5", calcPage.getResultText());
    }

    @Test
    public void DNegativeCalculation() throws InterruptedException {
        CalcPage calcPage = new CalcPage(driver);
        calcPage.clickClearButton();
        calcPage.clickParanLeftButton();
        calcPage.clickNumericButton(1);
        calcPage.clickNumericButton(0);
        calcPage.clickMinusButton();
        calcPage.clickNumericButton(2);
        calcPage.clickParanRightButton();
        calcPage.clickMultButton();
        calcPage.clickNumericButton(2);
        calcPage.clickCalcButton();
        assertNotEquals("20", calcPage.getResultText());
    }

    @Test
    public void EValidateCalculation() {
        CalcPage calcPage = new CalcPage(driver);
        assertEquals(4, calcPage.getHistoryCount());
    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }

}
