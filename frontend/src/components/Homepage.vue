<template>
    <v-app>
        <nav-bar></nav-bar>
        <v-carousel class="carousel">
            <v-carousel-item
                    v-for="(item,i) in items"
                    :key="i"
                    :src="item.src"
            >
                <div class="container"><br>
                    <h3 class="display-2 font-weight-bold white--text">Menjaga Kesayangan Anda</h3>
                    <h4 class="display-1 font-weight-medium white--text">Kapan Saja, Dimana Saja</h4>
                    <button class="btn">Cek Sekarang</button>
                </div>
            </v-carousel-item>
        </v-carousel>
        <br><br><br>
        <div id="homepage">
            <h4 class ="display-1 font-weight-bold" align="center">Layanan Kami</h4>
            <br><br><br>
        </div>
        <v-layout>
            <v-flex xs12 sm4 offset-xs-1>
                <v-card max-width="300px" align="justify">
                    <v-img class="imgLayanan"
                            src="http://www.towerjio.org/images/home-bg-slideshow2.jpg"
                            aspect-ratio="2.75"
                    ></v-img>

                    <v-card-title primary-title>
                        <div>
                            <h3 class="headline mb-0 font-weight-medium">Instalasi Infrastruktur</h3><br>
                            <div> {{ card_text1 }} </div>
                        </div>
                    </v-card-title>

                    <v-card-actions>
                        <v-btn flat color="blue">Baca Selengkapnya</v-btn>
                    </v-card-actions>
                </v-card>
                <br><br><br><br><br><br><br>
            </v-flex>

            <v-flex xs12 sm4 offset-xs-1>
                <v-card max-width="300px" align="justify">
                    <v-img class="imgLayanan"
                           src="https://www.solvereone.com/pages/wp-content/uploads/bfi_thumb/hiring-an-IT-consultant-net9i7csk1o6mjzut3kewpdl03j6pndqyq2c6a35vw.jpg"
                           aspect-ratio="2.75"
                    ></v-img>

                    <v-card-title primary-title>
                        <div>
                            <h3 class="headline mb-0 font-weight-medium">Konsultasi TI</h3><br>
                            <div> {{ card_text2 }} </div>
                        </div>
                    </v-card-title>

                    <v-card-actions>
                        <v-btn flat color="blue">Baca Selengkapnya</v-btn>
                    </v-card-actions>
                </v-card>
                <br><br><br><br><br><br><br>
            </v-flex>

            <v-flex xs12 sm4 offset-xs-1>
                <v-card max-width="300px" align="justify">
                    <v-img class="imgLayanan"
                           src="http://laruno.com/wp-content/uploads/2018/06/4-ide-bisnis-digital-sukses-untuk-anda-coba.jpg"
                           aspect-ratio="2.75"
                    ></v-img>

                    <v-card-title primary-title>
                        <div>
                            <h3 class="headline mb-0 font-weight-medium">Aplikasi Bisnis</h3><br>
                            <div> {{ card_text3 }} </div>
                        </div>
                    </v-card-title>

                    <v-card-actions>
                        <v-btn flat color="blue">Baca Selengkapnya</v-btn>
                    </v-card-actions>
                </v-card>
                <br><br><br><br><br><br><br>
            </v-flex>

            <v-flex xs12 sm4 offset-xs-1>
                <v-card max-width="300px" align="justify">
                    <v-img class="imgLayanan"
                           src="https://cdn-images-1.medium.com/max/2600/1*rV6_99F42Jr7uR5YtLrHrQ.jpeg"
                           aspect-ratio="2.75"
                    ></v-img>

                    <v-card-title primary-title>
                        <div>
                            <h3 class="headline mb-0 font-weight-medium">Pengembangan Web</h3><br>
                            <div> {{ card_text4 }} </div>
                        </div>
                    </v-card-title>

                    <v-card-actions>
                        <v-btn flat color="blue">Baca Selengkapnya</v-btn>
                    </v-card-actions>
                </v-card>
                <br><br><br><br><br><br><br>
            </v-flex>

        </v-layout>


        <nav-footer :fixed="'false'" v-bind:fixed="fixed"></nav-footer>
    </v-app>
