package com.sixdelta.exposp.model;

import java.util.Map;

public class ProcedureOutPojo {
    String numeroCuenta;
    String numeroCliente;
    Double saldo;
    
    public ProcedureOutPojo() {
    }

    public ProcedureOutPojo(Map<String, Object> pout) {
        this.numeroCliente = pout.get("p_cliente").toString();
        this.numeroCuenta = pout.get("p_cuenta").toString();
        this.saldo = Double.parseDouble(pout.get("p_saldo").toString());
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
