<template>
<div>
  <!-- <el-row>
    <el-col class="header-nav" span="24">
    <el-image  style="width:200px;height:40px" :src="workco" fit="fill"></el-image>
  </el-col>
  </el-row> -->
  <el-menu
    class="el-menu-demo"
    mode="horizontal"
    :ellipsis="false"
    text-color="#1F80B0"
    active-text-color="#144B66"
  >
  <el-image class="logo-img" style="width:200px;height:40px" :src="workco" fit="fill"></el-image>
  <div class="flex-grow" />
  <!-- <el-menu-item @click="login" index="1">
    登录/注册
  </el-menu-item> -->
  </el-menu>
</div>
</template>

<script>
const workco = require('../assets/workco.png')
const color1 = '#6d9ea3'
const color2 = '#a2c1c3'
const color3 = '#c4d3d3'
export default {
    name: 'HeaderNav',
    
    data() {
        return {
            workco, color1, color2, color3
        }
    },

    // methods: {
    //   login(){
    //     this.$router.push({
    //       name: 'Login'
    //     })
    //   }
    // },
}
</script>

<style scoped>
.flex-grow {
  flex-grow: 1;
}
.logo-img{
  margin-top: 8px;
}
</style>