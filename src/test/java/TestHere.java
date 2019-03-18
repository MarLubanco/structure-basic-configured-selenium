import common.Browser;
import common.BrowserDataProvider;
import common.Comandos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.util.ArrayList;

public class TestHere extends Comandos {

  public WebDriver driver;
  private String browser;

  @Factory(dataProvider = "navegadores", dataProviderClass = BrowserDataProvider.class)
  public TestHere(String browser) {
    this.browser = browser;
  }

  @BeforeClass
  public void setUp() throws Exception {
    driver = Browser.retornaNavegador(browser);
    logger.info("Inciando  teste - " + browser);
  }

  @AfterTest
  public void exitDriver() {
    driver.close();
  }
}
