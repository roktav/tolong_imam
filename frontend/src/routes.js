import HelloWorld from './components/HelloWorld.vue'
import HelloWinscore from './components/HelloWinscore.vue'
import ViewListProduk from "./components/ViewListProduk";


export default [
    { path : '/', component: HelloWorld},
    { path : '/admin', component: HelloWinscore},
    { path : '/list-produk', component: ViewListProduk}
]