package com.br;

import controller.MainController;
import persistence.DaoException;
import persistence.Database;
import persistence.IDatabase;
import persistence.dao.DiscountCodeDao;
import persistence.dao.IDao;
import persistence.dao.IProductCodeDao;
import persistence.dao.ProductCodeDao;
import persistence.dto.DiscountCodeDto;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.Callable;

public class Main {
    private static MainController mainController;
    private static Scanner scanner;
    public static Map<Integer, Callable> mapActions = new HashMap<>();

    public static void main(String[] args) {
        bootstrap();
        while(true) {
            printMenu();
            Integer option = scanner.nextInt();

            performAction(mapActions.get(option));
        }
    }

    public static void bootstrap() {
        scanner = new Scanner(System.in);

        try {
            IDatabase db = new Database();
            IDao<DiscountCodeDto> discountCodeDao = new DiscountCodeDao(db);
            IProductCodeDao productCodeDto = new ProductCodeDao(db);

            mapActions.put(0, () -> exit());
            mapActions.put(1, () -> listTiposDescontos());
            mapActions.put(2, () -> insertTipoDesconto());
            mapActions.put(3, () -> listProdutosPorTipoDesconto());

            mainController = new MainController(discountCodeDao, productCodeDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object listTiposDescontos() throws DaoException {
        List<String> listTiposDescontos = mainController.listTiposDescontos();
        for (String tipoDesconto:
                listTiposDescontos) {
            System.out.println(tipoDesconto);
        }
        return null;
    }

    public static Object insertTipoDesconto() throws DaoException {
        System.out.print("Informe o código de desconto: ");
        String discountCode = scanner.next();
        System.out.print("Informe a taxa de desconto: ");
        BigDecimal rate = scanner.nextBigDecimal();

        int rowsAffected = mainController.insertTipoDesconto(discountCode, rate);
        if (rowsAffected == 1) {
            System.out.println();
            System.out.println("Registro inserido com sucesso!");
        }
        return null;
    }

    public static Object listProdutosPorTipoDesconto()throws DaoException {
        System.out.print("Informe o tipo de desconto: ");
        String tipoDesconto = scanner.next();

        List<String> listProdutos = mainController.listProdutosPorTipoDesconto(tipoDesconto);
        for (String produto:
                listProdutos) {
            System.out.println(produto);
        }

        return null;
    }

    public static Object exit() {
        System.exit(0);
        return null;
    }

    public static void performAction(Callable<?> action) {
        try {
            action.call();
        } catch (DaoException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e ){
            System.out.println("Oooops... Erro genérico.");
        }
    }

    private static void printMenu() {
        System.out.println("Opção:");
        System.out.println("");
        System.out.println("1 - Lista tipos de descontos");
        System.out.println("2 - Inserir novo tipo de desconto");
        System.out.println("3 - Lista produtos por tipo de desconto");
        System.out.println("0 - Sair");
        System.out.println();
    }
}
