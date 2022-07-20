package com.adac.pageobjectactions.dashboard;

import com.adac.pageobjects.dashboard.DashboardPage;

public class DashboardPageAction extends DashboardPage {
    public Integer getDataOperationTotalCount(String dataOperationType){
        return Integer.parseInt(dataOperationTotalCountText(dataOperationType).getText());

    }

    public Integer getDataOperationUpCount(String dataOperationType){
        return Integer.parseInt(dataOperationUpCountText(dataOperationType).getText().trim().substring(0,2));

    }
    public Integer getDataOperationDownCount(String dataOperationType){
        return Integer.parseInt(dataOperationDownCountText(dataOperationType).getText().trim().substring(0,2));

    }
}
