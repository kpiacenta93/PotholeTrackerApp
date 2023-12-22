<!-- <template>
    <div id="map" style="height: 400px; width: 100%;"></div>
</template>

  <script>
  
  
  export default {
    name: 'Maps',
    mounted() {
      this.initMap();
    },


    methods: {
      async initMap() {
        const loader = new Loader({
          apiKey: "YOUR_API_KEY", 
          version: "weekly",
         
        });
  
        try {
          await loader.load();
          this.map = new google.maps.Map(document.getElementById("map"), {
            center: { lat: -34.397, lng: 150.644 },
            zoom: 8,
          });
        } catch (error) {
          console.error("Error loading Google Maps:", error);
        }
      }
    }
  };
  </script>
  
  <style>
  #map {
    height: 100%;
  }
  html, body {
    height: 100%;
    margin: 0;
    padding: 0;
  }
  </style> -->
 
 
 
<template>
  <div class="map-container">

    <GoogleMap api-key="apiKey" style="width: 100%; height: 500px" :center="center"
      :zoom="15">
      
      <Marker v-for="marker in markers" :key="marker.id"
  :options="{ position: { lat: marker.lat, lng: marker.lng }, visible: true, clickable: true}"
  @click="emitMarkerClick(marker.id)" />
      <!-- <Marker :options="{ position:test }" /> -->
      
    
    </GoogleMap>
  </div>
</template>
  
<script>
import { defineComponent } from "vue";
import { GoogleMap, Marker} from "vue3-google-map";

import { processExpression } from "@vue/compiler-core";

export default defineComponent({

  data() {
    
    return {
      markers: [],
      selectedMarkerData: null,
      apiKey: import.meta.env.VITE_API_KEY

    }
  },
  components: { GoogleMap, Marker },
  // created() {
  //     this.$store.state.potholes.forEach(pothole => {
  //     console.log('here')
  //     let marker = { center: { lat: pothole.latitude, lng: pothole.longitude } }
  //     this.$store.state.markers.push(marker)
  //   })

  // },
  methods: {
    emitMarkerClick(markerId) {
    this.$emit('marker-clicked', markerId);
    console.log("marker has been clicked")
  },

    onMarkerClick(marker){
    console.log("the marker has been clicked!!")
    this.selectedMarkerData = marker

  },

    testCenter() {
      
      this.$store.state.potholes.forEach(pothole => {
        let marker = {
          id: pothole.potholeid,
          lat: pothole.latitude,
          lng: pothole.longitude
        }
        console.log("this is something ")
        this.markers.push(marker)
        
      })
      
    }
  },

  setup() {
    const center = { lat: 39.952583, lng: -75.165222 };
    // const positions = [ { lat: -42.734358, lng: 147.439506 },
    //   { lat: -42.734358, lng: 147.501315 },
    //   { lat: -42.735258, lng: 147.438 },
    //   { lat: -43.999792, lng: 170.463352 }];

      // const center = {lat: -28.024, lng: 140.887 }

    return { center };
  
  },

  created(){
    this.testCenter();
  },
});
</script>

<style scoped>
.map-container {
  width: 99%;
  height: 500px;
  margin: auto;
  padding-bottom: 20px;

}

.pothole-pin {
  color: white;
}
</style>


