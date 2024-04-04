package org.pratice.banking.feature.account;

import org.pratice.banking.feature.account.dto.AccountRequest;
import org.pratice.banking.feature.account.dto.AccountRespone;

import java.util.List;

public interface AccountService {
    List<AccountRespone> getAccountList();
    AccountRespone createAccount(AccountRequest accountRequest);
    AccountRespone getAccount(String id);
    AccountRespone updateAccount(String accountNumber);
    List<AccountRespone> FindByUserAccountById(String id);
}
