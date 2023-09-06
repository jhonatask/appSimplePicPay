package br.com.jproject.services;

import br.com.jproject.dto.transaction.TransactionDTO;
import br.com.jproject.entity.user.User;

import java.math.BigDecimal;

public interface TransactionService {

    public void executeTransaction(TransactionDTO transactionDTO);

    public boolean authorizeTransaction();
}
