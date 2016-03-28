package com.br;

import java.math.BigDecimal;

/**
 * Created by ljunior on 3/28/16.
 */
public interface IContaMagica {
    String getNomeCliente();

    BigDecimal getSaldo();

    Categorias getStatus();

    void deposito(BigDecimal valor);

    void retirada(BigDecimal valor);
}
