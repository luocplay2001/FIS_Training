package fis.sprint02.dao.jdbc;

import fis.sprint02.model.*;
import fis.sprint02.model.enums.CaseStatus;
import fis.sprint02.model.enums.CaseType;
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
            criminalCase.setModifiedAt(DBUtils.convertDateToLocalDateTime(rs.getDate("modifiedAt")));
            criminalCase.setNumber(rs.getString("number"));
            criminalCase.setType(CaseType.valueOf(rs.getString("type")));
            criminalCase.setShortDescription(rs.getString("short_description"));
            criminalCase.setDetailedDescription(rs.getString("detailed_description"));
            criminalCase.setStatus(CaseStatus.valueOf(rs.getString("status")));
            criminalCase.setNotes(rs.getString("note"));
//            criminalCase.setLeadInvestigator();

            //TODO add some add.

            return criminalCase;
        }catch (SQLException ex){
            logger.error(ex.toString());
        }
        return null;
    }

    public static Detective getDetective(ResultSet rs) {
        try {
            Detective detective = new Detective();
            detective.setId(rs.getLong("detective_id"));

            return detective;
        }catch (SQLException ex){
            logger.error(ex.toString());
        }
        return null;
    }

    public static Evidence getEvidence(ResultSet rs) {
        try {
            Evidence evidence = new Evidence();
            evidence.setId(rs.getLong("evidence_id"));

            return evidence;
        }catch (SQLException ex){
            logger.error(ex.toString());
        }
        return null;
    }

    public static Storage getStorage(ResultSet rs) {
        try {
            Storage storage = new Storage();
            storage.setId(rs.getLong("storage_id"));

            return storage;
        }catch (SQLException ex){
            logger.error(ex.toString());
        }
        return null;
    }

    public static TrackEntry getTrackEntry(ResultSet rs) {
        try {
            TrackEntry trackEntry = new TrackEntry();
            trackEntry.setId(rs.getLong("track_entry_id"));

            return trackEntry;
        }catch (SQLException ex){
            logger.error(ex.toString());
        }
        return null;
    }
}
