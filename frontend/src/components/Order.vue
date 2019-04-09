<template>
    <v-app>
        <nav-bar></nav-bar>
        <h4 class = "display-1 left leftmargin">Pemesanan Produk</h4>
        <div class = "step1">
            <h4>Cek Area</h4>
            <label>Provinsi</label>
            <select v-model="dataOrder.provinsi">
                <option v-for= "provinsi in provinsis" :key="provinsi">{{ provinsi }}</option>
            </select>
            <label>Kabupaten/Kota</label>
            <select v-model="dataOrder.kota">
                <option v-for= "kota in kotas" :key="kota">{{ kota }}</option>
            </select>
            <label>Kecamatan</label>
            <select v-model="dataOrder.kecamatan">
                <option v-for= "kecamatan in kecamatans" :key="kecamatan">{{ kecamatan }}</option>
            </select>
            <br>
            <button>Alamat tidak ditemukan</button>
            <br>
            <button>Lanjutkan</button>
        </div>
        <div class="step2">
            <h4>Pilih Produk</h4>

        </div>
        <div class = "step3">
        <form v-if = "!submitted">
            <label class = "left leftmargin" >Nama Depan </label>
            <input class = "left leftmargin" type="text" v-model="dataOrder.namaDepan"/> <br><br>
            <label class = "left leftmargin" >Nama Belakang </label>
            <input class = "left leftmargin" type="text" v-model="dataOrder.namaBelakang"/> <br><br>
            <label class = "left leftmargin" >E-mail </label>
            <input class = "left leftmargin" type="text" v-model="dataOrder.email"/> <br><br>  
            <label class = "left leftmargin" >Nomor Ponsel </label>
            <input class = "left leftmargin" type="text" v-model="dataOrder.nomorPonsel"/> <br><br> 
            <label class = "left leftmargin" >Alamat Lengkap </label>
            <textarea class = "left leftmargin" v-model="dataOrder.alamatLengkap"></textarea> <br><br>  
            <button v-on:click="post">Submit</button>     
        </form>
        </div>
        <div>
            <img v-on:click="testClickableImage" class = "avatar left leftmargin" src="@/assets/images/padli.jpg">
            <img v-on:click="test2" class = "avatar left leftmargin" src="@/assets/images/glenz.png">
        </div>
        <div class = "step4" v-if = "submitted">
            <p>Nama depan : {{ dataOrder.namaDepan }}</p>
            <p>Nama belakang : {{ dataOrder.namaBelakang }}</p>
            <p>Alamat e-mail : {{ dataOrder.email }}</p>
            <p>Nomor ponsel : {{ dataOrder.nomorPonsel }}</p>
            <p>Alamat : {{ dataOrder.alamatLengkap }}</p>
            <p>Provinsi : {{ dataOrder.provinsi }}</p>
            <p>Kota : {{ dataOrder.kota }}</p>
            <p>Kecamatan : {{ dataOrder.kecamatan }}</p>
        </div>
        
        <p v-if = "submitted"> Data Submitted</p>
        <nav-footer></nav-footer>
    </v-app>
</template>

<script>
import NavBar from './NavBarVuetify';
import Footer from './Footer';

export default {
    name: 'Order',
    components: {
      'nav-bar': NavBar,
      'nav-footer' : Footer
    },
    el : '#app',
    data () {
        return {
            dataOrder : {
                namaDepan : '',
                namaBelakang : '',
                email : '',
                nomorPonsel : '',
                alamatLengkap : '',
                provinsi : '',
                kota : '',
                kecamatan : ''
            },
            submitted : false,
            provinsis : ['JawaBarat', 'DKIJakarta'],
            kotas : ['bogor', 'jakartaSelatan'],
            kecamatans : ['a', 'b', 'c']
        }
    },
    methods : {
        post: function(){
            this.submitted = true;
        },
        testClickableImage: function(){
            this.$router.push('admin-teknisi/profile');
        },
        test2: function(){
            this.dataOrder.email = "Ini email baru";
        }
    }
}
</script>

<style>
input[type="text"], textarea{
    display: inline-flex;
    width: 100%;
    padding: 8px;
}

.avatar {
  vertical-align: middle;
  width: 250px;
  height: 250px;
  border-radius: 50%;
}
</style>
