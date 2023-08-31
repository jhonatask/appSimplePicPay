package br.com.jproject.repository.user;


import br.com.jproject.entity.user.User;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Column;

import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<User, Long> {

    Optional<User> findUserByDocument(String  document){
        return find("document = ?1", document).firstResultOptional();
    }
}
