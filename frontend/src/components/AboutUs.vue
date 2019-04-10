<template>
    <v-app>
        <nav-bar></nav-bar>
        <br>
        <h2>Profil</h2>
        <p>Wirelessindo Information System of Customer Relation (WINSCORE) adalah sistem yang dibangun untuk memasarkan produk yang ditawarkan oleh CV Wirelessindo. CV Wirelessindo sudah memiliki pengalaman bekerja dengan korporasi. Visi kami adalah mampu berkembang mengikuti kebutuhan berbagai klien kami.</p>
        <nav-footer></nav-footer>
    </v-app>
</template>

<script>
import NavBar from './NavBarVuetify';
import Footer from './FooterUser';

export default {
  components: {
      'nav-bar': NavBar,
      'nav-footer' : Footer
  }
}

</script>

<style>
p {
   max-width: 800px;
   text-align: left; 
}
h2 {
    text-align: left;
}
</style>


