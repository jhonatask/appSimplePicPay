package br.com.jproject.dto.user;

import br.com.jproject.entity.user.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    public Long id;
    public String document;
    public String email;
    public String fullName;
    public String password;
    public BigDecimal balance;
    public UserType userType;
}
