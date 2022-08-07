import {createRouter,createWebHistory} from 'vue-router';
import HomeView from '@/views/HomeView.vue'
import TeamManage from '@/views/team/TeamManage.vue'
import HomePage from '@/views/HomePage.vue'
import UserInfo from '@/views/UserInfo.vue'
import LoginView from '@/views/LoginView.vue'
import RegisterView from '@/views/RegisterView.vue'
import TeamPage from '@/views/team/TeamPage.vue'
import ProjectPage from '@/views/projects/ProjectPage.vue'

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

            {
                path: 'team/:tid',
                name: 'TeamPage',
                component: TeamPage
            },

            {
                path: 'project/:pid',
                name: 'ProjectPage',
                component: ProjectPage
            },

        ]
    },

    
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router
