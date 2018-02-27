package com.sixdelta.exposp.controller;

import com.sixdelta.exposp.model.Account;
import com.sixdelta.exposp.model.ProcedureOutPojo;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import com.sixdelta.exposp.services.ClientCreateSP;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AltaControllerTest{
	
	@Autowired
	private MockMvc mockServicio;
	
	@MockBean
	private ClientCreateSP mockClientCreateSP;
	
	ObjectMapper mapper = new ObjectMapper();
	
	String cadenaAltaEjemplo = "{\"name\":\"Komander\","
			+ "\"phone\":\"223321\","
			+ "\"address\":\"direccion\","
			+ "\"email\":\"correo\","
			+ "\"executive\":\"ejecutivo123\","
			+ "\"amount\":\"42000.11\"}";

	@Test
	public void altaServicioRestTest() throws Exception{
		Map<String, Object> inParamsMock = new HashMap<String, Object>();
		inParamsMock.put("p_cliente", 1);
		inParamsMock.put("p_cuenta", 1);
		inParamsMock.put("p_saldo", 42000.11);
		ProcedureOutPojo outputDeseado = new ProcedureOutPojo(inParamsMock);
		Mockito.when(mockClientCreateSP.execute(
				Mockito.any(Account.class))).thenReturn(outputDeseado);	
		RequestBuilder reqMock = MockMvcRequestBuilders
				.post("/alta")
				.accept(MediaType.APPLICATION_JSON)
				.content(cadenaAltaEjemplo)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult resultadoMock = mockServicio.perform(reqMock)
				.andReturn();
		MockHttpServletResponse responseServicioMock = resultadoMock.getResponse();
		assertEquals(HttpStatus.OK.value(), responseServicioMock.getStatus());
		String jsonInString = responseServicioMock.getContentAsString();
		ProcedureOutPojo outputReal = mapper.readValue(jsonInString, ProcedureOutPojo.class);
		assertEquals(outputDeseado.getNumeroCliente(), outputReal.getNumeroCliente());
		assertEquals(outputDeseado.getNumeroCuenta(), outputReal.getNumeroCuenta());
		assertEquals(outputDeseado.getSaldo(), outputReal.getSaldo());
	}
	
}
