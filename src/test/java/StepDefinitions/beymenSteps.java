package StepDefinitions;

import Pages.Elements;
import Pages.Parent;
import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class beymenSteps {

    Elements e = new Elements();

    @When("open the site and verify that")
    public void openTheSiteAndVerifyThat() {
        GWD.getDriver().get("https://www.beymen.com");
        GWD.getDriver().manage().window().maximize();
        e.findAndContainsText("beymen", "kadın");
        System.out.println("Site acildi!");

    }

    @And("SendKeys to searchBar  from excel and delete")
    public void sendkeysToSearchBarFromExcelAndDelete() {

        ArrayList<ArrayList<String>> list = ExcelUtility.getListData("src/test/java/ExcelPath/beymen.xlsx", "Sayfa1", 2);


        for (ArrayList<String> sc : list) {

            e.findAndSend("searchBar", sc.get(0));
        }
        Actions ak=new Actions(GWD.getDriver());
        Action action = ak.click(e.searchBar).keyDown(Keys.BACK_SPACE).
                         keyDown(Keys.BACK_SPACE).
                         keyDown(Keys.BACK_SPACE).
                         keyDown(Keys.BACK_SPACE).build();

        action.perform();


    }

    @And("SendKeys to searchBar  from excel")
    public void sendkeysToSearchBarFromExcel() {
        ArrayList<ArrayList<String>> list = ExcelUtility.getListData("src/test/java/ExcelPath/beymen.xlsx", "Sayfa1", 2);


        for (ArrayList<String> sc : list) {

            e.findAndSend("searchBar", sc.get(1));
        }

    }


    @And("Press enter from keyboard and click on random product")
    public void pressEnterFromKeyboardAndClickOnRandomProduct() {

        Actions ak=new Actions(GWD.getDriver());
        Action action =ak.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build();
        action.perform();

        e.findAndClick("product");




    }

    @And("Write to product and price infos to txt file")
    public void writeToProductAndPriceInfosToTxtFile() {

        try {
            FileWriter  file=new FileWriter("src/test/java/eTxtFile/productInfo.txt",true);
            file.write(e.productTitle.getText());
            file.write("\n\n");
            file.write(e.productPrice.getText());
            file.write("\n");
            file.write(e.productColor.getText());
            file.write("\n\n\n");
            file.write(e.productInfo.getText());
            file.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        System.out.println("Urun Bilgileri txt'ye yazildi!");


    }

    @And("Add product to cart and compare the prices")
    public void addProductToCartAndCompareThePrices() {
        e.findAndClick("size");
        e.findAndClick("addToCart");
        e.findAndClick("Cart");

        e.findAndContainsText("CartPrice","1.199,00 TL");

        System.out.println("Sayfadaki ve sepetti fiyatlar esit!");


    }

    @And("Increase the quantity and verify")
    public void ıncreaseTheQuantityAndVerify() {
        e.findAndClick("quantityMenu");
        e.findAndClick("quantity");

        e.findAndContainsText("quantity","2");

        System.out.println("sepet adedi 2!");



    }

    @Then("Delete product from cart and verify")
    public void deleteProductFromCartAndVerify() {
           e.findAndClick("deleteBtn");
           e.findAndContainsText("emptyMsg","SEPETINIZDE ÜRÜN BULUNMAMAKTADIR");

          System.out.println("Sepet Bos!");

    }


}
