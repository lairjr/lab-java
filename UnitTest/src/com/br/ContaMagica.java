package com.br;

import java.math.BigDecimal;

/**
 * Created by ljunior on 3/28/16.
 */
public class ContaMagica implements IContaMagica {
    private String nomeCliente;
    private BigDecimal saldo;
    private Categorias status;

    public ContaMagica(String nome) {
        nomeCliente = nome;
        saldo = new BigDecimal(0);
        status = Categorias.Silver;
    }

    @Override
    public String getNomeCliente() {
        return nomeCliente;
    }

    @Override
    public BigDecimal getSaldo() {
        return saldo;
    }

    @Override
    public Categorias getStatus() {
        return status;
    }

    @Override
    public void deposito(BigDecimal valor) {
        if (this.getStatus().equals(Categorias.Gold)) {
            float fator = (float) (valor.floatValue() * 1.01);
            valor = new BigDecimal(fator);
        }
        else if (this.getStatus().equals(Categorias.Platinum)) {
            float fator = (float) (valor.floatValue() * 1.025);
            valor = new BigDecimal(fator);
        }
        saldo = saldo.add(valor);

        atualizaDeposito();
    }

    @Override
    public void retirada(BigDecimal valor) {
        saldo = saldo.subtract(valor);
        atualizaRetirada();
    }

    private void atualizaDeposito() {
        float saldoFloat = saldo.floatValue();

        status = Categorias.Silver;

        if (saldoFloat >= 200000)
            status =  Categorias.Platinum;
        else if (saldo.floatValue() >= 50000)
            status = Categorias.Gold;
    }

    private void atualizaRetirada() {
        float saldoFloat = saldo.floatValue();

        if (saldoFloat < 25000)
            status = Categorias.Silver;
        else if (saldoFloat < 100000)
            status = Categorias.Gold;
    }
}
