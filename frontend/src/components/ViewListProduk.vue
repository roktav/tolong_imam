<template>
    <div class="admin-page">
        <sidebar-menu :menu="menu" :width="'200px'"/>
        <nav-bar></nav-bar>
        <h2>Daftar Produk</h2>

        <div class="search-holder">
            <input type="text" v-model="search" placeholder="Cari produk" />
        </div>

    </div>
</template>

<script>
    import NavBar from './NavBar';


    export default {
        name: 'HelloWorld',
        components: {
            'nav-bar': NavBar
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
                search: ""
            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    .admin-page{
        margin-left: 200px;
    }

    h2 {
        margin-left: 60px;
        margin-top: 40px;
        align-self: center;
    }
    ul {
        list-style-type: none;
        padding: 0;
    }
    li {
        display: inline-block;
        margin: 0 10px;
    }
    a {
        color: #42b983;
    }
    .search-holder {
        display: flex;
        margin-left: 62px;
        margin-top: 30px;

    }
</style>
