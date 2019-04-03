<template>
    <v-app>
        <nav-side-bar></nav-side-bar>
        <div id="tambah-produk">
            <h4 class ="display-1 font-weight-medium" align="left">Tambah Produk</h4>
            <br>
        </div>
        <v-card-text>
            <img class = "avatar left leftmargin" src="@/assets/images/addPicture.png">
            <div class="detail">
                <v-flex xs12 sm6>
                    <v-text-field
                            label="Nama Produk"
                            outline
                            clearable
                    ></v-text-field>
                </v-flex>
                <v-flex xs12 sm6>
                    <v-text-field
                            label="Harga"
                            outline
                            clearable
                    ></v-text-field>
                </v-flex>
                <v-flex xs12 sm6>
                    <v-text-field
                            label="Spesifikasi"
                            outline
                            clearable
                    ></v-text-field>
                </v-flex>
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
        name: 'TambahProduk',
        components: {
            'nav-side-bar': NavSideBar,
            'nav-footer' : Footer
        },
        data() {
            return {
                info: null,
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
        margin-left: 380px;
        margin-top: 60px;
        width: 60px;
        height: 60px;
    }
    #tambah-produk {
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
    /*.edit {
        color: #009688;
    }
    .delete {
        color: #FF3D3D
    }*/
</style>
