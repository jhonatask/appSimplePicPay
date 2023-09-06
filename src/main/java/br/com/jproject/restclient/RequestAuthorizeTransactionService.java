package br.com.jproject.restclient;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/v3")
@RegisterRestClient
public interface RequestAuthorizeTransactionService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/8fafdd68-a090-496f-8c9a-3442cf30dae6")
    ResponseAuthorize getAuthorize();
}
