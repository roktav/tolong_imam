
<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-app>
        <nav-side-bar></nav-side-bar>
            <div id="schedule">
                <div>
                    <h4 class ="display-1 font-weight-medium black--text" align="center">Penjadwalan Bulanan Shift Teknisi</h4>
                    <h4 class ="headline font-weight-medium black--text" align="center">Tahun 2019</h4>
                    <br><br>
                </div>
                <v-expansion-panel>
                    <v-expansion-panel-content
                            v-for="(item,i) in months"
                            :key="i" >
                        <template v-slot:header>
                            <div>
                                <h2 class="subheading black--text font-weight-medium">{{item}}</h2>
                            </div>
                        </template>
                        <v-card id=daftar-teknisi>
                            <v-flex xs12 sm3 offset-xs8>
                                <v-card-title>
                                    <v-text-field
                                            v-model="search"
                                            append-icon="search"
                                            label="Search"
                                            single-line
                                            hide-details
                                    ></v-text-field>
                                </v-card-title>
                            </v-flex>
                            <v-flex xs12 offset-xs0>
                            <v-data-table
                                    :headers="headers"
                                    :items="daftarteknisi"
                                    :search="search"
                                    class="schedule-table"
                                    large>
                                <template v-slot:items="props">
                                    <td class="text-xs-left">{{ props.item.id_teknisi }}</td>
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
                                                        :rules="addressRules"
                                                        label="Edit"
                                                        single-line
                                                        counter
                                                ></v-text-field>
                                            </template>
                                        </v-edit-dialog>
                                    </td>
                                    <td class="text-xs-left">
                                    	{{ imperfectNumber }}
                                        <v-edit-dialog
                                                :return-value.sync="props.item.no_telp"
                                                lazy
                                                large
                                                persistent
                                                @save="save(props.item)"
                                                @cancel="cancel"
                                                @open="open"
                                                @close="close"
                                        > 
                                        	{{ props.item.no_telp }}
                                            <template v-slot:input>
                                                <v-text-field
                                                        v-model.number="props.item.no_telp"
                                                        :rules="numberRules"
                                                        label="Edit"
                                                        single-line
                                                        counter
                                                ></v-text-field>
                                            </template>
                                        </v-edit-dialog>
                                    </td>
                                    <td class="text-xs-left">
                                        <v-flex>
                                            <v-select
                                                    :items="items"
                                                    label="Pilih Shift"
                                                    v-model="props.item.shift">

                                            </v-select>
                                        </v-flex>
                                    </td>
                                    <td>
                                        <v-flex>
                                            <v-btn class="save-button secondary"depressed small lazy @click="addJob(props.item)"
                                                   persistent>
                                                Simpan
                                            </v-btn>
                                        </v-flex>
                                    </td>
                                </template>
                                <v-alert v-slot:no-results :value="true" color="error" icon="warning">
                                    Your search for "{{ search }}" found no results.
                                </v-alert>
                                <template v-slot:no-data>
                                    <v-alert :value="true" color="error" icon="warning">
                                        Data tidak ditemukan :(
                                    </v-alert>
                                </template>
                            </v-data-table>
                            </v-flex>
                        </v-card>

                  </v-expansion-panel-content>
                </v-expansion-panel><br><br><br><br><br><br><br>
                <v-snackbar v-model="snack" :timeout="3000" :color="snackColor">
                    {{ snackText }}
                    <v-btn flat @click="snack = false">Close</v-btn>
                  </v-snackbar>
        </div>
        <nav-footer-admin></nav-footer-admin>
    </v-app>
</template>
<script>
import NavSideBar from './NavSideBar';
import FooterAdmin from './FooterAdmin';
import axios from 'axios';


export default {
  name: 'AdminTeknisi',
  components: {
      'nav-side-bar': NavSideBar,
      'nav-footer-admin' : FooterAdmin
  },
  el: '#app',
  data () {
    return {
    	alert:false,
	  	items: ['pagi', 'siang'],
	  	addressRules: [
       		 v => v.length <= 150 || "Maximum 150 characters",
       		 v => !!v || "This field can't be empty"
     	],
	  	numberRules: [
       		 v => v.length <= 15 || "Maximum digits 15 or less",
       		 v => !!v || "This field can't be empty",
       		 v => v.isObjectNumber || "Only accepts number"
     	],
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
          { text: '(+62) Nomor Telepon', value: 'no_telp' },
          { text: 'Shift'},
          { text: 'Edit'}
        ],
        
    }
  },
  props: {
    source: String
  },
  methods: {
  		 save:function (teknisi) {
  		  const x = teknisi.no_telp
  		  const y = teknisi.alamat
  		 if ( x == null || x == "" || y == null || y  == "" ) {
     		this.snack = true
	     	this.snackColor = 'error'
     	 	this.snackText = 'empty input not allowed'
      		
   		} else {
    	  this.snack = true
    	  this.snackColor = 'success'
    	  this.snackText = 'Data saved'
    	  console.log(teknisi)
            axios.post('http://localhost:8080/api/ubah/' + teknisi.id_teknisi, teknisi)
            .then(response => {
  			})
  			.catch(e => {
  			console.log(e)
  		  }) }
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

    #schedule {
        margin-top: 60px;
        margin-left: 260px;
        margin-right: 37px;
        font-size: 12px;
    }
    .schedule-table {
        margin-left: 75px;
        margin-right: 80px;
    }
    #panel {
        margin-left: 270px;
        margin-top: 40px;
        width: 50%;
        font-size: 12px;
    }
</style>
