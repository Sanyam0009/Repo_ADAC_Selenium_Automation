package com.adac.pageobjectactions.serviceplane.dataobservability;

import com.adac.pageobjects.serviceplane.dataobservability.DataStoreItemsPage;

public class DataStoreItemsPageAction extends DataStoreItemsPage{
    public boolean checkDiskSpaceUsedDisplayed(){
        return diskSpaceCardHeading.isDisplayed();
    }
}
