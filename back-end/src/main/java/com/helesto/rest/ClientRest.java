package com.helesto.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.helesto.api.RequestInsertClient;
import com.helesto.api.RequestUpdateClient;
import com.helesto.api.ResponseInsertClient;
import com.helesto.api.ResponseSelectClient;
import com.helesto.exceptions.BusinessError;
import com.helesto.exceptions.BusinessErrorException;
import com.helesto.services.ClientDeleteService;
import com.helesto.services.ClientInsertService;
import com.helesto.services.ClientSelectService;
import com.helesto.services.ClientUpdateService;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/client")
@Tag(name = "Client", description = "Client CRUD")
@RequestScoped
public class ClientRest {

        private static final Logger LOG = LoggerFactory.getLogger(ClientRest.class.getName());

        @Inject
        ClientInsertService clientInsertService;

        @Inject
        ClientSelectService clientSelectService;

        @Inject
        ClientUpdateService clientUpdateService;

        @Inject
        ClientDeleteService clientDeleteService;

        @POST
        @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        @Operation(summary = "Insert Client", description = "Insert a client")
        @APIResponse(responseCode = "200", description = "ResponseInsertClient", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInsertClient.class)) })
        @APIResponse(responseCode = "422", description = "Business Error", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = BusinessError.class)) })
        @APIResponse(responseCode = "500", description = "System error", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = BusinessError.class)) })
        public Response insert(RequestInsertClient request) throws BusinessErrorException {

                LOG.debug("ClientRest + POST - begin");

                ResponseInsertClient response = clientInsertService.insertClientService(request);

                LOG.debug("ClientRest + POST - end");

                return Response.status(Response.Status.OK).entity(response).build();

        }

        @GET
        @Consumes(MediaType.TEXT_PLAIN)
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        @Operation(summary = "Select Client", description = "Select a client")
        @APIResponse(responseCode = "200", description = "RequestSelectClient", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseSelectClient.class)) })
        @APIResponse(responseCode = "422", description = "Business Error", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = BusinessError.class)) })
        @APIResponse(responseCode = "500", description = "System error", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = BusinessError.class)) })
        public Response select(
                        @Parameter(description = "The customer id to select.", required = true) @QueryParam("id") int clientId)
                        throws BusinessErrorException {

                LOG.debug("ClientRest + GET - begin");

                ResponseSelectClient response = clientSelectService.selectClientService(clientId);

                LOG.debug("ClientRest + GET - end");

                return Response.status(Response.Status.OK).entity(response).build();

        }

        @PUT
        @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        @Operation(summary = "Update Client", description = "Update a client")
        @APIResponse(responseCode = "200", description = "Succes")
        @APIResponse(responseCode = "422", description = "Business Error", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = BusinessError.class)) })
        @APIResponse(responseCode = "500", description = "System error", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = BusinessError.class)) })
        public Response update(RequestUpdateClient request) throws BusinessErrorException {

                LOG.debug("ClientRest + PUT - begin");

                clientUpdateService.updateClientService(request);

                LOG.debug("ClientRest + PUT - end");

                return Response.status(Response.Status.OK).build();

        }

        @DELETE
        @Consumes(MediaType.TEXT_PLAIN)
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        @Operation(summary = "Delete Client", description = "Delete a client")
        @APIResponse(responseCode = "200", description = "Sucess")
        @APIResponse(responseCode = "422", description = "Business Error", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = BusinessError.class)) })
        @APIResponse(responseCode = "500", description = "System error", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = BusinessError.class)) })
        public Response delete(
                        @Parameter(description = "The customer id to delete.", required = true) @QueryParam("id") int clientId)
                        throws BusinessErrorException {

                LOG.debug("ClientRest + DELETE - begin");

                clientDeleteService.deleteClientService(clientId);

                LOG.debug("ClientRest + DELETE - end");

                return Response.status(Response.Status.OK).build();

        }

}