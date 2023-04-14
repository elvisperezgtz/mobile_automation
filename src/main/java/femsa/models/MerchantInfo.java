package femsa.models;

import com.google.gson.annotations.SerializedName;

public class MerchantInfo {
    @SerializedName("merchant_name")
    private String merchantName;
    @SerializedName("merchant_activity")
    private String merchantActivity;
    @SerializedName("postal_code")
    private String postalCode;

    private MerchantInfo(Builder builder){
        this.merchantName= builder.merchantName;
        this.merchantActivity = builder.merchantActivity;
        this.postalCode = builder.postalCode;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantActivity() {
        return merchantActivity;
    }

    public void setMerchantActivity(String merchantActivity) {
        this.merchantActivity = merchantActivity;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "MerchantInfo{" +
                "merchantName='" + merchantName + '\'' +
                ", merchantActivity='" + merchantActivity + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public static class Builder {
        private String merchantName;
        private String merchantActivity;
        private String postalCode;

        public Builder withMerchantName(String merchantName) {
            this.merchantName = merchantName;
            return this;
        }

        public Builder withMerchantActivity(String merchantActivity) {
            this.merchantActivity = merchantActivity;
            return this;
        }
        public Builder withPostalCode (String postalCode){
            this.postalCode = postalCode;
            return this;
        }
        public MerchantInfo build(){return new MerchantInfo(this);}
    }
}
