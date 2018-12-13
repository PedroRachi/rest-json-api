package org.java.rest.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.java.rest.modal.Faturamento;

public class FaturamentoDao {

	ConnectionFactory cf = new ConnectionFactory();

	Faturamento faturamento;

	public List<Faturamento> retornaFaturamento() {
		//String sqlSelect = "SELECT id, estado, combustivel, hotel, estacionamento, supermercado FROM faturamento";
		String sqlSelect = "SELECT estado, sum(combustivel) as combustivel, sum(hotel) as hotel, sum(estacionamento) as estacionamento, sum(supermercado) as supermercado FROM faturamento group by estado;";
		List<Faturamento> lstFat = new ArrayList<Faturamento>();
		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			// stm.setString(1, documento);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					faturamento = new Faturamento();
					//faturamento.setId(rs.getInt("id"));					
					faturamento.setEstado(rs.getString("estado"));
					faturamento.setCombustivel(rs.getDouble("combustivel"));
					faturamento.setHotel(rs.getDouble("hotel"));
					faturamento.setEstacionamento(rs.getDouble("estacionamento"));
					faturamento.setSupermercado(rs.getDouble("supermercado"));
					lstFat.add(faturamento);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print("");}
		return lstFat;
	}
}
