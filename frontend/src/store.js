/* eslint-disable */
import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';

Vue.use(Vuex);

export const store = new Vuex.Store({
    state:{
        token : localStorage.getItem('access_token') || null
    },
    getters: {
        loggedIn(state){
            return state.token != null
        }
    },
    mutations: {
        retrieveToken(state, token){
            state.token = token
            console.log(axios.defaults.headers)
        },
        destroyToken(state){
            state.token = null
            console.log(axios.defaults.headers)
        }
    },
    actions: {
        retrieveToken(context, user){
            console.log(user.username)
            axios
                .post('http://localhost:8080/api/auth/signin/', {
                    'usernameOrEmail' : user.username,
                    'password' : user.password,
                })
                .then(response => {
                    console.log(response)
                    localStorage.setItem('access_token', response.data.accessToken)
                    context.commit('retrieveToken', response.data.accessToken)
                    axios.defaults.headers.common['Authorization'] = 'Bearer ' + response.data.accessToken
                })
                .catch(error => console.log(error.status))
                .finally(console.log('kelar'))
        },
        destroyToken(context) {
            localStorage.removeItem('access_token')
            axios.defaults.headers.common['Authorization'] = null
            context.commit('destroyToken')
        }
    }
})