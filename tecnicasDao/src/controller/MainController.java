package controller;

import persistence.DaoException;
import persistence.dao.IDao;
import persistence.dao.IProductCodeDao;
import persistence.dto.DiscountCodeDto;
import persistence.dto.ProductCodeDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ljunior on 4/14/16.
 */
public class MainController {
    private IDao<DiscountCodeDto> discountCodeDao;
    private IProductCodeDao productCodeDao;

    public MainController(IDao<DiscountCodeDto> discountCodeDao,
                          IProductCodeDao productCodeDao
                          ) {
        this.discountCodeDao = discountCodeDao;
        this.productCodeDao = productCodeDao;
    }


    public List<String> listTiposDescontos() throws DaoException {
        ArrayList<String> retornoTiposDescontos = new ArrayList<String>();
        List<DiscountCodeDto> listDiscountCode = discountCodeDao.getAll();

        for (DiscountCodeDto discount:
             listDiscountCode) {
            retornoTiposDescontos.add(discount.toString());
        }

        return retornoTiposDescontos;
    }

    public int insertTipoDesconto(String discountCode, BigDecimal rate) throws DaoException {
        DiscountCodeDto discountCodeDto = new DiscountCodeDto();

        discountCodeDto.setDiscountCode(discountCode);
        discountCodeDto.setRate(rate);

        return discountCodeDao.insert(discountCodeDto);
    }

    public List<String> listProdutosPorTipoDesconto(String discountCode) throws DaoException {
        ArrayList<String> retornoProducts = new ArrayList<String>();
        List<ProductCodeDto> listProducts = productCodeDao.getByDiscountCode(discountCode);

        for (ProductCodeDto product:
                listProducts) {
            retornoProducts.add(product.toString());
        }

        return retornoProducts;
    }
}
