package com.helesto.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.helesto.schema.ErrorResponse;
import com.helesto.schema.RequestInsertClient;
import com.helesto.schema.ResponseInsertClient;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Path("/client/insert")
public class InsertClientRest {

    private static final Logger LOG = LoggerFactory.getLogger(InsertClientRest.class.getName());

    @POST
    @Operation(summary = "Insert Client", description = "Insert a client")
    @APIResponse(responseCode = "200", description = "DadosRespostaConsultarCorretora", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInsertClient.class)) })
    @APIResponse(responseCode = "422", description = "Business Error", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
    @APIResponse(responseCode = "500", description = "System error", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })

    public Response servir(RequestInsertClient request) {

        LOG.debug("RequestInsertClient");

        Gson gson = new Gson();
        String json = gson.toJson(request);
        LOG.debug("Request: " + json);

        if (request.getName() == null || request.getName().equals("") || request.getName().equals("string")) {

            LOG.debug("Error 422");

            ErrorResponse error = new ErrorResponse(2, "Please inform the client name");

            return Response.status(422).type(MediaType.APPLICATION_JSON_TYPE).entity(error).build();

        }

        ResponseInsertClient response = new ResponseInsertClient();

        response.setClientId(1);

        json = gson.toJson(response);
        LOG.debug("Response: " + json);

        return Response.status(Response.Status.OK).entity(response).build();

    }

}