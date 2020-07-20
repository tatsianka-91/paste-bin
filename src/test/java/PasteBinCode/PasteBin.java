package PasteBinCode;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PasteBin {


    public static void main (String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();


        driver.get("http://pastie.org/");


        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("editor")));


        WebElement textInput=driver.findElement(By.id("editor"));
        textInput = waitForElementLocatedBy(driver, By.id("editor"));
        textInput.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"toolbar\"]/div[3]/button[text()='Save Paste']")));

        List<WebElement> saveBtn=driver.findElements(By.xpath("//*[@id=\"toolbar\"]/div[3]/button[text()='Save Paste']"));
        saveBtn.get(0).click();




        String enteredText= driver.findElement(By.xpath("//code[@class='hljs lang-plaintext'][text()]")).getText();
        System.out.println("The entered text is the following: \n" +enteredText);




        driver.quit();




    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}

