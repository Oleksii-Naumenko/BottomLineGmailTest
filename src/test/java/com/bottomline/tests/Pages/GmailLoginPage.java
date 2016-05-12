package com.bottomline.tests.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class GmailLoginPage {
    @FindBy(how = How.NAME, using = "Email")
    private SelenideElement emailAddressField;

    @FindBy(how = How.ID, using = "next")
    private SelenideElement proceedButton;

    @FindBy(how = How.NAME, using = "Passwd")
    private SelenideElement passwordField;

    @FindBy(how = How.ID, using = "signIn")
    private SelenideElement signInButton;

    @FindBy(how = How.NAME, using = "PersistentCookie")
    private SelenideElement staySignedCheckbox;

    public void  enterEmailAddress(String emailAddress){
        emailAddressField.setValue(emailAddress);
    }

    public void proceedLoginDialog(){
        proceedButton.click();
    }

    public void enterPassword(String password){
        passwordField.setValue(password);
    }

    public GmailInboxPage signIn(boolean staySigned) throws InterruptedException {

        boolean isChecked = staySignedCheckbox.isSelected();

        if (staySigned != isChecked){
            staySignedCheckbox.click();
        }

        signInButton.click();

        // TOOD: replace with dialog parsing
        Thread.sleep(10000);

        return page(GmailInboxPage.class);
    }
}
