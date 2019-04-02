<template>
    <v-app>
        <nav-side-bar></nav-side-bar>
        <div id="ubah-detail-produk">
            <h4 class ="display-1 font-weight-medium" align="left">Ubah Detail Produk</h4>
            <br>
        </div>
        <v-card-text>
            <img class = "avatar left leftmargin" src="@/assets/images/CCTV.jpg">
            <div class="detail">
                <v-flex xs12 sm6>
                    <v-text-field
                            value="4ch XMEYE 1080N"
                            solo
                    ></v-text-field>
                </v-flex>
                <h4 class = "body-2 left leftmargin">Kode Produk : GEDS-85204</h4> <br/>
                <h4 class = "body-2 left leftmargin">Harga : Rp800.000</h4><br/>
                <h4 class = "body-2 left leftmargin">Status : Tersedia</h4><br/><br>
                <h4 class = "body-2 left leftmargin">Spesifikasi:</h4> <br/>
                <h4 class = "body-2 left leftmargin">- Dapat digunakan untuk Android dan iOs smartphone</h4><br/>
                <h4 class = "body-2 left leftmargin">- Aplikasi menggunakan Mi Home</h4><br/>
                <h4 class = "body-2 left leftmargin">- Ir Infrared with Night Vision</h4><br/>
                <h4 class = "body-2 left leftmargin">- Micro SD 32 GB</h4><br/>
                <h4 class = "body-2 left leftmargin">- Full-HD video capture 1080p</h4><br/>
                <h4 class = "body-2 left leftmargin">- Built-in microphone and speaker</h4><br/>
                <h4 class = "body-2 left leftmargin">- Night shoot (visibility distance up to 9 m)</h4><br/>
                <h4 class = "body-2 left leftmargin">- Smoke and carbon monoxide sensors</h4><br/>
            </div>

            <div class="edit">
                <h4 class = "caption left leftmargin">Ubah Foto Produk</h4>
            </div>
        </v-card-text>
        <v-card-actions>
            <div class="button">
                <v-btn color="success">Simpan</v-btn>
                <v-btn color="error">Batal</v-btn>
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
        name: 'UbahDetailProduk',
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
        },
        dropdown: ['Tersedia', 'Tidak Tersedia']
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    .avatar {
        vertical-align: middle;
        margin-left: 310px;
        margin-top: 40px;
        width: 250px;
        height: 250px;
        border-radius: 50%;
    }
    #ubah-detail-produk {
        margin-left: 290px;
        margin-right: 50px;
        margin-top: 50px ;
    }
    .detail {
        margin-left: 660px;
    }
    .button {
        margin-left: 1000px;
        margin-top: 10px;
    }
    .edit {
        margin-left: 390px;
    }
    /*.edit {
        color: #009688;
    }
    .delete {
        color: #FF3D3D
    }*/
</style>
