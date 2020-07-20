package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PasteBinHomePage {

    private static final String HOMEPAGE_URL="http://pastie.org/";
    private WebDriver driver;

    @FindBy(id="editor")
            private WebElement textInput;
    @FindBy (xpath="//*[@id=\"toolbar\"]/div[3]/button[text()='Save Paste']")
            private WebElement saveBtn;

    public PasteBinHomePage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    public PasteBinHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PasteBinEnteredTextResultPage enterText (String term){
        textInput.sendKeys(term);
        saveBtn.click();
        return new PasteBinEnteredTextResultPage(driver,term);

    }

}
