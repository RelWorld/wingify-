package com.relevelProject.qa.testCases;

import com.relevelProject.qa.testComponents.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import relevelProject001.data.GetExcelData;
import relevelProject001.pageobjects.HomePage;

import java.io.IOException;

import java.util.List;
import java.util.Map;

public class HomePageFunctionality extends baseTest {
    //homepage ammount functionality , check if valuse are in sorted order or not in the table
    @Test(priority = 8,enabled = true)
    public void HomePageTest() throws IOException, InterruptedException {
        List<Map<String,String>> testDataInMap = GetExcelData.getTestdatInMap();
        landingPage.typeUserName(testDataInMap.get(0).get("username"));
        landingPage.typePassword(testDataInMap.get(0).get("password"));
        HomePage homePage = landingPage.login();
        List<String> list1 =homePage.CheckAmmountbeforeSortedOrder();
        Thread.sleep(3000);
        homePage.ammountClick();
        Thread.sleep(3000);
        List <String> list2 =homePage.CheckAmmountSortedOrder();
        boolean equalArray = list1.equals(list2);
        Assert.assertFalse(equalArray,"values are sorted ");



                }
            }






