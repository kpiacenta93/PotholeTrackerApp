import axios from "axios";

export default {

    getPotholeList(pothole) {
        return axios.get('/UsersPotholes', pothole)
    },

    addNewPothole(pothole) {
        return axios.post('/addPothole', pothole)
    },

    updateUsersReport(pothole){
        return axios.put(`/reportUpdate/${pothole.potholeid}`,pothole)
    },

    deletePothole(id){
        return axios.delete(`/potholes/${id}`)
    },

    addInspectedDate(date){
      return axios.post('/addInspectedDate', date)
    }

}