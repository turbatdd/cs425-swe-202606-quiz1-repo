package miu.lesson.quiz1.repository;

import miu.lesson.quiz1.db.DBContext;
import miu.lesson.quiz1.model.Account;
import miu.lesson.quiz1.model.Customer;

public class CustomerRepository {
    private static CustomerRepository instance;
    private DBContext dbContext;

    private CustomerRepository() {
        dbContext = DBContext.getInstance();
    }

    public static synchronized CustomerRepository getInstance() {
        if (instance == null) {
            instance = new CustomerRepository();
        }
        return instance;
    }

    public Customer[] findAll() {
        return dbContext.getAllCustomers();
    }

    public Account createAccount(Account account) {
        return dbContext.createAccount(account);
    }
}
