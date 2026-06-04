package miu.lesson.quiz1.service;

import miu.lesson.quiz1.model.Account;
import miu.lesson.quiz1.model.Customer;

public interface CustomerService {
    Customer[] getAllCustomer();
    Customer createCustomer(Account account);
}
