package persistence.dao;

import persistence.DaoException;
import persistence.IDatabase;
import persistence.dto.DiscountCodeDto;
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
public class DiscountCodeDao implements IDao<DiscountCodeDto> {
    private IDatabase db;

    public DiscountCodeDao(IDatabase db) {
        this.db = db;
    }

    @Override
    public List<DiscountCodeDto> getAll() throws DaoException {
        List<DiscountCodeDto> discountCodeDtos = new ArrayList();

        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("SELECT * FROM ");
        queryBuilder.append("DISCOUNT_CODE");

        try {
            Statement cmd = db.createStatement();
            ResultSet rs = cmd.executeQuery(queryBuilder.toString());

            while(rs.next()) {
                discountCodeDtos.add(create(rs));
            }

            return discountCodeDtos;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException(e, "Erro ao ler discontos do database.");
        }
    }

    @Override
    public DiscountCodeDto getById(String id) throws DaoException {
        DiscountCodeDto discountCodeDto = new DiscountCodeDto();

        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("SELECT * FROM ");
        queryBuilder.append("DISCOUNT_CODE ");
        queryBuilder.append("WHERE ");
        queryBuilder.append("DISCOUNT_CODE = ? ");

        try {
            PreparedStatement cmd = db.prepareStatement(queryBuilder.toString());

            cmd.setString(1, id);

            ResultSet rs = cmd.executeQuery();

            if(rs.next()) {
                discountCodeDto = create(rs);
            }

            return discountCodeDto;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException(e, "Erro ao ler o disconto do database.");
        }
    }

    @Override
    public int insert(DiscountCodeDto obj) throws DaoException {
        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("INSERT INTO ");
        queryBuilder.append("DISCOUNT_CODE ");
        queryBuilder.append("( ");
        queryBuilder.append("DISCOUNT_CODE, ");
        queryBuilder.append("RATE ");
        queryBuilder.append(") ");
        queryBuilder.append("VALUES (");
        queryBuilder.append("?, ");
        queryBuilder.append("? ");
        queryBuilder.append(") ");

        try {
            PreparedStatement cmd = db.prepareStatement(queryBuilder.toString());

            cmd.setString(1, obj.getDiscountCode());
            cmd.setBigDecimal(2, obj.getRate());

            return cmd.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException(e, "Erro ao inserir disconto no database.");
        }
    }

    private DiscountCodeDto create(ResultSet rs) throws SQLException {
        DiscountCodeDto discountCodeDto = new DiscountCodeDto();

        discountCodeDto.setDiscountCode(rs.getString("DISCOUNT_CODE"));
        discountCodeDto.setRate(rs.getBigDecimal("RATE"));

        return discountCodeDto;
    }
}
