<template>
  <div>
    <el-row>
      <el-col :span="3"></el-col>
      <el-col :span="10">
        <h1 class="text">
          <div class="text-anime">
            <span class="typed-text" v-html="typeValue"></span>
            <span class="cursor" :class="{'typing' : typeStatus}">&nbsp;</span>
          </div>
          <span style="color:#4A848C">沃扣</span>
          <span>：新一代软件工程协作与管理平台</span>
        </h1>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="3"></el-col>
      <el-col :span="8">
        <login-form></login-form>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import axios from 'axios'
import {Lock} from '@element-plus/icons-vue'
import LoginForm from '../components/LoginForm.vue'
const pic1 = require('../assets/test1.jpg')
const pic2 = require('../assets/test2.jpg')
const pic3 = require('../assets/test3.jpg')
export default {
  name: 'LoginView',
  components: {
    Lock, LoginForm
  },
  data() {
    return {
      info: {
        email : '',
        password : '',
      },
      
      

      pics : [
        pic1, pic2, pic3
      ],

      // 打字动画
      typeValue: '',
      typeStatus: false,
      typeContent: 'WorkCo',
      typingSpeed: 300,
      erasingSpeed: 100,
      newTextDelay: 2000,
      charIndex: 0,
      textColors: ['#2F77B5', '#D94437', '#EAB52A', '#2F77B5', '#489F4D', '#D94437', null, null]

    }
  },

  methods: {
    // handleLogin(){
        // axios({
        //     method: 'GET',
        //     url: 'http://localhost:9090/user/login',
        //     params: {
        //       userEmail: this.info.email,
        //       passWord: this.info.password
        //     }
        //   }).then(response => {
        //     let res = response.data
        //     console.log(res.data)
        //     if(res === 1)
        //       this.$store.commit('loginOptions/setLoggedIn')
        //     else if(res === 0)
        //       alert('密码输入错误')
        //     else if(res === -1)
        //       alert('不存在该用户')
        //       })
        
    // },


    typeText() {
      if(this.charIndex < this.typeContent.length){
        if(!this.typeStatus)
          this.typeStatus = true;
        this.typeValue +=
            '<span style="color:' + this.textColors[this.charIndex] + '">' + this.typeContent.charAt(this.charIndex) + '</span>'
        this.charIndex += 1;
        setTimeout(this.typeText, this.typingSpeed)
      }
      else{
        this.typeStatus = false;
        setTimeout(this.eraseText, this.newTextDelay)
      }
    },

    eraseText() {
      if(this.charIndex > 0){
        if(!this.typeStatus)
          this.typeStatus = true;

        this.typeValue = this.typeContent.substring(0, this.charIndex - 1);
        this.charIndex -= 1;
        setTimeout(this.eraseText, this.erasingSpeed);
      }
      else{
        this.typeStatus = false;

        setTimeout(this.typeText, this.newTextDelay)
      }
    }
  },

  created() {
    setTimeout(this.typeText, this.newTextDelay)
  },
}

</script>

<style lang="scss" scoped>
.text{
  float: left;
  text-align: left;
  margin-bottom: 0px;
  padding-bottom: 0px;
}

h1{
  font-size: 45px;

  .text-anime{
    font-size: 100px;
  }

  span.cursor {
    display: inline-block;
    margin-left: 3px;
    width: 4px;
    background-color: #000;
    animation: cursorBlink 1s infinite;
  }

  span.cursor.typing {
    animation: none;
  }

  @keyframes cursorBlink {
    49% {background-color: #000}
    50% {background-color: transparent}
    99% {background-color: transparent}
  }
}

.button {
  width: 100px;
  height: 40px;
  margin-top: 15px;
}

.login-block{
  margin-top: 20px
}
.login-text{
  margin-top: 5px;
  margin-bottom: 5px;
  font-weight: bold;
  font-size: 25px;
  color: #072f42;
}

</style>