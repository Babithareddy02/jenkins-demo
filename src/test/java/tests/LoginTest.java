
package tests;

import base.BaseTest;
import pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage login = new LoginPage(driver);

        login.login("tomsmith", "SuperSecretPassword!");

        Assert.assertTrue(
            driver.getCurrentUrl().contains("/secure"),
            "User should navigate to secure page"
        );

        Assert.assertTrue(
            login.getMessage().contains("You logged into a secure area!"),
            "Success message should be displayed"
        );
    }

    @Test
    public void invalidUsernameTest() {

        LoginPage login = new LoginPage(driver);

        login.login("wronguser", "SuperSecretPassword!");

        Assert.assertTrue(
            login.getMessage().contains("Your username is invalid!")
        );
    }

    @Test
    public void invalidPasswordTest() {

        LoginPage login = new LoginPage(driver);

        login.login("tomsmith", "wrongpassword");

        Assert.assertTrue(
            login.getMessage().contains("Your password is invalid!")
        );
    }

    @Test
    public void emptyCredentialsTest() {

        LoginPage login = new LoginPage(driver);

        login.login("", "");

        Assert.assertTrue(
            login.getMessage().contains("Your username is invalid!")
        );
    }
}
