package org.sid.ebankservice.service;

import org.sid.ebankservice.Dto.BankAccountRequestDTO;
import org.sid.ebankservice.Dto.BankAccountResponseDTO;

public interface AccountService {
    public BankAccountResponseDTO addaccount(BankAccountRequestDTO bankAccountDTO);
}
