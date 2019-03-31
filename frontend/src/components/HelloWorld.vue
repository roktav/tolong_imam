<template>
  <v-app>
    <nav-bar></nav-bar>
  </v-app>
</template>

<script>
import NavBar from './NavBarVuetify';

export default {
  name: 'HelloWorld',
  components: {
      'nav-bar': NavBar
  },
data() {
  return {
    produk : 'cctv'
  }
}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
