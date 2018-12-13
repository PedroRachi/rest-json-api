package org.java.rest.service;

import java.util.List;

import org.java.rest.Dao.FaturamentoDao;
import org.java.rest.modal.Faturamento;

public class FaturamentoService {
	FaturamentoDao dao;
	
	public FaturamentoService() {
		dao = new FaturamentoDao();
	}
	
	public List<Faturamento> retornaFaturamento() {
		return dao.retornaFaturamento();
	} 
	
	

}
