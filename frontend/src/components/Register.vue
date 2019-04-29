<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-app>
        <v-card style="font-family: 'Roboto', sans-serif">
            <nav-side-bar></nav-side-bar>
            <v-snackbar
                    v-model="snackbar"
                    absolute
                    top
                    right
                    color="success"
            >
                <span>Registration successful!</span>
                <v-icon dark>check_circle</v-icon>
            </v-snackbar>
            <v-form ref="form" @submit.prevent="submit" style="margin-left: 17%; margin-top: 4%">
                <v-container grid-list-xl fluid>
                    <h2 class = "display-1">Registrasi Sekarang</h2>
                    <v-layout wrap>
                        <v-flex xs6>
                            <v-text-field
                                    v-model="form.nama"
                                    :rules="rules.nama"
                                    color="purple darken-2"
                                    label="Nama lengkap"
                                    required
                            ></v-text-field>
                        </v-flex>
                        <v-flex xs6>
                            <v-text-field
                                    v-model="form.no_telp"
                                    :rules="rules.no_telp"
                                    color="blue darken-2"
                                    label="Nomor ponsel"
                                    required
                            ></v-text-field>
                        </v-flex>
                        <v-flex xs12>
                            <v-textarea
                                    v-model="form.alamat"
                                    color="teal"
                                    label="Alamat"
                                    required
                            >
                                <template v-slot:label>
                                    <div>
                                        Alamat <small>(optional)</small>
                                    </div>
                                </template>
                            </v-textarea>
                        </v-flex>
                        <v-flex xs4>
                            <v-select
                                    v-model="form.provinsi"
                                    :items="items_provinsi"
                                    :rules="rules.provinsi"
                                    color="pink"
                                    label="Provinsi"
                                    required
                            ></v-select>
                        </v-flex>
                        <v-flex xs4>
                            <v-select
                                    v-model="form.kota"
                                    :items="items_kota"
                                    :rules="rules.kota"
                                    label="Kota"
                                    color="pink"
                                    required
                            ></v-select>
                        </v-flex>
                        <v-flex xs4>
                            <v-select
                                    v-model="form.kecamatan"
                                    :items="items_kecamatan"
                                    :rules="rules.kecamatan"
                                    color="pink"
                                    label="Kecamatan"
                                    required
                            ></v-select>
                        </v-flex>
                        <v-flex xs6>
                            <v-text-field
                                    v-model="form.email"
                                    :rules="rules.email"
                                    color="purple darken-2"
                                    label="Email"
                                    required
                            ></v-text-field>
                        </v-flex>
                        <v-flex xs6>
                            <v-text-field
                                    v-model="form.password"
                                    :rules="rules.password"
                                    color="purple darken-2"
                                    label="Password"
                                    required
                            ></v-text-field>
                        </v-flex>
                        <v-layout row justify-space-between>
                            <v-flex xs8 style="padding-bottom: 0; padding-top: 0">
                                <v-checkbox
                                        v-model="form.terms"
                                        color="green"
                                >
                                    <template v-slot:label>
                                        <div @click.stop="">
                                            Do you accept the
                                            <a href="javascript:;" @click.stop="terms = true">terms</a>
                                            and
                                            <a href="javascript:;" @click.stop="conditions = true">conditions?</a>
                                        </div>
                                    </template>
                                </v-checkbox>
                            </v-flex>
                            <v-flex xs2></v-flex>
                            <v-spacer></v-spacer>
                            <v-flex xs2>
                                <v-btn flat color="info" @click="resetForm">Clear</v-btn>
                            </v-flex>
                        </v-layout>
                    </v-layout>
                    <v-card-actions xs12 style="padding-top: 0; padding-bottom: 30px;">
                        <v-btn round
                               dark
                               color="blue"
                               type="submit"
                               @click="addPembeli"
                               cfc

                        >Daftar</v-btn>
                    </v-card-actions>
                </v-container>
            </v-form>
            <v-dialog v-model="terms" width="70%">
                <v-card>
                    <v-card-title class="title">Terms</v-card-title>
                    <v-card-text v-for="n in 5" :key="n">
                        {{ content }}
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn
                                flat
                                color="purple"
                                @click="terms = false"
                        >Ok</v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
            <v-dialog v-model="conditions" width="70%">
                <v-card>
                    <v-card-title class="title">Conditions</v-card-title>
                    <v-card-text v-for="n in 5" :key="n">
                        {{ content }}
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn
                                flat
                                color="purple"
                                @click="conditions = false, alert = !alert"
                        >Ok</v-btn>
                        <v-alert
                                :value="alert"
                                type="success"
                                transition="scale-transition"
                        >
                            This is a success alert.
                        </v-alert>
                    </v-card-actions>
                </v-card>
            </v-dialog>
            <nav-footer></nav-footer>
        </v-card>
    </v-app>
