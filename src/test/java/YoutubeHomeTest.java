import common.Browser;
import common.BrowserDataProvider;
import common.Comandos;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class YoutubeHomeTest extends Comandos {

  public WebDriver driver;
  private String browser;

  @Factory(dataProvider = "navegadores", dataProviderClass = BrowserDataProvider.class)
  public YoutubeHomeTest(String browser) {
    this.browser = browser;
  }

  @Test
  public void abrirNavegador() {
    driver = Browser.retornaNavegador(browser);
    driver.get("https://www.youtube.com");
  }
}
