package br.com.jproject.services;


import br.com.jproject.core.exceptions.TransacitonException;
import br.com.jproject.dto.transaction.TransactionDTO;
import br.com.jproject.entity.user.User;
import br.com.jproject.repositorys.transaciton.TransactionRepository;
import br.com.jproject.restclient.RequestAuthorizeTransactionService;
import br.com.jproject.restclient.ResponseAuthorize;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class TransactionServiceImp implements TransactionService{
    @Inject
    UserService userService;

    @Inject
    @RestClient
    RequestAuthorizeTransactionService requestAuthorizeTransactionService;

    @Inject
    TransactionRepository transactionRepository;

    @Override
    public void executeTransaction(TransactionDTO transactionDTO) {
        User sender = userService.findById(transactionDTO.getPayer().getId());
        User receiver =  userService.findById(transactionDTO.getPayee().getId());

        userService.validadeTrasaction(sender, transactionDTO.getAmount());
        boolean isAuthorized = authorizeTransaction();
        if(!isAuthorized) {
            throw new TransacitonException("Transacao nao autorizada");
        }
        transactionRepository.createTransaction(transactionDTO);
        userService.updateValuesMoney(sender, receiver, transactionDTO.getAmount());
    }

    @Override
    public boolean authorizeTransaction() {
        ResponseAuthorize authorize = requestAuthorizeTransactionService.getAuthorize();
        return authorize.getMessage().equals("Autorizado");
    }
}
