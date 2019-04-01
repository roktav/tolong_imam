import ViewListProduk from './components/ViewListProduk.vue'
import AdminTeknisi from './components/AdminTeknisi.vue'
import Profile from './components/Profile.vue'
import ListOrder from './components/ListOrder.vue'
import ViewDetailProduk from './components/ViewDetailProduk.vue'

export default [
    { path : '/list-produk', component: ViewListProduk},
    { path : '/admin-teknisi', component: AdminTeknisi},
    { path : '/admin-teknisi/profile', component: Profile},
    { path : '/admin-teknisi/list-pesanan', component: ListOrder},
    { path : '/list-produk/detail-produk', component: ViewDetailProduk}

]