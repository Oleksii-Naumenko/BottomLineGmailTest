package com.bottomline.tests.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GmailInboxPage {

    @FindBy(how = How.ID, using = "gbqfq")
    private SelenideElement gmailInboxSearchInput;

    public boolean isInboxOpened(){
        return gmailInboxSearchInput.isDisplayed();
    }
}
