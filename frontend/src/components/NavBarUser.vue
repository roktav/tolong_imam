<template>
    <v-toolbar dark
               app
               :fixed="true"
               :clipped-left="true"
               class="navbar"
               height="80px"
               flat>

        <img class="navbar-logo" src="@/assets/images/logoWinscoreUser.png" @click="toHomeUser">

        <v-spacer></v-spacer>
        <v-toolbar-items class="hidden-xs-only text-lowercase">
            <v-btn flat v-text v-for="item in menuItems" :key="item.title" router :to="item.link">
                <v-icon left dark> {{item.icon}} </v-icon>
                {{item.title}}
            </v-btn>
        </v-toolbar-items>
    </v-toolbar>
</template>

<script>
    export default {
        data(){
            return {
                menuItems: [
                    {icon: '', title: 'Beranda', link: '/'},
                    {icon: '', title: 'Produk', link: ''},
                    {icon: '', title: 'Promosi', link: ''},
                    {icon: '', title: 'Tips', link: ''},
                    {icon: '', title: 'Bantuan', link: ''},
                    {icon: '', title: 'Pemesanan', link: ''},
                    {icon: 'account_circle', title: 'Fadli', link: '/admin-teknisi/profile'}
                ]
            }
        },
        methods: {
            toHomeUser(){
                this.$router.push('/')
            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style >
    .navbar-logo {
        width: 200px;
    }
    .navbar {
        color:#28292B;
    }

</style>
