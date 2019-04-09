<template>
<v-app>
  <v-stepper v-model="e6" vertical>
    <v-stepper-step :complete="e6 > 1" step="1">Cek Area</v-stepper-step>
    <v-stepper-content step="1">
      <v-card class="mb-5" >
        <v-card-text >
          <div v-if="!alamatUser">
            <h4>Apakah anda ingin menggunakan alamat registrasi?</h4>
            <v-btn @click="e6 = 2">Ya</v-btn>
            <v-btn @click="post">Tidak</v-btn>
          </div>
          <div v-if="alamatUser">
          <v-flex xs12 sm3 md3 align-left: start>
          <label>Provinsi</label>
          <v-select v-model="namaProvinsi" :items="provinsis" item-text="nama">
            <!-- <option v-for="provinsi in provinsis" :key="provinsi.nama">{{ provinsi.nama }}</option> -->
          </v-select>
          </v-flex>
          <br>
          <label>Kabupaten/Kota</label>
          <v-flex xs12 sm6 md6>
          <v-select v-model="namaKota" :items="kotas" item-text="nama">
            <!-- <option v-for="kota in kotas" :key="kota.nama">{{ kota.nama }}</option> -->
          </v-select>
          </v-flex>
          <br>
          <label>Kecamatan</label>
          <v-flex xs12 sm3 md3>
          <v-select v-model="namaKecamatan" :items="kecamatans" item-text="nama">
            <!-- <option v-for="kecamatan in kecamatans" :key="kecamatan.nama">{{ kecamatan.nama }}</option> -->
          </v-select>
          </v-flex>
          <br>
          </div>
        </v-card-text>
        <div v-if="alamatUser">
        <v-card-actions>
          <v-btn color="primary" @click="e6 = 2">Lanjutkan</v-btn>
          <v-dialog v-model="dialog">
          <template v-slot:activator="{ on }">
          <v-btn flat v-on="on">Alamat Tidak Ditemukan?</v-btn>
          </template>
          <v-card>
            <v-card-title>Form Pengisian Alamat</v-card-title>
            <v-card-text>
              <v-text-field v-model="alamatNotFound" label="insert your address here"></v-text-field>
              <br>
              <v-btn @click="e6 = 2, dialog=false">Submit</v-btn>
              <v-btn @click="dialog = false">Cancel</v-btn>
            </v-card-text>
          </v-card>
          </v-dialog>
        </v-card-actions>
        </div>
      </v-card>
    </v-stepper-content>

    <v-stepper-step :complete="e6 > 2" step="2">Pilih Produk</v-stepper-step>
    <v-stepper-content step="2">
      <v-card class="mb-5">
      <v-card-text>
          <v-flex xs12 md6 sm6>
          <p>Pilih Kategori Produk</p>
          <v-btn color="primary" @click="addKategoriProduk('cctv'), depressedButton('cctv')" :disabled="cctv">CCTV</v-btn>
          <v-btn color="primary" @click="addKategoriProduk('vcon'), depressedButton('vcons')" :disabled="vcon">VCON</v-btn>
          <v-btn color="primary" @click="addKategoriProduk('smartLiving'), depressedButton('smart')" :disabled="smart">Smart Living</v-btn>
        </v-flex>
        <v-spacer></v-spacer>
        <v-flex xs12 md6 sm6>
          <br>
          <p>Pilih Kategori Bangunan</p>
          <v-btn color="primary" @click="addKategoriBangunan('Rumah')">Rumah</v-btn>
          <v-btn color="primary" @click="addKategoriBangunan('Apartemen')">Apartemen</v-btn>
          <v-btn color="primary" @click="addKategoriBangunan('Ruko')">Ruko</v-btn>
        </v-flex>
        <v-spacer></v-spacer>
        <v-flex xs12 md6 sm6>
          <br>
          <p>Pilih Produk yang Anda Inginkan</p>
          <!-- <vue-select-image :dataImages="produks" 
          :is-multiple="true" 
          :selectedImages="initialSelected"
          @onselectmultipleimage="onSelectMultipleImage">
          </vue-select-image> -->
        </v-flex>
      </v-card-text>
      <v-card-action>
        <v-btn color="primary" @click="e6 = 3">Lanjutkan</v-btn>
        <v-btn flat @click="e6 = 1">Kembali</v-btn>
      </v-card-action>
      </v-card>
    </v-stepper-content>

    <v-stepper-step :complete="e6 > 3" step="3">Data Diri dan Alamat</v-stepper-step>

    <v-stepper-content step="3">
      <v-card class="mb-5">
        <v-card-content>
          <label>Nama Depan</label>
          <input type="text" v-model="dataOrder.namaDepan">
          <br>
          <label>Nama Belakang</label>
          <input type="text" v-model="dataOrder.namaBelakang">
          <br>
          <label>E-mail</label>
          <input type="text" v-model="dataOrder.email">
          <br>
          <label>Nomor Ponsel</label>
          <input type="text" v-model="dataOrder.nomorPonsel">
          <label>Alamat Lengkap</label>
          <input type="text" v-model="dataOrder.alamatLengkap">
        </v-card-content>
      <v-card-action>
      <v-btn color="primary" @click="e6 = 4">Lanjutkan</v-btn>
      <v-btn flat @click="e6 = 2">Kembali</v-btn>
      </v-card-action>
      </v-card>
    </v-stepper-content>

    <v-stepper-step step="4">Rincian Pemesanan</v-stepper-step>
    <v-stepper-content step="4">
      <v-card class="mb-5">
        <p>Alamat Real : {{ alamatNotFound }}</p>
        <p>Kategori Produk : {{ kategoriProduk }}</p>
        <p>kategori Bangunan : {{ kategoriBangunan }}</p>
        <p>Nama depan : {{ dataOrder.namaDepan }}</p>
        <p>Nama belakang : {{ dataOrder.namaBelakang }}</p>
        <p>Alamat e-mail : {{ dataOrder.email }}</p>
        <p>Nomor ponsel : {{ dataOrder.nomorPonsel }}</p>
        <p>Alamat : {{ dataOrder.alamatLengkap }}</p>
        <p>Provinsi : {{ namaProvinsi }}</p>
        <p>Kota : {{ namaKota }}</p>
        <p>Kecamatan : {{ namaKecamatan }}</p>
      </v-card>
      <v-btn color="primary" @click="e6 = 1">Continue</v-btn>
      <v-btn flat @click="e6 = 3">Kembali</v-btn>
    </v-stepper-content>
  </v-stepper>
