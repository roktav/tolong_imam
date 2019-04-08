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
      large
    >
      <template v-slot:items="props">
        <td>{{ props.item.id_teknisi }}</td>
        <td class="text-xs-left">{{ props.item.nama }}</td>
        <td class="text-xs-left">
        <v-edit-dialog
              :return-value.sync="props.item.alamat"
              lazy
              large 
              persistent
              @save="save(props.item)"
              @cancel="cancel"
              @open="open"
              @close="close"
            > {{ props.item.alamat }}
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.alamat"
                  :rules="[max250chars]"
                  label="Edit"
                  single-line
                  counter
                ></v-text-field>
              </template>
            </v-edit-dialog>
        </td>
        <td class="text-xs-left">
        <v-edit-dialog
              :return-value.sync="props.item.no_telp"
              lazy
              large 
              persistent
              @save="save(props.item)"
              @cancel="cancel"
              @open="open"
              @close="close"
            > {{ props.item.no_telp }}
              <template v-slot:input>
                <v-text-field
                  v-model="props.item.no_telp"
                  :rules="[max25chars]"
                  label="Edit"
                  single-line
                  counter
                ></v-text-field>
              </template>
            </v-edit-dialog>
        
        </td>
        <td class="text-xs-left">{{ props.item.foto }}</td>
        <td class="text-xs-left">
        	<v-flex xs12 sm6 d-flex>
          	<v-select
         
            	:items="items"
            	label="Pilih Shift"
            	v-model="props.item.shift"
            	
          	>
          	</v-select>
          	
          	<v-btn depressed small color="info" lazy @click="addJob(props.item)" 
          		large
        		lazy
        		persistent
        	>Simpan
      		</v-btn>
        	</v-flex>
        </td>
      </template>
 	   
      <v-alert v-slot:no-results :value="true" color="error" icon="warning">
        Your search for "{{ search }}" found no results.
      </v-alert>
      <template v-slot:no-data>
        <v-alert :value="true" color="error" icon="warning">
          Sorry, nothing to display here :(
        </v-alert>
      </template>
    </v-data-table>
    
  </v-card> 

      </v-expansion-panel-content>
    </v-expansion-panel>
 	<v-snackbar v-model="snack" :timeout="3000" :color="snackColor">
        {{ snackText }}
        <v-btn flat @click="snack = false">Close</v-btn>
      </v-snackbar>
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
    	alert:false,
	  	items: ['pagi', 'siang'],
	  	shift: [],
	  	snack: false,
        snackColor: '',
        snackText: '',
	  	months: ['Januari','Februari','Maret','April','Mei','Juni','Juli','Agustus','September','Oktober','November','Desember'],
     	pagination: {},
  		daftarteknisi: [],
  		
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
  		 save:function (teknisi) {
    	  this.snack = true
    	  this.snackColor = 'success'
    	  this.snackText = 'Data saved'
    	  console.log(teknisi)
            axios.post('http://localhost:8080/api/ubah/' + teknisi.id_teknisi, teknisi)
            .then(response => {
  			})
  			.catch(e => {
  			console.log(e)
  		  })
   		 },
   		 cancel () {
    	  this.snack = true
	      this.snackColor = 'error'
     	 this.snackText = 'Canceled'
   		 },
  		 open () {
      	  this.snack = true
      	  this.snackColor = 'info'
          this.snackText = 'Dialog opened'
   	 	},
   close () {
      console.log('Dialog closed')
    },
  		alert:function(){
  			this.$set=('alert',true)
  		},
        addJob:function(teknisi) {
      	  this.snack = true
    	  this.snackColor = 'success'
    	  this.snackText = 'Data saved'
        	console.log(teknisi)
            axios.post('http://localhost:8080/api/ubah/' + teknisi.id_teknisi, teknisi)
            .then(response => {
  				alert("Data tersimpan!")
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
	width: 50%;
	font-size: 12px;
	
	

}
</style>
