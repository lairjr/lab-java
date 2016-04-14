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
import persistence.dto.ProductCodeDto;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    private static MainController mainController;
    private static Scanner scanner;

    public static void main(String[] args) {
        bootstrap();
        while(true) {
            printMenu();
            Integer option = scanner.nextInt();

            switch (option) {
                case 1:
                    listTiposDescontos();
                    break;
                case 2:
                    insertTipoDesconto();
                    break;
                case 3:
                    listProdutosPorTipoDesconto();
                    break;
                case 0:
                    exit();
                default:
                        break;
            }
        }
    }

    public static void bootstrap() {
        scanner = new Scanner(System.in);

        try {
            IDatabase db = new Database();
            IDao<DiscountCodeDto> discountCodeDao = new DiscountCodeDao(db);
            IProductCodeDao productCodeDto = new ProductCodeDao(db);

            mainController = new MainController(discountCodeDao, productCodeDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void listTiposDescontos() {
        try {
            List<String> listTiposDescontos = mainController.listTiposDescontos();
            for (String tipoDesconto:
                 listTiposDescontos) {
                System.out.println(tipoDesconto);
            }
        } catch (DaoException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar dados do DB");
        }
    }

    public static void insertTipoDesconto() {
        try {
            System.out.print("Informe o código de desconto: ");
            String discountCode = scanner.next();
            System.out.print("Informe a taxa de desconto: ");
            BigDecimal rate = scanner.nextBigDecimal();

            int rowsAffected = mainController.insertTipoDesconto(discountCode, rate);
            if (rowsAffected == 1) {
                System.out.println();
                System.out.println("Registro inserido com sucesso!");
            }
        } catch (DaoException e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir dados no DB");
        }
    }

    public static void listProdutosPorTipoDesconto() {
        try {
            System.out.print("Informe o tipo de desconto: ");
            String tipoDesconto = scanner.next();

            List<String> listProdutos = mainController.listProdutosPorTipoDesconto(tipoDesconto);
            for (String produto:
                    listProdutos) {
                System.out.println(produto);
            }
        } catch (DaoException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar dados do DB");
        }
    }

    public static void exit() {
        System.exit(0);
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
