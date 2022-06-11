package fis.sprint02.dao.jdbc;

import fis.sprint02.dao.IDAOEvidence;
import fis.sprint02.model.Evidence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCEvidence implements IDAOEvidence {
    private final static Logger logger = LoggerFactory.getLogger(JDBCEvidence.class);
    @Override
    public Evidence save(Evidence evidence) {
        return null;
    }

    @Override
    public Optional<Evidence> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Evidence> findAll() {
        List<Evidence> evidenceList = new ArrayList<>();
        try(Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM evidence");
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Evidence evidence = DBMapper.getEvidence(rs);
                if(evidence != null)
                    evidenceList.add(evidence);
            } // end of while

        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return null;
    }

    @Override
    public void update(Evidence evidence) {

    }

    @Override
    public Evidence delete(Evidence evidence) {
        return null;
    }
}
