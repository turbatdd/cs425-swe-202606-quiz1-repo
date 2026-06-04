package miu.lesson.quiz1.db;

import miu.lesson.quiz1.model.Account;

public class DBContext {
    private static DBContext instance;
    private Account[] accounts;

    private DBContext() {
    }

    public static synchronized DBContext getInstance() {
        if (instance == null) {
            instance = new DBContext();
        }
        return instance;
    }

    private void loadData() {
        Account[] arr1 = {
                new Account(1, "TTT", "Agar", "(641) 123-0009", "dagar@m.as", "1 N Street"),
                new Account(3, "DDD", "Garvey", "(123) 292-0018", null, "4 East Ave"),
                new Account(4, "EEE", "Goldbloom", "(999) 165-1192", "jgold@es.co.za", null),
                new Account(5, "AAA", "Washington", null, null, "30 W Burlington")
        };
        accounts = arr1;
    }

    public Account[] getAllAccount() {
        if (accounts == null || accounts.length == 0) {
            loadData();
        }
        return accounts;
    }

    public Account createAccount(Account account) {
        Account[] newArr = new Account[accounts.length + 1];

        for (int i = 0; i < accounts.length; i++) {
            newArr[i] = accounts[i];
        }

        newArr[accounts.length] = account;

        accounts = newArr;
        return account;
    }
}
