package com.github.curriculeon.arcade;

import com.github.curriculeon.Arcade;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class ArcadeAccountManager {

    private HashMap<String, ArcadeAccount> accounts;
    private final Path file = Paths.get("accounts.txt");

    public ArcadeAccountManager() throws IOException {
        this.accounts = new HashMap<>();
        BufferedReader reader = Files.newBufferedReader(this.file);
        String line;
        while ((line = reader.readLine()) != null) {
            String[] acctData = line.split(",");
            ArcadeAccount acct = new ArcadeAccount(acctData[0], acctData[1]);
        }
    }

    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public ArcadeAccount getAccount(String accountName, String accountPassword) {
        if (this.accounts.containsKey(accountName)) {
            ArcadeAccount acct = this.accounts.get(accountName);
            if (acct.getPassword().equals(accountPassword)) {
                return acct;
            }
        }
        return  null;
    }

    public Set<String> getAccountUsernames() {
        return accounts.keySet();
    }

    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public ArcadeAccount createAccount(String accountName, String accountPassword) {
       if (this.accounts.containsKey(accountName)) {
           return null;
       } else {
           ArcadeAccount newAcct = new ArcadeAccount(accountName, accountPassword);
           this.accounts.put(accountName, newAcct);
           return newAcct;
       }
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param arcadeAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(ArcadeAccount arcadeAccount) {
        this.accounts.put(arcadeAccount.getUserName(),arcadeAccount);
    }

    public void updateAccounts() throws IOException{
        String data = "";
        for (HashMap.Entry<String, ArcadeAccount> entry : this.accounts.entrySet()) {
            data += entry.getValue().getUserName() + "," + entry.getValue().getPassword() + "\n";
        }
        byte[] accountsData = data.getBytes();
        Files.write(this.file, accountsData);
    }
}
