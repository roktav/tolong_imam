import HelloWorld from './components/HelloWorld.vue'
import AdminTeknisi from './components/AdminTeknisi.vue'
import Profile from './components/Profile.vue'
import Teknisi from './components/Teknisi.vue'


export default [
    { path : '/', component: HelloWorld},
    { path : '/admin-teknisi', component: AdminTeknisi},
    { path : '/admin-teknisi/profile', component: Profile},
    { path : '/teknisi', component: Teknisi}

]