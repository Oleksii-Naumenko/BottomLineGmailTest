package com.bottomline.tests;

import com.bottomline.tests.Pages.GmailInboxPage;
import com.bottomline.tests.Pages.GmailLoginPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class AppTest
{
    @Test
    public void test() throws InterruptedException {

        String loginUser = System.getProperty("loginUser");

        String passwordUser = System.getProperty("passwordUser");

        GmailLoginPage page = open("http://gmail.com", GmailLoginPage.class);

        page.enterEmailAddress(loginUser);

        page.proceedLoginDialog();

        page.enterPassword(passwordUser);

        GmailInboxPage inboxPage =  page.signIn(false);

        org.testng.Assert.assertTrue(inboxPage.isInboxOpened(), "Verify Inbox page is displayed");
    }
}
