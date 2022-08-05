<template>
    <el-row>
    <el-col :span="4">
        <img :src="info.avatar">
    </el-col>
    <div class="topper">
    <el-col :span="4" >
    <el-row>
        <span class="fakeName">{{info.fakeName}}</span>
    </el-row>
    <el-row>
        <span class="joinDate">加入时间:  {{info.joinDate}}</span>
    </el-row>
    </el-col>
    </div>
    </el-row>
    <el-form label-width="120px" jusitfy="center" class="form" :disabled="isSelf">
    <el-form-item label="姓名">
      <el-input style = "width:85px" v-model="info.realName" />
    </el-form-item>
    <el-form-item label="职位">
      <el-input style = "width:120px" v-model="info.job" />
    </el-form-item>
    <el-form-item label="所在公司/学校">
      <el-input style = "width:500px" v-model="info.corp" />
    </el-form-item>
    <el-form-item label="所在地区">
      <el-select v-model="info.region" placeholder="please select your zone">
        <el-option label="上海" value="shanghai" />
        <el-option label="北京" value="beijing" />
      </el-select>
    </el-form-item>
    <el-form-item label="生日">
        <el-date-picker
          v-model="info.birthday"
          type="date"
          placeholder="Pick a date"
          style="width: 120px"
        />
    </el-form-item>
    <el-form-item label="个人网站">
      <el-input style = "width:500px" v-model="info.website" />
    </el-form-item>
    <el-form-item label="个人简介">
      <el-input style = "width:500px" v-model="info.sum" type="textarea" />
    </el-form-item>
  </el-form>
</template>

<script>
import userDefault from '../assets/userDefault.png'
export default{
  name: 'UserInfo',
  data(){
    return{
      info: {
        avatar: userDefault,
        fakeName: 'Henry',
        realName: '',
        job: '',
        corp: '',
        region: '',
        birthday: 0,
        joinDate: '2027/08/09',
        website: '',
        quote: ''
      },

      props:['uid'],

      computed:{
        // 跟目前登陆对比
        isSelf(){
          return true;
        }
      }
    }
  }
}
</script>

<style scoped>
img{
  border-radius:50%;
  width: 200px;
  height: 200px;
}

.fakeName{
  font-weight: 700;
  font-size: 45px;
  margin-top: 80px;
  margin-left: 0px;
}

.joinDate{
  font-weight: 700;
  font-size: 20px;
  margin-top: 20px;
  margin-left: 0px;
}

.form{
  font-weight: 700;
  margin-top: 20px;
}

.topper{
  margin-left: 10px;
}

</style>