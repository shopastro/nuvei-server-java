package com.safecharge.model;

import javax.validation.constraints.Size;

public class ExternalTokenProvider {

    @Size(max = 45)
    private String externalTokenProvider;

    @Size(max = 45)
    private String cardType;

    @Size(max = 255)
    private String externalTokenData;

    @Size(max = 5000)
    private String mobileToken;

    public String getExternalTokenProvider() {
        return externalTokenProvider;
    }

    public void setExternalTokenProvider(String externalTokenProvider) {
        this.externalTokenProvider = externalTokenProvider;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getExternalTokenData() {
        return externalTokenData;
    }

    public void setExternalTokenData(String externalTokenData) {
        this.externalTokenData = externalTokenData;
    }

    public String getMobileToken() {
        return mobileToken;
    }

    public void setMobileToken(String mobileToken) {
        this.mobileToken = mobileToken;
    }
}