<template>
  <div class="home">
    <div class="button-container">
      <button class="click" @click="goToAddPothole">ADD POTHOLE!</button>
      <button class="click" @click="goToAllPotholeView">SEE POTHOLES!</button>
    </div>

    <div class="content-container">
      <h1 class="home-title">Pothole Patrol</h1>
      <div class="paragraph-container">
        <p class="paragraph">
          At the heart of our mission with the Pothole Tracker application is a
          simple yet profound vision: to make our streets safer and our
          communities more connected. By empowering individuals to report
          potholes swiftly and efficiently, we're not just fixing roads — we're
          fostering a sense of community responsibility and collaboration.
        </p>
        <p class="paragraph">
          Each reported pothole symbolizes a step towards smoother, safer
          journeys for everyone. It's more than just an app; it's a tool for
          change, demonstrating how technology can bring us together to improve
          our shared spaces.
        </p>
        <p class="paragraph">
          Together, we're not just repairing the roads — we're building the
          foundation for a more responsive and caring world, one application at
          a time.
        </p>
      </div>
    </div>

    <img src="../img/Pothole Patrol App.jpg" class="app-icon" />
  </div>
</template>

<script>
import PotholeService from "../services/PotholeService";

export default {
  methods: {
    goToAddPothole() {
      this.$router.push("/potholes");
    },

    goToAllPotholeView() {
      this.$router.push("/potholeList");
    },
    fetchPotholes() {
      console.log("Fetching potholes...");

      PotholeService.getPotholeList().then((response) => {
        this.$store.state.potholes = response.data;
      });
    },
    // createMarkers(){
    //   this.$store.state.potholes.forEach(pothole=>{
    //       let marker = {center: {lat: pothole.latitude, lng: pothole.longitude}}
    //       this.$store.state.markers.push(marker)
    //     })
    // },
  },
  created() {
    this.fetchPotholes();
    // this.createMarkers()
  },
};
</script>

<style>
.home {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  min-height: 100vh;
  background-image: url('https://cdn10.phillymag.com/wp-content/uploads/sites/3/2020/03/philadelphia-coronavirus-shutdown-photos.jpg');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  color: white;
  border: 1px solid black;
  color: rgb(208, 243, 8);
  font-size: 2.75rem;
}

.container {
  border-radius: 1px solid white;
  height: 650px;
  display: flex;
  align-items: center;
  justify-content: space-evenly;
  flex-direction: column;
  background: rgba(37, 37, 37, 0.5);
  backdrop-filter: blur(3px);
  -webkit-backdrop-filter: blur(5px);
  border-radius: 10px;
  border: 1px solid rgba(253, 243, 243, 0.705);
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.781);
  width: 1100px;
}

.click:hover {
  background-color: aqua;
  transform: scaleY(1.2);
}

.click {
  display: inline-flex;
  justify-content: center;
  align-items: center;
  width: 300px;
  height: 45px;
  padding: 0 15px;
  margin: 0 10px;
  border-radius: 15px;
  box-shadow: 2px 2px 2px black;
  font-size: xx-large;
  background-color: #dae906;
  color: black;
  transition: background-color 0.3s, transform 0.3s;
  border: none;
  cursor: pointer;
}

.paragraph {
  text-align: center;
  padding-right: 6px;
  padding-left: 6px;
  font-family: monospace, Arial Narrow Impact, Haettenschweiler, 'Arial Narrow Bold';
  font-size: 1.75rem;
  color: whitesmoke;
  margin: auto;
  padding-bottom: 40px;
}


.app-icon {
  position: fixed;
  bottom: 20px;
  right: 20px;
  height: 50px;
  width: 50px;
  z-index: 1000;
}

.buttons {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  width: 100%;
  padding-top: 40px;
  padding-bottom: 20px;
}

.home-title  {
  font-size: 2em;
  color: #dae906;
  text-align: center;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
  font-family: fantasy;
  margin-top: 20px;
  margin-bottom: 20px;
 
}

.paragraph-container {
  background: rgba(8, 0, 0, 0.719);
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.3);
  max-width: 60%;
  margin-top: 20px;
  margin-bottom: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  border: 1px solid grey;
}

.content-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 100%;
}

</style>
