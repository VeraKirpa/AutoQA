package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class OpenPage {
    public static final WebDriver driver = new ChromeDriver();
    public static final ArrayList<String> priceList = new ArrayList<String>();
    HashMap<String, String> cousrePrice = new HashMap<String, String>();

    @When("webpage is opened")
    public static void WebPageOpened() {

    }

    @When("user open webpage")
    public void userOpenWebpage() {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @And("click radio button Radio{int}")
    public void clickRadioButtonRadio(int arg0) {
        WebElement radbtn = driver.findElement(By.xpath("//input[@value='radio1']"));
        radbtn.click();
        System.out.println("WE are here");

    }


    @And("type in text field {string}")
    public void typeInTextField(String arg0) {
        WebElement txtfld = driver.findElement(By.xpath("//input[@class='inputs ui-autocomplete-input']"));
        txtfld.sendKeys(arg0);
    }

    @And("click dropdown and select {string}")
    public void clickDropdownAndSelectOption(String arg0) {
        Select drpdwn = new Select(driver.findElement(By.xpath("//select[@id='dropdown-class-example']")));
        drpdwn.selectByValue(arg0);
    }

    @And("get checkbox text")
    public void getOptionCheckboxText() {
        String gettextstr = driver.findElement(By.xpath("//option[@value='option2']")).getText();
        System.out.println(gettextstr);
        System.out.println("WE are here 2");
    }



    public List<String> getAllPricesFromTableToList() {


        List<WebElement> list;
        list = driver.findElements(By.xpath("(//body)[1]/tr"));

        for (int i = 2; i < list.size(); i++) {
            priceList.add(driver.findElement(By.xpath("(//tbody)[1]/tr["+i+"]/td[3]")).getText());
            System.out.println(priceList.get(i-3));
        }
        System.out.println("WE are here 3");
        return priceList;

    }

    @And("print out list")
    public void printOutList() {

     List<String> newList = getAllPricesFromTableToList();

        getAllPricesFromTableToList().forEach(System.out::println);

        System.out.println("WE are here 6");

    }

    public  HashMap<String, String> getAllPricesIntoMapWhereKeyIsCourseNameAndValueIsPrice(HashMap<String, String> cousrePrice) {
        HashMap<String, String> mapPrice = new HashMap<String, String>();
        List<WebElement> list;
        list = driver.findElements(By.xpath("(//body)[1]/tr"));

        for (int i = 2; i < list.size(); i++) {
            mapPrice.put(driver.findElement(By.xpath("(//tbody)[1]/tr["+i+"]/td[2]")).getText(),driver.findElement(By.xpath("(//tbody)[1]/tr["+i+"]/td[3]")).getText());
            System.out.println(i+""+mapPrice.get(i-3));
        }
        System.out.println("WE are here 4");
        return mapPrice;
    }

    @And("print out map")
    public void printOutMap() {


        getAllPricesIntoMapWhereKeyIsCourseNameAndValueIsPrice(cousrePrice);
        System.out.println(cousrePrice);
        System.out.println("WE are here 5");

    }

    @Then("close webpage")
    public void closeWebpage() {
        driver.quit();
    }


}

