package femsa.models;

import com.google.gson.annotations.SerializedName;

public class BankInformation {

    private String clabe;
    @SerializedName("account_holder")
    private String accountHolder;

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

}
