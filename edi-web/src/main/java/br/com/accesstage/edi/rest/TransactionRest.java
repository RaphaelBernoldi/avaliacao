package br.com.accesstage.edi.rest;

import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.accesstage.edi.facade.TransactionFacade;
import br.com.accesstage.edi.model.TransactionModel;

@Path("/transaction")
public class TransactionRest {
	
	private final Logger LOGGER = Logger.getLogger(TransactionRest.class.getName());
	
	@EJB
	private TransactionFacade transactionFacade;

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(TransactionModel transactionModel){
		LOGGER.info("[transaction][create]");
		
		try {
			String response = transactionFacade.save(transactionModel);
			
			return Response.ok(response).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.ok(e.getMessage()).build();

		}
	}
	
	@GET
	@Path("/{instituitionSender}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(@PathParam("instituitionSender") String instituitionSender){
		LOGGER.info("[transaction][find]");
		try {
			TransactionModel transactionModel = transactionFacade.findByInstituitionSent(instituitionSender);
			return Response.ok(transactionModel).build();

		} catch (Exception e) {
			return Response.ok(e.getMessage()).build();

		}
	}
}
