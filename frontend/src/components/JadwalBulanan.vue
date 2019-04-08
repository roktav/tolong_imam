<template>
	<div id="app">
	<nav-side-bar>
	
	</nav-side-bar>
	<v-app id="panel">
	<br></br>
	<h1 align="left"> Kelola Shift Bulanan </h1>
	<div id="app">
  <v-app id="inspire">
    <v-container id="dropdown-example" grid-list-xl>
      <v-layout row wrap>
        <v-flex xs12 sm4>
          <p>Pilih Tahun</p>
          <v-overflow-btn
            :items="dropdown_edit"
            label="Editable Btn"
            editable
            item-value="text"
          ></v-overflow-btn>
        </v-flex>
  
        <v-flex xs12 sm4>
          <p>Pilih Bulan</p>
            <v-overflow-btn
            :items="dropdown_edit"
            label="Editable Btn"
            editable
            item-value="text"
          ></v-overflow-btn>
        </v-flex>
        
        <v-flex xs12 sm4>
          <p>Pilih Minggu</p>
            <v-overflow-btn
            :items="dropdown_edit"
            label="Editable Btn"
            editable
            item-value="text"
          ></v-overflow-btn>
        </v-flex>
      </v-layout>
    </v-container>
  </v-app>
</div>
	
	</v-app>
	</div>
</template>
<script>
import NavSideBar from './NavSideBar';
import Footer from './Footer';
import axios from 'axios';
export default {
  el: '#app',
  name: 'AdminTeknisi',
  components: {
      'nav-side-bar': NavSideBar,
      'nav-footer' : Footer
  },
  data(){
  	return{
  		months: ['Januari','Februari','Maret','April','Mei','Juni','Juli','Agustus','September','Oktober','November','Desember'],
     	
  	
  	}
  
  },
  
}
 

</script>
<style>
#panel {
	margin-left: 270px;
	margin-top: 40px;
	width: 83%;
	
	

}
</style>