<template>
  <div id="capstone-app">
    <div id="nav">
      <div class="nav-welcome">
        <p>Saving the world ONE POTHOLE at a time!</p>
      </div>
      <div class="divider"></div>
      <div class="nav-links">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
        <router-link v-bind:to="{name: 'register'}" v-if="!$store.state.user || !$store.state.user.username">Register!</router-link>
        <div class="user-info">Welcome to Pothole Patrol, {{ $store.state.user.username }}</div>

      </div>
    </div>
    <!-- <div>{{ $store.state.user }}</div> -->
    <router-view />
    
  </div>
  <div>
  <footer class="footer"><span>&copy; Pothole Patrol 2023</span></footer>
</div>
</template>


<style>
#nav {
  display: flex;
  justify-content: space-between; 
  align-items: center; 
  padding-bottom: 20px;
  font-family: fantasy;
  background-color: black;
  color: whitesmoke;
  padding-bottom: 5px;
  border-bottom: 2px solid white;
  height: 50px;
  padding-right: 5px;
}

.nav-links a {
  color: rgb(253, 228, 6);
  padding-right: 5px;
}

.nav-links a:hover{
  color: aqua;
}

.nav-welcome p {
  display:flex;
  margin: 0; 
  /* text-shadow: 2px 2px 3px rgb(214, 214, 195);  */
  color:rgb(253, 228, 6);
  font-size: xx-large;
  /* padding-left: 600px; */
  padding-left: 10px
  /* align-items: center; */
  /* justify-content: space-between; */
}

.nav-welcome {
  display: flex;
  justify-content: space-around;
}

.nav-links {
  display: flex;
  gap: 10px; 
  padding-right: 5px;
}

.user-info {
  color: white;
  
  border: 1px solid white;
 
  margin-right: auto;
  display:flex;
  justify-content: center;
  align-items: center;
}

.footer {
  display: flex;
  justify-content: space-between; 
  align-items: center; 
  /* padding-bottom: 20px; */
  font-family: fantasy;
  background-color: black;
  color: whitesmoke;
  
  border-bottom: 2px solid white;

  height: 50px;
  padding-top: 5px;
  border-top: 2px solid white;
  display: flex;
  justify-content: center;
}


/* @media (max-width: 768px){
  .nav-welcome{
    width: 100%;
    padding: 15px;
  }
} */
</style>

