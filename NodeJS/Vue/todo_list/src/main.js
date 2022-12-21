import Vue from 'vue'; // 引入vue模块
import App from './App'; // 引入vue组件
import router from './router'; //  引入路由配置文件
import Mock from './mock';
import store from './vuex/store'; //  引入vuex实例
Mock.start();
Vue.config.productionTip = false;  //  关闭生产模式下给出的提示

/* eslint-disable no-new */
new Vue({ //  创建一个 Vue 的根实例
    el: '#app',
    render: h => h(App),
    router, //  注入路由配置
    store, // 注入
})
