package ru.st.selenium;

import org.testng.annotations.Test;
import ru.st.selenium.model.Film;

import static org.testng.Assert.assertTrue;


public class AddNewMovieSuccess extends ru.st.selenium.pages.TestBase{

   @Test
    public void addNewMovieSuccess() throws Exception{
       Film film = new Film()
               .setTitle("FilmName" + System.currentTimeMillis())
               .setYear("1980");

        app.getUserHelper().loginAs(ADMIN);
        Integer beforeList = app.getFilmHelper().getSizeOfList();
        app.getFilmHelper().create(film);
        app.getNavigationHelper().openMainPage();
        Integer afterList = app.getFilmHelper().getSizeOfList();
        assertTrue(afterList.equals(beforeList + 1));
        app.getUserHelper().logout();
    }

}
