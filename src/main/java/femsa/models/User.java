package femsa.models;

import com.google.gson.annotations.SerializedName;

public class User {

    private User() {
    }

    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("email")
    private String email;

    private MerchantInfo merchantInfo;
    private BankInformation bankInformation;

    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.merchantInfo = builder.merchantInfo;
        this.bankInformation = builder.bankInformation;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public MerchantInfo getMerchantInfo() {
        return merchantInfo;
    }

    public BankInformation getBankInformation() {
        return bankInformation;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private MerchantInfo merchantInfo;
        private BankInformation bankInformation;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder merchantInfo(MerchantInfo merchantInfo) {
            this.merchantInfo = merchantInfo;
            return this;
        }

        public Builder bankInformation(BankInformation bankInformation) {
            this.bankInformation = bankInformation;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", merchantInfo=" + merchantInfo +
                ", bankInformation=" + bankInformation +
                '}';
    }
}
