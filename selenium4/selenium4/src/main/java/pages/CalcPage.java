package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class CalcPage {
    WebDriver driver;
    private String numericBtn = "Btn~NUM~";

    By btnPlus = By.id("BtnPlus");
    By btnMult = By.id("BtnMult");
    By btnMinus = By.id("BtnMinus");
    By btnDiv = By.id("BtnDiv");
    By btnParanR = By.id("BtnParanR");
    By btnParanL = By.id("BtnParanL");
    By btnSin = By.id("BtnSin");
    By btnCalc = By.id("BtnCalc");
    By btnClear = By.id("BtnClear");
    By history = By.cssSelector("#histframe ul li");

    public CalcPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getNumericButtonCss (int num) {
        String btnCss = numericBtn.replaceAll("~NUM~", String.valueOf(num));
        return By.id(btnCss);
    }

    public void clickNumericButton (int num) {
        WebElement we = driver.findElement(getNumericButtonCss(num));
        we.click();
    }

    public void clickPlusButton () {
        WebElement we = driver.findElement(btnPlus);
        we.click();
    }

    public void clickMultButton () {
        WebElement we = driver.findElement(btnMult);
        we.click();
    }

    public void clickMinusButton () {
        WebElement we = driver.findElement(btnMinus);
        we.click();
    }
    public void clickDivButton () {
        WebElement we = driver.findElement(btnDiv);
        we.click();
    }
    public void clickCalcButton () throws InterruptedException {
        WebElement we = driver.findElement(btnCalc);
        we.click();
        Thread.sleep(1000);
    }
    public void clickParanRightButton () {
        WebElement we = driver.findElement(btnParanR);
        we.click();
    }
    public void clickParanLeftButton () {
        WebElement we = driver.findElement(btnParanL);
        we.click();
    }

    public void clickSinButton () {
        WebElement we = driver.findElement(btnSin);
        we.click();
    }

    public void clickClearButton () {
        WebElement we = driver.findElement(btnClear);
        we.click();
    }
    public String getResultText () {
        WebElement we = driver.findElement(By.id("input"));
        return we.getAttribute("value");
    }

    public int getHistoryCount () {
        return driver.findElements(history).size();
    }

}
