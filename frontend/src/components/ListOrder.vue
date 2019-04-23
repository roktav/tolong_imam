<template>
    <v-app>
        <nav-side-bar></nav-side-bar>
        <div id="app">
            <v-app id="inspire">
                <h4 class ="display-1 font-weight-medium black--text" align="left">Daftar Pesanan</h4>
                <br>
                <v-card>
                    <v-card-title>
                        <v-spacer></v-spacer>
                        <v-spacer></v-spacer>
                        <v-spacer></v-spacer>
                        <v-text-field
                                v-model="search"
                                append-icon="search"
                                label="Search"
                                single-line
                                hide-details
                        ></v-text-field>
                    </v-card-title>
                    <v-data-table
                            :headers="headers"
                            :items="desserts"
                            :search="search"
                    >
                        <template slot="items" slot-scope="props">
                            <td class="text-xs-left">{{ props.item.tanggal_pesanan }}</td>
                            <td class="text-xs-left">{{ props.item.kode_pesanan }}</td>
                            <td class="text-xs-left">{{ props.item.nama_produk }}</td>
                            <td class="text-xs-left">{{ props.item.nama_pembeli }}</td>
                            <td class="text-xs-left">{{ props.item.harga }}</td>
                            <td class="text-xs-left">{{ props.item.status_pesanan }}</td>
                            <td class="text-xs-left"><router-link :to="{ name: 'detail-order', params: {id_order: props.item.kode_pesanan } }">Edit</router-link></td>
                        </template>
                        <v-alert slot="no-results" :value="true" color="error" icon="warning">
                            Your search for "{{ search }}" found no results.
                        </v-alert>
                    </v-data-table>
                </v-card>
            </v-app>
        </div>
        <nav-footer-admin></nav-footer-admin>
    </v-app>
</template>

<script>
import axios from 'axios'
import NavSideBar from './NavSideBar';
import FooterAdmin from './FooterAdmin';

    export default {
        name: 'AdminTeknisi',
        components: {
            'nav-side-bar': NavSideBar,
            'nav-footer-admin' : FooterAdmin
        },

        data () {
            return {
                search: '',
                headers: [
                    {
                        text: 'Tanggal Pesanan', value: 'tanggal_pesanan'
                    },
                    { text: 'Kode Pesanan', value: 'kode_pesanan' },
                    { text: 'Nama Produk', value: 'nama_produk' },
                    { text: 'Nama Pembeli', value: 'nama_pembeli' },
                    { text: 'Harga', value: 'harga' },
                    { text: 'Status Pesanan', value: 'status_pesanan' },
                    { text: 'Actions', value: 'actions' }
                ],
                desserts: [
                ],

            }
        },
        created() {
            axios
                .get('http://localhost:8080/api/order')
                .then(response => {
                    let formatted = []
                    let getData = response.data.result
                    console.log(getData)
                    for (var key in getData){
                        console.log(getData[key])
                        formatted.push(
                            {tanggal_pesanan: getData[key].tgl_order,
                            kode_pesanan: getData[key].id_order,
                            nama_produk: getData[key].kategori_produk,
                            nama_pembeli: getData[key].pembeli.id_pembeli.nama,
                            harga: '100000',
                            status_pesanan: getData[key].status_order,
                            }
                        )
                    }
                    console.log(formatted)
                    this.desserts = formatted
                })
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    #app {
        margin-left: 130px;
        margin-right: 10px
    }
</style>
