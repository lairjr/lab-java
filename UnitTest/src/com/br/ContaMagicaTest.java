package com.br;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.math.BigDecimal;

/**
 * Created by ljunior on 3/28/16.
 */
public class ContaMagicaTest {

    private ContaMagica _sut;
    private String _getNomeResult;
    private BigDecimal _getSaldoResult;
    private Categorias _getStatusResult;

    @BeforeTest
    public void SetUp() {
        _sut = new ContaMagica("");
    }

    @Test
    public void testGetNomeClienteDeveRetornarNomeCorreto() {
        String nome = "Test Nome";

        ConsiderandoClienteComSaldo(nome, new BigDecimal(0));

        QuandoGetNome();

        EntaoNomeDeverSer(nome);
    }

    @Test
    public void testGetSaldo() throws Exception {
    }

    @Test
    public void testGetStatusDeveRetornarSilver() throws Exception {
        BigDecimal valor = new BigDecimal(10000);

        ConsiderandoClienteComSaldo("Test Status", valor);

        QuandoGetStatus();

        EntaoStatusDeverSer(Categorias.Silver);
    }

    @Test
    public void testGetStatusDeveRetornarGold() throws Exception {
        BigDecimal valor = new BigDecimal(50000);

        ConsiderandoClienteComSaldo("Test Status", valor);

        QuandoGetStatus();

        EntaoStatusDeverSer(Categorias.Gold);
    }

    @Test
    public void testGetStatusDeveRetornarPlatinum() throws Exception {
        BigDecimal valor = new BigDecimal(200000);

        ConsiderandoClienteComSaldo("Test Status", valor);

        QuandoGetStatus();

        EntaoStatusDeverSer(Categorias.Platinum);
    }

    @Test
    public void testDepositoDeveDebitarValorSilverCorreto() throws Exception {
        BigDecimal valor = new BigDecimal(10000);
        BigDecimal saldoCliente = new BigDecimal(0);

        ConsiderandoClienteComSaldo("Test Saldo", saldoCliente);

        QuandoDeposito(valor);
        QuandoGetSaldo();

        EntaoSaldoDeveSer(valor);
    }

    @Test
    public void testDepositoDeveDebitarValorGoldCorreto() throws Exception {
        BigDecimal valor = new BigDecimal(1000);
        BigDecimal saldoCliente = new BigDecimal(50000);
        BigDecimal saldoFinal = new BigDecimal(51010);

        ConsiderandoClienteComSaldo("Test Saldo", saldoCliente);

        QuandoDeposito(valor);
        QuandoGetSaldo();

        EntaoSaldoDeveSer(saldoFinal);
    }

    @Test
    public void testDepositoDeveDebitarValorPlatinumCorreto() throws Exception {
        BigDecimal valor = new BigDecimal(1000);
        BigDecimal saldoCliente = new BigDecimal(200000);
        BigDecimal saldoFinal = new BigDecimal(201025);

        ConsiderandoClienteComSaldo("Test Saldo", saldoCliente);

        QuandoDeposito(valor);
        QuandoGetSaldo();

        EntaoSaldoDeveSer(saldoFinal);
    }

    @Test
    public void testRetiradaDeveRetirarParaValorGold() throws Exception {
        BigDecimal valor = new BigDecimal(100001);
        BigDecimal saldoCliente = new BigDecimal(200000);

        ConsiderandoClienteComSaldo("Test Saldo", saldoCliente);

        QuandoRetira(valor);
        QuandoGetStatus();

        EntaoStatusDeverSer(Categorias.Gold);
    }

    @Test
    public void testRetiradaDeveRetirarParaValorSilver() throws Exception {
        BigDecimal valor = new BigDecimal(75001);
        BigDecimal saldoCliente = new BigDecimal(100000);

        ConsiderandoClienteComSaldo("Test Saldo", saldoCliente);

        QuandoRetira(valor);
        QuandoGetStatus();

        EntaoStatusDeverSer(Categorias.Silver);
    }

    private void ConsiderandoClienteComSaldo(String nome, BigDecimal saldo) {
        _sut = new ContaMagica(nome);
        _sut.deposito(saldo);
    }

    private void QuandoDeposito(BigDecimal valor) {
        _sut.deposito(valor);
    }

    private void QuandoGetNome() {
        _getNomeResult = _sut.getNomeCliente();
    }

    private void QuandoGetSaldo() {
        _getSaldoResult = _sut.getSaldo();
    }

    private void QuandoGetStatus() {
        _getStatusResult = _sut.getStatus();
    }

    private void QuandoRetira(BigDecimal valor) {
        _sut.retirada(valor);
    }

    private void EntaoNomeDeverSer(String nome) {
        Assert.assertEquals(_getNomeResult, nome);
    }

    private void EntaoSaldoDeveSer(BigDecimal valor) {
        Assert.assertEquals(_getSaldoResult, valor);
    }

    private void EntaoStatusDeverSer(Categorias status) {
        Assert.assertEquals(_getStatusResult, status);
    }
}