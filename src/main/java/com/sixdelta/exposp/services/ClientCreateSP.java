package com.sixdelta.exposp.services;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import com.sixdelta.exposp.model.Account;
import com.sixdelta.exposp.model.ProcedureOutPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Component;


@Component
public class ClientCreateSP extends StoredProcedure {
	
	private static final String SPROC_NAME = "alta_cliente";
	
	@Autowired
	ClientCreateSP(DataSource dataSource) {
		super(dataSource, SPROC_NAME);
		declareParameter(new SqlParameter("Nombre", Types.VARCHAR));
		declareParameter(new SqlParameter("Direccion", Types.VARCHAR));
		declareParameter(new SqlParameter("Correo", Types.VARCHAR));
		declareParameter(new SqlParameter("Telefono", Types.VARCHAR));
		declareParameter(new SqlParameter("Saldo", Types.DECIMAL));
		declareParameter(new SqlParameter("Ejecutivo", Types.VARCHAR));
		
		
		declareParameter(new SqlOutParameter("p_cliente", Types.INTEGER));
		declareParameter(new SqlOutParameter("p_cuenta", Types.INTEGER));
	    declareParameter(new SqlOutParameter("p_saldo", Types.DECIMAL));
	    compile();
	}
	
	public ProcedureOutPojo execute(Account input) {
		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put("Nombre", input.getName());
		inParams.put("Direccion", input.getAddress());
		inParams.put("Correo", input.getEmail());
		inParams.put("Telefono", input.getPhone());
		inParams.put("Saldo", input.getAmount());
		inParams.put("Ejecutivo", input.getExcecutive());

		Map<String, Object> out = super.execute(inParams);
		out.put("p_cliente", String.format("%08d", out.get("p_cliente")));
		return new ProcedureOutPojo(out);
	}
	
	

}