<template>
    <v-toolbar dark
          app
          :fixed="true"
          :clipped-left="true"
          class="primary"
          flat>

                    <!-- Just an image -->
            <b-navbar variant="faded" type="light">
                <b-navbar-brand>
                    <img class="navbar-logo" src="@/assets/images/logoWinscore.png">
                </b-navbar-brand>
            </b-navbar>

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
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style >
    .navbar-logo {
        width: 200px;
    }
    
</style>
