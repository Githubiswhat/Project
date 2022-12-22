import Vue from 'vue'
import router from './router/router'
import store from './store/'
import './style/common'
import './config/rem'

new Vue({
    router,
    store,
}).$mount('#app')