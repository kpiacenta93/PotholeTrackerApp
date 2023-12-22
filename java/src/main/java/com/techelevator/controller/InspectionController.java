package com.techelevator.controller;

import com.techelevator.dao.inspectedDate;
import com.techelevator.model.inspectedDateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class InspectionController {

    private inspectedDateDto inspectionDateDto;

    private inspectedDate inspectedDateDao;

    @Autowired
    public InspectionController(inspectedDate inspectedDateDao, inspectedDateDto inspectionDateDto){
        this.inspectionDateDto = inspectionDateDto;
        this.inspectedDateDao = inspectedDateDao;
    }


    @RequestMapping(path = "/addInspectedDate", method = RequestMethod.POST)
    public inspectedDateDto addInspectedDate(@RequestBody inspectedDateDto inspection) {

        return inspectedDateDao.addNewInspectedDate(inspection.getInspectedDatePK(),inspection.getDateInspected(), inspection.getInspectedFk());
    }



}
