import axios from "axios";

export default {

    getUserNameByPotholeId(potholeid) {
        return axios.get(`/users/${potholeid}`);
    }

}