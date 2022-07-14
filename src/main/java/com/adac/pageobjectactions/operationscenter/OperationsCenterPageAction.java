package com.adac.pageobjectactions.operationscenter;

import com.adac.pageobjects.operationscenter.OperationsCenterPage;

public class OperationsCenterPageAction extends OperationsCenterPage {
    public boolean checkSearchByDropdownDisplayed(){
        return searchByDropdown.isDisplayed();
    }

    public void clickSearchByDropdown(){
        searchByDropdown.click();
    }
}
