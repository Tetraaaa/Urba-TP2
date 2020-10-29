package org.cnam.sample.domain;

import org.cnam.sample.domain.entity.Account;
import org.cnam.sample.domain.entity.AccountToCreate;
import org.cnam.sample.repository.AccountRepository;
import org.cnam.sample.repository.model.AccountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountRepository sampleRepository;

    public Account getById(Long id) {
        AccountModel accountModelFound = sampleRepository.getOne(id);

        return new Account(accountModelFound.getId(), accountModelFound.getMoney());
    }

    public Account create(AccountToCreate accountToCreate) {
        AccountModel accountModelToCreate = new AccountModel(accountToCreate.money);

        AccountModel accountModelCreated = sampleRepository.save(accountModelToCreate);

        return new Account(accountModelCreated.getId(), accountModelCreated.getMoney());
    }

}
