<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-app>
        <nav-side-bar></nav-side-bar>
        <div id="tambah-produk">
            <h4 class ="display-1 font-weight-medium black--text" align="left">Tambah Produk</h4>
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
                    <p class="kategori" align="left">Kategori Produk</p>
                    <v-overflow-btn
                            label="Pilih Kategori"
                            :items="dropdown_kategori"
                            v-model="newProduk.kategori_produk"
                            target="#dropdown-example"
                    ></v-overflow-btn>

                </v-flex>
                <v-flex xs12 sm6>
                    <v-text-field
                            v-model="newProduk.harga"
                            :rules="[rules.required, rules.prices]"
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
                        <v-date-picker v-model="date" min="2019-04-10" no-title scrollable @input="menu=false, $refs.menu.save(date)">

                        </v-date-picker>
                    </v-menu>
                </v-flex>
                <v-flex>
                    <div>
                        <h3 class="unggah-foto font-weight-medium">Unggah Foto Produk</h3>
                    </div>
                </v-flex>
            </div>
            <v-flex xs12 sm2>
                <div v-if="!image">

                    <v-btn raised class="secondary" @click="onPickFile">Upload image</v-btn>
                    <input type="file" style="display:none" ref="fileInput" accept="image/*" @change="onFileChange">
                </div>
                <div v-else>
                    <img :src="imageUrl" />
                    <button @click="removeImage">Hapus</button>
                </div>
            </v-flex>
        </v-card-text>
        <v-card-actions>
            <div class="button">
                <v-btn class="white--text secondary"
                       @click.native="addProduk">Simpan</v-btn>
                <v-btn class="white--text warning"
                       router :to="'/list-produk'">Batal</v-btn>
            </div>
        </v-card-actions><br><br><br><br><br><br>
        <v-snackbar v-model="snack" :timeout="3000" :color="snackColor">
            {{ snackText }}
            <v-btn flat @click="snack = false">Close</v-btn>
        </v-snackbar>
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
                    kategori_produk: null,
                    kode_produk: "GEDS-85200",
                    detail_produk: null,
                    status: "Tersedia",
                    harga: null,
                    foto_produk: null,
                    tgl_garansi: null

                },
                title: '',
                email: '',
                idProduk: null,
                rules: {
                    required: value => !!value || 'Required',
                    counter: value => value.length <= 30 || 'Maksimum 30 karakter',
                    counter_spec: value => value.length <= 200 || 'Maksimum 200 karakter',
                    prices: value => {
                        const pattern = /^([0-9]+)$/
                        return pattern.test(value) || 'Masukkan angka'
                    }

                },
                date: new Date().toISOString().substr(0, 10),
                menu: false,
                modal: false,
                menu2: false,
                dropdown_kategori: ['CCTV', 'Smart Living', 'Video Conference'],
                snack: false,
                snackColor: '',
                snackText: '',
                image: null,
                imageUrl: ''
            }
        },
        props: {
            source: String
        },
        computed: {
          formIsValid(){
              return this.newProduk.nama !== '' &&
                      this.newProduk.kategori_produk !== '' &&
                      this.newProduk.harga !== '' &&
                      this.newProduk.detail_produk !== '' &&
                      this.newProduk.tgl_garansi !== '' &&
                      this.imageUrl !== ''
          }
        },
        methods: {
            addProduk(){
               /* if(!this.formIsValid){
                    return
                }
                if(!this.image){
                    return
                }
                const tambahProduk = {
                    nama: this.newProduk.nama,
                    kategori: this.newProduk.kategori_produk,
                    harga: this.newProduk.harga,
                    detail: this.newProduk.detail_produk,
                    tglgaransi: this.newProduk.tgl_garansi,
                    imageUrl: this.imageUrl
                }
                this.$store.dispatch('addProduk', tambahProduk)
                this.$router.push()*/

                /*const x =  newProduk.nama
                const y = newproduk.detail_produk
                if(x == null || x == "" || y == null || y == ""){
                    alert("Data gagal tersimpan")
                }else{*/
                this.snack = true
                this.snackColor = 'success'
                this.snackText = 'Data berhasil disimpan'
                console.log(this.newProduk)
                let productFormData = new FormData()
                for ( var key in this.newProduk ) {
                    productFormData.append(key, this.newProduk[key]);
                }

                for (var pair of productFormData.entries()) {
                    console.log(pair[0]+ ', ' + pair[1]);
                }

                axios.post('http://localhost:8080/api/list-produk/tambah-produk', productFormData, {
                    'content-type': 'multipart/form-data'
                })
                    .then(response => {
                        const idProduk = response.data.result.id_produk
                        this.$router.push(`/list-produk/detail-produk/${idProduk}`)

                    })
                    .catch(e => {
                        console.log(e)
                    })

                /*}alert("Data berhasil disimpan")*/
            },
            onPickFile(){
                this.$refs.fileInput.click();
            },
            onFileChange(e) {
                const files = e.target.files
                let filename = files[0].name
                if (filename.lastIndexOf('.')<=0) {
                    return alert('Masukkan file yang sesuai')
                }
                const fileReader = new FileReader()
                fileReader.addEventListener('load', () => {
                    this.imageUrl = fileReader.result
                })
                fileReader.readAsDataURL(files[0])
                this.image = files[0]
                this.newProduk.foto_produk = files[0]
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
    .kategori{
        font-size: medium;
        color: #757575;
        margin-bottom: 1px
    }
</style>
