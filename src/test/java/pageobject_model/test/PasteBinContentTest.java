package pageobject_model.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.PasteBinHomePage;

import java.util.List;

public class PasteBinContentTest {
    private WebDriver driver;

@BeforeMethod (alwaysRun=true)
public void browserSetup(){
    driver=new ChromeDriver();
}


@Test (description = "Verifying the saved pastie text equals to the text we entered")
    public void  verifyEnteredTextIsCorrectTest (){



String expectedEnteredText=new PasteBinHomePage(driver)
        .openPage()
        .enterText("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force")
        .printTextResults();






    Assert.assertEquals(expectedEnteredText,"git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force");













    }

    @AfterMethod(alwaysRun = true)
    public void browserClosure(){
        driver.quit();
        driver=null;
    }


    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}

