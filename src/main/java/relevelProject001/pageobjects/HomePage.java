package relevelProject001.pageobjects;

import com.relevelProject.qa.utilis.abstractComponents01;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends abstractComponents01 {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        // initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//th[@class='text-center']/following-sibling::th[1]")
    public WebElement ammountOPtion; // ammount

    @FindBy(xpath = "//td[@class='text-right bolder nowrap']/span")
    public List<WebElement> amountCells; // table values (6 vaues)

    public void ammountClick() {
        ammountOPtion.click();

    }

 public List<String> CheckAmmountbeforeSortedOrder() {
     List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'transactionsTable']//tbody//tr//td[5]"));
     List <String> array = new ArrayList<>();
     for(int i = 1; i <= rows.size(); i++)
     {
         WebElement val = driver.findElement(By.xpath("//table[@id = 'transactionsTable']//tr["+i+"]//td[5]"));
         String values = val.getText();
         array.add(values);

     }
return array;
 }

    public List<String> CheckAmmountSortedOrder() {
        List <WebElement> rows1 = driver.findElements(By.xpath("//table[@id = 'transactionsTable']//tbody//tr//td[5]"));
        List <String> sortArray = new ArrayList<>();
        for(int i = 1; i <= rows1.size(); i++)
        {
            WebElement val = driver.findElement(By.xpath("//table[@id = 'transactionsTable']//tr["+i+"]//td[5]"));
            String values = val.getText();
            sortArray.add(values);
        }

                 return sortArray;
    }
 }