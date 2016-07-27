package ru.st.selenium;

import org.testng.annotations.Test;
import ru.st.selenium.model.Film;
import static org.testng.Assert.assertTrue;

public class DeleteMovie extends ru.st.selenium.pages.TestBase{

    @Test
    public void deleteMovie() throws Exception{
        Film film = new Film()
                .setTitle("FilmName" + System.currentTimeMillis())
                .setYear("1980");

        app.getUserHelper().loginAs(ADMIN);
        Integer beforeList = app.getFilmHelper().getSizeOfList();
        if (beforeList.equals(0)){
            app.getFilmHelper().create(film);
            app.getNavigationHelper().openMainPage();
            beforeList = 1;
        }
        app.getFilmHelper().delete();
        Integer afterList = app.getFilmHelper().getSizeOfList();
        assertTrue(afterList.equals(beforeList - 1));
        app.getUserHelper().logout();
    }
}
