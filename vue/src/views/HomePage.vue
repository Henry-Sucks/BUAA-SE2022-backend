<template>
  <div>
    <el-row>
      <el-col :span="3">
        <side-bar></side-bar>
      </el-col>
      <el-col :span="21">
        <router-view></router-view>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import SideBar from '@/components/SideBar.vue'
export default {
    name: 'HomePage',
    components:{
        SideBar, 
    }
}
</script>

<style>

</style>