</template>

<script>
    import NavBarUser from './NavBarUser';
    import FooterUser from './FooterUser';
    import axios from 'axios'

    export default {
        name: 'DetailProduk',
        components: {
            'nav-bar': NavBarUser,
            'nav-footer' : FooterUser
        },
        data() {
            return {
                fixed: false,
                detailProduk: [],
                dialog: false,
                card_text1: 'Seiring berjalannya waktu, tidak terasa sudah banyak kepercayaan yang diberikan terhadap Wirelessindo sebagai solusi dalam Bidang IT.' +
                    ' Mulai dari instansi komersi yang dimiliki swasta, intansi sosial hingga intansi Militer dan Pemerintahan.' +
                    ' Adapun jenis pekerjaan yang ditawarkan sebagai solusi terhadap bidang IT pada berbagai institusi.',
                card_text2: 'Integrasi antar sistem informasi yang dapat memenuhi kebutuhan suatu perusahaan dibutuhkan ' +
                    'tenaga profesional untuk menjembatani antara perusahaan dan vendor.' +
                    ' Kami dapat membantu untuk memberikan pendapat professional mengenai keperluan perangkat maupun software beserta penggunaannya.' +
                    ' Baca selengkapnya.',
                card_text3: 'Sebagai pemenuhan kebutuhan IT satu pintu (One Way Service), ' +
                    'wirelessindo juga memiliki keahlian dalam bidang pengadaan dan pembuatan SOFTWARE baik untuk kebutuhan Desktop, ' +
                    'Online Application hingga Aplikasi berbasi SMART Phone semisal APK untuk Android.' +
                    ' Baca selengkapnya untuk mengetahui informasi ini lebih lanjut.',
                card_text4: 'Para pengembang web kami ada di seluruh penjuru kota di Indonesia.' +
                    ' Berbagai orang yang menjadi developer tentunya memiliki kompetensi yang tinggi untuk bisa mengembangkan' +
                    ' web yang dimiliki oleh perusahaan.' +
                    ' Para developer tersebut telah mengemban tugas untuk memenuhi kebutuhan perusahaan. Baca selengkapnya untuk lebih lanjut.',
                items: [
                    { src: require('@/assets/images/carousel1.png') },
                    { src: require('@/assets/images/carousel2.png') },
                    { src: require('@/assets/images/carousel3.png') },
                    { src: require('@/assets/images/carousel4.png') }
                ],

            }
        },
        props: {
            source: String,

        },

        methods: {

        },
        mounted(){

            axios.get('http://localhost:8080/api/list-produk/detail-produk/' + this.$route.params.id_produk)
                .then(response => {
                    this.detailProduk = response.data.result
                    console.log(response.data)
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
        margin-left: 290px;
        margin-right: 50px;
        margin-top: 50px ;
    }
    .detail {
        margin-left: 660px;
        margin-top: 30px;
    }
    .button {
        margin-left: 1000px;
        margin-top: 10px;
    }
    .carousel {
        height: 400px !important;
    }

    .imgLayanan {
        height: 150px;
    }
    .container {
        position: relative;
        width: 50%;
    }

    /* Style the button and place it in the middle of the container/image */
    .container .btn {
        position: absolute;
        top: 50%;
        left: 50%;
        margin-top: 240px;
        transform: translate(-50%, -50%);
        -ms-transform: translate(-50%, -50%);
        background-color: #3FA9F5;
        color: white;
        font-size: 18px;
        padding: 12px 24px;
        border: none;
        cursor: pointer;
        border-radius: 30px;
    }

    .container .btn:hover {
        background-color: black;
    }
</style>