</v-app>
</template>


<script>
/* eslint-disable */
import axios from 'axios';

export default {
  data () {
    return {
      e6: 1,
      toggle_exclusive : 2,
      dataOrder : {
              namaDepan : '',
              namaBelakang : '',
              email : '',
              nomorPonsel : '',
              alamatLengkap : '',         
          },
      kategoriProduk : '',
      kategoriBangunan : '',
      provinsis : [],
      kotas : [],
      kecamatans : [],
      info : null,
      namaProvinsi : '',
      namaKota : '',
      namaKecamatan : '',
      alamatUser : false,
      produks : [],
      produk : [],
      dialog : false,
      alamatNotFound : '',
      cctv : false,
      vcon : false,
      smart : false,
      dataImages : []
    }
  },
  methods : {
     addKategoriProduk: function(val) {
       this.kategoriProduk = val
     },

     addKategoriBangunan: function(val) {
       this.kategoriBangunan = val
     },

     post: function(){
       this.alamatUser = true;
     },

     onSelectMultipleImage: function(){
       this.produk += produk.nama; 
     },

     depressedButton: function(val){
       alert(val)
       if (val === 'cctv'){
         alert(val)
         this.cctv = true
         this.vcon = !this.cctv
         this.smart = !this.cctv
       }
       else if (val === 'vcons'){
         alert(val)
         this.vcon = true
         this.cctv = !this.vcon
         this.smart = !this.vcon
       }
       else if (val === 'smart'){
         this.smart = true
         this.cctv = !this.smart
         this.vcon = !this.smart
       }
     }
   },
  mounted() {
    axios.get('http://localhost:8080/api/provinsi/list')
    .then(response => (this.provinsis = response.data.result)),

    axios.get('http://localhost:8080/api/produk.list')
    .then(response => (this.produks = response.data.result))
  },

  watch : { 
    namaProvinsi: function (val){
      axios
      .get('http://localhost:8080/api/KabKota/provinsi/' + this.namaProvinsi)
      .then(response => {
        this.kotas = response.data.result
        console.log(this.provinsis)
        console.log(this.kotas)
      })
    },
    
    namaKota: function (val){
      axios.get('http://localhost:8080/api/kecamatan/kabKota/' + this.namaKota)
      .then(response => (this.kecamatans = response.data.result))
    },

    kategoriProduk: function (val){
      axios.get('http://localhost:8080/api/produk/list/' + this.kategoriProduk)
      .then(response => {
        let formatted = []
        let getData = response.data.result
        for (var ket in getData){
          formatted.push({
            id: getData[key].id_produk,
            src: getData[key].image,
            alt: getData[key].nama,
          })
        }
        this.dataImages = formatted
        console.log(this.dataImages)
      })
    }
  }
};
</script>