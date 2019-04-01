<template>
  <v-app>
    <nav-side-bar></nav-side-bar>
    <ul v-for="item in daftarteknisi" :key = "item.id_teknisi">
    	<li> {{item.nama }}</li>
    </ul>
    
    <nav-footer></nav-footer>
    <v-card id=daftar-teknisi>
    <v-card-title>
     Daftar Teknisi
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
        <td class="text-xs-left">{{ props.item.id_teknisi }}</td>
        <td class="text-xs-left">{{ props.item.nama }}</td>
        <td class="text-xs-left">{{ props.item.shift }}</td>
        <td class="text-xs-left">{{ props.item.alamat }}</td>
        <td class="text-xs-left">{{ props.item.no_telp }}</td>
        <td class="text-xs-left">{{ props.item.foto }}</td>
      </template>
      <v-alert v-slot:no-results :value="true" color="error" icon="warning">
        Your search for "{{ search }}" found no results.
      </v-alert>
    </v-data-table>
  </v-card>
   
  </v-app>
  
  
</template>

<script>
import NavSideBar from './NavSideBar';
import Footer from './Footer';
import axios from 'axios';
//import teknisi.vue 

export default {
  name: 'AdminTeknisi',
  components: {
      'nav-side-bar': NavSideBar,
      'nav-footer' : Footer
  },
  data() {
    return {
    	daftarteknisi: [],
    	errors: [],
    	search: "",
    	 headers: [
          {
            text: 'Daftar Teknisi',
            align: 'center',
            sortable: false,
            value: 'daftarteknisi'
          },
          { text: 'ID', value: 'id' },
          { text: 'Nama', value: 'nama' },
          { text: 'Shift', value: 'shift' },
          { text: 'Alamat', value: 'alamat' },
          { text: 'Nomor Telepon', value: 'no_telp' },
          { text: 'Foto', value: 'foto' }
        ],
        
    }
  },
  props: {
    source: String
  },
  mounted(){
  	axios.get('http://localhost:8080/api/teknisi')
  	.then(response => {
  		this.daftarteknisi = response.data.result
  		console.log(this.daftarteknisi)
  	})
  	.catch(e => {
  		console.log(e)
  	})
  },
  methods: {
    
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#daftar-teknisi {
	margin-left: 270px;
	margin-right: 20px;
	
}

</style>

