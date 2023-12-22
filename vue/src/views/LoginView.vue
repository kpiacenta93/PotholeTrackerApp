<template>
  
  <div id="login">
    <form v-on:submit.prevent="login">
      <h1 class="app-name">Pothole Patrol</h1>
      <div class="input-container">
        <!-- <h1 class="app-name">POTHOLE TRACKER</h1> -->
      <h1 >Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      
      <div class="form-input-group">
        <label for="username">Username:</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
    
      <button type="submit" id="submit">Sign in</button>
      
      <!-- <p>
      <router-link v-bind:to="{ name: 'register'}">Need an account? Sign up.</router-link></p> -->
      <p><router-link class="GuestView" to="/guestView">View Potholes as Guest</router-link></p>
    </div>
    </form>
    <!-- <button @click="message()">click</button> -->
    <img src="../img/Pothole Patrol App.jpg" class="app-icon" />
  </div>

</template>

<script>
import authService from "../services/AuthService";

export default {
  components: {},
  data() {
    return {
      user: {
        userRole: this.role,
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
        
    },
    message(){
      console.log(VITE_API_KEY)
    }
  }
};

// import dotenv from 'dotenv'

// dotenv.config()

// console.log(VITE_API_KEY)
</script>

<style scoped>

#login {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-image: url('https://images.unsplash.com/photo-1539651044670-315229da9d2f?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  color: white;
  border: 1px solid black;
  font-family: monospace;
}

.input-container {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  gap: 10px;
  padding: 30px;
  background: rgba(34, 2, 2, 0.247);
  backdrop-filter: blur(3px);
  -webkit-backdrop-filter: blur(5px);
  border-radius: 10px;
  border: 1px solid rgba(0, 0, 0, 0.705);
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.781);
  width: 400px;
  height: 400px;
  margin: auto;
  text-align: center;
  font-family: monospace;
}

.form-input-group {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  height: 55px;
  font-family: monospace
  
}

.form-input-group label,
.form-input-group input,
.form-input-group button {
  width: 100%;
  font-size: 1rem;
  font-family: monospace;
  
 
  height: 100px;
  padding-top: 5px;
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

#submit {
  background-color: rgb(13, 173, 173);
  color: rgb(255, 255, 255);
  transition: background-color 0.3s ease-in-out, transform 0.3s ease-in-out;
  border-radius: 5px;
  height: 37px;
  width: 43.5vh;
  margin-top: 10px;
  border-radius: 15px 15px 15px 15px;
  
  font-size: medium;
}

#submit:hover {
  background-color:rgb(13, 173, 173);
  transform: scaleY(1.3);
  color: black;
}

/* .app-name {
  display: flex;
  justify-content: center;
  align-items: center;
  text-decoration: wavy;
  font-size: 75px;
  border-radius: 1px solid white;
  
  
  
} */

.app-name {
  font-size: 5em; 
  color: #dae906; 
  text-align: center; 
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); 
  font-family:fantasy; 
  margin-bottom: 20px; 
  margin-top: -100px;
  /* text-decoration: underline; */
  
  
}

.form-input-group input:focus {
  border-color: rgb(13, 173, 173);  
  box-shadow: 0 0 5px rgba(76, 175, 80, 0.4); 
  outline: none; 
}

.form-input-group input {
  border-radius: 15px 15px 15px 15px;
  padding-left: 10px;
  background-color: rgba(255, 255, 255, 0.8);
  font-family: monospace;
}

.GuestView {
  font-size: 1.2rem;
  color: rgb(251, 255, 255);
}

.GuestView:hover {
  color: #d4d896;
}

</style>


