package com.github.curriculeon.arcade;

import com.github.curriculeon.utils.Loggable;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class ArcadeAccountManager implements Loggable {
    private static final Path file = Paths.get(System.getProperty("user.dir") + "/src/main/resources/accounts.txt");
    private List<ArcadeAccount> accounts;

    public ArcadeAccountManager() {
        this.accounts = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = Files.newBufferedReader(file);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] acctData = line.split(",");
                ArcadeAccount acct = new ArcadeAccount(acctData[0], acctData[1]);
                accounts.add(acct);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public ArcadeAccount getAccount(String accountName, String accountPassword) {
        warn("Attempting to `%s(%s, %s)`...", getCurrentMethod(), accountName, accountPassword);
        ArcadeAccount result = accounts
                .stream()
                .filter(account -> {
                    String name = account.getUserName();
                    String pass = account.getPassword();
                    boolean correctName = name.equals(accountName);
                    boolean correctPass = pass.equals(accountPassword);
                    boolean correctAcct = correctName && correctPass;
                    return correctAcct;
                })
                .findFirst()
                .orElseGet(() -> {
                    warn("Account with username `%s` and password `%s` DOES NOT exist!", accountName, accountPassword);
                    registerAccount(createAccount(accountName, accountPassword));
                    return getAccount(accountName, accountPassword);
                });
        warn("`%s(%s, %s)` was successful!", getCurrentMethod(), accountName, accountPassword);
        warn("`%s(%s, %s)` resulted in [ %s ]", getCurrentMethod(), accountName, accountPassword, result);
        return result;
    }

    public Set<String> getAccountUsernames() {
        return accounts
                .stream()
                .map(ArcadeAccount::getUserName)
                .collect(Collectors.toSet());
    }

    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public ArcadeAccount createAccount(String accountName, String accountPassword) {
        warn("Attempting to `%s(%s, %s)`...", getCurrentMethod(), accountName, accountPassword);
        ArcadeAccount result = null;
        if (getAccountUsernames().contains(accountName)) {
            warn("`%s(%s, %s)` was NOT successful!", getCurrentMethod(), accountName, accountPassword);
            warn("Account with username `%s` already exists!", accountName);
        } else {
            result = new ArcadeAccount(accountName, accountPassword);
            warn("`%s(%s, %s)` was successful!", getCurrentMethod(), accountName, accountPassword);
            warn("`%s(%s, %s)` resulted in [ %s ]", getCurrentMethod(), accountName, accountPassword, result);
        }
        return result;
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param arcadeAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(ArcadeAccount arcadeAccount) {
        warn("Attempting to `%s(%s)`...", getCurrentMethod(), arcadeAccount);
        this.accounts.add(arcadeAccount);
        warn("`%s(%s)` was successful!", getCurrentMethod(), arcadeAccount);
        updateAccounts();
    }

    public void updateAccounts() {
        String data = "";
        for (ArcadeAccount arcadeAccount : accounts) {
            data += arcadeAccount.getUserName() + "," + arcadeAccount.getPassword() + "\n";
        }
        byte[] accountsData = data.getBytes();
        try {
            Files.write(file, accountsData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
