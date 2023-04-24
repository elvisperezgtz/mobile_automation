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

    public BankInformation (Builder builder){
        this.clabe = builder.clabe;
        this.accountHolder = builder.accountHolder;
    }

    @Override
    public String toString() {
        return "BankInformation{" +
                "clabe='" + clabe + '\'' +
                ", accountHolder='" + accountHolder + '\'' +
                '}';
    }
    public static class Builder{
        private String clabe;
        private String accountHolder;

        public Builder withClabe(String clabe){
            this.clabe = clabe;
            return this;
        }
        public Builder withAccountHolder(String accountHolder){
            this.accountHolder = accountHolder;
            return  this;

        }
        public BankInformation build(){
            return new BankInformation(this);
        }
    }
}
