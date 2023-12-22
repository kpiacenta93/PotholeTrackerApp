package com.techelevator.controller;

import com.techelevator.dao.PotholeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.dao.UsersPotholeDao;
import com.techelevator.model.Pothole;
import com.techelevator.model.User;
import com.techelevator.model.UsersPotholeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    private UsersPotholeDao usersPotholeDao;

    public UserController(UsersPotholeDao usersPotholeDao) {
        this.usersPotholeDao = usersPotholeDao;

    }


    @RequestMapping(path = "/users/{potholeId}", method = RequestMethod.GET)
    public ResponseEntity getUserByPotholeId(@PathVariable int potholeId) {
        UsersPotholeDto user = usersPotholeDao.getUserByPotholeId(potholeId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/UsersPotholes", method = RequestMethod.GET)
    public List<UsersPotholeDto> getAllPotholes(){
        return usersPotholeDao.getAllUsersPotholeList();
    }

   @ResponseStatus(HttpStatus.CREATED)
   @RequestMapping(path = "/reportUpdate/{id}",method = RequestMethod.PUT)
    public Pothole updateUsersReport(@RequestBody UsersPotholeDto report, @PathVariable int id) {

        return usersPotholeDao.updateUsersReport(report);
    }
}
