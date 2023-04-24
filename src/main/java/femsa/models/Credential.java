package femsa.models;

import com.google.gson.annotations.SerializedName;

public class Credential {
    @SerializedName("phoneNumber")
    private final String username;
    @SerializedName("password")
    private final String password;

    private Credential(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }



    public static class Builder {
        private String username;

        private String password;

        public Builder() {
        }



        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Credential build() {
            return new Credential(this);
        }
    }

    @Override
    public String toString() {
        return "Credential{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
