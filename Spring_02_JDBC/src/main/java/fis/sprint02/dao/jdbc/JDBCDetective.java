package fis.sprint02.dao.jdbc;

import fis.sprint02.dao.IDAODetective;
import fis.sprint02.dao.IDAODetective;
import fis.sprint02.model.Detective;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCDetective implements IDAODetective {
    private final static Logger logger = LoggerFactory.getLogger(JDBCDetective.class);
    @Override
    public Detective save(Detective detective) {
        return null;
    }

    @Override
    public Optional<Detective> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Detective> getAll() {
        List<Detective> detectiveList = new ArrayList<>();
        try(Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM detective");
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Detective Detective = DBMapper.getDetective(rs);
                if(Detective != null)
                    detectiveList.add(Detective);
            } // end of while

        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return null;
    }

    @Override
    public void update(Detective detective) {

    }

    @Override
    public Detective delete(Detective detective) {
        return null;
    }
}
