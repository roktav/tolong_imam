import HelloWorld from './components/HelloWorld.vue'
import ViewListProduk from './components/ViewListProduk'
import AdminTeknisi from './components/AdminTeknisi.vue'
import Profile from './components/Profile.vue'

export default [
    { path : '/', component: HelloWorld},
    { path : '/admin', component: HelloWinscore},
    { path : '/list-produk', component: ViewListProduk},
    { path : '/admin-teknisi', component: AdminTeknisi},
    { path : '/admin-teknisi/profile', component: Profile}
]