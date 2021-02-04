package org.cnam.sample.controller;

import org.cnam.sample.controller.dto.WithdrawalResponse;
import org.cnam.sample.controller.dto.WithdrawalToCreateRequest;
import org.cnam.sample.domain.WithdrawalService;
import org.cnam.sample.domain.entity.Withdrawal;
import org.cnam.sample.domain.entity.WithdrawalResult;
import org.cnam.sample.domain.entity.WithdrawalToConfirm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/withdrawal")
public class WithdrawalController {

    @Autowired
    WithdrawalService withdrawalService;

    @Autowired
    UserService userService;

    @Autowired
    AccountService accountService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<WithdrawalResponse> getWithdrawal(@PathVariable("id") Long id) {
        Withdrawal withdrawalFound = withdrawalService.getById(id);
        if(withdrawalFound == null) return ResponseEntity.notFound().build();

        WithdrawalResponse withdrawalResponse = new WithdrawalResponse(withdrawalFound.id, withdrawalFound.amount, withdrawalFound.beneficiaire, withdrawalFound.account);

        return new ResponseEntity<>(withdrawalResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<WithdrawalResponse> createWithdrawal(@RequestBody WithdrawalToCreateRequest withdrawalToCreateRequest) {
        WithdrawalToConfirm withdrawalToConfirm = new WithdrawalToConfirm(withdrawalToCreateRequest.amount, withdrawalToCreateRequest.beneficiaire, withdrawalToCreateRequest.account);
        WithdrawalResponse withdrawalResponse;

        WithdrawalResult withdrawalResult = withdrawalService.askForWithdrawal(withdrawalToConfirm);
        if(withdrawalResult.ok)
        {
             withdrawalResponse = new WithdrawalResponse(withdrawalResult.id, withdrawalResult.amount, withdrawalResult.beneficiaire, withdrawalResult.account);

        }
        else
        {
             withdrawalResponse = new WithdrawalResponse(withdrawalResult.id, withdrawalResult.amount, withdrawalResult.beneficiaire, withdrawalResult.account);

        }

        return new ResponseEntity<>(withdrawalResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<WithdrawalResponse> updateWithdrawal(@PathVariable("id") Long id, @PathParam("amount") Long amount, @PathParam("beneficiaireId") Long beneficiaireId, @PathParam("accountId") Long accountId) {
        Withdrawal withdrawalFound = withdrawalService.getById(id);
        if(withdrawalFound == null) return ResponseEntity.notFound().build();

        Withdrawal withdrawalUpdated = withdrawalService.update(withdrawalFound, amount, accountService.getById(beneficiaireId), accountService.getById(accountId));

        WithdrawalResponse withdrawalResponse = new WithdrawalResponse(withdrawalUpdated.id, withdrawalUpdated.amount, withdrawalUpdated.beneficiaire, withdrawalUpdated.account);

        return new ResponseEntity<>(withdrawalResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity deleteWithdrawal(@PathVariable("id") Long id) {
        Withdrawal withdrawalFound = withdrawalService.getById(id);
        if(withdrawalFound == null) return ResponseEntity.notFound().build();

        withdrawalService.delete(withdrawalFound);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/retirer")
    @ResponseBody
    public ResponseEntity<WithdrawalResponse> effectuerRetrait(@RequestBody WithdrawalToCreateRequest withdrawalToCreateRequest) {
        WithdrawalResponse withdrawalResponse;
        WithdrawalResult withdrawalResult = withdrawalService.effectuerRetrait(withdrawalToCreateRequest.amount, withdrawalToCreateRequest.beneficiaire, withdrawalToCreateRequest.account);
        if(withdrawalResult != null)
        {
            withdrawalResponse = new WithdrawalResponse(withdrawalResult.id, withdrawalResult.amount, withdrawalResult.beneficiaire, withdrawalResult.account);
        }
        else
        {
            withdrawalResponse = new WithdrawalResponse(null, withdrawalResult.amount, withdrawalResult.beneficiaire, withdrawalResult.account);
        }

        return new ResponseEntity<>(withdrawalResponse, HttpStatus.OK);
    }
}
