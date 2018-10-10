package common;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.logging.Level;

public class Browser {

  public static WebDriver retornaNavegador(String browserName) {
    WebDriver driver = null;
    if (browserName.equals("firefox")) {
    System.setProperty("webdriver.gecko.driver",
            "src/main/resources/linux/geckodriver");
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    FirefoxProfile profile = new FirefoxProfile();
    profile.setPreference("pdfjs.disabled", true);
    profile.setPreference("browser.download.folderList", 2);
    profile.setPreference("browser.download.manager.showWhenStarting", false);
//                profile.setPreference("browser.download.dir", donwloadPath);
    profile.setPreference("browser.helperApps.neverAsk.openFile",
            "text/pdf,text/csv,application/x-msexcel,application/pdf,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
    profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
            "text/pdf,text/csv,application/x-msexcel,application/pdf,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");                profile.setPreference("browser.helperApps.alwaysAsk.force", false);
    profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
    profile.setPreference("browser.download.manager.focusWhenStarting", false);
    profile.setPreference("browser.download.manager.useWindow", false);
    profile.setPreference("browser.download.manager.showAlertOnComplete", false);
    profile.setPreference("browser.download.manager.closeWhenDone", false);
    LoggingPreferences logs = new LoggingPreferences();
    logs.enable(LogType.DRIVER, Level.OFF);
    logs.enable(LogType.BROWSER, Level.OFF);
    logs.enable(LogType.CLIENT, Level.OFF);
    logs.enable(LogType.PROFILER, Level.OFF);
    logs.enable(LogType.SERVER, Level.OFF);
    System.getProperties().put("webdriver.log.driver", "ON");
//    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//    capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
    // firefoxOptions.setBinary("C:\\selenium\\WebDriver\\Firefox\\55.0.3\\firefox.exe");
//    firefoxOptions.setProfile(profile);
//    firefoxOptions.addCapabilities(capabilities);
    driver = new FirefoxDriver(firefoxOptions);
    driver.manage().window().setSize(new Dimension(1366, 768));
  }
  return driver;
  }
}
