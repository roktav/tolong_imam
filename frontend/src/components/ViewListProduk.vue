<template>
    <v-app>
        <nav-side-bar></nav-side-bar>
        <div id="list-produk">
            <v-app id="inspire">
                <h4 class ="display-1">Daftar Produk</h4>

                <v-card>
                    <v-card-title>
                        <v-spacer></v-spacer>
                        <v-text-field
                                v-model="search"
                                label="Cari produk"
                                append-icon="search"
                                single line
                                hide-details>
                        </v-text-field>
                    </v-card-title>
                    <v-data-table
                        :headers="header"
                        :items="desserts"
                        :search="search">

                        <template slot="items" slot-scope="props">
                            <td>{{ props.item.name }}</td>
                            <td class="text-xs-right">{{ props.item.calories }}</td>
                            <td class="text-xs-right">{{ props.item.fat }}</td>
                            <td class="text-xs-right">{{ props.item.carbs }}</td>
                            <td class="text-xs-right">{{ props.item.protein }}</td>
                            <td class="text-xs-right">{{ props.item.iron }}</td>
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
        data() {
            return {
                menu: [
                    {
                        header: true,
                        title: 'Winscore'
                    },
                    {
                        href: '/',
                        title: 'Winscore Site',
                        icon: 'fas fa-globe'
                    },
                    {
                        href: '/admin',
                        title: 'Dashboard',
                        icon: 'fas fa-home'
                    }
                ],

            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    #list-produk {
        margin-top: 50px;
    }
</style>
