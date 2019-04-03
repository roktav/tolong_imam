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
                            :rules="[rules.required, rules.counter]"
                            label="Nama Produk"
                            counter
                            maxlength="30"
                    ></v-text-field>
                </v-flex>
                <v-flex xs12 sm6>
                    <v-text-field
                            v-model="price"
                            :rules="[rules.required, rules.price]"
                            label="Harga"
                            prefix="Rp "
                    ></v-text-field>
                </v-flex>
                <v-flex xs12 sm6>
                    <v-text-field
                            :rules="[rules.required, rules.counter_spec]"
                            label="Spesifikasi"
                            counter
                            maxlength="200"
                    ></v-text-field>
                </v-flex>
            </div>
        </v-card-text>
        <v-card-actions>
            <div class="button">
                <v-btn class="white--text" color="#009688"
                       router :to="'/list-produk/detail-produk/:id_produk'">Simpan</v-btn>
                <v-btn class="white--text" color="#EF5350"
                       router :to="'/list-produk'">Batal</v-btn>
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
                //info: null,
                title: '',
                email: '',
                rules: {
                    required: value => !!value || 'Required',
                    counter: value => value.length <= 30 || 'Maksimum 30 karakter',
                    counter_spec: value => value.length <= 200 || 'Maksimum 200 karakter',
                    price: value => {
                        const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
                        return pattern.test(value) || 'Invalid'
                    }
                }
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
