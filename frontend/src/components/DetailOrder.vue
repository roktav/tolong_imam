<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-app>
        <nav-side-bar></nav-side-bar>
        <v-container id="detail">
            <v-card>
                <v-card-title>
                    <span class="display-1 left">Detail Pembelian</span>
                </v-card-title>
                <v-card-text>
                    <tr>
                        <td class="text-xs-left">Kode Pesanan</td>
                        <td class="text-xs-left"> : {{ desserts.id_order }}</td>
                        <td><v-spacer></v-spacer></td>
                        <td class="text-xs-left">Status Pesanan : </td>
                        <td class="text-xs-left red--text">{{ desserts.status_order }} </td>
                    </tr>
                    <tr>
                        <td class="text-xs-left">Tanggal Pesanan</td>
                        <td class="text-xs-left"> : {{ desserts.tgl_order }}</td>
                    </tr>
                    <tr>
                        <td class="text-xs-left">Nama Pembeli</td>
                        <td class="text-xs-left"> : {{ desserts.pembeli.id_pembeli.nama }}</td>
                    </tr>
                    <tr>
                        <td class="text-xs-left">Email</td>
                        <td class="text-xs-left"> : {{ desserts.pembeli.id_pembeli.email }}</td>
                    </tr>
                    <tr>
                        <td class="text-xs-left">Nomor Ponser</td>
                        <td class="text-xs-left"> : {{ desserts.pembeli.id_pembeli.no_telp }}</td>
                    </tr>
                    <br>

                    <v-divider></v-divider>

                    <v-flex v-if="survei">
                        <br>
                        <tr>
                            <td class="text-xs-left">Jadwal Survei</td>
                            <td class="text-xs-left"> : {{ jadwalSurvei.tanggal_survei}} </td>
                        </tr>
                        <tr>
                            <td class="text-xs-left">Waktu Survei</td>
                            <td class="text-xs-left"> : {{ jadwalSurvei.waktu_survei}}</td>
                        </tr>
                        <tr>
                            <td class="text-xs-left">Alamat Survei</td>
                            <td class="text-xs-left"> : {{ jadwalSurvei.alamat_survei}}</td>
                        </tr>
                        <tr>
                            <td class="text-xs-left">Keterangan</td>
                            <td class="text-xs-left"> : {{ jadwalSurvei.keterangan }}</td>
                        </tr>
                        <tr>
                            <td class="text-xs-left">Nama Teknisi</td>
                            <td class="text-xs-left"> : Belum Tersedia</td>
                        </tr>
                    </v-flex>
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
                                :items="daftarProduk"
                                :search="search"
                        >
                            <template slot="items" slot-scope="props">
                                <td class="text-xs-left">{{ props.item.listProdukKey.produk.id_produk }}</td>
                                <td class="text-xs-left">{{ props.item.listProdukKey.produk.nama }}</td>
                                <td class="text-xs-left">{{ props.item.jumlah_pesanan }}</td>
                                <td class="text-xs-left">{{ props.item.harga }}</td>
                            </template>
                            <v-alert slot="no-results" :value="true" color="error" icon="warning">
                                Your search for "{{ search }}" found no results.
                            </v-alert>
                        </v-data-table>
                    </v-card>

                </v-card-text>
                <v-card-actions>
                    <v-layout align-end justify-end row>
                        <v-dialog v-model="dialog" persistent max-width="450px">
                            <template v-slot:activator="{ on }" >
                                <v-btn color="light green" dark v-on="on">Konfirmasi Pesanan</v-btn>
                            </template>
                            <v-card>
                                <v-card-title>
                                    <span class="headline">Konfirmasi Pesanan</span>
                                </v-card-title>
                                <v-card-text>
                                    <span class="headline">Kode Pesanan : {{desserts.id_order}}</span>
                                    <v-container grid-list-md>
                                        <v-layout wrap>
                                            <v-flex xs12 sm6 md6>
                                                <v-menu
                                                        ref="menu1"
                                                        v-model="menu"
                                                        :close-on-content-click="false"
                                                        :nudge-right="40"
                                                        :return-value.sync="jadwalSurvei.tanggal_survei"
                                                        lazy
                                                        transition="scale-transition"
                                                        offset-y
                                                        full-width
                                                        min-width="290px"
                                                >
                                                    <template v-slot:activator="{ on }">
                                                        <v-text-field
                                                                v-model="jadwalSurvei.tanggal_survei"
                                                                label="Jadwal Survei*"
                                                                prepend-icon="event"
                                                                readonly
                                                                v-on="on"
                                                                :rules="rulesSurvei.rule_tanggal"
                                                        ></v-text-field>
                                                    </template>
                                                    <v-date-picker v-model="date" no-title scrollable dark @input="$refs.menu1.save(date), menu = false" v-bind:min="disabledDates"></v-date-picker>
                                                </v-menu>
                                            </v-flex>
                                            <v-flex xs12 sm6 md 6>
                                                <v-select
                                                        v-model="jadwalSurvei.waktu_survei"
                                                        :items="states"
                                                        :rules="rulesSurvei.rule_waktu"
                                                        menu-props="auto"
                                                        label="Waktu Survei*"
                                                        hide-details
                                                        prepend-icon="access_time"
                                                ></v-select>
                                            </v-flex>
                                            <v-flex xs12>
                                                <v-text-field label="Alamat Survei*" :rules="rulesSurvei.rule_alamat" v-model="jadwalSurvei.alamat_survei"required></v-text-field>
                                            </v-flex>
                                            <v-flex xs12>
                                                <v-text-field label="Keterangan Tambahan" v-model="jadwalSurvei.keterangan"></v-text-field>
                                            </v-flex>
                                        </v-layout>
                                    </v-container>
                                    <small>*indicates required field</small>
                                </v-card-text>
                                <v-card-actions>
                                    <v-spacer></v-spacer>
                                    <v-btn color="blue darken-1" flat @click="dialog = false">Close</v-btn>
                                    <v-btn color="blue darken-1" flat @click="saveKonfirmasi()">Save</v-btn>
                                </v-card-actions>
                            </v-card>
                        </v-dialog>
                    </v-layout>

                </v-card-actions>
                <br>
            </v-card>
        </v-container>
        <nav-footer></nav-footer>
    </v-app>
