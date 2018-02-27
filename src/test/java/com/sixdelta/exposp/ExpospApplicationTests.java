package com.sixdelta.exposp;

import com.sixdelta.exposp.model.Account;
import com.sixdelta.exposp.model.Cliente;
import com.sixdelta.exposp.model.Cuenta;
import com.sixdelta.exposp.repository.ClientRepository;
import com.sixdelta.exposp.repository.CuentaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.beans.factory.annotation.Autowired;
import com.sixdelta.exposp.services.ClientCreateSP;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExpospApplicationTests{

	@Autowired
	ClientCreateSP clientSp;

	@Autowired
	CuentaRepository cuentaRepository;

	@Autowired
	ClientRepository clientRepository;

	@Test
	public void altaAccountTest() {
		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put("Nombre", "Carolina2");
		inParams.put("Direccion", "Casa de caro2");
		inParams.put("Correo", "caro2@correo");
		inParams.put("Telefono", "5546567823");
		inParams.put("Saldo", 0.35);
		inParams.put("Ejecutivo", "Pablo_ejecutivo");

		Map<String, Object> res =clientSp.execute(inParams);
		assertEquals(0.35, ((BigDecimal) res.get("p_saldo")).doubleValue(), 1e-15);

		Long idCliente = Long.parseLong(res.get("p_cliente").toString());
		Long idCuenta = Long.parseLong(res.get("p_cuenta").toString());
		
		cuentaRepository.delete(idCuenta);
		clientRepository.delete(idCliente);
	}

	@Test
	public void nameTest() {
		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put("Nombre", "Nombre de Prueba 123");
		inParams.put("Direccion", "Test Nombre");
		inParams.put("Correo", "Test Nombre");
		inParams.put("Telefono", "11223344");
		inParams.put("Saldo", 0.35);
		inParams.put("Ejecutivo", "TestNombre");

		Map<String, Object> res =clientSp.execute(inParams);

		Long idCliente = Long.parseLong(res.get("p_cliente").toString());
		Long idCuenta = Long.parseLong(res.get("p_cuenta").toString());
		Cliente client = clientRepository.findOne(idCliente);

		assertEquals("Nombre de Prueba 123", client.getNombre());

		cuentaRepository.delete(idCuenta);
		clientRepository.delete(idCliente);

	}

	@Test
	public void addressTest() {
		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put("Nombre", "Test Direccion");
		inParams.put("Direccion", "123 Calle de Prueba");
		inParams.put("Correo", "Test Direccion");
		inParams.put("Telefono", "11223344");
		inParams.put("Saldo", 0.35);
		inParams.put("Ejecutivo", "TestDir");

		Map<String, Object> res =clientSp.execute(inParams);

		Long idCliente = Long.parseLong(res.get("p_cliente").toString());
		Long idCuenta = Long.parseLong(res.get("p_cuenta").toString());
		Cliente client = clientRepository.findOne(idCliente);

		assertEquals("123 Calle de Prueba", client.getDireccion());

		cuentaRepository.delete(idCuenta);
		clientRepository.delete(idCliente);

	}

	@Test
	public void mailTest() {
		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put("Nombre", "Test Correo");
		inParams.put("Direccion", "Test Correo");
		inParams.put("Correo", "dondeNoDaElSol@gmail.com");
		inParams.put("Telefono", "11223344");
		inParams.put("Saldo", 0.35);
		inParams.put("Ejecutivo", "TestMail");

		Map<String, Object> res =clientSp.execute(inParams);

		Long idCliente = Long.parseLong(res.get("p_cliente").toString());
		Long idCuenta = Long.parseLong(res.get("p_cuenta").toString());
		Cliente client = clientRepository.findOne(idCliente);

		assertEquals("dondeNoDaElSol@gmail.com", client.getCorreo());

		cuentaRepository.delete(idCuenta);
		clientRepository.delete(idCliente);

	}

	@Test
	public void phoneTest() {
		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put("Nombre", "Test telefono");
		inParams.put("Direccion", "Test telefono");
		inParams.put("Correo", "test telefono");
		inParams.put("Telefono", "5534385535");
		inParams.put("Saldo", 0.35);
		inParams.put("Ejecutivo", "Test telefono");

		Map<String, Object> res =clientSp.execute(inParams);

		Long idCliente = Long.parseLong(res.get("p_cliente").toString());
		Long idCuenta = Long.parseLong(res.get("p_cuenta").toString());
		Cliente client = clientRepository.findOne(idCliente);

		assertEquals("5534385535", client.getTelefono());
		cuentaRepository.delete(idCuenta);
		clientRepository.delete(idCliente);
	}

	@Test
	public void amountTest() {
		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put("Nombre", "Test saldo");
		inParams.put("Direccion", "Test saldo");
		inParams.put("Correo", "test saldo");
		inParams.put("Telefono", "11223344");
		inParams.put("Saldo", 117343.350);
		inParams.put("Ejecutivo", "test saldo");

		Map<String, Object> res =clientSp.execute(inParams);

		Long idCliente = Long.parseLong(res.get("p_cliente").toString());
		Long idCuenta = Long.parseLong(res.get("p_cuenta").toString());
		Cuenta cuenta = cuentaRepository.findOne(idCuenta);

		assertEquals(117343.35, cuenta.getSaldoCuenta(), 1e-15);

		cuentaRepository.delete(idCuenta);
		clientRepository.delete(idCliente);
	}

	@Test
	public void excecutiveTest() {
		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put("Nombre", "Test Correo");
		inParams.put("Direccion", "Test Correo");
		inParams.put("Correo", "dondeNoDaElSol@gmail.com");
		inParams.put("Telefono", "11223344");
		inParams.put("Saldo", 0.35);
		inParams.put("Ejecutivo", "Ejecutivo 992 I 33");

		Map<String, Object> res =clientSp.execute(inParams);

		Long idCliente = Long.parseLong(res.get("p_cliente").toString());
		Long idCuenta = Long.parseLong(res.get("p_cuenta").toString());
		Cuenta cuenta = cuentaRepository.findOne(idCuenta);

		assertEquals("Ejecutivo 992 I 33", cuenta.getEjecutivoBanco() );

		cuentaRepository.delete(idCuenta);
		clientRepository.delete(idCliente);

	}
}
