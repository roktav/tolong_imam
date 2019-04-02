<template>
    <v-app>
        <nav-side-bar></nav-side-bar>
        <div id="list-produk">
            <v-app id="inspire">
                <h4 class ="display-1 font-weight-medium" align="left">Daftar Produk</h4>
                <br>
                <v-flex xs4>
                <v-text-field id="search-holder"
                        v-model="search"
                        label="Cari produk"
                        append-icon="search"
                        single-line
                        hide-details>
                </v-text-field>
                </v-flex>
                <v-card>
                    <v-data-table
                        :headers="headers"
                        :items="products"
                        :search="search">

                        <template slot="items" slot-scope="props">
                            <td class="text-xs-center">{{ props.item.kode }}</td>
                            <td class="text-xs-center">{{ props.item.nama }}</td>
                            <td class="text-xs-center">{{ props.item.harga }}</td>
                            <td class="text-xs-center">{{ props.item.status }}</td>
                        </template>
                        <v-alert slot="no-results" :value="true" color="error" icon="warning">
                        Your search for "{{ search }}" found no results.
                        </v-alert>
                    </v-data-table>
                </v-card>
            </v-app>
        </div>
        <nav-footer></nav-footer>
    </v-app>
</template>

<script>
    import NavSideBar from './NavSideBar';
    import Footer from './Footer';

    export default {
        name: 'ListProduk',
        components: {
            'nav-side-bar': NavSideBar,
            'nav-footer': Footer,
        },
        el:'#list-produk',
        data() {
            return {
                search: '',
                headers: [

                    { text: 'Kode Produk', value: 'kode', align: 'center' },
                    { text: 'Nama Produk', value: 'nama', align: 'center' },
                    { text: 'Harga', value: 'harga', align: 'center' },
                    { text: 'Status Persediaan', value: 'status', align: 'center' }
                ],
                products: [
                    {
                        value: false,
                        kode: 'GEDS-85204',
                        nama: '4ch XMEYE 1080N',
                        harga: 'Rp800.000',
                        status: 'Tersedia'
                    },
                    {
                        value: false,
                        kode: 'GEDS-85208',
                        nama: '8ch XMEYE 1080N',
                        harga: 'Rp1.000.000',
                        status: 'Tersedia'
                    },
                    {
                        value: false,
                        kode: 'GEDS-85210',
                        nama: '8ch XMEYE 1060N',
                        harga: 'Rp1.000.000',
                        status: 'Tersedia'
                    },
                    {
                        value: false,
                        kode: 'GEDS-85200',
                        nama: '6ch XMEYE 1080N',
                        harga: 'Rp900.000',
                        status: 'Tersedia'
                    },
                    {
                        value: false,
                        kode: 'GEDS-85310',
                        nama: '8ch XMEYE 1020N',
                        harga: 'Rp1.000.000',
                        status: 'Tersedia'
                    },
                ]
            }
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
    #search-holder {
        margin-bottom: 3px;

    }
</style>
