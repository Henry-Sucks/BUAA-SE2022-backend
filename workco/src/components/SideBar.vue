<template>
<el-menu
    default-active="0"
    class="SideBar"
    :collapse="collapsed"
    @open="handleOpen"
    text-color="#1F80B0"
    active-text-color="#144B66"
    >
<el-sub-menu index="0">
    <template #title>
        <el-image class="nav-icon" :class="{'collapsed' : collapsed}" :src="teamManage" style="width: 30px;"></el-image>
        <span>团队</span>
    </template>
    <el-menu-item @click="teamSelected">
        管理团队
    </el-menu-item>
</el-sub-menu>    
<el-sub-menu index="1">
    <template #title>
        <el-image class="nav-icon" :class="{'collapsed' : collapsed}" :src="teamWork" style="width: 30px;"></el-image>
        <span>项目</span>
    </template>
</el-sub-menu>    
<el-menu-item></el-menu-item>
<el-menu-item></el-menu-item>
<el-menu-item></el-menu-item>
<el-menu-item></el-menu-item>
<el-menu-item></el-menu-item>
<el-menu-item></el-menu-item>
<el-menu-item></el-menu-item>
<el-menu-item></el-menu-item>
<el-menu-item></el-menu-item>
<el-sub-menu index="2">
    <template #title>
        <el-image class="nav-icon" :class="{'collapsed' : collapsed}" :src="user" style="width: 30px;"></el-image>
        <span>账户</span>
    </template>
    <el-menu-item @click="userSelected">
        个人主页
    </el-menu-item>
    <el-menu-item>
        <span style="color:#D61428; font-weight:bolder;">退出登录</span>
    </el-menu-item>
</el-sub-menu> 
</el-menu>

</template>

<script>
const teamManage = require('../assets/menu/teamManage.svg')
const teamWork = require('../assets/menu/teamWork.svg')
const user = require('../assets/menu/user.svg')
export default {
    name: 'SideBar',

    data() {
        return {
            // 资源
            teamManage, teamWork, user,
            collapsed: true
        }
    },

    methods: {
        handleOpen(){
            if(this.collapsed)
                this.collapsed = false
        },
        handleClose(){
            if(this.collapsed)
                this.collapsed = true
        },
        teamSelected(){
            this.$router.push({
          name:'TeamManage'
        })
        },
        userSelected(){
            console.log("调用成功")
            this.$router.push({
            name:'UserInfo',
            params:{
                uid: 1
            }
        })
        },
    },
}
</script>

<style>
.flex-grow{
    flex-grow: 1;
}
.nav-icon{
    margin-bottom: 30px;
    margin-right: 30px;
    transition: all 1s ease-in-out;
}

.nav-icon.collapsed{
    margin-right: 0px;
}

/* .nav-icon:hover{
    transform: rotate(90deg);
    transform-origin: 50% 50%;
} */
</style>