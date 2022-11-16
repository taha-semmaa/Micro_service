package org.sid.ebankservice.web;

import org.sid.ebankservice.Dto.BankAccountRequestDTO;
import org.sid.ebankservice.Dto.BankAccountResponseDTO;
import org.sid.ebankservice.entities.BankAccount;
import org.sid.ebankservice.mappers.AccountMapper;
import org.sid.ebankservice.repositories.BankAccountRepository;
import org.sid.ebankservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;

    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService=accountService;
        this.accountMapper = accountMapper;
    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
       return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccount/{id}")
    public BankAccount bankAccount(@PathVariable String id)
    {
        return bankAccountRepository.findById(id).
                orElseThrow(()->new RuntimeException(String.format("Account not found",id)));
    }
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO)
    {

        return accountService.addaccount(requestDTO);
    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount)
    {
        BankAccount account=bankAccountRepository.findById(id).orElseThrow();
        if(bankAccount.getBalance()!=0)  account.setBalance(bankAccount.getBalance());
        if(bankAccount.getType()!=null)  account.setType(bankAccount.getType());
        if(bankAccount.getCurrency()!=null)  account.setCurrency(bankAccount.getCurrency());
        if(bankAccount.getCratedAt()!=null)     account.setCratedAt(bankAccount.getCratedAt());
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccount/{id}")
    public void deleteAccount(@PathVariable String id)
    {
         bankAccountRepository.deleteById(id);
    }

}
