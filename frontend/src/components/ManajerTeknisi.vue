<template>
  <v-app>
    <nav-side-bar></nav-side-bar>
    <nav-footer></nav-footer>
  </v-app>
</template>

<script>
import NavSideBar from './NavSideBar';
import Footer from './FooterUser';


export default {
  name: 'ManajerTeknisi',
  components: {
      'nav-side-bar': NavSideBar,
      'nav-footer' : Footer
  },
  data() {
    return {
        
    }
  },
  props: {
    source: String
  },
  
  methods: {
    
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
