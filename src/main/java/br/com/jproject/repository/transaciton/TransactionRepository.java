package br.com.jproject.repository.transaciton;

import br.com.jproject.entity.transaction.Transaction;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TransactionRepository implements PanacheRepositoryBase<Transaction, Long> {
}
