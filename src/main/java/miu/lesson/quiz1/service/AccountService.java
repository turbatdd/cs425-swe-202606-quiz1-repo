package miu.lesson.quiz1.service;

import miu.lesson.quiz1.model.Account;

public interface AccountService {
    Account[] getAllAccounts();
    Account createAccount(Account account);
}
