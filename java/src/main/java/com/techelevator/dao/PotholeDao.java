package com.techelevator.dao;

import com.techelevator.model.Pothole;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface PotholeDao {

        Pothole createNewPothole(int userId, double latitude, double longitude, int severity, String status);

        List<Pothole> getAllPotholes();

        //todo create Pothole getPotholeByUserId(int userId)
        void deletePotholeByUserID(int userId);

        public Pothole getPotholeById(int id);

        public void deletePotholeByID(int potholeId);

}
