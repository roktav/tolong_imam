import HelloWorld from './components/HelloWorld.vue'
import AdminTeknisi from './components/AdminTeknisi.vue'
import Profile from './components/Profile.vue'
<<<<<<< HEAD
import AboutUs from './components/AboutUs.vue'
import OurPartners from './components/OurPartners.vue'
import ContactUs from './components/ContactUs.vue'
import Faq from './components/Faq.vue'
=======
import ListProduk from './components/ListProduk.vue'
import ListOrder from './components/ListOrder.vue'
>>>>>>> 0b417e96c86eb8fa9fbab29c272410af757c2351


export default [
    { path : '/', component: HelloWorld},
    { path : '/admin-teknisi', component: AdminTeknisi},
    { path : '/admin-teknisi/profile', component: Profile},
<<<<<<< HEAD
    { path : '/about-us', component: AboutUs},
    { path : '/partners', component: OurPartners},
    { path : '/contact-us', component: ContactUs},
    { path : 'faq', component: Faq}
=======
    { path : '/admin-teknisi/list-produk', component: ListProduk},
    { path : '/admin-teknisi/list-pesanan', component: ListOrder}
>>>>>>> 0b417e96c86eb8fa9fbab29c272410af757c2351

]