package miu.lesson.quiz1.repository;

import miu.lesson.quiz1.db.DBContext;
import miu.lesson.quiz1.model.Account;

import java.util.Arrays;
import java.util.Comparator;

public class AccountRepository {
    private static AccountRepository instance;
    private DBContext dbContext;

    private AccountRepository() {
        dbContext = DBContext.getInstance();
    }

    public static synchronized AccountRepository getInstance() {
        if (instance == null) {
            instance = new AccountRepository();
        }
        return instance;
    }

    public Account[] findAll() {
        return dbContext.getAllAccount();
    }

    public Account createAccount(Account account) {
        return dbContext.createAccount(account);
    }
}
