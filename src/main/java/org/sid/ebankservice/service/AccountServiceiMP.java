package org.sid.ebankservice.service;

import org.sid.ebankservice.Dto.BankAccountRequestDTO;
import org.sid.ebankservice.Dto.BankAccountResponseDTO;
import org.sid.ebankservice.entities.BankAccount;
import org.sid.ebankservice.mappers.AccountMapper;
import org.sid.ebankservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceiMP implements AccountService{
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addaccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .cratedAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
       BankAccount savedbankAccount=bankAccountRepository.save(bankAccount);
       BankAccountResponseDTO bankAccountResponseDTO=accountMapper.fromBankAccount(savedbankAccount);
        return bankAccountResponseDTO;
    }
}
