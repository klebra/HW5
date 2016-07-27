package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class AddFilmPage extends InternalPage{

    public AddFilmPage(PageManager pages) {
        super(pages);
    }

    @FindBy(name = "name")
    private WebElement titleField;

    @FindBy(name = "year")
    private WebElement yearField;

    @FindBy(css = "img[alt=\"Save\"]")
    private WebElement saveButton;

    public AddFilmPage setTitleField(String text){
        titleField.sendKeys(text);
        return this;
    }

    public AddFilmPage setYearField(String text){
        yearField.sendKeys(text);
        return this;
    }

    public void clickSubmitButton() {
        saveButton.click();
    }

    public AddFilmPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.name("name")));
        return this;
    }

}
