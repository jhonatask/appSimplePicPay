package br.com.jproject.repositorys.transaciton;

import br.com.jproject.dto.transaction.TransactionDTO;
import br.com.jproject.entity.transaction.Transaction;
import br.com.jproject.entity.user.User;
import br.com.jproject.mapper.transaction.TransactionMapperDTO;
import br.com.jproject.services.UserService;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;

@ApplicationScoped
public class TransactionRepository implements PanacheRepositoryBase<Transaction, Long> {

    @Inject
    TransactionMapperDTO transactionMapperDTO;

    @Inject
    UserService userService;
    public void createTransaction(TransactionDTO transactionDTO){
        Transaction transaction = transactionMapperDTO.transacitonDtoToTransaction(transactionDTO);
        User sender = userService.findById(transactionDTO.getPayer().getId());
        User receiver =  userService.findById(transactionDTO.getPayee().getId());
        transaction.setApproved(true);
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setPayer(sender);
        transaction.setPayee(receiver);
        transaction.setTimestamp(LocalDateTime.now());
        persist(transaction);
    }
}
