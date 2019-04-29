<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-app>
        <v-card>
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
                <h4 class ="display-1 font-weight-medium black--text" align="left" style="margin-left: 2%"
                >Tambah Karyawan Baru</h4>
                <v-container grid-list-xl fluid>
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
                                    v-model="form.role"
                                    :items="items_role"
                                    :rules="rules.role"
                                    color="pink"
                                    label="Role"
                                    required
                            ></v-select>
                        </v-flex>
                        <v-flex xs4>
                            <v-select
                                    v-model="form.cabang"
                                    :items="items_cabang"
                                    :rules="rules.cabang"
                                    label="Kantor Cabang"
                                    color="pink"
                                    required
                            ></v-select>
                        </v-flex>
                        <v-flex xs4>
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
                                    v-model="form.username"
                                    :rules="rules.username"
                                    color="purple darken-2"
                                    label="Username"
                                    required
                            ></v-text-field>
                        </v-flex>
                        <v-flex xs6>
                            <v-text-field
                                    v-model="form.password"
                                    :rules="[rules.required, rules.min]"
                                    name="input-10-1"
                                    label="Password"
                                    hint="At least 8 characters"
                                    required
                            ></v-text-field>
                        </v-flex>
                        <v-flex xs6>
                            <v-text-field
                                    v-model="form.id_pegawai"
                                    :rules="rules.id_pegawai"
                                    color="purple darken-2"
                                    label="ID Pegawai"
                                    required
                            ></v-text-field>
                        </v-flex>
                        <v-flex xs6>
                            <v-select
                                    v-model="form.jabatan"
                                    :items="items_jabatan"
                                    label="Jabatan"
                                    color="pink"
                                    required
                            ></v-select>
                        </v-flex>
                    </v-layout>
                    <v-card-actions xs12 style="padding-top: 0; padding-bottom: 30px;">
                        <v-btn flat color="primary" dark @click="resetForm">Clear</v-btn>
                        <v-spacer></v-spacer>
                        <v-btn round
                               dark
                               color="blue"
                               type="submit"
                               @click="addAdmin"
                               cfc

                        >Daftar</v-btn>
                    </v-card-actions>
                </v-container>
            </v-form>
            <br><br>
            <nav-footer></nav-footer>
        </v-card>
    </v-app>

</template>

<script>
    import NavSideBar from './NavSideBar';
    import Footer from './FooterAdmin';
    import axios from 'axios';


    export default {
        components: {
            'nav-side-bar': NavSideBar,
            'nav-footer' : Footer
        },
        data () {
            const defaultForm = Object.freeze({
                nama: '',
                no_telp: '',
                role: 'Sistem Teknisi',
                cabang: '',
                alamat:'',
                username:'',
                password:'',
                id_pegawai:'',
                jabatan:'',
                cabang:'Bogor',
                status:'Aktif',

                terms: false
            });
            return {
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
                items_role: [
                    'Admin Sistem',
                    'Admin Sales and Marketing',
                    'Admin Keuangan',
                    'Admin Teknisi',
                    'Manajer Teknisi'
                ],
                items_cabang: [
                    'Bogor',
                    'Bekasi',
                    'Semarang'
                ],
                items_jabatan: [
                    'Direktur',
                    'General Manager',
                    'Finance Manager',
                    'IT Manager',
                    'HRD',
                    'Division of Finance',
                    'Division of Marketing',
                    'Division of Civil and Infrastructure',
                    'DIvision of Project'
                ],
                conditions: false,
                content: `Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet. Duis sagittis ipsum. Praesent mauris. Fusce nec tellus sed augue semper porta. Mauris massa. Vestibulum lacinia arcu eget nulla. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Curabitur sodales ligula in libero. Sed dignissim lacinia nunc.`,
                snackbar: false,
                terms: false,
                defaultForm
            }
        },
        computed: {
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
        },
        methods: {
            addAdmin(){
                console.log(this.form)
                    axios.post('http://localhost:8080/admin/post', this.form)
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

    /*
   <script>
       export default {
           data: () => ({


               valid: true,
               nama: '',
               nameRules: [
                   v => !!v || 'Name is required',
                   v => (v && v.length <= 10) || 'Name must be less than 10 characters'
               ],
               email: '',
               emailRules: [
                   v => !!v || 'E-mail is required',
                   v => /.+@.+/.test(v) || 'E-mail must be valid'
               ],
               no_telp: '',
               notelp_rules: [
                   v => !!v || 'Phone number is required',
                   v => /.+@.+/.test(v) || 'Phone number must be valid'
               ],
               provinsi: null,
               items_provinsi: [
                   'Sumatera',
                   'Jawa Barat',
                   'Jawa Tengah',
                   'Jawa Timur',
                   'Kalimantan',
                   'Sunda Kecil (Nusa Tenggara)',
                   'Maluku',
                   'Sulawesi',
               ],
               kota: null,
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
               kecamatan: null,
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
               checkbox: false
           }),
           computed: {
               formIsValid () {
                   return (
                       this.form.first &&
                       this.form.last &&
                       this.form.favoriteAnimal &&
                       this.form.terms
                   )
               }
           },
           methods: {
               validate () {
                   if (this.$refs.form.validate()) {
                       this.snackbar = true
                   }
               },
               reset () {
                   this.$refs.form.reset()
               },
               resetValidation () {
                   this.$refs.form.resetValidation()
               }
           }
       }
   </script>*/