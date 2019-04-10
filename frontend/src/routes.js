import Homepage from './components/Homepage.vue'
import ViewListProduk from './components/ViewListProduk.vue'
import AdminTeknisi from './components/AdminTeknisi.vue'
import Profile from './components/Profile.vue'
import Teknisi from './components/Teknisi.vue'
//import TeknisiUpdate from './components/TeknisiUpdate.vue'
import Shift from './components/Shift.vue'
import JadwalBulanan from './components/JadwalBulanan.vue'
import ListProduk from './components/ListProduk.vue'
import ListOrder from './components/ListOrder.vue'
import DetailOrder from './components/DetailOrder.vue'
import ViewDetailProduk from './components/ViewDetailProduk.vue'
import UbahDetailProduk from './components/UbahDetailProduk.vue'
import TambahProduk from './components/TambahProduk.vue'
import ManajerTeknisi from './components/ManajerTeknisi.vue'


export default [

    { path : '/', component: Homepage},
    { path : '/list-produk', component: ViewListProduk},
    { path : '/list-produk/detail-produk/:id_produk', name: 'detail-produk', component: ViewDetailProduk},
    { path : '/list-produk/detail-produk/:id_produk/ubah-detail-produk', component: UbahDetailProduk},
    { path : '/list-produk/tambah-produk', component: TambahProduk},
    { path : '/admin-teknisi', component: AdminTeknisi},
    { path : '/admin-teknisi/profile', component: Profile},
    { path : '/teknisi', component: Teknisi},
    { path : '/admin-teknisi/list-pesanan', component: ListOrder},
    {
        path: '/detail-order/:id_order',
        name: 'detail-order',
        component: DetailOrder
    },
    { path : '/ubah/{id_teknisi}', component: TeknisiUpdate}
    { path : '/teknisi/shift', component: Shift},
    { path : '/manajer-teknisi/profile', component: ManajerTeknisi},
    { path : '/jadwalbulanan', component: JadwalBulanan},
    { path : '/admin-teknisi/list-produk', component: ListProduk},
    { path : '/admin-teknisi/list-pesanan', component: ListOrder}


]