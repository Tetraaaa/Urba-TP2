package org.cnam.sample.domain;

import org.cnam.sample.domain.entity.*;
import org.cnam.sample.repository.WithdrawalRepository;
import org.cnam.sample.repository.model.WithdrawalModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class WithdrawalService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private WithdrawalService withdrawalService;

    public Withdrawal getById(Long id)
    {
        Optional<WithdrawalModel> withdrawalModelFound = withdrawalRepository.findById(id);
        if(!withdrawalModelFound.isPresent()) return null;

        WithdrawalModel modelFound = withdrawalModelFound.get();
        Account beneficiaire = accountService.getById(modelFound.getBeneficiaire().getId());
        Account account = accountService.getById(modelFound.getAccount().getId());

        return new Withdrawal(modelFound.getId(), modelFound.getAmount(), beneficiaire, account);
    }

    public Withdrawal create(WithdrawalToCreate withdrawalToCreate)
    {
        AccountModel beneficiaire = new AccountModel(withdrawalToCreate.beneficiaire.id, withdrawalToCreate.beneficiaire.money, new UserModel(withdrawalToCreate.beneficiaire.user.id, withdrawalToCreate.beneficiaire.user.firstname, withdrawalToCreate.beneficiaire.user.lastname));
        AccountModel account = new AccountModel(withdrawalToCreate.account.id, withdrawalToCreate.account.money, new UserModel(withdrawalToCreate.account.user.id, withdrawalToCreate.account.user.firstname, withdrawalToCreate.account.user.lastname));

        WithdrawalModel withdrawalCreated =  withdrawalRepository.save(new WithdrawalModel(withdrawalToCreate.amount, beneficiaire, account));
        return new Withdrawal(withdrawalCreated.getId(), withdrawalCreated.getAmount(), accountService.getById(withdrawalCreated.getBeneficiaire().getId()), accountService.getById(withdrawalCreated.getAccount().getId()));
    }

    public WithdrawalResult askForWithdrawal(WithdrawalToConfirm withdrawalToConfirm)
    {
        AccountModel beneficiaire = new AccountModel(withdrawalToConfirm.beneficiaire.id, withdrawalToConfirm.beneficiaire.money, new UserModel(withdrawalToConfirm.beneficiaire.user.id, withdrawalToConfirm.beneficiaire.user.firstname, withdrawalToConfirm.beneficiaire.user.lastname));
        AccountModel account = new AccountModel(withdrawalToConfirm.account.id, withdrawalToConfirm.account.money, new UserModel(withdrawalToConfirm.account.user.id, withdrawalToConfirm.account.user.firstname, withdrawalToConfirm.account.user.lastname));

        WithdrawalModel withdrawalCreated =  withdrawalRepository.save(new WithdrawalModel(withdrawalToConfirm.amount, beneficiaire, account));


        if(account.getMoney() >= withdrawalToConfirm.amount)
        {
            account.setMoney(account.getMoney() - withdrawalToConfirm.amount);
            accountRepository.save(account);
            return new WithdrawalResult(true, withdrawalCreated.getId(), withdrawalToConfirm.amount, withdrawalToConfirm.beneficiaire, withdrawalToConfirm.account);
        }
        else
        {
            return new WithdrawalResult(false, withdrawalCreated.getId(), withdrawalToConfirm.amount, withdrawalToConfirm.beneficiaire, withdrawalToConfirm.account);
        }
    }

    public Withdrawal update(Withdrawal withdrawalToUpdate, Long amount, Account beneficiaire, Account account)
    {
        AccountModel beneficiaireModel = new AccountModel(beneficiaire.id, beneficiaire.money, new UserModel(beneficiaire.user.id, beneficiaire.user.firstname, beneficiaire.user.lastname));
        AccountModel accountModel = new AccountModel(account.id, account.money, new UserModel(withdrawalToUpdate.account.user.id, withdrawalToUpdate.account.user.firstname, withdrawalToUpdate.account.user.lastname));
        WithdrawalModel withdrawalModelToUpdate = new WithdrawalModel(withdrawalToUpdate.id, amount, beneficiaireModel, accountModel);
        WithdrawalModel withdrawalModelUpdated = withdrawalRepository.save(withdrawalModelToUpdate);
        return new Withdrawal(withdrawalModelUpdated.getId(), withdrawalModelUpdated.getAmount(), accountService.getById(withdrawalModelUpdated.getBeneficiaire().getId()), accountService.getById(withdrawalModelUpdated.getAccount().getId()));
    }

    public void delete(Withdrawal withdrawalToDelete)
    {
        AccountModel beneficiaire = new AccountModel(withdrawalToDelete.beneficiaire.id, withdrawalToDelete.beneficiaire.money, new UserModel(withdrawalToDelete.beneficiaire.user.id, withdrawalToDelete.beneficiaire.user.firstname, withdrawalToDelete.beneficiaire.user.lastname));
        AccountModel account = new AccountModel(withdrawalToDelete.account.id, withdrawalToDelete.account.money, new UserModel(withdrawalToDelete.account.user.id, withdrawalToDelete.account.user.firstname, withdrawalToDelete.account.user.lastname));
        WithdrawalModel withdrawalModel = new WithdrawalModel(withdrawalToDelete.id, withdrawalToDelete.amount, beneficiaire, account);
        withdrawalRepository.delete(withdrawalModel);
    }

    public WithdrawalResult effectuerRetrait(Long amount, Account beneficiaire, Account account)
    {
        if(accountService.accountExists(account) && amount > 0)
        {
            accountService.crediterCompte(amount, account);
            WithdrawalToCreate withdrawalToCreate = new WithdrawalToCreate(amount, beneficiaire, account);
            Withdrawal withdrawal = withdrawalService.create(withdrawalToCreate);
            return new WithdrawalResult(true, withdrawal.id, withdrawal.amount, withdrawal.beneficiaire, withdrawal.account);
        }
        else
        {
            return null;
        }
    }
}
