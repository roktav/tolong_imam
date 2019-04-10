import Homepage from './components/Homepage.vue'
import ViewListProduk from './components/ViewListProduk.vue'
import AdminTeknisi from './components/AdminTeknisi.vue'
import Profile from './components/Profile.vue'
import Teknisi from './components/Teknisi.vue'
//import TeknisiUpdate from './components/TeknisiUpdate.vue'
import Shift2 from './components/Shift2.vue'
import Shift from './components/Shift.vue'
import JadwalBulanan from './components/JadwalBulanan.vue'
import ListProduk from './components/ListProduk.vue'
import ListOrder from './components/ListOrder.vue'
import AboutUs from './components/AboutUs.vue'
import OurPartners from './components/OurPartners.vue'
import ContactUs from './components/ContactUs.vue'
import Faq from './components/Faq.vue'
import orderTemplate from './components/orderTemplate.vue'
import ViewDetailProduk from './components/ViewDetailProduk.vue'
import UbahDetailProduk from './components/UbahDetailProduk.vue'
import TambahProduk from './components/TambahProduk.vue'


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
   // { path : '/ubah/{id_teknisi}', component: TeknisiUpdate},
    { path : '/teknisi/shift', component: Shift},
    { path : '/teknisi/shiftt', component: Shift2},
    { path : '/jadwalbulanan', component: JadwalBulanan},
    { path : '/admin-teknisi/list-produk', component: ListProduk},
    { path : '/admin-teknisi/list-pesanan', component: ListOrder},
    { path : '/about-us', component: AboutUs},
    { path : '/partners', component: OurPartners},
    { path : '/contact-us', component: ContactUs},
    { path : '/faq', component: Faq},
    { path : '/orderTemplate', component: orderTemplate}




]