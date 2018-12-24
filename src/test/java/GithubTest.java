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

public class GithubTest extends Comandos {

  public WebDriver driver;
  private String browser;
  ArrayList<String> repositoriosExistentes = new ArrayList<String>();


  @Factory(dataProvider = "navegadores", dataProviderClass = BrowserDataProvider.class)
  public GithubTest(String browser) {
    this.browser = browser;
  }

  @BeforeClass
  public void setUp() throws Exception {
    driver = Browser.retornaNavegador(browser);
    logger.info("Inciando  teste Github - " + browser);
  }

  @Test
  public void abrirNavegador() {
    driver.get("https://github.com/MarLubanco");
  }

  @Test(groups = "validationUser", dependsOnMethods = "abrirNavegador")
  public void validarQuantidadeDeRepositorios() {
   WebElement repositories = driver.findElement(By.cssSelector("#js-pjax-container > div > div.col-9.float-left.pl-2 > div.UnderlineNav.user-profile-nav.js-sticky.top-0 > nav > a:nth-child(2)"));
   String repositoriesHas = repositories.getText();
   Assert.assertEquals("Repositories 22", repositoriesHas);
  }

  @Test(groups = "validationUser")
  public void validarFollowers() {
    WebElement followers = driver.findElement(By.cssSelector("#js-pjax-container > div > div.col-9.float-left.pl-2 > div.UnderlineNav.user-profile-nav.js-sticky.top-0 > nav > a:nth-child(4)"));
    String fls = followers.getText();
    Assert.assertEquals("Followers 2", fls);
  }

  @Test(dependsOnGroups = "validationUser")
  public void navegarParaRepositorios() {
    driver.get("https://github.com/MarLubanco?tab=repositories");
    for( int i=1; i < 22; i++) {
      String nomeRepo = driver.findElement(By.xpath("//*[@id=\"user-repositories-list\"]/ul/li[" + i + "]/div[1]/div[1]/h3/a")).getText();
      repositoriosExistentes.add(nomeRepo);
    }
  }

  @Test(dependsOnMethods = "navegarParaRepositorios")
  public void listarRepositorios() {
    repositoriosExistentes.forEach( repositorio -> logger.info("Repositório: " + repositorio));
  }

  @AfterTest
  public void exitDriver() {
    driver.close();
  }
}
