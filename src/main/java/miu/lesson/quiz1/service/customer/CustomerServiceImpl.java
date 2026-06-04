package miu.lesson.quiz1.service.customer;

import miu.lesson.quiz1.model.Account;
import miu.lesson.quiz1.model.Customer;
import miu.lesson.quiz1.repository.AccountRepository;
import miu.lesson.quiz1.repository.CustomerRepository;
import miu.lesson.quiz1.service.AccountService;
import miu.lesson.quiz1.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl() {
        this.customerRepository = CustomerRepository.getInstance();
    }

    @Override
    public Customer[] getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Account account) {
        return null;
    }
}