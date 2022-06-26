package com.adac.pageobjectactions.serviceplane.datadiscovery;

import com.adac.pageobjects.serviceplane.datadiscovery.DataDiscoveryPage;
import org.openqa.selenium.Keys;

public class DataDiscoveryPageAction extends DataDiscoveryPage {

    public void searchValue(String value){
        searchTextBar.sendKeys(value);
        searchTextBar.sendKeys(Keys.ENTER);
    }

}
