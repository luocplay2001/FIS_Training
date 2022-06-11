package fis.sprint02.dao.jdbc;

import fis.sprint02.model.CriminalCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBMapper {
    private final static Logger logger = LoggerFactory.getLogger(JDBCCriminalCase.class);
    public static CriminalCase getCriminalCase(ResultSet rs) {
        try {
            CriminalCase criminalCase = new CriminalCase();

            criminalCase.setId(rs.getLong("id"));
            criminalCase.setVersion(rs.getInt("version"));
            criminalCase.setCreatedAt(DBUtils.convertDateToLocalDateTime(rs.getDate("createdAt")));
            criminalCase.setNumber(rs.getString("number"));
            //TODO add some add.

            return criminalCase;
        }catch (SQLException ex){
            logger.error(ex.toString());
        }
        return null;
    }
}
