package br.com.jproject.services;

import br.com.jproject.core.exceptions.TransacitonException;
import br.com.jproject.core.exceptions.UserException;
import br.com.jproject.entity.user.User;
import br.com.jproject.entity.user.UserType;
import br.com.jproject.repositorys.user.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;

@ApplicationScoped
public class UserServiceImp implements UserService{

    @Inject
    UserRepository userRepository;
    @Override
    public void validadeTrasaction(User sender, BigDecimal amount) {
            if (sender.getUserType() == UserType.MERCHANT){
                throw new TransacitonException("Usuario do tipo logista nao esta autorizado a realizar transacao");
            }
            if (sender.getBalance().compareTo(amount) < 0){
                throw new TransacitonException("Saldo Insuficiente");
            }
    }

    @Override
    public User findById(long id) {
        User user = userRepository.findById(id);
        if(user == null) {
            String userNotFound = "Usuario não encontrado";
            throw new UserException(userNotFound);
        }
        return user;
    }

    @Override
    public void updateValuesMoney(User sender, User receiver, BigDecimal value) {
        sender.setBalance(sender.getBalance().subtract(value));
        receiver.setBalance(receiver.getBalance().add(value));
        userRepository.persist(sender);
        userRepository.persist(receiver);
    }
}
