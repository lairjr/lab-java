package com.br;

import java.math.BigDecimal;

/**
 * Created by ljunior on 3/28/16.
 */
public class ContaMagica implements IContaMagica {
    private String nomeCliente;

    public ContaMagica(String nome) {
        nomeCliente = nome;
    }

    @Override
    public String getNomeCliente() {
        return nomeCliente;
    }

    @Override
    public BigDecimal getSaldo() {
        return null;
    }

    @Override
    public Categorias getStatus() {
        return null;
    }

    @Override
    public void deposito(BigDecimal valor) {

    }

    @Override
    public void retirada(BigDecimal valor) {

    }
}
