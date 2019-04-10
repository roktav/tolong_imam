import HelloWorld from './components/HelloWorld.vue'
import AdminTeknisi from './components/AdminTeknisi.vue'
import Profile from './components/Profile.vue'

import Teknisi from './components/Teknisi.vue'
import TeknisiUpdate from './components/TeknisiUpdate.vue'

import ListProduk from './components/ListProduk.vue'
import ListOrder from './components/ListOrder.vue'
import DetailOrder from './components/DetailOrder.vue'



export default [

    { path : '/admin-teknisi', component: AdminTeknisi},
    { path : '/admin-teknisi/profile', component: Profile},

    { path : '/teknisi', component: Teknisi},

    { path : '/admin-teknisi/list-produk', component: ListProduk},
    { path : '/admin-teknisi/list-pesanan', component: ListOrder},
    {
        path: '/detail-order/:id_order',
        name: 'detail-order',
        component: DetailOrder
    },
    { path : '/ubah/{id_teknisi}', component: TeknisiUpdate}

]