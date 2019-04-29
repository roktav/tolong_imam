<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-app>
        <nav-side-bar></nav-side-bar>
        <v-card>
            <v-card-title>
                <div id="detail-pembeli">
                    <h4 class ="display-1 font-weight-medium black--text" align="left">Detail Pembeli</h4>

                </div>
            </v-card-title>
            <v-card-text>
                <img class = "avatar left leftmargin" src="@/assets/images/CCTV.jpg">
                <div class="detail">
                    <h4 class = "title left leftmargin">{{ detailPembeli.nama }}</h4> <br/> <br/>
                    <h4 class = "body-2 left leftmargin">ID Karyawan : {{ detailPembeli.no_telp }}</h4> <br><br>
                    <h4 class = "body-2 left leftmargin">Jabatan : {{ detailPembeli.email }}</h4><br/><br>
                    <h4 class = "body-2 left leftmargin">Nomor Ponsel : {{ detailPembeli.alamat}}</h4><br/><br>
                </div>
            </v-card-text>
            <v-card-actions>
                <div class="button">

                    <v-btn class="white--text" color="#009688" @click.native="ubahPembeli">Ubah</v-btn>
                    <v-dialog v-model="dialog" persistent max-width="400">
                        <template v-slot:activator="{ on }">
                            <v-btn class="white--text" color="#EF5350" v-on="on">Hapus</v-btn><br><br><br><br><br><br>
                        </template>
                        <v-card>
                            <v-card-title class="headline justify-center">Produk akan dihapus!</v-card-title>
                            <v-card-text>Apakah Anda yakin ingin menghapus produk?</v-card-text>
                            <v-card-actions>
                                <v-spacer></v-spacer>
                                <v-btn color="green darken-4" flat @click="hapusPembeli">Ya</v-btn>
                                <v-btn color="green darken-4" flat @click="dialog = false">Tidak</v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-dialog>
                </div>
            </v-card-actions>
        </v-card>
        <nav-footer-admin></nav-footer-admin>
    </v-app>
</template>

<script>
    import NavSideBar from './NavSideBar';
    import FooterAdmin from './FooterAdmin';
    import axios from 'axios'

    export default {
        name: 'DetailPembeli',
        components: {
            'nav-side-bar': NavSideBar,
            'nav-footer-admin' : FooterAdmin
        },
        data() {
            return {
                detailPembeli: [],
                dialog: false
            }
        },
        props: {
            source: String,

        },

        methods: {
            ubahPembeli(){
                this.$router.push('ubah-detail-pembeli/' + this.$route.params.id_user)
            },
            hapusPembeli(){

                axios.post('http://localhost:8080/pembeli/delete/' + this.$route.params.id_user)
                    .then(response => {
                        this.$router.push('/')
                    })
            }

        },
        mounted(){
            axios.get('http://localhost:8080/pembeli/detail-pembeli/' + this.$route.params.id_user)
                .then(response => {
                    this.detailPembeli = response.data.result
                    console.log(this.detailPembeli)
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
        margin-left: 274px;
        margin-right: 50px;
        margin-top: 44px ;
    }
    .detail {
        margin-left: 640px;
        margin-top: 30px;
    }
    .button {
        margin-left: 1000px;
        margin-top: 10px;
    }

</style>
