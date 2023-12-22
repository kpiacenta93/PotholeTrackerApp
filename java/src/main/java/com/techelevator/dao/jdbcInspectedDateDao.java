package com.techelevator.dao;

import com.techelevator.model.Pothole;
import com.techelevator.model.inspectedDateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class jdbcInspectedDateDao implements inspectedDate {
    private Pothole pothole;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public jdbcInspectedDateDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public inspectedDateDto addNewInspectedDate(int inspectedDatePK, Date dateInspected, int inspectedFK) {
        String insertIntoInspections = "INSERT INTO public.inspections(\n" +
                "\tdateinspected, inspectedFk )\n" +
                "\tVALUES (?, ?) RETURNING inspecteddate;";
        inspectedDatePK = jdbcTemplate.queryForObject(insertIntoInspections, int.class,dateInspected, inspectedFK);
        inspectedDateDto newInspection = new inspectedDateDto();
        newInspection.setInspectedDatePK(inspectedDatePK);
        newInspection.setDateInspected(dateInspected);
        newInspection.setInspectedFk(inspectedFK);

//        jdbcTemplate.update(insertIntoInspections, newInspection.getInspectedFk()); // Use inspectedFK as an argument

        return newInspection;
    }


    private inspectedDateDto mapRowToInspectedDateDto(SqlRowSet rowSet) {
        inspectedDateDto inspectedDateDto = new inspectedDateDto();

        inspectedDateDto.setDateInspected(rowSet.getDate("dateinspected"));
        inspectedDateDto.setInspectedFk(rowSet.getInt("inspectedFk"));

        return inspectedDateDto;
    }
}