</template>

<script>
    import NavSideBar from './NavSideBar';
    import Footer from './FooterUser';
    import axios from 'axios'


    export default {
        components: {
             'nav-side-bar': NavSideBar,
            'nav-footer' : Footer
        },
        data () {
            const defaultForm = Object.freeze({
                nama: '',
                no_telp: '',
                provinsi: '',
                kota: '',
                alamat:'',
                kecamatan:'',
                password:'',
                role:'USER      ',
                terms: false
            });
            return {
                alert: true,
                form: Object.assign({}, defaultForm),
                rules: {
                    nama: [
                        v => !!v || 'Name is required',
                        v => (v && v.length <= 30) || 'Name must be less than 31 characters'
                    ],
                    email: [
                        v => !!v || 'E-mail is required',
                        v => /.+@.+/.test(v) || 'E-mail must be valid'
                    ],
                    no_telp: [
                        v => !!v || 'Phone number is required',
                    ],
                    alamat: [
                        v => !!v || 'Address is required',
                        v => (v && v.length <= 144) || 'Name must be less than 144 characters',
                    ]
                },
                items_provinsi: [
                    'Sumatera',
                    'Jawa Barat',
                    'Jawa Tengah',
                    'Jawa Timur',
                    'Kalimantan',
                    'Sunda Kecil (Nusa Tenggara)',
                    'Maluku',
                    'Sulawesi'
                    ],
                items_kota: [
                    'Sumatera',
                    'Jawa Barat',
                    'Jawa Tengah',
                    'Jawa Timur',
                    'Kalimantan',
                    'Sunda Kecil (Nusa Tenggara)',
                    'Maluku',
                    'Sulawesi',
                ],
                items_kecamatan: [
                    'Sumatera',
                    'Jawa Barat',
                    'Jawa Tengah',
                    'Jawa Timur',
                    'Kalimantan',
                    'Sunda Kecil (Nusa Tenggara)',
                    'Maluku',
                    'Sulawesi',
                ],
                conditions: false,
                content: `Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet. Duis sagittis ipsum. Praesent mauris. Fusce nec tellus sed augue semper porta. Mauris massa. Vestibulum lacinia arcu eget nulla. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Curabitur sodales ligula in libero. Sed dignissim lacinia nunc.`,
                snackbar: false,
                terms: false,
                defaultForm
            }
        },
        /*computed: {
            formIsValid () {
                return (
                    this.form.nama &&
                    this.form.no_telp &&
                    this.form.provinsi &&
                    this.form.kota &&
                    this.form.kecamatan &&
                    this.form.password
                )
            }
        },*/
        methods: {
            /*addUser(){
                alert(this.form);
                    axios.post('http://localhost:8080/register', this.form)
                        .then(response => {
                            this.$router.push(`/login`)
                        })
            },*/

                addPembeli(){
                    console.log(this.form);
                    axios.post('http://localhost:8080/pembeli/post', this.form)
                },
                resetForm () {
                    this.form = Object.assign({}, this.defaultForm);
                    this.$refs.form.reset()
                },
                submit () {
                    this.snackbar = true;
                    this.resetForm()
                }

        }
    }
</script>

<style scoped>
    .leftmargin {
        margin-left: 4%
    }

    .avatar {
        vertical-align: middle;
        width: 250px;
        height: 250px;
        border-radius: 50%;
    }

</style>