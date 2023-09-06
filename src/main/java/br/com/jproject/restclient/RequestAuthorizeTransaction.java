package br.com.jproject.restclient;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/autorization")
public class RequestAuthorizeTransaction {

    @Inject
    @RestClient
    RequestAuthorizeTransactionService requestAuthorizeTransactionService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthorize(){
        ResponseAuthorize autorizacao =  requestAuthorizeTransactionService.getAuthorize();
        return Response.ok(autorizacao).build();
    }

}
