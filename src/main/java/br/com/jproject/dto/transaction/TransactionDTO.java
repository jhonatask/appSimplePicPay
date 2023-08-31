package br.com.jproject.dto.transaction;

import br.com.jproject.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private Long id;
    private User payer;
    private User payee;
    private BigDecimal amount;
    private LocalDateTime timestamp;
    private boolean isApproved;
}
