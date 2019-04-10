<!--<template>
    <v-footer app absolute="fixed" :clipped-left="true" dark class="primary">
      <span class="caption mx-3">Copyright &copy; 2019 Wirelessindo | Total IT Solution</span>
      <v-spacer></v-spacer>

    </v-footer>
</template>-->
<template>
    <v-footer
        dark
        :inset="false"
        :height="10"
        :absolute="true"
        :clipped-left="true"
    >
        <v-card
                class="flex"
                color="#28292B"
                flat
                tile
        >

            <v-flex xs12>
                <v-card-title class="footer">
                    <img class="footer-logo" src="@/assets/images/logoWinscoreUser.png">
                    <h5 class="caption white--text">Supported by</h5>
                    <img class="wirelessindo" src="@/assets/images/wirelessindo.png">
                    <v-spacer></v-spacer>

                    <v-card-actions class="copyright caption darken-3 justify-center">
                        Copyright &copy; 2019 Wirelessindo | Total IT Solution
                    </v-card-actions>
                </v-card-title>
            </v-flex>
        </v-card>
    </v-footer>
</template>

<script>
    export default {
        data() {
            return {

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
        margin-left: 230px;
    }

    .wirelessindo {
        width: 130px;
        margin-top: 0px;
    }

</style>
