<!--<template>
    <v-footer app absolute="fixed" :clipped-left="true" dark class="primary">
      <span class="caption mx-3">Copyright &copy; 2019 Wirelessindo | Total IT Solution</span>
      <v-spacer></v-spacer>

    </v-footer>
</template>-->
<template>
    <v-footer
            dark

            height="auto"
    >
        <v-card
                class="flex"
                color="#28292B"
                flat
                tile
        >

            <v-flex xs12 sm10>
                <v-card-title class="footer">
                    <div>
                        <img class="footer-logo" src="@/assets/images/logoWinscoreUser.png">
                        <h5 class="caption white--text">Supported by</h5>
                        <img class="wirelessindo" src="@/assets/images/wirelessindo.png">
                    </div>

                    <v-spacer></v-spacer>
                    <v-spacer></v-spacer>
                    <v-spacer></v-spacer>
                    <v-spacer></v-spacer>
                    <div class="about-us">
                        <h5 class="caption font-weight-bold white--text">Tentang Kami</h5>
                        <div class="caption font-weight-thin white--text"> {{ about }} </div>
                        <div class="caption font-weight-thin white--text"> {{ partner }} </div>
                    </div>
                    <v-spacer></v-spacer>
                    <div class="help">
                        <h5 class="caption font-weight-bold white--text">Bantuan</h5>
                        <div class="caption font-weight-thin white--text"> {{ contact }} </div>
                        <div class="caption font-weight-thin white--text"> {{ faq }} </div>
                    </div>
                    <v-spacer></v-spacer>
                    <div class="terms">
                        <h5 class="caption font-weight-bold white--text">Syarat & Ketentuan</h5>
                        <br><br>
                    </div>
                </v-card-title>
            </v-flex>


            <v-card-actions class="copyright caption darken-3 justify-left">
                Copyright &copy; 2019 Wirelessindo | Total IT Solution
            </v-card-actions>
        </v-card>
    </v-footer>
</template>

<script>
export default {
    data() {
        return {
            about: 'Profil',
            partner: 'Rekan Kami',
            contact: 'Kontak Kami',
            faq: 'FAQ',

        }
    }
}
</script>

<style>
    .footer {

        margin-left: 124px;
        margin-right: 50px;
        height: 100px;
    }
    .footer-logo {
        width: 100px;
        margin-top: 3px;
    }

    .copyright {
        margin-left: 130px;
    }
    .about-us {
        margin-top: 20px;
        text-align: left;
    }
    .help {
        margin-top: 20px;
        text-align: left;
    }
    .terms {
        margin-top: 20px;
        text-align: left;
    }
    .wirelessindo {
        width: 130px;
        margin-top: 0px;
    }

</style>
