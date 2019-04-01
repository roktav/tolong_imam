import ViewListProduk from './components/ViewListProduk'
import AdminTeknisi from './components/AdminTeknisi.vue'
import Profile from './components/Profile.vue'
import ListProduk from './components/ListProduk.vue'
import ListOrder from './components/ListOrder.vue'

export default [
    { path : '/list-produk', component: ViewListProduk},
    { path : '/admin-teknisi', component: AdminTeknisi},
    { path : '/admin-teknisi/profile', component: Profile},
    { path : '/admin-teknisi/list-produk', component: ListProduk},
    { path : '/admin-teknisi/list-pesanan', component: ListOrder}

]