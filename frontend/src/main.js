  import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import Routes from './routes'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css' // Ensure you are using css-loader
import axios from 'axios'
import VueAxios from 'vue-axios'
import VueSelectImage from 'vue-select-image'
import { store } from './store'

Vue.config.productionTip = false

Vue.use(Vuetify,{
  theme: {
    primary: '#28292B',
    secondary: '#009688',
    warning: '#ef5350'
  }
});
Vue.use(VueRouter);
Vue.use(VueAxios, axios);
Vue.use(VueSelectImage);

require('vue-select-image/dist/vue-select-image.css');


const router = new VueRouter({
  routes: Routes,
  mode: 'history'
});

new Vue({
  render: h => h(App),
  router: router,
  store,
}).$mount('#app')
