package com.helesto.endpoint;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.helesto.dto.ClientDto;
import com.helesto.exceptions.BusinessError;
import com.helesto.exceptions.BusinessErrorException;
import com.helesto.services.ClientCreateService;
import com.helesto.services.ClientDeleteService;
import com.helesto.services.ClientListService;
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
public class ClientEndpoint {

        private static final Logger LOG = LoggerFactory.getLogger(ClientEndpoint.class.getName());

        @Inject
        ClientCreateService clientCreateService;

        @Inject
        ClientListService clientListService;

        @Inject
        ClientUpdateService clientUpdateService;

        @Inject
        ClientDeleteService clientDeleteService;

        @POST
        @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        @Operation(summary = "Create a Client", description = "Create a Client. Inform date field with the format mm/dd/yyyy")
        @APIResponse(responseCode = "200", description = "OK", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = ClientDto.class)) })
        @APIResponse(responseCode = "422", description = "Business Error", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = BusinessError.class)) })
        @APIResponse(responseCode = "500", description = "System error", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = BusinessError.class)) })
        public Response create(ClientDto request) throws BusinessErrorException {

                Jsonb jsonb = JsonbBuilder.create();
                String jsonString = jsonb.toJson(request);

                LOG.debug("ClientRest + POST - request - " + jsonString);

                ClientDto response = clientCreateService.CreateClientService(request);

                jsonString = jsonb.toJson(response);
                LOG.debug("ClientRest + POST - response - " + jsonString);

                return Response.status(Response.Status.OK).entity(response).build();

        }

        @GET
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        @Operation(summary = "List Client", description = "List clients")
        @APIResponse(responseCode = "200", description = "OK", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = ClientDto[].class)) })
        @APIResponse(responseCode = "422", description = "Business Error", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = BusinessError.class)) })
        @APIResponse(responseCode = "500", description = "System error", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = BusinessError.class)) })
        public Response list() throws BusinessErrorException {

                LOG.debug("ClientRest + GET");

                ClientDto[] response = clientListService.listClientService();

                Jsonb jsonb = JsonbBuilder.create();
                String jsonString = jsonb.toJson(response);

                LOG.debug("Response + GET - response - " + jsonString);

                return Response.status(Response.Status.OK).entity(response).build();

        }

        @PUT
        @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        @Operation(summary = "Update Client", description = "Update a client.  Inform date field with the format mm/dd/yyyy")
        @APIResponse(responseCode = "200", description = "Succes")
        @APIResponse(responseCode = "422", description = "Business Error", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = BusinessError.class)) })
        @APIResponse(responseCode = "500", description = "System error", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = BusinessError.class)) })
        public Response update(ClientDto request) throws BusinessErrorException {

                Jsonb jsonb = JsonbBuilder.create();
                String jsonString = jsonb.toJson(request);

                LOG.debug("ClientRest + PUT - request - " + jsonString);

                ClientDto response = clientUpdateService.updateClientService(request);

                jsonString = jsonb.toJson(response);
                LOG.debug("ClientRest + PUT - response - " + jsonString);

                return Response.status(Response.Status.OK).entity(response).build();

        }

        @DELETE
        @Path("{id}")
        @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
        @Operation(summary = "Delete Client", description = "Delete a client")
        @APIResponse(responseCode = "200", description = "Sucess")
        @APIResponse(responseCode = "422", description = "Business Error", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = BusinessError.class)) })
        @APIResponse(responseCode = "500", description = "System error", content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = BusinessError.class)) })
        public Response delete(
                        @Parameter(description = "The customer id to delete.", required = true) @PathParam("id") int id)
                        throws BusinessErrorException {

                LOG.debug("ClientRest + DELETE - id=[" + id + "]");

                clientDeleteService.deleteClientService(id);

                LOG.debug("ClientRest + DELETE - end");

                return Response.status(Response.Status.OK).build();

        }

}