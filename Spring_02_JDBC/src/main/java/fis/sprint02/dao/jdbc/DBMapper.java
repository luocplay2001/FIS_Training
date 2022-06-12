package fis.sprint02.dao.jdbc;

import fis.sprint02.model.*;
import fis.sprint02.model.enums.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DBMapper {
//    private static final JDBCDetective jdbcDetective = new JDBCDetective();
    private final static Logger logger = LoggerFactory.getLogger(JDBCCriminalCase.class);
    public static CriminalCase getCriminalCase(ResultSet rs) {
        try {
            CriminalCase criminalCase = new CriminalCase();

            criminalCase.setId(rs.getLong("criminal_case_id"));
            criminalCase.setVersion(rs.getInt("version"));
            criminalCase.setCreatedAt(DBUtils.convertDateToLocalDateTime(rs.getDate("createdAt")));
            criminalCase.setModifiedAt(DBUtils.convertDateToLocalDateTime(rs.getDate("modifiedAt")));
            criminalCase.setNumber(rs.getString("number"));
            criminalCase.setType(CaseType.valueOf(rs.getString("type")));
            criminalCase.setShortDescription(rs.getString("short_description"));
            criminalCase.setDetailedDescription(rs.getString("detailed_description"));
            criminalCase.setStatus(CaseStatus.valueOf(rs.getString("status")));
            criminalCase.setNotes(rs.getString("notes"));
//            Optional<Detective> opt = new JDBCDetective().findById(rs.getLong("detective_id"));
//            if(opt.isPresent())
//                criminalCase.setLeadInvestigator(opt.get());
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
            detective.setVersion(rs.getInt("version"));
            detective.setCreatedAt(DBUtils.convertDateToLocalDateTime(rs.getDate("createdAt")));
            detective.setModifiedAt(DBUtils.convertDateToLocalDateTime(rs.getDate("modifiedAt")));
            detective.setUsername(rs.getString("username"));
            detective.setFirstName(rs.getString("first_name"));
            detective.setLastName(rs.getString("last_name"));
            detective.setPassword(rs.getString("password"));
            detective.setHiringDate(DBUtils.convertDateToLocalDateTime(rs.getDate("hiringDate")));
            detective.setBadgeNumber(rs.getString("badgeNumber"));
            detective.setRank(Rank.valueOf(rs.getString("rank")));
            detective.setArmed(rs.getBoolean("armed"));
            detective.setStatus(EmploymentStatus.valueOf(rs.getString("status")));
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
            evidence.setVersion(rs.getInt("version"));
            evidence.setCreatedAt(DBUtils.convertDateToLocalDateTime(rs.getDate("createdAt")));
            evidence.setModifiedAt(DBUtils.convertDateToLocalDateTime(rs.getDate("modifiedAt")));
            evidence.setNumber(rs.getString("number"));
            evidence.setItemName(rs.getString("item_name"));
            evidence.setNotes(rs.getString("notes"));
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
            storage.setVersion(rs.getInt("version"));
            storage.setCreatedAt(DBUtils.convertDateToLocalDateTime(rs.getDate("createdAt")));
            storage.setModifiedAt(DBUtils.convertDateToLocalDateTime(rs.getDate("modifiedAt")));
            storage.setName(rs.getString("name"));
            storage.setLocation(rs.getString("location"));
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
            trackEntry.setVersion(rs.getInt("version"));
            trackEntry.setCreatedAt(DBUtils.convertDateToLocalDateTime(rs.getDate("createdAt")));
            trackEntry.setModifiedAt(DBUtils.convertDateToLocalDateTime(rs.getDate("modifiedAt")));
            trackEntry.setDate(DBUtils.convertDateToLocalDateTime(rs.getDate("date")));
            trackEntry.setAction(TrackAction.valueOf(rs.getString("action")));
            trackEntry.setResson(rs.getString("resson"));
            return trackEntry;
        }catch (SQLException ex){
            logger.error(ex.toString());
        }
        return null;
    }
}
