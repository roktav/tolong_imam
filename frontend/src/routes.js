import ViewListProduk from './components/ViewListProduk.vue'
import AdminTeknisi from './components/AdminTeknisi.vue'
import Profile from './components/Profile.vue'
import Teknisi from './components/Teknisi.vue'
import TeknisiUpdate from './components/TeknisiUpdate.vue'
import ListOrder from './components/ListOrder.vue'
import ViewDetailProduk from './components/ViewDetailProduk.vue'
import UbahDetailProduk from './components/UbahDetailProduk.vue'
import TambahProduk from './components/TambahProduk.vue'


export default [

    { path : '/list-produk', component: ViewListProduk},
    { path : '/list-produk/detail-produk/:id_produk', name: 'detail-produk', component: ViewDetailProduk},
    { path : '/list-produk/detail-produk/:id_produk/ubah-detail-produk', component: UbahDetailProduk},
    { path : '/list-produk/tambah-produk', component: TambahProduk},
    { path : '/admin-teknisi', component: AdminTeknisi},
    { path : '/admin-teknisi/profile', component: Profile},
    { path : '/teknisi', component: Teknisi},
    { path : '/admin-teknisi/list-pesanan', component: ListOrder},
    { path : '/ubah/{id_teknisi}', component: TeknisiUpdate}



]