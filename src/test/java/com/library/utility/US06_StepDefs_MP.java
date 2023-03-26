package com.library.utility;

import com.library.pages.BasePage;
import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.mysql.cj.log.Log;
import io.cucumber.java.en.*;
import org.jsoup.Connection;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class US06_StepDefs_MP {

    LoginPage loginPage;
    BasePage basePage;

    BookPage bookPage;
    @Given("the {string} on the home page")
    public void the_on_the_home_page(String librarian) {
        loginPage.login(librarian);
    }


    @Given("the user navigates to {string} page")
    public void the_user_navigates_to_page(String Books) {
        basePage.navigateModule(Books);
    }


    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {
        bookPage.addBook.click();
    }


    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String book) {
        bookPage.bookName.sendKeys(book);
    }


    @When("the librarian enter ISBN {string}")
    public void the_librarian_enter_isbn(String isbn) {
        bookPage.isbn.sendKeys(isbn);
    }


    @When("the librarian enter year {string}")
    public void the_librarian_enter_year(String year) {
        bookPage.year.sendKeys(year);
    }


    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String author) {
        bookPage.author.sendKeys(author);
    }


    @When("the librarian choose the book category {string}")
    public void the_librarian_choose_the_book_category(String category) {
        Select select = new Select(bookPage.categoryDropdown);
        select.selectByVisibleText(category);
    }


    @When("the librarian click to save changes")
    public void the_librarian_click_to_save_changes() {
        bookPage.saveChanges.click();
    }


    @Then("verify {string} message is displayed")
    public void verify_message_is_displayed(String message) {
        String actualMessage = bookPage.toastMessage.getText();
        System.out.println("actualMessage = " + actualMessage);


        String expectedMessage = message;
        System.out.println("expectedMessage = " + expectedMessage);


        Assert.assertEquals(expectedMessage, actualMessage);

    }


    @Then("verify {string} information must match with DB")
    public void verify_information_must_match_with_db(String string) {



    }


}
