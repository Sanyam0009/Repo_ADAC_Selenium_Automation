package com.adac.pageobjectactions.login;

import com.adac.pageobjects.login.LoginPage;

public class LoginPageAction extends LoginPage {

    public void adacLogin(String usernameVal, String passwordVal) throws InterruptedException {
        usernameTextBox.sendKeys(usernameVal);
        passwordTextBox.sendKeys(passwordVal);
        signInButton.click();
        Thread.sleep(2000);
    }

}
