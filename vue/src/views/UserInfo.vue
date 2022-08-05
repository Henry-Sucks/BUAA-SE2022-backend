<template>
  <el-form label-width="120px" jusitfy="center">
    <el-form-item label="头像">
      <img :src="info.avatar">
    </el-form-item>
    <el-form-item label="用户名">
      <el-input style = "width:85px" v-model="info.fakeName" />
    </el-form-item>
    <el-form-item style = "width:85px" label="加入时间"/>
      <el-input style = "width:85px" v-model="info.joinDate" />
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
        fakeName: '',
        realName: '',
        job: '',
        corp: '',
        region: '',
        birthday: 0,
        joinDate: 0,
        website: '',
        quote: ''
      }
    }
  }
}
</script>

<style scoped>

</style>