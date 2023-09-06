package br.com.jproject.restclient;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RegisterForReflection
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAuthorize {
    private String message;
}
