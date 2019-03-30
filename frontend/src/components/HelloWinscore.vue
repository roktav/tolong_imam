<template>
  <div class="admin-page">
    <sidebar-menu :menu="menu" :width="'200px'"/>
    <nav-bar></nav-bar>
    <h2>Welcome to Winscore Admin Page</h2>
    <data-table></data-table>
  </div>
</template>

<script>
import NavBar from './NavBar';
import DataTable from './DataTable';


export default {
  components: {
      'nav-bar': NavBar,
      'data-table': DataTable
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
        ]
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.admin-page{
  margin-left: 200px;
}

.v-sidebar-menu.vsm-header {
  font-size: 23px;
}


h2 {
  margin-left: 20px;
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
</style>
