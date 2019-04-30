import Homepage from './components/Homepage.vue'
import ViewListProduk from './components/ViewListProduk.vue'
import AdminTeknisi from './components/AdminTeknisi.vue'
import Profile from './components/Profile.vue'
import Teknisi from './components/Teknisi.vue'
/*import TeknisiUpdate from './components/TeknisiUpdate.vue'*/
/*import Shift2 from './components/Shift2.vue'*/
import Shift from './components/Shift.vue'
import JadwalBulanan from './components/JadwalBulanan.vue'
import ListProduk from './components/ListProduk.vue'
import ListOrder from './components/ListOrder.vue'
import LoginComponent from "./components/Login.vue"
import LogoutComponent from "./components/Logout.vue"
import SecureComponent from "./components/secure.vue"
import Register from "./components/Register.vue"
import RegisterAdmin from "./components/RegisterAdmin"
import ViewDetailProduk from './components/ViewDetailProduk.vue'
import UbahDetailProduk from './components/UbahDetailProduk.vue'
import TambahProduk from './components/TambahProduk.vue'
import ListAdmin from './components/ListAdmin.vue'
import ViewDetailAdmin from './components/ViewDetailAdmin.vue'
import ViewDetailPembeli from './components/ViewDetailPembeli.vue'
import UbahDetailPembeli from './components/UbahDetailPembeli.vue'


export default [
    { path : '/register', component: Register},
    { path : '/admin-register', component: RegisterAdmin},
    { path : '/', name:'home', component: Homepage},
    { path : '/list-produk', component: ViewListProduk},
    { path : '/list-produk/detail-produk/:id_produk', name: 'detail-produk', component: ViewDetailProduk},
    { path : '/list-produk/detail-produk/:id_produk/ubah-detail-produk', component: UbahDetailProduk},
    { path : '/list-produk/tambah-produk', component: TambahProduk},
    { path : '/admin-teknisi', component: AdminTeknisi},
    { path : '/admin-teknisi/profile', name: 'profile', component: Profile},
    { path : '/teknisi', name:'teknisi', component: Teknisi},
    { path : '/admin-teknisi/list-pesanan', component: ListOrder},
    {
        path: "/login",
        name: "login",
        component: LoginComponent
    },
    {
        path: "/logout",
        name: "logout",
        component: LogoutComponent
    },
    {
        path: "/secure",
        name: "secure",
        component: SecureComponent
    },
   /* { path : '/ubah/{id_teknisi}', component: TeknisiUpdate},*/
    { path : '/teknisi/shift', component: Shift},
    /*{ path : '/manajer-teknisi/profile', component: ManajerTeknisi},*/
    { path : '/jadwalbulanan', component: JadwalBulanan},
    { path : '/admin-teknisi/list-produk', component: ListProduk},
    { path : '/admin/list-admin', component: ListAdmin},
    { path : '/admin/list-admin/detail-admin/:id_admin', name: 'detail-admin', component: ViewDetailAdmin},
    { path : '/pembeli/detail-pembeli/:id_user', name: 'detail-pembeli', component: ViewDetailPembeli},
    { path : '/pembeli/detail-pembeli/ubah-detail-pembeli/:id_user', component: UbahDetailPembeli},
    { path : '/admin-teknisi/list-pesanan', component: ListOrder},

]



/*
export default new Router({
    routes: [
        {
            path: "/login",
            name: "login",
            component: LoginComponent
        },
        {
            path: "/secure",
            name: "secure",
            component: SecureComponent
        },

        { path : '/', component: HelloWorld},
        { path : '/admin-teknisi', component: AdminTeknisi},
        { path : '/admin-teknisi/profile', component: Profile},
        { path : '/admin-teknisi/list-produk', component: ListProduk},
        { path : '/admin-teknisi/list-pesanan', component: ListOrder}
    ]
})*/
