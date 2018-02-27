package com.api.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Double Saldo;
    private String Ejecutivo;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Double getSaldoCuenta() {
        return Saldo;
    }
    public void setSaldoCuenta(Double saldoCuenta) {
        this.Saldo = saldoCuenta;
    }
    public String getEjecutivoBanco() {
        return Ejecutivo;
    }
    public void setEjecutivoBanco(String ejecutivoBanco) {
        this.Ejecutivo = ejecutivoBanco;
    }

}
