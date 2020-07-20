package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PasteBinEnteredTextResultPage {
    private final String term;
    private WebDriver driver;
private String enterText;

    public PasteBinEnteredTextResultPage(WebDriver driver, String term) {
        
        this.driver=driver;
        this.term=term;
        
    }


    public String printTextResults() {
        String expectedEnteredText= driver.findElement(By.xpath("//code[@class='hljs lang-plaintext'][text()]")).getText();
        System.out.println("The entered text is the following: \n" +expectedEnteredText);
        return expectedEnteredText;
        
    }

    public String printPastieType(){
        String savedPastieType=driver.findElement(By.xpath("//*[@id=\"language\"][text()]")).getText();
        System.out.println("The saved pastie is of the following type: " + savedPastieType);
        return savedPastieType;
    }

    public String printBackgroundColor(){
        String backgroundColor=driver.findElement(By.xpath("//select[@id='themes']/descendant::*[@value='shades-of-purple.css']")).getText();
        System.out.println(backgroundColor);
        return backgroundColor;

    }
}
