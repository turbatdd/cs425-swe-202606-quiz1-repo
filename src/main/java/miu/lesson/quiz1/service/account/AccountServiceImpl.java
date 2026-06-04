package miu.lesson.quiz1.service.account;

import miu.lesson.quiz1.model.Account;
import miu.lesson.quiz1.repository.AccountRepository;
import miu.lesson.quiz1.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl() {
        this.accountRepository = AccountRepository.getInstance();
    }

    @Override
    public Account[] getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.createAccount(account);
    }
}