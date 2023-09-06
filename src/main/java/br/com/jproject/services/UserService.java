package br.com.jproject.services;

import br.com.jproject.entity.user.User;

import java.math.BigDecimal;

public interface UserService {

    void validadeTrasaction(User sender, BigDecimal amount);
    User findById(long id);

    void updateValuesMoney(User sender, User receiver, BigDecimal value);
}
