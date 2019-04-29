<template xmlns:to="http://www.w3.org/1999/xhtml">
    <v-app>
        <nav-side-bar></nav-side-bar>
        <!--<ul v-for="item in listProduk" :key = "item.id_produk">
            <li> {{item.nama }}</li>
        </ul>-->
        <div id="list-produk" style="padding-top: 40px; margin-left: 20px">
            <v-app id="inspire" style="margin-left: 17%; margin-top: -4%">
                <h4 class ="display-1 font-weight-medium black--text" align="left">Daftar Seluruh Karyawan</h4>
                <v-card-title>
                    <v-spacer></v-spacer>
                    <v-text-field
                            v-model="search"
                            append-icon="search"
                            label="Cari Karyawan"
                            single-line
                            hide-details
                    ></v-text-field>
                    <!--<v-spacer></v-spacer>
                    <v-btn class="white&#45;&#45;text" color="#009688" @click="expand = !expand"
                           router :to="'/admin-register'">
                        Tambah Karyawan
                    </v-btn>-->
                </v-card-title>
                <br>
                <v-card>
                    <v-data-table
                            :headers="headers"
                            :items="listAdmin"
                            :search="search">
                        <template slot="items" slot-scope="props">
                            <td>{{ props.index }}</td>
                            <td class="text-xs-center">{{ props.item.adminModel.id_pegawai }}</td>
                            <td class="text-xs-center"><v-btn class="admin-name"
                                                              router :to = "{name :'detail-admin', params: {id_admin: props.item.adminModel.id_admin.id_user}}"
                                                              flat>
                                {{ props.item.userModel.nama }}</v-btn></td>
                            <td class="text-xs-center">{{ props.item.adminModel.jabatan }}</td>
                            <td class="text-xs-center">{{ props.item.adminModel.status }}</td>
                        </template>
                        <v-alert slot="no-results" :value="true" color="error" icon="warning">
                            Your search for "{{ search }}" found no results.
                        </v-alert>
                    </v-data-table>
                </v-card>
                <v-card-title>
                    <v-spacer></v-spacer>
                    <v-btn class="white--text" color="#009688" @click="expand = !expand"
                           router :to="'/admin-register'">
                        Tambah Karyawan
                    </v-btn>
                </v-card-title>
                <br><br><br><br><br><br><br>
            </v-app>
        </div>
        <nav-footer-admin></nav-footer-admin>
    </v-app>
</template>

<script>
    import NavSideBar from './NavSideBar';
    import FooterAdmin from './FooterAdmin';
    import axios from 'axios';

    export default {
        name: 'listAdmin',
        components: {
            'nav-side-bar': NavSideBar,
            'nav-footer-admin': FooterAdmin,
        },
        data() {
            return {
                listAdmin: [],
                errors: [],
                search: '',
                headers: [
                    { text: 'No.', value: 'index', align: 'center'},
                    { text: 'ID Karyawan', value: 'id_karyawan', align: 'center' },
                    { text: 'Nama', value: 'nama', align: 'center' },
                    { text: 'Jabatan', value: 'jabatan', align: 'center' },
                    { text: 'Status', value: 'status', align: 'center' }
                ],
            }
        },
        props: {
            source: String
        },
        mounted(){
            axios.get('http://localhost:8080/admin/list-admin')
                .then(response => {
                    this.listAdmin = response.data.result;
                    console.log(this.listAdmin)
                })
                .catch(e => {
                    console.log(e)
                })
        },
        methods: {

        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    #list-produk {
        margin-top: 60px;
        margin-left: 290px;
        margin-right: 50px;
    }

    .product-name {
        font-size: small;

    }
</style>
