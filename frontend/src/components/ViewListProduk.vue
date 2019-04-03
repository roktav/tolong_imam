<template>
    <v-app>
        <nav-side-bar></nav-side-bar>
        <!--<ul v-for="item in listProduk" :key = "item.id_produk">
            <li> {{item.nama }}</li>
        </ul>-->
        <div id="list-produk">
            <v-app id="inspire">
                <h4 class ="display-1 font-weight-medium" align="left">Daftar Produk</h4>
                <v-card-title>
                    <v-text-field
                            v-model="search"
                            append-icon="search"
                            label="Cari Produk"
                            single-line
                            hide-details
                    ></v-text-field>
                    <v-spacer></v-spacer>
                </v-card-title>
                <v-btn id="button-add-produk" class="white--text" color="#009688">Tambah Produk</v-btn>
                <v-card>
                    <v-data-table
                        :headers="headers"
                        :items="listProduk"
                        :search="search">

                        <template slot="items" slot-scope="props">
                            <td class="text-xs-center">{{ props.item.kode_produk }}</td>
                            <td class="text-xs-center">{{ props.item.nama }}</td>
                            <td class="text-xs-center">Rp {{ props.item.harga }}</td>
                            <td class="text-xs-center">{{ props.item.status }}</td>
                        </template>
                        <v-alert slot="no-results" :value="true" color="error" icon="warning">
                        Your search for "{{ search }}" found no results.
                        </v-alert>
                    </v-data-table>
                </v-card>
                <br><br><br><br><br>
            </v-app>
        </div>
        <nav-footer></nav-footer>
    </v-app>
</template>

<script>
    import NavSideBar from './NavSideBar';
    import Footer from './Footer';
    import axios from 'axios';

    export default {
        name: 'ListProduk',
        components: {
            'nav-side-bar': NavSideBar,
            'nav-footer': Footer,
        },
        data() {
            return {
                listProduk: [],
                errors: [],
                search: '',
                headers: [

                    { text: 'Kode Produk', value: 'kode_produk', align: 'center' },
                    { text: 'Nama Produk', value: 'nama', align: 'center' },
                    { text: 'Harga', value: 'harga', align: 'center' },
                    { text: 'Status Persediaan', value: 'status', align: 'center' }
                ],
            }
        },
        props: {
            source: String
        },
        mounted(){
            axios.get('http://localhost:8080/api/list-produk')
                .then(response => {
                    this.listProduk = response.data.result
                    console.log(response.data)
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
        margin-top: 50px;
        margin-left: 290px;
        margin-right: 50px;
    }
    #button-add-produk {
        margin-left: 770px;
        margin-top: 5px;
    }
</style>
