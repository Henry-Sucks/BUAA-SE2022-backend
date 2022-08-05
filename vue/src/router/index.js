import {createRouter,createWebHistory} from 'vue-router';
import HomeView from '@/views/HomeView'
import TeamManage from '@/views/TeamManage'
import HomePage from '@/views/HomePage'
import UserInfo from '@/views/UserInfo'
import LoginView from '@/views/LoginView'
import RegisterView from '@/views/RegisterView'
const routes = [
    {
        path: '/',
        name: 'HomeView',
        component: HomeView
    },

    {
        path: '/register',
        name: 'Register',
        component: RegisterView
    },

    {
        path: '/login',
        name: 'Login',
        component: LoginView
    },

    {
        path: '/home',
        name: 'HomePage',
        component: HomePage,
        children:[
            {
                path: 'team',
                name: 'TeamManage',
                component: TeamManage
            },

            {
                path: 'info/:uid',
                name: 'UserInfo',
                component: UserInfo
            },

        ]
    },

    
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router