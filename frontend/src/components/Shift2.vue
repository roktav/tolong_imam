<template>
	<div id="app">
	<nav-side-bar></nav-side-bar>
	
  	<v-app id="panel" >
  	<h1>Penjadwalan Bulanan Shift Teknisi</h1>
  	<h1> 2019 </h1>
    <v-expansion-panel>
      <v-expansion-panel-content v-for="(item,i) in months"
        :key="i" >
        <template v-slot:header>
          <div>
          <h2>{{item}}</h2>
          </div>
        </template>
        <v-card id=daftar-teknisi>
    <v-card-title>
      <v-spacer></v-spacer>
      <v-text-field
        v-model="search"
        append-icon="search"
        label="Search"
        single-line
        hide-details
      ></v-text-field>
    </v-card-title>
    <v-data-table
      :headers="headers"
      :items="daftarteknisi"
      :search="search"
    >
      <template v-slot:items="props">
        <td>{{ props.item.id_teknisi }}</td>
        <td class="text-xs-left">{{ props.item.nama }}</td>
        <td class="hidden-xs-only">{{ props.item.alamat }}</td>
        <td class="text-xs-left">{{ props.item.no_telp }}</td>
        <td class="text-xs-left">{{ props.item.foto }}</td>
        <td class="text-xs-left">
        	<v-flex xs12 sm6 d-flex>
          	<v-select
            	:items="items"
            	label="Pilih Shift"
            	v-model="props.item.shift"
          	>
          		
          	</v-select>
        	</v-flex>
        	<v-btn depressed small color="primary" @click="addJob(props.item)">Primary</v-btn>
        </td>
      </template>
      
      <v-alert v-slot:no-results :value="true" color="error" icon="warning">
        Your search for "{{ search }}" found no results.
      </v-alert>
    </v-data-table>
  </v-card> 
          
        	
              	
      </v-expansion-panel-content>
    </v-expansion-panel>
 
  </v-app>
</div>
</template>
<script>
import NavSideBar from './NavSideBar';
import Footer from './Footer';
import axios from 'axios';


export default {
  name: 'AdminTeknisi',
  components: {
      'nav-side-bar': NavSideBar,
      'nav-footer' : Footer
  },
  el: '#app',
  data () {
    return {
	  	items: ['pagi', 'siang'],
	  	shift: [],
	  	months: ['Januari','Februari','Maret','April','Mei','Juni','Juli','Agustus','September','Oktober','November','Desember'],
     	pagination: {},
  		daftarteknisi: [],
  		
  		editedItem: {
  		  nama: '',
  		  alamat: '',
  		  no_telp: '',
  		  foto: '',
  		  shift: '', 
  		},
    	errors: [],
    	search: "",
    	headers: [
          {
            text: 'ID Teknisi',
            align: 'left',
            sortable: false,
            value: 'daftarteknisi'
          },
         
          { text: 'Nama', value: 'nama' },
          { text: 'Alamat', value: 'alamat' }, 
          { text: 'Nomor Telepon', value: 'no_telp' },
          { text: 'Foto', value: 'foto' },
          { text: 'Shift'}
        ],
        
    }
  },
  props: {
    source: String
  },
  methods: {
  		editItem(item){
  			this.editedIndex = this.daftarteknisi.indexOf(item)
  			this.editedItem = Object.assign({}, item)
  		},
        addJob:function(teknisi) {
        	console.log(teknisi)
            axios.post('http://localhost:8080/api/ubah/' + teknisi.id_teknisi, teknisi)
            .then(response => {
  				alert("hooray")
  			})
  			.catch(e => {
  			console.log(e)
  			})
        }
  },
  mounted(){
  	axios.get('http://localhost:8080/api/teknisi')
  	.then(response => {
  		this.daftarteknisi = response.data.result
  		this.shift = this.daftarteknisi.shift
  		console.log(this.daftarteknisi)
  		console.log(this.shift)
  	})
  	.catch(e => {
  		console.log(e)
  	})
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
