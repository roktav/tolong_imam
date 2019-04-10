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
          <v-btn color="primary" @click="addKategoriBangunan('Rumah'), pressed('rumah')" :disabled="rumah">Rumah</v-btn>
          <v-btn color="primary" @click="addKategoriBangunan('Apartemen'), pressed('apart')" :disabled="apart">Apartemen</v-btn>
          <v-btn color="primary" @click="addKategoriBangunan('Ruko'), pressed('ruko')" :disabled="ruko">Ruko</v-btn>
        </v-flex>
        <v-spacer></v-spacer>
        <v-flex xs12 md6 sm6>
          <br>
          <p>Pilih Produk yang Anda Inginkan</p>
          <vue-select-image :dataImages="dataImages" 
          :is-multiple="true" 
          :useLabel="true"
          @onselectmultipleimage="onSelectMultipleImage">
          </vue-select-image>
            
            <v-flex xs12 v-if="cctv || vcon || smart">
            <v-btn @click="increaseCounter">
              <v-icon small>add</v-icon>
            </v-btn>          
            <p>Jumlah Item : {{ counterBuyer }}</p>          
            <v-btn @click="decreaseCounter">
              <v-icon small>remove</v-icon>
            </v-btn>
            </v-flex>

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
          <v-text-field type="text" v-model="listUser[0].nama" label="Nama Lengkap"></v-text-field>
          <br>
          <v-text-field type="text" v-model="listUser[0].email" label="E-mail"></v-text-field>
          <br>
          <v-text-field type="text" v-model="listUser[0].no_telp" label="Nomor Telepon"></v-text-field>
          <br>
          <v-text-field type="text" v-model="listUser[0].alamat" label="Alamat Lengkap"></v-text-field>
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
        <v-flex v-if="!readyToSubmit">
        <h4>Kirim tagihan ke alamat e-mail sesuai data registrasi?</h4>
        <v-btn @click="emailCek = true">Ya</v-btn>
        <v-btn @click="addEmail = true">Tidak</v-btn>
        <v-text-field v-if="addEmail && !emailCek" v-model="emailPembayaran" label="insert your e-mail and press enter" v-on:keyup.enter="emailCek = true"></v-text-field>
        <br>
        <p v-if="emailCek">Tagihan akan dikirim ke e-mail anda. 
          Silahkan pilih Lanjutkan untuk melihat rincian pesanan atau Kembali untuk mengubah pesanan</p>
        <br>
        <v-btn v-if="emailCek" @click="e6 = 3">Kembali</v-btn>
        <v-btn v-if="emailCek" @click="readyToSubmit = true">Lanjutkan</v-btn>
        </v-flex>
        <v-card v-if="readyToSubmit">
          <v-card-title>Informasi Data Diri</v-card-title>
          <v-card-text>
            <p>Nama : {{ listUser[0].nama }}</p>
            <p>E-mail : {{ listUser[0].email }}</p>
            <p>Nomor Ponsel : {{ listUser[0].no_telp }}</p>
            <p>Alamat Lengkap : {{ listUser[0].alamat }}</p>
          </v-card-text>
        </v-card>  
        <v-card v-if="readyToSubmit">
          <v-card-title>Informasi Pemesanan</v-card-title>
          <v-card-text>
            <p>Tanggal Pemesanan : {{ dataOrder.tgl_order }}</p>
            <p>Kategori Produk : {{ dataOrder.kategori_produk }}</p>
            <p>Nama Produk : {{ imageMultipleSelected[0].alt }}</p>
            <p>Jenis Bangunan : {{ dataOrder.jenis_bangunan }}</p>
            <p>Jumlah : {{ counterBuyer }} </p>
            <p>Total Harga : {{ harga }}</p>
          </v-card-text>
        </v-card>
        <v-btn v-if="readyToSubmit" @click="e6 = 3">Kembali</v-btn>
        <v-btn v-if="readyToSubmit" @click.native="submitForm(), snackbar=true">Pesan Sekarang</v-btn>
        <v-snackbar v-model="snackbar" auto-height=true :timeout="timeout">
          <h4>Pesanan Anda Telah Kami Terima</h4>
          <p>Terimakasih telah menggunakan WINSCORE</p>
          <p>Kami akan menghubungi Anda untuk konfirmasi pesanan</p>
          <v-btn :to="'/'">OK</v-btn>
        </v-snackbar>
      </v-card>
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
      dataOrder : {
        kategori_produk : '',
        jenis_bangunan : '',
        tgl_order : new Date().toISOString().substr(0, 10),

      },
      kategoriProduk : '',
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
      rumah : false,
      apart : false,
      ruko : false,
      dataImages : [],
      emailCek : false,
      addEmail : false,
      emailPembayaran : '',
      listUser : [],
      counterBuyer : 1,
      imageMultipleSelected : [],
      readyToSubmit : false,
      harga : 0,
      snackbar : false,
      timeout : 60000
    }
  },
  methods : {
     addKategoriProduk: function(val) {
       this.kategoriProduk = val
       this.dataOrder.kategori_produk = val
     },

     addKategoriBangunan: function(val) {
       this.dataOrder.jenis_bangunan = val
     },

     post: function(){
       this.alamatUser = true;
     },

    onSelectMultipleImage: function (data) {
      console.log('fire event onSelectMultipleImage: ', data)
      this.imageMultipleSelected = data
      console.log(this.imageMultipleSelected)
    },

     depressedButton: function(val){
       if (val === 'cctv'){
         this.cctv = true
         this.vcon = !this.cctv
         this.smart = !this.cctv
       }
       else if (val === 'vcons'){
         this.vcon = true
         this.cctv = !this.vcon
         this.smart = !this.vcon
       }
       else if (val === 'smart'){
         this.smart = true
         this.cctv = !this.smart
         this.vcon = !this.smart
       }
     },

     pressed: function(val){
       if (val === 'rumah'){
         this.rumah = true
         this.apart = !this.rumah
         this.ruko = !this.rumah
       }
       else if(val === 'apart'){
         this.apart = true
         this.rumah = !this.apart
         this.ruko = !this.apart
       }
       else if(val === 'ruko'){
         this.ruko = true
         this.rumah = !this.ruko
         this.apart = !this.ruko
       }
     },

     increaseCounter: function(){
       this.counterBuyer += 1;
     },
     decreaseCounter: function(){
       if (this.counterBuyer > 1){
         this.counterBuyer -= 1;
       }
     },
     submitForm: function(){
       console.log(this.dataOrder)
       axios.post('http://localhost:8080/api/order/post', this.dataOrder)
       
     }
   },
   
  mounted() {
    axios.get('http://localhost:8080/api/provinsi/list')
    .then(response => (this.provinsis = response.data.result))

    axios.get('http://localhost:8080/api/user/list')
    .then(response => {
      this.listUser = response.data.result
      console.log(this.listUser)
    })
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
      axios.get('http://localhost:8080/api/produk/list/' + this.dataOrder.kategori_produk)
      .then(response => {
        let formatted = []
        let getData = response.data.result
        for (var key in getData){
          formatted.push({
            id: getData[key].id_produk,
            src: getData[key].image,
            alt: getData[key].nama,
            harga: getData[key].harga
          })
        }
        this.dataImages = formatted
      })
    },

    counterBuyer: function(){
      this.harga = this.counterBuyer * this.imageMultipleSelected[0].harga
      console.log(this.counterBuyer)
      console.log(this.imageMultipleSelected[0].harga)
      console.log("INI PAD HARGANYA ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^")


    }
  }
};
</script>