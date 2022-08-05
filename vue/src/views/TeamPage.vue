<template>
  <el-row>
    <el-col :span="12" class="left">
        <img class="image" :src="info.teamAvatar">
        <span>{{info.teamName}}</span>
        <span>创建时间: {{}}</span>
        <span>管理项目</span>
    </el-col>
    <el-col :span="12">
        <span>管理成员</span>
        <ul>


        </ul>
    </el-col>
  </el-row>
</template>

<script>
export default {
    name: 'TeamPage', 

    data(){
        return{
            info:{
                tid: 1,
                name: 'Henry-Sucks',
                avatar: 'https://us.123rf.com/450wm/kaisorn/kaisorn1507/kaisorn150700059/43462346-office-workplace-flat-design.jpg',
                joinDate: "2022.09.01"
            }
        }
    }
    
}
</script>

<style scoped>

.image{
    object-fit: cover;
    width: 700px;
    height:300px;
}

.left {
  border-right: 1px solid rgb(111, 114, 119);
  height: 800px;
}
</style>