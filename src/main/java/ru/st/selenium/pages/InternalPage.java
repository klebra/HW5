package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InternalPage extends AnyPage {

	public InternalPage(PageManager pages) {
		super(pages);
	}
	
  public InternalPage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.cssSelector("nav")));
    return this;
  }
  
  @FindBy(css = "nav a[href $= '?go=profile']")
  private WebElement userProfileLink;

  @FindBy(css = "nav a[href $= '?go=users']")
  private WebElement userManagementLink;

  @FindBy(css = "nav a[href $= '?logout']")
  private WebElement logoutLink;

  @FindBy(css = "img[alt=\"Add movie\"]")
  private WebElement addFilmButton;

  @FindBy(id = "results")
  public WebElement listOfFilms;

  public UserProfilePage clickUserProfilePage() {
    userProfileLink.click();
    return pages.userProfilePage;
  }

  public UserManagementPage clickUserManagementLink() {
    userManagementLink.click();
    return pages.userManagementPage;
  }
  
  public AddFilmPage clickAddFilmButton() {
    addFilmButton.click();
    return pages.addFilmPage;
  }

  public List<WebElement> listOfFilms(){
     return pages.internalPage.ensurePageLoaded().listOfFilms.findElements(By.tagName("a"));
  }

  public FilmPage clickOnNthFilm(Integer filmNumber){
    pages.internalPage.listOfFilms.findElements(By.className("title")).get(filmNumber).click();
    return pages.filmPage;
  }

  public LoginPage clickLogoutLink() {
    logoutLink.click();
    wait.until(alertIsPresent()).accept();
    return pages.loginPage;
  }

}
