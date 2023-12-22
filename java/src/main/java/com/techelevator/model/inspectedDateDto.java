package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class inspectedDateDto {
   private  Date dateInspected;
    private int inspectedDatePK;


    private int inspectedFk;

    public inspectedDateDto() {
    }


    public inspectedDateDto(int inspectedDatePK, Date dateInspected, int inspectedFk) {
        this.dateInspected = dateInspected;
        this.inspectedDatePK = inspectedDatePK;
        this.inspectedFk = inspectedFk;
    }

    public Date getDateInspected() {
        return dateInspected;
    }

    public void setDateInspected(Date inspectedDate) {
        this.dateInspected = inspectedDate;
    }

    public int getInspectedDatePK() {
        return inspectedDatePK;
    }

    public void setInspectedDatePK(int inspectedDatePK) {
        this.inspectedDatePK = inspectedDatePK;
    }

    public int getInspectedFk() {
        return inspectedFk;
    }

    public void setInspectedFk(int inspectedFk) {
        this.inspectedFk = inspectedFk;
    }
}


