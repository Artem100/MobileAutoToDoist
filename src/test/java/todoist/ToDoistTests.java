package todoist;

import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ToDoistTests extends AndroidSetupToDoist {

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
    }

    @Test
    public void testLogin() throws InterruptedException{
        WebElement Ok = driver.findElement(By.id("android:id/button1"));
        Ok.click();
        Thread.sleep(1000);
        WebElement email = driver.findElement(By.id("com.todoist:id/btn_google"));
        email.click();
        WebElement fieldEmail = driver.findElement(By.id("com.todoist:id/email_exists_input"));
        fieldEmail.sendKeys("hello167@meta.ua");
        WebElement buttonContinueEmail = driver.findElement(By.id("com.todoist:id/btn_continue_with_email"));
        buttonContinueEmail.click();
        WebElement fieldPassword = driver.findElement(By.id("com.todoist:id/log_in_password"));
        fieldEmail.sendKeys("Todomdom1");
        WebElement clickLogIn = driver.findElement(By.id("com.todoist:id/btn_log_in"));
        clickLogIn.click();
        Ok.click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.id("com.todoist:id/fab")).isDisplayed());
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}
