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
                <v-flex sm6>
                    <v-text-field
                            value="GEDS-85200"
                            label="Kode Produk"
                            disabled
                    ></v-text-field>
                </v-flex>
                <v-flex xs12 sm6>
                    <v-text-field
                            value="4ch XMEYE 1080N"
                            label="Nama Produk"
                            clearable
                    ></v-text-field>
                </v-flex>
                <v-flex xs12 sm6>
                    <v-text-field small
                            value="Rp 800000"
                            label="Harga"
                            clearable
                    ></v-text-field>
                </v-flex>
                <v-flex xs12 sm6>
                    <v-text-field
                            value="Menggunakan aplikasi Mi Home"
                            label="Spesifikasi"
                            clearable
                    ></v-text-field>
                </v-flex>
                <v-flex xs12 sm6>
                    <p class="status" align="left">Status</p>
                    <v-overflow-btn
                            label="Tersedia"
                            :items="dropdown_status"
                            target="#dropdown-example"
                    ></v-overflow-btn>

                </v-flex>
            </div>
        </v-card-text>
        <v-flex>
            <v-btn class="edit-photo"
                   flat
                   small
                   :position-x="x"
                   :position-y="y"
                   router-link :to="'/list-produk'"
                >Ubah Foto Produk
            </v-btn>
        </v-flex>
        <v-card-actions>
            <div class="button">
                <v-btn class="white--text" color="#009688"
                       router :to="'/list-produk/detail-produk/:id_produk'">Simpan</v-btn>
                <v-btn class="white--text" color="#EF5350"
                       router :to="'/list-produk/detail-produk/:id_produk'">Batal</v-btn>

            </div>
        </v-card-actions>
        <br><br><br><br>
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
                info: null,
                dropdown_status: ['Tersedia', 'Tidak Tersedia']
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

    .status {
        font-size: smaller;
        color: #757575;
        margin-bottom: 1px
    }
    .edit-photo {
        font-size: x-small;
        margin-left: 5px;

    }

    /*.edit {
        color: #009688;
    }
    .delete {
        color: #FF3D3D
    }*/
</style>
