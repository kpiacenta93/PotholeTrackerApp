package com.techelevator.controller;

import com.techelevator.dao.PotholeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Pothole;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class PotholeController {

    private Pothole pothole;
    private PotholeDao potholeDao;
    private UserDao userDao;
    public PotholeController(PotholeDao potholeDao, UserDao userDao){
        this.potholeDao = potholeDao;
        this.userDao = userDao;

    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/addPothole", method = RequestMethod.POST)
    public Pothole createPothole(@Valid @RequestBody Pothole pothole, Principal principal){
        User user = userDao.getUserByUsername(principal.getName());
        return potholeDao.createNewPothole(
                user.getId(),
                pothole.getLatitude(),
                pothole.getLongitude(),
                pothole.getSeverity(),
                pothole.getStatus()
        );
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/potholes", method = RequestMethod.GET)
    public List<Pothole> getAllPotholes(){
        return potholeDao.getAllPotholes();
    }



    //todo -> create a controller for public Pothole deletePotholeByUserID(it will take a path variable which will be userID)
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/potholes/user/{userId}")
    public void deletePotholeByUserID(@PathVariable int userId) {
        potholeDao.deletePotholeByUserID(userId);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/potholes/{potholeid}")
    public void deletePotholeByID(@PathVariable int potholeid) {
        potholeDao.deletePotholeByID(potholeid);
    }
}