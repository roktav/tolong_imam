<template>
    <v-app>
        <nav-bar></nav-bar>
        <h1>Get in touch</h1>
        <h4>Head Office</h4>
        <p>Jl. Ahmad Yani No.124, Tanah Sareal
            Kota Bogor, Jawa Barat, 16161</p>
        <br>
        <h4>Hotline</h4>
        <p>0251-8331858</p>
        <nav-footer></nav-footer>
    </v-app>
</template>

<script>
import NavBar from './NavBarVuetify';
import Footer from './Footer';

export default {
  components: {
      'nav-bar': NavBar,
      'nav-footer' : Footer
  }
}

</script>