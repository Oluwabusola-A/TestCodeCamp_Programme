package Konga;

import PageObjects.SearchPage;
import Setup.SetupTest;
import org.testng.annotations.Test;

import java.util.Random;


public class KongaTest extends SetupTest {
    @Test
    public void testLoginPage()
    {
        int addToCartButtonID = 1, numberOfItems = 1;
        String userId = "useremail", password = "userpassword", item = "Apple MacBooks",
                cardNumber = "0005 7876 0988 0004", date = "02/30", cvv = "071";
        //Instantiate random class
        Random random = new Random();

        try {
            //Sign in to Konga website
            //Replace the class type  'LoginPage' with 'var'
            var loginPage = welcomePage.clickLoginSignUpButton();
            //Replace the username and password string with valid user details
            loginPage.enterUsername(userId);
            loginPage.enterPassword(password);
            //Click on Login Button
            loginPage.clickLoginButton();
            //Select the category and subcategory
            var subCategoryPage =welcomePage.clickCategoryAndSub();
            //Search for an item
            subCategoryPage.searchForAnItem(item);
            SearchPage searchPage = subCategoryPage.clickSearchButton();
            //Click on the add to cart button
            searchPage.clickOnAddToCart(addToCartButtonID);
            //Click on the My Cart button
            var addToCartPage = searchPage.clickMyCartButton();
            //Click on checkout
            var checkOutPage = addToCartPage.clickCheckOut();
            //Click "Pay Now" to enable “Continue to Payment” button - the user must have preselected pick up method
            checkOutPage.clickOnPayNow();
            //Click on the “Continue to Payment” button
            checkOutPage.clickContinueToPayment();
            //Select the “CARD” payment method
            checkOutPage.clickOnPaymentType();
            //Input a wrong card number, date, CVV
            checkOutPage.enterCardDetails(cardNumber, date , cvv);

            //Print out invalid message for the card number field.
            System.out.println(checkOutPage.invalid_message());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}