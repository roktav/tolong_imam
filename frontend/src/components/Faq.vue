<template>
    <v-app>
        <nav-bar></nav-bar>
        <h1>Frequently Asked Questions</h1>
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