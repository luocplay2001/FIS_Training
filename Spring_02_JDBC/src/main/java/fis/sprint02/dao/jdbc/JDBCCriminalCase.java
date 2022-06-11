package fis.sprint02.dao.jdbc;

import fis.sprint02.dao.IDAOCriminalCase;
import fis.sprint02.model.CriminalCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCCriminalCase implements IDAOCriminalCase {
    private final static Logger logger = LoggerFactory.getLogger(JDBCCriminalCase.class);
    @Override
    public CriminalCase save(CriminalCase criminalCase) {
        return null;
    }

    @Override
    public Optional<CriminalCase> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<CriminalCase> getAll() {
        List<CriminalCase> criminalCaseList = new ArrayList<>();
        try(Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM criminal_case");
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                CriminalCase criminalCase = DBMapper.getCriminalCase(rs);
                if(criminalCase != null)
                    criminalCaseList.add(criminalCase);
            } // end of while

        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return null;
    }

    @Override
    public void update(CriminalCase criminalCase) {

    }

    @Override
    public CriminalCase delete(CriminalCase criminalCase) {
        return null;
    }
}
