package ink.onei.rowMapper;

import ink.onei.entity.Address;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressRowMapper implements RowMapper<Address> {
    @Override
    public Address mapRow(ResultSet resultSet, int i) throws SQLException {
        Address result= new Address();
        result.setId(resultSet.getInt("id"));
        result.setAddr(resultSet.getString("addr"));
        result.setPhone(resultSet.getString("phone"));
        result.setPostcode(resultSet.getString("postcode"));
        result.setUserId(resultSet.getInt("user_id"));
        return result;
    }
}
