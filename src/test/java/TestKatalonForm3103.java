import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.charset.MalformedInputException;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestKatalonForm3103
{
       WebDriver driver;
       String nameID = "first-name";
       String lastNameID = "last-name";
       String genderXPath = "/html/body/div/div/form/div[3]/div/div/label[1]/input";
       String dateOfBirthID = "dob";
       String addressID = "address";
       String emailID = "email";
       String passwordID = "password";
       String roleID = "role";
       String submitID = "submit";
       String companyID = "company";
       String commentID = "comment";
       String firstNameErrorMessageID = "first-name-error";
       String submitMessageID = "submit-msg";
       String lastNameErrorMessageID = "last-name-error";
       String 

    @Before
public void setUp() {

    System.setProperty("webdriver.gecko.driver",
            "src/resources/geckodriver");

    driver = new FirefoxDriver();

    driver.manage().window().maximize();

    driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@Test
    public void testValidUserRegistration() {
        //znajd element do wpisania imienia
        WebElement nameField = driver.findElement(By.id(nameID));
        //klikni pole, wyczyść i wpisz tekst "Karol"
        if (nameField.isDisplayed()) {
            nameField.click();
            nameField.clear();
            nameField.sendKeys("Karol");
            System.out.println("Wpisuję w pole o id:" + nameID + " wartość; Karol");
        }
        else {
            Assert.fail();
                    }








    //znajd element do wpisania nazwiska
    WebElement lastNameField = driver.findElement(By.id(lastNameID));
    //klikni pole, wyczyść i wpisz tekst "Kowalski"
    lastNameField.click();
    lastNameField.clear();
    lastNameField.sendKeys("Kowalski");



    //znajd element do zaznaczenia płci
    WebElement genderField = driver.findElement(By.xpath(genderXPath));
    //zaznacz płeć męską
    genderField.click();



    //znajd element do wpisania daty urodzenia
    WebElement dateOfBirthField = driver.findElement(By.id(dateOfBirthID));
    //klikni pole, wyczyść i wpisz tekst "05/22/2010"
    dateOfBirthField.click();
    dateOfBirthField.clear();
    dateOfBirthField.sendKeys("05/22/2010");



    //znajd element do wpisania adresu
    WebElement addressField = driver.findElement(By.id(addressID));
    //klikni pole, wyczyść i wpisz tekst "Prosta51"
    addressField.click();
    addressField.clear();
    addressField.sendKeys("Prosta51");

    //znajd element do wpisania adresu mailowego
    WebElement emailField = driver.findElement(By.id(emailID));
    //klikni pole, wyczyść i wpisz tekst "karol.kowalski@mailinator.com"
    emailField.click();
    emailField.clear();
    emailField.sendKeys("karol.kowalski@mailinator.com");

    //znajd element do wpisania hasła
    WebElement passwordField = driver.findElement(By.id(passwordID));
    //klikni pole, wyczyść i wpisz hasło "Pass123"
    passwordField.click();
    passwordField.clear();
    passwordField.sendKeys("Pass123");

    //znajd element do wpisania nazwy firmy
    WebElement companyField = driver.findElement(By.id(companyID));
    //klikni pole, wyczyść i wpisz tekst "Coders Lab"
    companyField.click();
    companyField.clear();
    companyField.sendKeys("Coders Lab");

    //znajd element do wpisania komentarzu
    WebElement commentField = driver.findElement(By.id(commentID));
    //klikni pole, wyczyść i wpisz tekst "To jest mój pierwszy automat testowy"
    commentField.click();
    commentField.clear();
    commentField.sendKeys("To jest mój pierwszy automat testowy");

    //selekt
    Select select = new Select(driver.findElement(By.id(roleID)));
    select.selectByVisibleText("QA");


    //submit
    WebElement submitButton = driver.findElement(By.id(submitID));
    //zatwierdź submit
    submitButton.click();

    WebElement submitMessage = driver.findElement(By.id(submitMessageID));
    assertEquals("Successfully submitted!",submitMessage.getText());



}

@Test
public void errorHandling(){
        WebElement submitButton = driver.findElement(By.id(submitMessageID));
        submitButton.click();



        WebElement firstNameErrorMessage = driver.findElement(By.id(firstNameErrorMessageID));
        assertTrue(firstNameErrorMessage.isDisplayed());



        WebElement lastNameErrorMessage = driver.findElement(By.id(lastNameErrorMessageID));
        assertTrue(lastNameErrorMessage.isDisplayed());






}

@After
 public void tearDown() {
// driver.quit();
}

}
