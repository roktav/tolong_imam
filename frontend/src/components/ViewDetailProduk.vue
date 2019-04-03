<template>
    <v-app>
        <nav-side-bar></nav-side-bar>
        <div id="detail-produk">
            <h4 class ="display-1 font-weight-medium" align="left">Detail Produk</h4>
            <br>
        </div>
        <v-card-text>
            <img class = "avatar left leftmargin" src="@/assets/images/CCTV.jpg">
            <div class="detail">
                <h4 class = "title left leftmargin">{{ detailProduk.nama }}</h4> <br/> <br/>
                <h4 class = "body-2 left leftmargin">Kode Produk : {{ detailProduk.kode_produk }}</h4> <br/>
                <h4 class = "body-2 left leftmargin">Harga : Rp {{ detailProduk.harga }}</h4><br/>
                <h4 class = "body-2 left leftmargin">Status : {{ detailProduk.status }}</h4><br/><br>
                <h4 class = "body-2 left leftmargin">Spesifikasi:</h4> <br/>
                <h4 class = "body-2 left leftmargin">{{ detailProduk.detail_produk }}</h4><br/>
            </div>

        </v-card-text>
        <v-card-actions>
            <div class="button">
                <v-btn class="white--text" color="#009688"
                       router :to="'/list-produk/detail-produk/ubah-detail-produk'">Ubah</v-btn>
                <v-btn class="white--text" color="#EF5350">Hapus</v-btn>
            </div>
        </v-card-actions>
        <nav-footer></nav-footer>
    </v-app>
</template>

<script>
    import NavSideBar from './NavSideBar';
    import Footer from './Footer';
    import axios from 'axios'

    export default {
        name: 'DetailProduk',
        components: {
            'nav-side-bar': NavSideBar,
            'nav-footer' : Footer
        },
        data() {
            return {
                detailProduk: []
            }
        },
        props: {
            source: String
        },

        methods: {

        },
        mounted(){
            axios.get('http://localhost:8080/api/list-produk/detail-produk/1')
                .then(response => {
                    this.detailProduk = response.data.result
                    console.log(response.data)
                })
                .catch(e => {
                    console.log(e)
                })
        },
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    .avatar {
        vertical-align: middle;
        margin-left: 310px;
        margin-top: 10px;
        width: 250px;
        height: 250px;
        border-radius: 50%;
    }
    #detail-produk {
        margin-left: 290px;
        margin-right: 50px;
        margin-top: 50px ;
    }
    .detail {
        margin-left: 660px;
        margin-top: 30px;
    }
    .button {
        margin-left: 1000px;
        margin-top: 10px;
    }
    /*.edit {
        color: #009688;
    }
    .delete {
        color: #FF3D3D
    }*/
</style>
