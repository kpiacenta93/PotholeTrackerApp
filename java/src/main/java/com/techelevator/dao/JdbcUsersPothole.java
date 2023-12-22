package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Pothole;
import com.techelevator.model.UsersPotholeDto;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcUsersPothole implements UsersPotholeDao{

    private final JdbcTemplate jdbcTemplate;
    private PotholeDao potholeDao;

    public JdbcUsersPothole(JdbcTemplate jdbcTemplate, PotholeDao potholeDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.potholeDao = potholeDao;
    }


    @Override
    public UsersPotholeDto getUserByPotholeId(int potholeId) {
        UsersPotholeDto user = null;
        String sql = "SELECT potholeid, username, userid, latitude, longitude, severity, status, reportedat FROM potholes " +
                "JOIN users ON users.user_id = potholes.userid " +
                "WHERE potholes.potholeid = ?;";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, potholeId);
            if (rowSet.next()) {
                user = mapRowToUsersPothole(rowSet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return user;
    }

    @Override
    public List<UsersPotholeDto> getAllUsersPotholeList() {
        List<UsersPotholeDto> potholes = new ArrayList<>();

        String sql = "SELECT potholes.potholeid, users.username, potholes.userid, potholes.latitude, potholes.longitude, potholes.severity, potholes.status, potholes.reportedat \n" +
                "FROM potholes \n" +
                "JOIN users ON users.user_id = potholes.userid;\n";
        String testSql = "SELECT potholeid, userid, username, latitude, longitude, severity, status, reportedat, inspected FROM \n" +
                " (SELECT MAX(dateinspected) as inspected, inspectedFk FROM inspections GROUP BY inspectedFk) as inspectedInfo\n" +
                "\t\t\t\tRIGHT JOIN potholes ON inspectedInfo.inspectedfk = potholes.potholeid " +
        "JOIN users ON users.user_id = potholes.userid;\n";

//            "JOIN users ON users.user_id = potholes.userid ";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(testSql);
            while(results.next()){
                UsersPotholeDto pothole = mapRowToUsersPotholeInspectedDate(results);
                potholes.add(pothole);
            }
        }catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }
        return potholes;
    }

    @Override
    public Pothole updateUsersReport(UsersPotholeDto report) {
        String sql = "UPDATE potholes SET severity = ?, status = ? WHERE potholeid = ?;";

        jdbcTemplate.update(sql, report.getSeverity(), report.getStatus(), report.getPotholeid());
        return potholeDao.getPotholeById(report.getPotholeid());
    }


    private UsersPotholeDto mapRowToUsersPothole(SqlRowSet rowset) {
        UsersPotholeDto usersPothole = new UsersPotholeDto();

        usersPothole.setPotholeid(rowset.getInt("potholeid"));
        usersPothole.setUsername(rowset.getString("username"));
        usersPothole.setLatitude(rowset.getDouble("latitude"));
        usersPothole.setLongitude(rowset.getDouble("longitude"));
        usersPothole.setSeverity(rowset.getInt("severity"));
        usersPothole.setStatus(rowset.getString("status"));
        usersPothole.setReportedAt(rowset.getDate("reportedat"));
        return usersPothole;
    }

    private UsersPotholeDto mapRowToUsersPotholeInspectedDate(SqlRowSet rowset) {
        UsersPotholeDto usersPothole = new UsersPotholeDto();

        usersPothole.setPotholeid(rowset.getInt("potholeid"));
        usersPothole.setUsername(rowset.getString("username"));
        usersPothole.setLatitude(rowset.getDouble("latitude"));
        usersPothole.setLongitude(rowset.getDouble("longitude"));
        usersPothole.setSeverity(rowset.getInt("severity"));
        usersPothole.setStatus(rowset.getString("status"));
        usersPothole.setReportedAt(rowset.getDate("reportedat"));
        usersPothole.setInspectedDate(rowset.getDate("inspected"));
        return usersPothole;
    }


}
