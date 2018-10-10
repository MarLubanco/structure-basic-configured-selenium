package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YoutubeHome {

  @FindBy(id = "search")
  private WebElement search;

  @FindBy(id = "search-icon-legacy")
  private WebElement buttonSearch;

}