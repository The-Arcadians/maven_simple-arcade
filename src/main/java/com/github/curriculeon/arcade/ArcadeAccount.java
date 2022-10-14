package com.github.curriculeon.arcade;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class ArcadeAccount {
    public String accountName;
    public String accountPassword;
    public ArcadeAccountManager arcadeAccountManager;

    public String getAccountName() {
        String userAccountName = new String("");
        return accountName;
    }

    public String getAccountPassword() {
        String userAccountPassword = new String("");
        return accountPassword;
    }

    public ArcadeAccountManager getArcadeAccountManager() {
        return arcadeAccountManager;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public void setArcadeAccountManager(ArcadeAccountManager arcadeAccountManager) {
        this.arcadeAccountManager = arcadeAccountManager;
    }
}
