package org.cnam.sample.controller;

import org.cnam.sample.controller.dto.AccountResponse;
import org.cnam.sample.controller.dto.AccountToCreateRequest;
import org.cnam.sample.controller.dto.DepositResponse;
import org.cnam.sample.controller.dto.DepositToCreateRequest;
import org.cnam.sample.domain.AccountService;
import org.cnam.sample.domain.DepositService;
import org.cnam.sample.domain.UserService;
import org.cnam.sample.domain.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/deposit")
public class DepositController {

    @Autowired
    DepositService depositService;

    @Autowired
    UserService userService;

    @Autowired
    AccountService accountService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<DepositResponse> getDeposit(@PathVariable("id") Long id) {
        Deposit depositFound = depositService.getById(id);
        if(depositFound == null) return ResponseEntity.notFound().build();

        DepositResponse depositResponse = new DepositResponse(true, depositFound.id, depositFound.amount, depositFound.depositaire, depositFound.account);
        return new ResponseEntity<>(depositResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<DepositResponse> createDeposit(@RequestBody DepositToCreateRequest depositToCreateRequest) {
        DepositToCreate depositToCreate = new DepositToCreate(depositToCreateRequest.amount, depositToCreateRequest.depositaire, depositToCreateRequest.account);

        DepositResult depositResult = depositService.create(depositToCreate);

        DepositResponse depositResponse = new DepositResponse(depositResult.ok, depositResult.id, depositResult.amount, depositResult.depositaire, depositResult.account);

        return new ResponseEntity<>(depositResponse, HttpStatus.OK);
    }

    @PostMapping("/deposer")
    @ResponseBody
    public ResponseEntity<DepositResponse> effectuerDepot(@RequestBody DepositToCreateRequest depositToCreateRequest) {
        DepositResponse depositResponse;
        DepositResult depositResult = depositService.effectuerDepot(depositToCreateRequest.amount, depositToCreateRequest.depositaire, depositToCreateRequest.account);
        if(depositResult != null)
        {
            depositResponse = new DepositResponse(true, depositResult.id, depositResult.amount, depositResult.depositaire, depositResult.account);
        }
        else
        {
            depositResponse = new DepositResponse(false, null, depositResult.amount, depositResult.depositaire, depositResult.account);
        }

        return new ResponseEntity<>(depositResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<DepositResponse> updateDeposit(@PathVariable("id") Long id, @PathParam("amount") Long amount, @PathParam("depositaireId") Long depositaireId, @PathParam("accountId") Long accountId) {
        Deposit depositFound = depositService.getById(id);
        if(depositFound == null) return ResponseEntity.notFound().build();

        Deposit depositUpdated = depositService.update(depositFound, amount, userService.getById(depositaireId), accountService.getById(accountId));

        DepositResponse depositResponse = new DepositResponse(true, depositUpdated.id, depositUpdated.amount, depositUpdated.depositaire, depositUpdated.account);

        return new ResponseEntity<>(depositResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity deleteDeposit(@PathVariable("id") Long id) {
        Deposit depositFound = depositService.getById(id);
        if(depositFound == null) return ResponseEntity.notFound().build();

        depositService.delete(depositFound);

        return ResponseEntity.ok().build();
    }
}
