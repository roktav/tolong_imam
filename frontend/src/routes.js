import HelloWorld from './components/HelloWorld.vue'
import AdminTeknisi from './components/AdminTeknisi.vue'
import Profile from './components/Profile.vue'
import AboutUs from './components/AboutUs.vue'
import OurPartners from './components/OurPartners.vue'
import ContactUs from './components/ContactUs.vue'
import Faq from './components/Faq.vue'


export default [
    { path : '/', component: HelloWorld},
    { path : '/admin-teknisi', component: AdminTeknisi},
    { path : '/admin-teknisi/profile', component: Profile},
    { path : '/about-us', component: AboutUs},
    { path : '/partners', component: OurPartners},
    { path : '/contact-us', component: ContactUs},
    { path : 'faq', component: Faq}

]