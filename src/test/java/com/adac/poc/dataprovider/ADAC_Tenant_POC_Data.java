package com.adac.poc.dataprovider;

import org.testng.annotations.DataProvider;

public class ADAC_Tenant_POC_Data {

    @DataProvider (name="createTeamVerification")
    public Object[][] createTeamVerificationData(){
       return  new Object[][] {{"SanyamTeamT1","Tester","TestDesc"}};
    }
}
