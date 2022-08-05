<template>
  <el-container>
    <el-header>
    <header-nav></header-nav>
    </el-header>
    <el-main>
    <router-view></router-view>
    </el-main>
  </el-container>
</template>

<script>
import HeaderNav from '@/components/HeaderNav.vue';
import { mapState } from 'vuex';
export default {
  name: 'App',
  components:{
    HeaderNav, 
  },

  computed: {
    ...mapState('loginOptions', ['loggedIn'])
  },

  watch:{
    loggedIn(newValue){
      if(newValue === true){
        this.$router.push({
          name:'HomePage'
        })
      }
      else{
        this.$router.push({
          name:'HomeView'
        })
      }
    }
  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.header-nav {
  margin-top: 0;
  padding-top: 0;
}
</style>
