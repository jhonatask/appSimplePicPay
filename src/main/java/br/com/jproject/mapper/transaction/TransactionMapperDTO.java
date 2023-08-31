package br.com.jproject.mapper.transaction;

import br.com.jproject.dto.transaction.TransactionDTO;
import br.com.jproject.entity.transaction.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface TransactionMapperDTO {
    TransactionDTO transacitonToTransactionDTO(Transaction entity);
    Transaction transacitonDtoToTransaction(TransactionDTO entity);
}
