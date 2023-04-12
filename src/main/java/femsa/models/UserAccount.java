package femsa.models;

public class UserAccount {
    private String holder;
    private String idBranch;
    private String idClabe;
    private String idFinancialData;
    private String idMerchant;
    private String nameMerchant;

    private UserAccount(Builder builder){
        this.holder = builder.holder;
        this.idBranch = builder.idBranch;
        this.idClabe = builder.idClabe;
        this.idFinancialData = builder.idFinancialData;
        this.idMerchant = builder.idMerchant;
        this.nameMerchant = builder.nameMerchant;
    }


    public String getHolder() {
        return holder;
    }

    public String getIdBranch() {
        return idBranch;
    }

    public String getIdClabe() {
        return idClabe;
    }

    public String getIdFinancialData() {
        return idFinancialData;
    }

    public String getIdMerchant() {
        return idMerchant;
    }

    public String getNameMerchant() {
        return nameMerchant;
    }

    public static class Builder {
        private String holder;
        private String idBranch;
        private String idClabe;
        private String idFinancialData;
        private String idMerchant;
        private String nameMerchant;

        public Builder withHolder(String holder){
            this.holder = holder;
            return this;
        }
        public Builder withIdBranch(String idBranch){
            this.idBranch = idBranch;
            return this;
        }
        public Builder withIdClabe(String idClabe){
            this.idClabe = idClabe;
            return this;
        }
        public Builder withIdFinancialData(String idFinancialData){
            this.idFinancialData = idFinancialData;
            return this;
        }
        public Builder withIdMerchant(String idMerchant){
            this.idMerchant = idMerchant;
            return this;
        }
        public Builder withNameMerchant(String nameMerchant){
            this.nameMerchant = nameMerchant;
            return this;
        }
    }
}
