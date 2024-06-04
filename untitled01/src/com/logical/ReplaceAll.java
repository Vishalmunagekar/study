package com.logical;

public class ReplaceAll {

    public static void main(String[] args) {
        String str = "{\"userInfo\":{\"bankID\":\"EIKB\",\"id\":\"VISHSUP\",\"localeInfo\":{\"country\":\"\",\"language\":\"\"},\"multiUserFields\":\"{topCustomerId:};{userVotes:};{userType:BANK};{unLimitedToken:N}\",\"name\":\"Vishal\",\"networkAddress\":\"\",\"orgUnitID\":\"we will see\",\"roles\":[],\"superUser\":true,\"timeZoneId\":\"Europe/Copenhagen\",\"userCustSeqNo\":null,\"userSubCustAccess\":\"N\",\"userType\":\"BANK\",\"lastLogin\":-1},\"hideError\":true,\"token\":\"jUgAX03n7oiuip1Khltdy/fnhgIxVV2gkBbV4MP40Sg=TIMESTAMP:1711964247190\"}, Path: /healthcheck/getHealthStatus&AASWeb, Bearer: asdf, xIsSSO: TPH-Is-SSO";
        String[] sensitiveFields = {"password", "token", "bankID", "Bearer"};
        for (String field : sensitiveFields) {
            str = str.replaceAll("\"" + field + "\"\\s*:\\s*\"[^\"]+\"", "\"" + field + "\":\"*****\"");
        }
        System.out.println(str);
    }

}
