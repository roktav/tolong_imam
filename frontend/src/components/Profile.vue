<template>
  <v-app>
    <nav-side-bar></nav-side-bar>
    <v-card class = "card-content">
      <v-card-title>      
        <h4 class = "display-1 left leftmargin">Profile Admin</h4>
      </v-card-title>
      <v-card-text>
         <img class = "avatar left leftmargin" src="@/assets/images/padli.jpg">
        <h4 class = "title left leftmargin">Arief Fadli Wicksono</h4> <br/> <br/>
        <h4 class = "title left leftmargin">Status  : Aktif</h4> <br/>
        <h4 class = "title left leftmargin">ID Karyawan : UBP131241213</h4><br/>
        <h4 class = "title left leftmargin">Jabatan     : CEO</h4><br/>
        <h4 class = "title left leftmargin">Role        : Admin Teknisi</h4><br/> 
        <h4 class = "title left leftmargin">Kantor Cabang: Jakarta</h4><br/>
        <h4 class = "title left leftmargin">Nomor Handphone : 08121231123</h4><br/>
        <h4 class = "title left leftmargin">Email       : arief.fadli@gmail.com</h4><br/>
        <h4 class = "title left leftmargin">Alamat      : Kebun Raya Bogor</h4><br/>
        <h4 class = "title left leftmargin">Info      : {{ info }}</h4><br/>
      </v-card-text>
      <v-card-actions>
        <v-btn class="secondary">Edit</v-btn>
        <v-btn class="error">Delete</v-btn>
      </v-card-actions>
    </v-card>
      
    <nav-footer></nav-footer>
  </v-app>
</template>

<script>
import NavSideBar from './NavSideBar';
import Footer from './FooterUser';
import axios from 'axios'

export default {
  name: 'adminprofil',
  components: {
      'nav-side-bar': NavSideBar,
      'nav-footer' : Footer
  },
  data() {
    return {
        info: null
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
.leftmargin {
  margin-left: 4%
}

.card-content{
  margin-left: 250px
}


.avatar {
  vertical-align: middle;
  width: 250px;
  height: 250px;
  border-radius: 50%;
}
</style>
