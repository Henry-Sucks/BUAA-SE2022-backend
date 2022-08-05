<template>
  <div>
      <!-- <h1>
        <span class="google-blue">W</span>
        <span class="google-red">O</span>
        <span class="google-yellow">R</span>
        <span class="google-blue">K</span>
        <span class="google-green">C</span>
        <span class="google-red">O</span>
      </h1> -->
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
        <el-col :span="10">
          <h2 class="text">
          在沃扣上自由结识朋友、自由组成团队、共同开发项目。沃扣是为中小型开发团队提供数字信息管理与协同的一站式工作中心。
          </h2>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="3"></el-col>
        <el-button class="button" color="#1F80B0" @click="login">免费使用</el-button>
      </el-row>
      <el-carousel height="400px">
          <el-carousel-item v-for="pic in pics" :key="pic">
            <el-image  style="width:600px;height:400px" :src="pic" fit="contain"></el-image>
          </el-carousel-item>
      </el-carousel>
  </div>
</template>

<script>
const pic1 = require('../assets/test1.jpg')
const pic2 = require('../assets/test2.jpg')
const pic3 = require('../assets/test3.jpg')
export default {
    name: 'HomeView',

    data() {
      return {
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
      login(){
        this.$router.push({
          name: 'Login'
        })
      },
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


</style>