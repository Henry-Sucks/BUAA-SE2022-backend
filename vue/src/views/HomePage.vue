<template>
    <el-row>
      <el-col :span="3">
        <side-bar></side-bar>
      </el-col>
      <el-col :span="21">
        <!-- <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item><a href="/">管理{{userName}}的团队</a></el-breadcrumb-item>
          <el-breadcrumb-item>promotion list</el-breadcrumb-item>
          <el-breadcrumb-item>promotion detail</el-breadcrumb-item>
        </el-breadcrumb> -->
        <router-view class="view"></router-view>
      </el-col>
    </el-row>

</template>

<script>
import SideBar from '@/components/SideBar.vue'
export default {
    name: 'HomePage',
    components:{
        SideBar, 
    },

    data(){
      return{
        userName: 'Henry'
      }
    }
}
</script>

<style sc>

</style>