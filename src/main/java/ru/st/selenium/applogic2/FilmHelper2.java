package ru.st.selenium.applogic2;

import java.util.List;

import ru.st.selenium.applogic.FilmHelper;
import ru.st.selenium.model.Film;
import ru.st.selenium.pages.InternalPage;

public class FilmHelper2 extends DriverBasedHelper implements FilmHelper {

  public FilmHelper2(ApplicationManager2 manager) {
    super(manager.getWebDriver());
  }

  @Override
  public void create(Film film) {
    pages.internalPage
            .clickAddFilmButton().ensurePageLoaded()
            .setTitleField(film.getTitle())
            .setYearField(film.getYear())
            .clickSubmitButton();
  }

  @Override
  public void delete() {
     pages.internalPage
            .clickOnNthFilm(0).ensurePageLoaded()
            .clickRemoveFilmButton();
  }

  @Override
  public List<Film> search(String title) {
    // TODO Auto-generated method stub
    return null;
  }

    @Override
    public int getSizeOfList() {
        return pages.internalPage
                .listOfFilms().size();
    }

}
