<template>
    <v-app>
        <nav-side-bar></nav-side-bar>
        <div id="detail-produk">
            <v-app id="inspire">
                <h4 class ="display-1 font-weight-medium" align="left">Detail Produk</h4>

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
            </v-card-text>
            <v-card-actions>
                <v-btn class="secondary">Edit</v-btn>
                <v-btn class="error">Delete</v-btn>
            </v-card-actions>
            </v-app>
        </div>

        <nav-footer></nav-footer>
    </v-app>
</template>

<script>
    import NavSideBar from './NavSideBar';
    import Footer from './Footer';
    import axios from 'axios'

    export default {
        name: 'DetaiProduk',
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

        },
        mounted() {
            axios
                .get('http://localhost:8080/api/order')
                .then(response => {
                    this.info = response.data[0]
                    console.log(this.info)
                })
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    .avatar {
        vertical-align: middle;
        width: 250px;
        height: 250px;
        border-radius: 50%;
    }
    #detail-produk {
        margin-left: 270px;
        margin-right: 30px;
        margin-top: 50px ;
    }
</style>
