package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class FilmPage extends InternalPage {

    public FilmPage(PageManager pages) {
        super(pages);
    }

    @FindBy(css = "img[alt=\"Remove\"]")
    private WebElement removeFilmButton;

    public InternalPage clickRemoveFilmButton() {
        removeFilmButton.click();
        wait.until(alertIsPresent()).accept();
        return pages.internalPage;
    }

    public FilmPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.className("maininfo_full")));
        return this;
    }
}
