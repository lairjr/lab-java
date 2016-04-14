package persistence.dao;

import persistence.dto.ProductCodeDto;

import java.util.List;

/**
 * Created by ljunior on 4/14/16.
 */
public interface IProductCodeDao extends IDao<ProductCodeDto> {
    List<ProductCodeDto> getByDiscountCode(String discountCode);
}
