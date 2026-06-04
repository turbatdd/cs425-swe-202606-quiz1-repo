package miu.lesson.quiz1.db;

import miu.lesson.quiz1.model.Account;
import miu.lesson.quiz1.model.AccountTierType;
import miu.lesson.quiz1.model.AccountType;
import miu.lesson.quiz1.model.Customer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class DBContext {
    private static DBContext instance;
    private Account[] accounts;
    private Customer[] customers;

    private DBContext() {
    }

    public static synchronized DBContext getInstance() {
        if (instance == null) {
            instance = new DBContext();
        }
        return instance;
    }

    private void loadData() {

        String id1 = UUID.randomUUID().toString();
        String id2 = UUID.randomUUID().toString();
        String id3 = UUID.randomUUID().toString();

        Customer[] customers1 = {
                new Customer(
                        id1,
                        "Bob",
                        "Jones"),
                new Customer(
                        id2,
                        "Carlos",
                        "Jimenez"),
                new Customer(
                        id3,
                        "Carlos",
                        "Jimenez")
        };

        Account[] acc1 = {
                new Account(
                        "aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa",
                        "AC1002",
                        AccountTierType.PLATINUM,
                        AccountType.CHECKING,
                        LocalDate.parse("2016-05-17"),
                        new BigDecimal("155900.50"),
                        id1
                ),
                new Account(
                        "bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb",
                        "AS1001",
                        AccountTierType.SILVER,
                        AccountType.SAVINGS,
                        LocalDate.parse("2021-06-02"),
                        new BigDecimal("12500.95"),
                        id2
                ),
                new Account(
                        "cccccccc-cccc-cccc-cccc-cccccccccccc",
                        "AS1003",
                        AccountTierType.GOLD,
                        AccountType.SAVINGS,
                        LocalDate.parse("2016-07-11"),
                        new BigDecimal("75000.00"),
                        id3
                )};

        accounts = acc1;
        customers = customers1;
    }

    public Account[] getAllAccount() {
        if (accounts == null || accounts.length == 0) {
            loadData();
        }
        return accounts;
    }

    public Customer[] getAllCustomers() {
        if (customers == null || customers.length == 0) {
            loadData();
        }

        return customers;
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