</template>

<script>
    import NavSideBar from './NavSideBar';
    import Footer from './FooterAdmin';
    import axios from 'axios';
    import DatePicker from './DatePicker';


    export default {
        name: 'DetailOrder',
        components: {
            'nav-side-bar': NavSideBar,
            'nav-footer' : Footer,
            'date-picker' : DatePicker,
        },
        data () {
            return {
                search: '',
                dialog: false,
                date: null,
                time: null,
                menu: false,
                menu2: false,
                survei: true,
                states:['10:30','11:00','11:30','12:00','12:30','13:00','13:30','14:00','14:30','15:00','15:30','16:00','16:30','17:00'],
                headers: [
                    {
                        text: 'Kode', value: 'listProdukKey.produk.id_produk'
                    },
                    { text: 'Nama', value: 'listProdukKey.produk.nama' },
                    { text: 'Jumlah', value: 'jumlah_pesanan' },
                    { text: 'Harga', value: 'harga' }
                ],
                desserts: [],
                jadwalSurvei: {
                    tanggal_survei: null,
                    waktu_survei: null,
                    alamat_survei: null,
                    keterangan: null
                },
                daftarProduk: [],
                rulesSurvei:{
                    rule_tanggal: [v => !!v || "Tanggal harus diisi"],
                    rule_waktu: [v => !!v || "Waktu Survei harus diisi"],
                    rule_alamat: [v => !!v || "Alamat harus diisi"],
                    rule_keterangan: [],
                },
                asiaDates: new Date().toLocaleString("en-US", {timeZone: "Asia/Jakarta"}).substr(0, 9),
                disabledDates: new Date().toISOString().substr(0, 10)

            }
        },
        created() {
            alert(this.asiaDates)
        },
        mounted() {
            axios
                .get('http://localhost:8080/api/order/detail/' + this.$route.params.id_order)
                .then(response => {
                    this.desserts = response.data.result
                }),
                axios
                    .get('http://localhost:8080/api/order/detailList/' + this.$route.params.id_order)
                    .then(response => {
                        this.daftarProduk = response.data.result;
                        for (let key in this.daftarProduk){
                            this.daftarProduk[key]["harga"] = this.daftarProduk[key].listProdukKey.produk.harga * this.daftarProduk[key].jumlah_pesanan
                        }
                    }),
                axios
                    .get('http://localhost:8080/api/order/detail/lihat-survei/' + this.$route.params.id_order)
                    .then(response => {
                        console.log(response)
                        if(response.data.status === 200){
                            this.jadwalSurvei = response.data.result
                        } else {
                            this.survei = false
                        }
                        console.log(this.jadwalSurvei)
                    })

        },
        methods: {
            saveKonfirmasi(){
                axios
                    .post('http://localhost:8080/api/order/detail/tambah-survei/' + this.$route.params.id_order, this.jadwalSurvei)
                    .then(response => {
                        console.log(response.data.result)
                        this.survei = true
                    }),
                    axios
                        .post('http://localhost:8080/api/order/detail/update/' + this.$route.params.id_order)
                        .then(response => {
                            this.$router.push('')
                        });
                this.dialog = false;
            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    #detail {
        margin-left: 245px;
        width: 82%
    }
</style>
