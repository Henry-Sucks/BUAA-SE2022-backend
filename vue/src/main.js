import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import store from './store/index.js'
import axios from 'axios'
import VueAxios from 'vue-axios'

import * as ElementPlusIconsVue from '@element-plus/icons-vue'


const app = createApp(App)
app.use(VueAxios,axios);
axios.get('api/getNewsList')
.then((response)=>{
    console.log(response)
})

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}

app.use(router).use(ElementPlus).use(store).mount('#app')
