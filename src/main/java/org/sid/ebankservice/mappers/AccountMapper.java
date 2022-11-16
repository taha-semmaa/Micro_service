package org.sid.ebankservice.mappers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.sid.ebankservice.Dto.BankAccountResponseDTO;
import org.sid.ebankservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }

}
