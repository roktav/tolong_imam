import HelloWorld from './components/HelloWorld.vue'
import AdminTeknisi from './components/AdminTeknisi.vue'
import Profile from './components/Profile.vue'
import ListProduk from './components/ListProduk.vue'
import ListOrder from './components/ListOrder.vue'
import AboutUs from './components/AboutUs.vue'
import OurPartners from './components/OurPartners.vue'
import ContactUs from './components/ContactUs.vue'
import Faq from './components/Faq.vue'
import Order from './components/Order.vue'
import orderTemplate from './components/orderTemplate.vue'


export default [
    { path : '/', component: HelloWorld},
    { path : '/admin-teknisi', component: AdminTeknisi},
    { path : '/admin-teknisi/profile', component: Profile},
    { path : '/admin-teknisi/list-produk', component: ListProduk},
    { path : '/admin-teknisi/list-pesanan', component: ListOrder},
    { path : '/about-us', component: AboutUs},
    { path : '/partners', component: OurPartners},
    { path : '/contact-us', component: ContactUs},
    { path : '/faq', component: Faq},
    { path : '/order', component: Order},
    { path : '/orderTemplate', component: orderTemplate}

]