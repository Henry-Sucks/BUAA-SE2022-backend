import {createRouter,createWebHistory} from 'vue-router';
import HomeView from '@/views/HomeView.vue'
import TeamManage from '@/views/team/TeamManage.vue'
import HomePage from '@/views/HomePage.vue'
import UserInfo from '@/views/UserInfo.vue'
import LoginView from '@/views/LoginView.vue'
import RegisterView from '@/views/RegisterView.vue'
import TeamPage from '@/views/team/TeamPage.vue'
import ProjectPage from '@/views/projects/ProjectPage.vue'
import FileCenter from '@/views/files/FileCenter.vue'
import ProjectFile from '@/views/projects/ProjectFile.vue'
import FileEditor from '@/views/files/FileEditor.vue'

import TestView from '@/views/TestView.vue'
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
                path: 'teamManage',
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
                component: ProjectPage,
                children: [
                    {
                        path: 'file',
                        name: 'ProjectFile',
                        component: ProjectFile
                    },
                    {
                        path: 'file/:fid',
                        name: 'FileEditor',
                        component: FileEditor
                    },
                    // {
                    //     path: 'design',
                    //     name: 'ProjectDesign',
                    //     component: ProjectDesign
                    // }
                ]
            },

        ]
    },

    {
        path: '/test',
        name: 'TestView',
        component: TestView
    },

    
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router
