package com.adac.pageobjectactions.operationscenter;

import com.adac.pageobjects.operationscenter.OperationsCenterPage;

public class OperationsCenterPageAction extends OperationsCenterPage {
    public boolean checkSearchByDropdownDisplayed(){
        return searchByDropdown.isDisplayed();
    }

    public void applyIncludeAllServicesFilter(){
        searchByDropdown.click();
        includeAllServicesToggleButton.click();
        searchByDoneButton.click();
    }

    public boolean checkIncidentsExist(){
        if(incidentRows.size() > 0){
            return true;
        }else{
           return false;
        }
    }
}
