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
                <v-flex sm8>
                    <v-text-field
                            v-model="ubahDetailProduk.kode_produk"
                            value="GEDS-85200"
                            label="Kode Produk"
                            disabled
                    ></v-text-field>
                </v-flex>
                <v-flex xs12 sm8>
                    <v-text-field
                            v-model="ubahDetailProduk.nama"
                            value="4ch XMEYE 1080N"
                            label="Nama Produk"
                            clearable
                    ></v-text-field>
                </v-flex>
                <v-flex xs12 sm8>
                    <v-text-field small
                                  v-model="ubahDetailProduk.harga"
                            value="Rp 800000"
                            label="Harga"
                            clearable
                    ></v-text-field>
                </v-flex>
                <v-flex xs12 sm8>
                    <v-text-field
                            v-model="ubahDetailProduk.detail_produk"
                            value="Menggunakan aplikasi Mi Home"
                            label="Spesifikasi"
                            clearable
                    ></v-text-field>
                </v-flex>
                <v-flex xs12 sm8>
                    <v-menu
                            ref="menu"
                            v-model="menu"
                            :close-on-content-click="false"
                            :nudge-right="100"
                            :return-value.sync="ubahDetailProduk.id_garansi.tgl_kadaluarsa"
                            lazy
                            transition="scale-transition"
                            offset-y
                            full-width
                            min-width="290px"
                    >
                        <template v-slot:activator="{ on }">
                            <v-text-field
                                    v-model="ubahDetailProduk.id_garansi.tgl_kadaluarsa"
                                    label="Tanggal Batas Garansi"
                                    prepend-icon="event"
                                    v-on="on"
                                    clearable
                            ></v-text-field>
                        </template>
                        <v-date-picker v-model="date" no-title scrollable>
                            <v-spacer></v-spacer>
                            <v-btn flat color="primary" @click="menu = false">Cancel</v-btn>
                            <v-btn flat color="primary" @click="$refs.menu.save(date)">OK</v-btn>
                        </v-date-picker>
                    </v-menu>
                </v-flex>

                <v-flex xs12 sm8>
                    <p class="status" align="left">Status</p>
                    <v-overflow-btn
                            label="Tersedia"
                            :items="dropdown_status"
                            v-model="ubahDetailProduk.status"
                            target="#dropdown-example"
                    ></v-overflow-btn>

                </v-flex>
            </div>
        </v-card-text>
        <div class="app">
            <div class="choose-button" v-if="!image">
                <input type="file" @change="onFileChange">
            </div>
            <div v-else>
                <img :src="image" />
                <button @click="removeImage">Hapus</button>
            </div>
        </div>
        <v-card-actions>
            <div class="button">
                <v-btn class="white--text" color="#009688"
                       @click.native="updateProduk">Simpan</v-btn>
                <v-btn class="white--text" color="#EF5350">Batal</v-btn>

            </div>
        </v-card-actions>
        <br><br><br>
        <nav-footer-admin></nav-footer-admin>
    </v-app>
</template>

<script>
    import NavSideBar from './NavSideBar';
    import FooterAdmin from './FooterAdmin';
    import axios from 'axios'

    export default {
        name: 'UbahDetailProduk',
        components: {
            'nav-side-bar': NavSideBar,
            'nav-footer-admin' : FooterAdmin
        },
        data() {
            return {
                image:'',
                ubahDetailProduk: [],
                dropdown_status: ['Tersedia', 'Tidak Tersedia'],
                date: new Date().toISOString().substr(0, 10),
                menu: false,
                modal: false,
                menu2: false
            }
        },
        props: {
            source: String
        },

        methods: {
            updateProduk(){
                console.log(this.ubahDetailProduk),
                    axios.post('http://localhost:8080/api/list-produk/detail-produk/' + this.$route.params.id_produk + '/ubah-detail-produk/', this.ubahDetailProduk)
                        .then(response => {
                            const idProduk = response.data.result.id_produk

                            this.$router.push(`/list-produk/detail-produk/${idProduk}`)
                        })
            },
            /*cancelUpdate(){
                this.$router.push('http://localhost:8080/api/list-produk/detail-produk/' + this.$route.params.id_produk)

            },*/


            onFileChange(e) {
                var files = e.target.files || e.dataTransfer.files;
                if (!files.length)
                    return;
                this.createImage(files[0]);
            },
            createImage(file) {
                const image = new Image();
                const reader = new FileReader();
                const vm = this;

                reader.onload = (e) => {
                    vm.image = e.target.result;
                };
                reader.readAsDataURL(file);
            },
            removeImage: function (e) {
                this.image = '';
            }
        },
        mounted() {
            console.log('text')
            axios
                .get('http://localhost:8080/api/list-produk/detail-produk/' + this.$route.params.id_produk)
                .then(response => {
                    this.ubahDetailProduk = response.data.result
                    console.log(this.ubahDetailProduk)
                })
                .catch(e => {
                    console.log(e)
                })
            console.log(this.ubahDetailProduk)
        },
        dropdown: ['Tersedia', 'Tidak Tersedia']
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    .avatar {
        vertical-align: middle;
        margin-left: 310px;
        margin-top: 80px;
        width: 250px;
        height: 250px;
        border-radius: 50%;
    }
    #ubah-detail-produk {
        margin-left: 290px;
        margin-right: 50px;
        margin-top: 60px ;
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

    .app {
        text-align: left;
        margin-left: 0px;
    }
    img {
        width: 20%;
        margin-left: 330px;
        display: block;
        margin-bottom: 10px;
    }
    button {
        margin-left: 330px;
        color: #757575;
    }
    .choose-button {
        margin-left: 330px;

    }
</style>
