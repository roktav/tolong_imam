<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-app>
        <nav-side-bar></nav-side-bar>
        <v-card>
            <v-card-title>
                <div id="detail-admin">
                    <h4 class ="display-1 font-weight-medium black--text" align="left">Detail Admin</h4>

                </div>
            </v-card-title>
            <v-card-text>
                <img class = "avatar left leftmargin" src="@/assets/images/CCTV.jpg">
                <div class="detail">
                    <h4 class = "title left leftmargin">{{ detailAdmin.nama }}</h4> <br/> <br/>
                    <h4 class = "body-2 left leftmargin">ID Karyawan : {{ detailAdmin.id_pegawai }}</h4> <br><br>
                    <h4 class = "body-2 left leftmargin">Jabatan : {{ detailAdmin.jabatan }}</h4><br/><br>
                    <h4 class = "body-2 left leftmargin">Nomor Ponsel : {{ detailAdmin.no_telp}}</h4><br/><br>
                    <h4 class = "body-2 left leftmargin">Email : {{ detailAdmin.email }}</h4><br/><br>
                    <h4 class = "body-2 left leftmargin">Alamat:</h4> <br/><br>
                    <h4 class = "body-2 left leftmargin">{{ detailAdmin.alamat }}</h4><br/>
                </div>
                <div class="button">

                    <v-btn class="white--text" color="#009688" @click.native="ubahAdmin">Ubah</v-btn>
                    <v-dialog v-model="dialog" persistent max-width="400">
                        <template v-slot:activator="{ on }">
                            <v-btn class="white--text" color="#EF5350" v-on="on">Hapus</v-btn><br><br><br><br><br><br>
                        </template>
                        <v-card>
                            <v-card-title class="headline justify-center">Produk akan dihapus!</v-card-title>
                            <v-card-text>Apakah Anda yakin ingin menghapus produk?</v-card-text>
                            <v-card-actions>
                                <v-spacer></v-spacer>
                                <v-btn color="green darken-4" flat @click="hapusAdmin">Ya</v-btn>
                                <v-btn color="green darken-4" flat @click="dialog = false">Tidak</v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-dialog>
                </div>
            </v-card-text>
        </v-card>
        <nav-footer-admin></nav-footer-admin>
    </v-app>
</template>

<script>
    import NavSideBar from './NavSideBar';
    import FooterAdmin from './FooterAdmin';
    import axios from 'axios'

    export default {
        name: 'DetailAdmin',
        components: {
            'nav-side-bar': NavSideBar,
            'nav-footer-admin' : FooterAdmin
        },
        data() {
            return {
                detailAdmin: [],
                dialog: false
            }
        },
        props: {
            source: String,

        },

        methods: {
            ubahAdmin(){
                this.$router.push(this.$route.params.id_admin + '/ubah-detail-admin')
            },
            hapusAdmin(){

                axios.post('http://localhost:8080/admin/list-admin/' + this.$route.params.id_admin)
                    .then(response => {
                        this.$router.push('/list-admin')
                    })
            }

        },
        mounted(){

            axios.get('http://localhost:8080/admin/list-admin/detail-admin/' + this.$route.params.id_admin)
                .then(response => {
                    this.detailAdmin = response.data.result
                    console.log(this.detailAdmin)
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
