<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-app>
        <nav-side-bar></nav-side-bar>
        <v-card>
        <v-card-title>
        <div id="detail-produk">
            <h4 class ="display-1 font-weight-medium black--text" align="left">Profile</h4>

        </div>
        </v-card-title>
        <v-card-text>
            <img class = "avatar left leftmargin" src="@/assets/images/padli.jpg">
            <div class="detail">
                <h4 class = "title left leftmargin">Reihan Frandha</h4> <br/> <br/>
                <h4 class = "body-2 left leftmargin">Status       	 : Aktif</h4> <br><br>
                <h4 class = "body-2 left leftmargin">ID Karyawan  	 : UBP131245029</h4><br/><br>
                <h4 class = "body-2 left leftmargin">Jabatan      	 : Manajer Operasional</h4><br/><br>
                <h4 class = "body-2 left leftmargin">Role        	 : Manajer Teknisi</h4><br/><br>
                <h4 class = "body-2 left leftmargin">Kantor Cabang	 : TB Simatupang</h4> <br/><br>
                <h4 class = "body-2 left leftmargin">Nomor Handphone : 081380831321</h4><br/><br>
                <h4 class = "body-2 left leftmargin">Email           : yesjadimanajer@winscore.com</h4><br/><br>
                <h4 class = "body-2 left leftmargin">Alamat          : Istiqlal </h4><br/><br>
            </div>
        </v-card-text>
        <v-card-actions>
            <div class="button">

                <v-btn class="white--text" color="#009688" @click.native="ubahProduk">Ubah</v-btn>
                <v-dialog v-model="dialog" persistent max-width="400">
                    <template v-slot:activator="{ on }">
                        <v-btn class="white--text" color="#EF5350" v-on="on">Hapus</v-btn><br><br><br><br><br><br>
                    </template>
                    <v-card>
                        <v-card-title class="headline justify-center">Produk akan dihapus!</v-card-title>
                        <v-card-text>Apakah Anda yakin ingin menghapus produk?</v-card-text>
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn color="green darken-4" flat @click="hapusProduk">Ya</v-btn>
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
    import NavSideBarMT from './NavSideBarMT';
    import FooterAdmin from './FooterAdmin';
    import axios from 'axios'

    export default {
        name: 'DetailProduk',
        components: {
            'nav-side-bar': NavSideBarMT,
            'nav-footer-admin' : FooterAdmin
        },
        data() {
            return {
                detailProduk: [],
                dialog: false
            }
        },
        props: {
            source: String,

        },

        methods: {
            ubahProduk(){
                this.$router.push(this.$route.params.id_produk + '/ubah-detail-produk')
            },
            hapusProduk(){

                axios.post('http://localhost:8080/api/list-produk/' + this.$route.params.id_produk)
                    .then(response => {
                        this.$router.push('/list-produk')
                    })
            }

        },
        mounted(){

            axios.get('http://localhost:8080/api/list-produk/detail-produk/' + this.$route.params.id_produk)
                .then(response => {
                    this.detailProduk = response.data.result
                    console.log(this.detailProduk)
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
