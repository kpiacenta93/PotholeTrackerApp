<!-- <template>
    <div>
      <AddPothole @potholeAdded="handlePotholeAdded" />
<Maps ref="mapComponent" />

    </div>
  </template>
  <script>
   import AddPothole from '../components/AddPothole.vue'
   import Maps from '../components/Maps.vue';
  export default {
    components: {
       AddPothole,
       Maps
    },

    methods : {
      handlePotholeAdded(potholeLocation){
        this.$refs.mapComponent.addMarker
      }
    }
  };
  </script> -->


  <template>
    <div>
      <AddPothole/>
      
    </div>
  </template>
  
  <script>
  import AddPothole from '../components/AddPothole.vue';
  
  
  export default {
    components: {
      AddPothole,
    },
    data() {
      return {
        markers: [],
      };
    },
    methods: {
      handlePotholeAdded(pothole) {
        // this.$store.state.potholes.push(this.pothole);
        const newMarker = {
          id: this.markers.length + 1,
          position: {
            lat: pothole.latitude,
            lng: pothole.longitude,
          },
        };
        this.markers.push(newMarker);
      },
    },
  };
  </script>
  