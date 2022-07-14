package com.adac.pageobjectactions.operationcenter;

import com.adac.pageobjects.operationcenter.OperationCenterPage;

public class OperationCenterPageAction extends OperationCenterPage {
    public boolean checkSearchByDropdownDisplayed(){
        return searchByDropdown.isDisplayed();
    }

    public void clickSearchByDropdown(){
        searchByDropdown.click();
    }
}
