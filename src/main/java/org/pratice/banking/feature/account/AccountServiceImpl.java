package org.pratice.banking.feature.account;

import lombok.RequiredArgsConstructor;
import org.pratice.banking.feature.account.dto.AccountRequest;
import org.pratice.banking.feature.account.dto.AccountRespone;
import org.pratice.banking.feature.accountrepository.AccountRepository;
import org.pratice.banking.feature.mapper.AccountMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;
    @Override
    public List<AccountRespone> getAccountList() {
        return null;
    }

    @Override
    public AccountRespone createAccount(AccountRequest accountRequest) {
        return null;
    }

    @Override
    public AccountRespone getAccount(String id) {
        return null;
    }

    @Override
    public AccountRespone updateAccount(String accountNumber) {
        return null;
    }

    @Override
    public List<AccountRespone> FindByUserAccountById(String id) {
        return null;
    }

}
