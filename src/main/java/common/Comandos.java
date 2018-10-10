package common;


import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

/**
 * Created by surfista
 */
public class Comandos {
  public Logger    logger;
  public WebDriver driver;

  {
    logger = Logger.getLogger("Comandos.class");
  }

  public void esperaTitulo(String titulo) {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.titleIs(titulo));
  }

  public void esperaElementoVisivel(WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOf(element));
  }
//
//  public void esperaCarregarInformacoes() {
//    WebDriverWait wait = new WebDriverWait(driver, 50);
//    WebElement body = driver.findElement(By.cssSelector("body"));
//    wait.until(new ExpectedCondition<Boolean>() {
//      public Boolean apply(WebDriver driver) {
//        // logger.info(body.getAttribute("class"));
//        String txt = body.getAttribute("class");
//        return  !txt.contains("block-ui-active");
//
//      }
//    });
//  }

  public void esperaElementoFicarClicavel(WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, 100);
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  public void clicarComJavaScript(WebElement element, WebElement elementDois) {
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, 40);
    wait.until(ExpectedConditions.elementToBeClickable(element));
    executor.executeScript("arguments[0].click();", element);
    executor.executeScript("arguments[0].click();", elementDois);
  }

  public void clicarComJavaScript(WebElement element) {
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, 40);
    wait.until(ExpectedConditions.elementToBeClickable(element));
    executor.executeScript("arguments[0].click();", element);
  }

  public void navegarPages(WebElement element, WebElement elementDois, WebElement elementTres) {
    esperaElementoVisivel(element);
    esperaElementoFicarClicavel(element);
    clicarComJavaScript(element);
    esperaElementoFicarClicavel(elementDois);
    clicarComJavaScript(elementDois);
    esperaElementoFicarClicavel(elementTres);
    clicarComJavaScript(elementTres);
//    esperaCarregarInformacoes();

  }

  public void navegarPages(WebElement element, WebElement elementDois) {
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, 40);
    wait.until(ExpectedConditions.elementToBeClickable(element));
    executor.executeScript("arguments[0].click();", element);
    wait.until(ExpectedConditions.elementToBeClickable(elementDois));
    executor.executeScript("arguments[0].click();", elementDois);
  }

  public void checkTrueAndClick(WebElement element) {
    if (element.isSelected()) {
      clicarComJavaScript(element);
    }
  }


  public void checkTrueAndClickTest(WebElement element) {
    if (element.isSelected()) {
      element.click();
    }
  }

  public void checkFalseAndClick(WebElement element) {
    if (!element.isSelected()) {
      clicarComJavaScript(element);
    }
  }

  public void scrool(Dimension pag) throws InterruptedException, AWTException {
    Robot bot = new Robot();
    bot.mouseMove((pag.width / 2), (pag.height / 2));
    bot.setAutoDelay(100);
    sleep(100);
// System.out.println("++");
    bot.mouseWheel(25);
    sleep(100);
// System.out.println("--");
    // bot.mouseWheel(-25);

  }

  public void scroolJavaScript() {
    JavascriptExecutor jse = ((JavascriptExecutor) driver);
    jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
  }

  public void scroolDown(int valueDown) {
    WebElement body = driver.findElement(By.tagName("body"));

    Action scrollDown = new Actions(driver).moveToElement(body, body.getSize().getWidth() - 10,
            15) // position mouse over scrollbar
            .clickAndHold()
            .moveByOffset(0, valueDown) // scroll down
            .release()
            .build();

    scrollDown.perform();
  }

  public void scroolAlertas() throws InterruptedException, AWTException {
    Robot bot = new Robot();
//        bot.mouseMove();

    // bot.mouseMove((pag.width / 2), (pag.height / 2));
    // System.out.println("Largura: " + pag.width+ " Altura: " + pag.height);
    bot.setAutoDelay(100);
    sleep(100);
// System.out.println("++");
    bot.mouseWheel(-25);
    sleep(100);
// System.out.println("--");
    // bot.mouseWheel(-25);

  }

  public boolean isClickable(WebElement element) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, 5);
      wait.until(ExpectedConditions.elementToBeClickable(element));
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public Boolean noPresent(WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    Boolean result;
    try {
      wait.until(ExpectedConditions.invisibilityOf(element));
      result = true;
    } catch (Exception e) {
      result = false;
    }
    return result;

  }

  public boolean esperaTextoMudar(WebElement element, String textoAtual) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, 1);
      wait.until(ExpectedConditions.textToBePresentInElementValue(element, textoAtual));
      return true;
    } catch (Exception e) {
      return false;
    }
  }



  public void preencherCampos(WebElement element, String valor) {
    esperaElementoFicarClicavel(element);
    element.clear();
    esperaElementoFicarClicavel(element);
    element.sendKeys(valor);
  }



  public void validadorDeOrdenacaoDois(ArrayList array,
                                       WebElement botaoDaTabela) {
    logger.info("Ordenação : " + 0);
    clicarComJavaScript(botaoDaTabela);

    clicarComJavaScript(botaoDaTabela);
    logger.info("Ordenação : " + 1);

    clicarComJavaScript(botaoDaTabela);
    logger.info("Ordenação : " + 2);

    clicarComJavaScript(botaoDaTabela);
  }


  public void mudarAbaNavegador(String titleAba) {

    Set<String> janelas = driver.getWindowHandles();

    for (String janela : janelas) {
      driver.switchTo().window(janela);
      if (driver.getTitle().equals(titleAba)) {
        break;
      }
    }
  }

  public void analyzeLog() {
    LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
    for (LogEntry entry : logEntries) {
      System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry
              .getMessage());
      //do something useful with the data
    }
  }


}





