<!--<template>
    <v-app>
        <nav-side-bar></nav-side-bar>
        <div id="tambah-produk">
            <h4 class ="display-1 font-weight-medium" align="left">Tambah Produk</h4>
            <br>
        </div>
        <v-card-text>
            <div class="detail">
                <v-flex xs12 sm6>
                    <v-text-field
                            v-model="newProduk.nama"
                            :rules="[rules.required, rules.counter]"
                            label="Nama Produk"
                            counter
                            clearable
                            maxlength="30"
                    ></v-text-field>
                </v-flex>
                <v-flex xs12 sm6>
                    <v-text-field
                            v-model="newProduk.harga"
                            :rules="[rules.required]"
                            label="Harga"
                            prefix="Rp "
                            clearable
                    ></v-text-field>
                </v-flex>
                <v-flex xs12 sm6>
                    <v-text-field
                            v-model="newProduk.detail_produk"
                            :rules="[rules.required, rules.counter_spec]"
                            label="Spesifikasi"
                            counter
                            maxlength="200"
                            clearable
                    ></v-text-field>
                </v-flex>
                <v-flex xs12 sm6>
                    <v-menu
                            ref="menu"
                            v-model="menu"
                            :close-on-content-click="false"
                            :nudge-right="100"
                            :return-value.sync="newProduk.tgl_garansi"
                            lazy
                            transition="scale-transition"
                            offset-y
                            full-width
                            min-width="290px"
                    >
                        <template v-slot:activator="{ on }">
                            <v-text-field
                                    v-model="newProduk.tgl_garansi"
                                    label="Tanggal Batas Garansi"
                                    prepend-icon="event"
                                    readonly
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
                <v-flex>
                    <div>
                        <h3 class="unggah-foto font-weight-medium">Unggah Foto Produk</h3>
                    </div>
                </v-flex>
            </div>
            <div class="app">
                <div class="choose-button" v-if="!image">
                    <input type="file" @change="onFileChange">
                </div>
                <div v-else>
                    <img :src="image" />
                    <button @click="removeImage">Hapus</button>
                </div>
            </div>
        </v-card-text>

        <v-card-actions>
            <div class="button">
                <v-btn class="white&#45;&#45;text" color="#009688"
                       @click.native="addProduk">Simpan</v-btn>
                <v-btn class="white&#45;&#45;text" color="#EF5350"
                       router :to="'/list-produk'">Batal</v-btn>
                <br><br><br><br><br>
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

        el: '#app',
        name: 'TambahProduk',
        components: {
            'nav-side-bar': NavSideBar,
            'nav-footer' : Footer
        },
        data() {
            return {
                image: '',
                newProduk: {
                    nama: null,
                    kode_produk: "GEDS-85200",
                    detail_produk: null,
                    status: "Tidak Tersedia",
                    harga: null,
                    tgl_garansi: null

                },
                title: '',
                email: '',
                idProduk: null,
                rules: {
                    required: value => !!value || 'Required',
                    counter: value => value.length <= 30 || 'Maksimum 30 karakter',
                    counter_spec: value => value.length <= 200 || 'Maksimum 200 karakter',

                },
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

            addProduk(){
                alert(this.newProduk),
                    axios.post('http://localhost:8080/api/list-produk/tambah-produk', this.newProduk)
                        .then(response => {
                            const idProduk = response.data.result.id_produk
                            this.$router.push(`/list-produk/detail-produk/${idProduk}`)
                        })
            },

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
        /*mounted() {
            axios
                .get('http://localhost:8080/api/list-produk/tambah-produk')
                .then(response => {
                    this.newProduk = response.data.result
                    console.log(response.data)
                })
                .catch(e => {
                    console.log(e)
                })
        }*/
    }
</script>

&lt;!&ndash; Add "scoped" attribute to limit CSS to this component only &ndash;&gt;
<style scoped>

    #tambah-produk {
        margin-left: 290px;
        margin-right: 50px;
        margin-top: 50px ;
    }
    .detail {
        margin-left: 330px;
    }
    .button {
        margin-left: 1000px;
        margin-top: 10px;
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
    .unggah-foto {
        text-align: left;
        margin-left: 0px;
        color: #757575;
        font-size: 15px;
    }
    .choose-button {
        margin-left: 330px;

    }
</style>-->
<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-app>
        <nav-side-bar></nav-side-bar>
        <div id="tambah-produk">
            <h4 class ="display-1 font-weight-medium" align="left">Tambah Produk</h4>
            <br>
        </div>
        <v-card-text>


            <div class="detail">
                <v-flex xs12 sm6>
                    <v-text-field
                            v-model="newProduk.nama"
                            :rules="[rules.required, rules.counter]"
                            label="Nama Produk"
                            counter
                            clearable
                            maxlength="30"
                    ></v-text-field>
                </v-flex>
                <v-flex xs12 sm6>
                    <v-text-field
                            v-model="newProduk.harga"
                            :rules="[rules.required]"
                            label="Harga"
                            prefix="Rp "
                            clearable
                    ></v-text-field>
                </v-flex>
                <v-flex xs12 sm6>
                    <v-text-field
                            v-model="newProduk.detail_produk"
                            :rules="[rules.required, rules.counter_spec]"
                            label="Spesifikasi"
                            counter
                            maxlength="200"
                            clearable
                    ></v-text-field>
                </v-flex>
                <v-flex xs12 sm6>
                    <v-menu
                            ref="menu"
                            v-model="menu"
                            :close-on-content-click="false"
                            :nudge-right="100"
                            :return-value.sync="newProduk.tgl_garansi"
                            lazy
                            transition="scale-transition"
                            offset-y
                            full-width
                            min-width="290px"
                    >
                        <template v-slot:activator="{ on }">
                            <v-text-field
                                    v-model="newProduk.tgl_garansi"
                                    label="Tanggal Batas Garansi"
                                    prepend-icon="event"
                                    readonly
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
                <v-flex>
                    <div>
                        <h3 class="unggah-foto font-weight-medium">Unggah Foto Produk</h3>
                    </div>
                </v-flex>
            </div>
            <div class="app">
                <div class="choose-button" v-if="!image">
                    <input type="file" @change="onFileChange">
                </div>
                <div v-else>
                    <img :src="image" />
                    <button @click="removeImage">Hapus</button>
                </div>
            </div>
        </v-card-text>
        <v-card-actions>
            <div class="button">
                <v-btn class="white--text" color="#009688"
                       @click.native="addProduk">Simpan</v-btn>
                <v-btn class="white--text" color="#EF5350"
                       router :to="'/list-produk'">Batal</v-btn>
            </div>
        </v-card-actions><br><br><br>
        <nav-footer-admin></nav-footer-admin>
    </v-app>

</template>

<script>
    import NavSideBar from './NavSideBar';
    import FooterAdmin from './FooterAdmin';
    import axios from 'axios'

    export default {

        name: 'TambahProduk',
        components: {
            'nav-side-bar': NavSideBar,
            'nav-footer-admin' : FooterAdmin
        },
        el: '#app',
        data() {
            return {
                newProduk: {
                    nama: null,
                    kode_produk: "GEDS-85200",
                    detail_produk: null,
                    status: "Tersedia",
                    harga: null,
                    tgl_garansi: null

                },
                title: '',
                email: '',
                idProduk: null,
                rules: {
                    required: value => !!value || 'Required',
                    counter: value => value.length <= 30 || 'Maksimum 30 karakter',
                    counter_spec: value => value.length <= 200 || 'Maksimum 200 karakter',

                },
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

            addProduk(){
                alert(this.newProduk),
                    axios.post('http://localhost:8080/api/list-produk/tambah-produk', this.newProduk)
                        .then(response => {
                            const idProduk = response.data.result.id_produk
                            this.$router.push(`/list-produk/detail-produk/${idProduk}`)
                        })
            },
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
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    #tambah-produk {
        margin-left: 290px;
        margin-right: 50px;
        margin-top: 60px ;
    }
    .detail {
        margin-left: 330px;
    }
    .button {
        margin-left: 1000px;
        margin-top: 10px;
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
    .unggah-foto {
        text-align: left;
        margin-left: 0px;
        color: #757575;
        font-size: 15px;
    }
    .choose-button {
        margin-left: 330px;

    }
</style>
