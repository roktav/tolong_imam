<template>
  <div>
    <v-navigation-drawer
      :clipped="drawer.clipped"
      :fixed="drawer.fixed"
      :permanent="drawer.permanent"
      :mini-variant="drawer.mini"
      :width="'250px'"
      v-model="drawer.open"
      app
      dark
      class="primary"
    >
      <v-divider style= "margin-top : 0"></v-divider>
      <v-list>
        <v-list-tile router :to="'/list-pesanan'" >
          <v-list-tile-action><v-icon>assignment</v-icon></v-list-tile-action>
          <v-list-tile-content><v-list-tile-title>Pesanan</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>

        <v-list-tile router :to="'/list-produk'">
          <v-list-tile-action><v-icon>store</v-icon></v-list-tile-action>
          <v-list-tile-content><v-list-tile-title>Produk</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>

        <v-list-tile router :to="'/list-promosi'">
          <v-list-tile-action><v-icon>event</v-icon></v-list-tile-action>
          <v-list-tile-content><v-list-tile-title>Promosi</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>
    </v-navigation-drawer>
    <nav-bar-vue></nav-bar-vue>
    
  </div>
</template>

<script>
import NavBarVuetify from './NavBarVuetify';


export default {
  name: 'HelloWorld',
  components: {
      'nav-bar-vue': NavBarVuetify
  },
  data() {
    return {
        menu: [
            {
                header: true,
                title: 'Winscore'
            },
            {
                href: '/',
                title: 'Winscore Site',
                icon: 'fas fa-globe'
            },
            {
                href: '/admin',
                title: 'Dashboard',
                icon: 'fas fa-home'
            }
        ],
        drawer: {
          // sets the open status of the drawer
          open: true,
          // sets if the drawer is shown above (false) or below (true) the toolbar
          clipped: true,
          // sets if the drawer is CSS positioned as 'fixed'
          fixed: false,
          // sets if the drawer remains visible all the time (true) or not (false)
          permanent: true,
          // sets the drawer to the mini variant, showing only icons, of itself (true) 
          // or showing the full drawer (false)
          mini: false
        },
        toolbar: {
          //
          fixed: true,
          // sets if the toolbar contents is leaving space for drawer (false) or not (true)
          clippedLeft: true
        },
        footer: {
          // sets the CSS position of the footer
          fixed: true,
          // sets if the footer is full width (true) or gives space to the drawer (false)
          clippedLeft: true
        }
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
.router-link-exact-active {
  background-color: cyan
}
</style>
