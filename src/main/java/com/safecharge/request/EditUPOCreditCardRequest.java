package com.safecharge.request;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.safecharge.model.UserDetails;
import com.safecharge.request.builder.SafechargeBuilder;
import com.safecharge.util.APIConstants;
import com.safecharge.util.AddressUtils;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;
import com.safecharge.util.ValidationUtils;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 * <p>
 * Request to add Credit/Debit card User Payment Option(UPO) to a User.
 * <p>
 * This goal of this request is to add a credit card UPO for a specific user according to their User Token ID.
 * Once a credit card UPO is added to the user’s list of UPOs, the credit card is displayed in the payment page.
 *
 * @author <a mailto:bozhidarsh@safecharge.com>Bozhidar Shumanov</a>
 * @since 3/21/2017
 */
@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.EDIT_CASHIER_CC_CARD)
public class EditUPOCreditCardRequest extends SafechargeRequest {

    /**
     * One or two digit value that is the expiration month.
     */
    @NotNull(message = "ccExpMonth parameter is mandatory!")
    @Pattern(regexp = APIConstants.EXP_MONTH_REGEX, message = "Expiration month must have a valid value")
    private String ccExpMonth;

    /**
     * Two or four digit value that is the expiration year.
     * When the value is two digits, the year is assumed to be 2000 + ccExpYear; ccExpMonth and ccExpYear must be a date that is after the current date.
     * The year may not exceed 10 years in to the future.
     */
    @NotNull(message = "ccExpYear parameter is mandatory!")
    @Pattern(regexp = APIConstants.EXP_YEAR_REGEX, message = "Expiration year must 2 or 4 digits")
    private String ccExpYear;

    /**
     * The name of the credit card owner as it is written on the card.
     */
    @NotNull(message = "ccNameOnCard parameter is mandatory!")
    private String ccNameOnCard;

    /**
     * This parameter is a unique identifier for each customer generated by you.
     */
    @NotNull(message = "userTokenId parameter is mandatory!")
    private String userTokenId;

    /**
     * Billing address related to a user payment option. Since order can contain only one payment option billing address is part of the order parameters.
     */
    private UserDetails billingAddress;

    public static Builder builder() {
        return new Builder();
    }

    public String getCcExpMonth() {
        return ccExpMonth;
    }

    public void setCcExpMonth(String ccExpMonth) {
        this.ccExpMonth = ccExpMonth;
    }

    public String getCcExpYear() {
        return ccExpYear;
    }

    public void setCcExpYear(String ccExpYear) {
        this.ccExpYear = ccExpYear;
    }

    public String getCcNameOnCard() {
        return ccNameOnCard;
    }

    public void setCcNameOnCard(String ccNameOnCard) {
        this.ccNameOnCard = ccNameOnCard;
    }

    public String getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        this.userTokenId = userTokenId;
    }

    public UserDetails getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(UserDetails billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AddUPOCreditCard{");
        sb.append(", ccExpMonth='")
                .append(ccExpMonth)
                .append('\'');
        sb.append(", ccExpYear='")
                .append(ccExpYear)
                .append('\'');
        sb.append(", ccNameOnCard='")
                .append(ccNameOnCard)
                .append('\'');
        sb.append(", billingAddress=")
                .append(billingAddress);
        sb.append(", userTokenId='")
                .append(userTokenId)
                .append('\'');
        sb.append(", ")
                .append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    public static class Builder extends SafechargeBuilder<Builder> {

        private String ccExpMonth;
        private String ccExpYear;
        private String ccNameOnCard;
        private String userTokenId;
        private UserDetails billingAddress;

        /**
         * Adds the credit card expiration month to the request.
         *
         * @param ccExpMonth Two digit value representing the expiration month.
         * @return this object
         */
        public Builder addCcExpMonth(String ccExpMonth) {
            this.ccExpMonth = ccExpMonth;
            return this;
        }

        /**
         * Adds the credit card expiration year to the request.
         *
         * @param ccExpYear Two or four digit value representing the expiration year.
         *                  When the value is two digits, the year is assumed to be 2000 + ccExpYear.
         *                  The ccExpMonth and ccExpYear must be a future date.
         *                  The year may not exceed 10 years in to the future.
         * @return this object
         */
        public Builder addCCExpYear(String ccExpYear) {
            this.ccExpYear = ccExpYear;
            return this;
        }

        /**
         * Adds the name of the credit card owner to the request.
         *
         * @param ccNameOnCard The name of the credit card owner as it appears on the card
         * @return this object
         */
        public Builder addCcNameOnCard(String ccNameOnCard) {
            this.ccNameOnCard = ccNameOnCard;
            return this;
        }

        /**
         * Adds user token id to the request.
         *
         * @param userTokenId the user token as {@link String}
         * @return this object
         */
        public Builder addUserTokenId(String userTokenId) {
            this.userTokenId = userTokenId;
            return this;
        }

        /**
         * Adds billing address data to the request.
         *
         * @param billingAddress {@link UserDetails} object to get the billing details from
         * @return this object
         */
        public Builder addBillingAddress(UserDetails billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        /**
         * Adds billing address data to the request.
         *
         * @param firstName   The first name of the recipient
         * @param lastName    The last name of the recipient
         * @param address     The address of the recipient
         * @param phone       The phone number of the recipient
         * @param zip         The postal code of the recipient
         * @param city        The city of the recipient
         * @param countryCode The country of the recipient(two-letter ISO country code)
         * @param state       The state of the recipient(two-letter ISO state code)
         * @param email       The email of the recipient
         * @param locale      The recipient’s locale and default language, for example en_UK.
         * @param dateOfBirth The date of birth of the recipient
         * @return this object
         */
        public Builder addBillingAddress(String firstName, String lastName, String address, String phone, String zip, String city, String countryCode,
                                         String state, String email, String locale, String dateOfBirth, String county) {

            UserDetails billingAddress = AddressUtils.createUserDetailsFromParams(firstName, lastName, address, phone,
                    zip, city, countryCode, state, email, locale, dateOfBirth, county);

            return addBillingAddress(billingAddress);
        }

        /**
         * Builds the request.
         *
         * @return {@link SafechargeRequest} object build from the params set by this builder
         * @throws ConstraintViolationException if the validation of the params fails
         */
        @Override
        public SafechargeBaseRequest build() throws ConstraintViolationException {
            EditUPOCreditCardRequest addUPOCreditCard = new EditUPOCreditCardRequest();
            addUPOCreditCard.setCcExpMonth(ccExpMonth);
            addUPOCreditCard.setCcExpYear(ccExpYear);
            addUPOCreditCard.setCcNameOnCard(ccNameOnCard);
            addUPOCreditCard.setUserTokenId(userTokenId);
            addUPOCreditCard.setBillingAddress(billingAddress);
            return ValidationUtils.validate(super.build(addUPOCreditCard));
        }
    }
}
