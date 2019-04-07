import HelloWorld from './components/HelloWorld.vue'
import AdminTeknisi from './components/AdminTeknisi.vue'
import Profile from './components/Profile.vue'

import Teknisi from './components/Teknisi.vue'
import Shift2 from './components/Shift2.vue'
import Shift from './components/Shift.vue'


import ListProduk from './components/ListProduk.vue'
import ListOrder from './components/ListOrder.vue'



export default [

    { path : '/admin-teknisi', component: AdminTeknisi},
    { path : '/admin-teknisi/profile', component: Profile},

    { path : '/teknisi', component: Teknisi},
    { path : '/teknisi/shift', component: Shift},
    { path : '/teknisi/shiftt', component: Shift2},
    

    { path : '/admin-teknisi/list-produk', component: ListProduk},
    { path : '/admin-teknisi/list-pesanan', component: ListOrder}


]