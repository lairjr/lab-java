package persistence.dao;

import persistence.IDatabase;
import persistence.DaoException;
import persistence.dto.ProductCodeDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ljunior on 4/14/16.
 */
public class ProductCodeDao implements IDao<ProductCodeDto> {
    private IDatabase db;

    public ProductCodeDao(IDatabase db) {
        this.db = db;
    }

    @Override
    public List<ProductCodeDto> getAll() throws DaoException {
        List<ProductCodeDto> productCodeDtos = new ArrayList();

        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("SELECT * FROM ");
        queryBuilder.append("PRODUCT_CODE");

        try {
            Statement cmd = db.createStatement();
            ResultSet rs = cmd.executeQuery(queryBuilder.toString());

            while(rs.next()) {
                productCodeDtos.add(create(rs));
            }

            return productCodeDtos;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productCodeDtos;
    }

    @Override
    public ProductCodeDto getById(String id) throws DaoException {
        ProductCodeDto productCodeDto = new ProductCodeDto();

        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("SELECT * FROM ");
        queryBuilder.append("PRODUCT_CODE ");
        queryBuilder.append("WHERE ");
        queryBuilder.append("PROD_CODE = ? ");

        try {
            PreparedStatement cmd = db.prepareStatement(queryBuilder.toString());

            cmd.setString(1, id);

            ResultSet rs = cmd.executeQuery();

            if(rs.next()) {
                productCodeDto = create(rs);
            }

            return productCodeDto;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productCodeDto;
    }

    @Override
    public int insert(ProductCodeDto obj) throws DaoException {
        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("INSERT INTO ");
        queryBuilder.append("PRODUCT_CODE ");
        queryBuilder.append("( ");
        queryBuilder.append("PROD_CODE, ");
        queryBuilder.append("DISCOUNT_CODE, ");
        queryBuilder.append("DESCRIPTION ");
        queryBuilder.append(") ");
        queryBuilder.append("VALUES (");
        queryBuilder.append("PROD_CODE = ? ");
        queryBuilder.append("DISCOUNT_CODE = ? ");
        queryBuilder.append("DESCRIPTION = ? ");
        queryBuilder.append(") ");

        try {
            PreparedStatement cmd = db.prepareStatement(queryBuilder.toString());

            cmd.setString(1, obj.getProductCode());
            cmd.setString(2, obj.getDiscountCode());
            cmd.setString(3, obj.getDescription());

            return cmd.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    private ProductCodeDto create(ResultSet rs) throws SQLException {
        ProductCodeDto ProductCodeDto = new ProductCodeDto();

        ProductCodeDto.setDescription(rs.getString("DESCRIPTION"));
        ProductCodeDto.setDiscountCode(rs.getString("DISCOUNT_CODE"));
        ProductCodeDto.setProductCode(rs.getString("PROD_CODE"));

        return ProductCodeDto;
    }
}