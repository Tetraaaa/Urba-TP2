package org.cnam.sample.controller;

import org.cnam.sample.controller.dto.AccountToCreateRequest;
import org.cnam.sample.controller.dto.AccountResponse;
import org.cnam.sample.domain.AccountService;
import org.cnam.sample.domain.entity.Account;
import org.cnam.sample.domain.entity.AccountToCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<AccountResponse> getAccount(@PathVariable("id") Long id) {
        Account accountFound = accountService.getById(id);
        if(accountFound == null) return ResponseEntity.notFound().build();

        AccountResponse accountResponse = new AccountResponse(accountFound.id, accountFound.money, accountFound.user);

        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<AccountResponse> createAccount(@RequestBody AccountToCreateRequest accountToCreateRequest) {
        AccountToCreate accountToCreate = new AccountToCreate(accountToCreateRequest.money, accountToCreateRequest.user);

        Account accountCreated = accountService.create(accountToCreate);

        AccountResponse accountResponse = new AccountResponse(accountCreated.id, accountCreated.money, accountCreated.user);

        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<AccountResponse> updateAccount(@PathVariable("id") Long id, @PathParam("money") Long money, @PathParam("userId") Long userId) {
        Account accountFound = accountService.getById(id);
        if(accountFound == null) return ResponseEntity.notFound().build();

        Account accountUpdate = accountService.update(accountFound, money, userId);

        AccountResponse accountResponse = new AccountResponse(accountUpdate.id, accountUpdate.money, accountUpdate.user);

        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity deleteAccount(@PathVariable("id") Long id) {
        Account accountFound = accountService.getById(id);
        if(accountFound == null) return ResponseEntity.notFound().build();

        accountService.delete(accountFound);

        return ResponseEntity.ok().build();
    }
}
