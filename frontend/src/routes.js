import HelloWorld from './components/HelloWorld.vue'
import AdminTeknisi from './components/AdminTeknisi.vue'
import Profile from './components/Profile.vue'
import ListProduk from './components/ListProduk.vue'
import ListOrder from './components/ListOrder.vue'
import DetailOrder from './components/DetailOrder.vue'


export default [
    { path : '/', component: HelloWorld},
    { path : '/admin-teknisi', component: AdminTeknisi},
    { path : '/admin-teknisi/profile', component: Profile},
    { path : '/admin-teknisi/list-produk', component: ListProduk},
    { path : '/admin-teknisi/list-pesanan', component: ListOrder},
    {
        path: '/detail-order/:id_order',
        name: 'detail-order',
        component: DetailOrder
    }

]