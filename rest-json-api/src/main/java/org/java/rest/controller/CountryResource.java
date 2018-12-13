package org.java.rest.controller;


import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.java.rest.modal.Faturamento;
import org.java.rest.service.FaturamentoService;

@Path("/faturamento")
public class CountryResource {
	
	@GET
	@Path("/lista-geral")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Faturamento> getFatruamentoGeral(){
		
		FaturamentoService serv = new FaturamentoService();
		List<Faturamento> lstfat = serv.retornaFaturamento();	
				
		return lstfat;
	}
	
	
}
