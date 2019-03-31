<template>
  <div >
    <router-view></router-view>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import ViewListProduk from './components/ViewListProduk'

export default {
    name: 'app',
    components: {
        'hello-world': HelloWorld,
        'hello-winscore': HelloWinscore,
        'list-produk': ViewListProduk
    },
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
