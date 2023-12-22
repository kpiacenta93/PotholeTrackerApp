<template>
  <div id="register" class="text-center">
    <form v-on:submit.prevent="register">
      <h1 class="app-name">Pothole Patrol</h1>
      <div class="input-container">
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">Username:</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>
      <button type="submit" id="submit">Create Account</button>
      <p><router-link v-bind:to="{ name: 'login' }" style="color: white">Already have an account? Log in.</router-link></p>
    </div>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}

.text-center {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-image: url('https://images.unsplash.com/photo-1539651044670-315229da9d2f?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  font-family: monospace;
  color: white;
}

.input-container {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
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
}


.form-input-group label,
.form-input-group input,
.form-input-group button {
  width: 100%;
  font-size: 1rem;
  font-family: monospace;
 
  height: 23px;
  padding-top: 5px;
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

#submit {
  background-color: rgb(13, 173, 173);
  color: rgb(255, 255, 255);
  transition: background-color 0.3s ease-in-out, transform 0.3s ease-in-out;
  border-radius: 5px;
  height: 36px;
  width: 43vh;
  padding-top: 5px;
  padding-bottom: 10px;
  border-radius: 15px 15px 15px 15px;
  font-size: large;
  font-family: monospace;
}

#submit:hover {
  background-color:rgb(10, 136, 136);
  transform: scaleY(1.2);
  color: black;
}


.app-name {
  font-size: 5em; 
  color: #dae906; 
  text-align: center; 
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); 
  font-family:fantasy; 
  margin-bottom: 20px; 
  margin-top: -100px;
  /* text-decoration: underline;  */
}



.form-input-group input:focus {
  border-color:aqua; 
  box-shadow: 2px 2px 2px rgba(76, 175, 80, 0.4); 
  outline: none; 
}

.form-input-group input {
  border-radius: 15px 15px 15px 15px;
  padding-left: 10px;
  background-color: rgba(255, 255, 255, 0.8);
  font-family: monospace;
}

</style>
