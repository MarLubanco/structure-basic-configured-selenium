package common;

import org.testng.annotations.DataProvider;

public class BrowserDataProvider {

  @DataProvider(name = "navegadores")
  public Object[][] navegadores() {
    return new Object[][]{

            //  {getParameterBrowser()},
//                {"chrome"},
            {"firefox"},
//                {"phantomjs"},
    };
  }

  public String getParameterBrowser() {
    return (System.getProperty("BrowserName").toString());
  }
}



