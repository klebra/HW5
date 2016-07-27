package ru.st.selenium;

import org.testng.annotations.Test;
import ru.st.selenium.model.Film;

import static org.testng.Assert.assertTrue;

public class AddNewMovieFail extends ru.st.selenium.pages.TestBase{

    @Test
    public void addNewMovieFail() throws Exception{
        Film film = new Film()
                .setTitle("")
                .setYear("ffff");

        app.getUserHelper().loginAs(ADMIN);
        Integer beforeList = app.getFilmHelper().getSizeOfList();
        app.getFilmHelper().create(film);
        app.getNavigationHelper().openMainPage();
        Integer afterList = app.getFilmHelper().getSizeOfList();
        assertTrue(afterList.equals(beforeList));
        app.getUserHelper().logout();
    }

}

