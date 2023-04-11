package femsa.models;

import com.google.gson.annotations.SerializedName;

public class MerchantInfo {
    @SerializedName("merchant_name")
    private String merchantName;
    @SerializedName("merchant_activity")
    private String merchantActivity;
    @SerializedName("postal_code")
    private String postalCode;

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
}
