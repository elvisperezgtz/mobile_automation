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

    @SerializedName("merchant_info")
    private MerchantInfo merchantInfo;
    @SerializedName("bank_information")
    private BankInformation bankInformation;
    @SerializedName("phone_number")
    private String phoneNumber;

    @SerializedName("credentials")
    private Credentials credentials;

    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.merchantInfo = builder.merchantInfo;
        this.bankInformation = builder.bankInformation;
        this.phoneNumber = builder.phoneNumber;
        this.credentials = builder.credentials;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setNewPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private MerchantInfo merchantInfo;
        private BankInformation bankInformation;
        private String phoneNumber;
        private Credentials credentials;

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email) {
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

        public Builder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder withCredentials(Credentials credentials) {
            this.credentials = credentials;
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
                ", phoneNumber=" + phoneNumber +
                ", credentials=" + credentials +
                '}';
    }
}
