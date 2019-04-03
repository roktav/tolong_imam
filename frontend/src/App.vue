<template>
  <div >
    <router-view></router-view>
  </div>
</template>

<script>
import ViewListProduk from "./components/ViewListProduk"
import ViewDetailProduk from "./components/ViewDetailProduk";
import UbahDetailProduk from "./components/UbahDetailProduk";
import TambahProduk from "./components/TambahProduk";

export default {
    name: 'app',
    components: {
        'list-produk': ViewListProduk,
        'detail-produk': ViewDetailProduk,
        'ubah-detail-produk': UbahDetailProduk,
        'tambah-produk': TambahProduk

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
