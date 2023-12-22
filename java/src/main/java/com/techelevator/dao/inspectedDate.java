package com.techelevator.dao;

import com.techelevator.model.inspectedDateDto;

import java.util.Date;

public interface inspectedDate {

     inspectedDateDto addNewInspectedDate(int inspectedDatePK, Date dateInspected, int inspectedFK);
}
