import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestWikipedia {


    WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver",
                "src/resources/geckodriver");

        driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.get("https://pl.wikipedia.org/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testInnerText () {
        //jaki tekst się wyświetli
        WebElement element = driver.findElement(By.id("main-page-column1"));
        System.out.println(element.getText());
    }

     @Test
     public void testGetAttribute(){
        //zwieryfikuj jaką wartość ma atrybut class
         String atrybut = driver.findElement(By.id("main-page-content")).getAttribute("class");
         System.out.println(atrybut);
        }

      @Test
      public void testGetTagName(){
        //zwraca nazwę znacznika podanego elementu
          String tag = driver.findElement(By.id("main-page-content")).getTagName();
          System.out.println(tag);
      }

      @Test
      public void testIsEnabled(){
        //zweryfikuj czy element został znaleziony na stronie
          WebElement search = driver.findElement(By.id("searchInput"));
          if(search.isEnabled()) {
              search.sendKeys("Selenium");
              search.submit();
          }
          else {
              Assert.fail();
          }
      }

      @Test
      public void testIsDisplayed(){
        WebElement search = driver.findElement(By.id("searchInput"));
          if(search.isDisplayed()) {
              search.sendKeys("Selenium");
              search.submit();
          }
          else {
              Assert.fail();
          }

      }



    @After
    public void tearDown() {
// driver.quit();
    }
}
