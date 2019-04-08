<template>
    <v-toolbar dark
          app
          :fixed="true"
          :clipped-left="true"
          class="navbar"
          height="80px"
          flat>
<!--
                    &lt;!&ndash; Just an image &ndash;&gt;
            <navbar variant="faded" type="light">
                <navbar-brand>

                </navbar-brand>
            </navbar>-->
        <img class="navbar-logo" src="@/assets/images/logoWinscore.png" @click="toHome">
        <v-spacer></v-spacer>
        <v-toolbar-items class="hidden-xs-only">
            <v-btn flat v-for="item in menuItems" :key="item.title" router :to="item.link">
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
                    {icon: 'home', title: 'Beranda', link: '/'},
                    {icon: 'account_circle', title: 'Fadli', link: '/admin-teknisi/profile'}
                ]
            }
        },
        methods: {
            toHome(){
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
