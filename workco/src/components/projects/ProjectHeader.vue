<template>
    <el-row class="project-header">
    <el-col :span="1">
        <el-avatar  shape="square" size='large' :src="projectAvatar" />
    </el-col>
        <span class="text">{{projectName}}</span>
        <el-col :span="1"></el-col>
        <el-button  color="#1F80B0" :icon="Edit" @click="openEdit"/>
        <span>{{teamName}}</span>
    </el-row>

    <!-- <el-dialog>
        v-model="editState"
        title="修改项目信息"
    >
    </el-dialog> -->
</template>

<script lang="ts" setup>
import {Edit} from '@element-plus/icons-vue'
import {ref, reactive} from 'vue'
import TeamConfig from '../../components/teams/TeamConfig.vue'
const props = defineProps({
    projectAvatar:{
      type: String,
      default: 'https://us.123rf.com/450wm/kaisorn/kaisorn1507/kaisorn150700059/43462346-office-workplace-flat-design.jpg'  
    },
    projectName: String,
    teamName: String
})

let editState = ref(false)
function openEdit(){
    editState.value = true
}
</script>

<style scoped>
.project-header{
    align-items: center;
    margin-bottom: 20px;
}

.project-header.item{
    margin-right: 20px;
}
.text{
    font-weight:600;
    font-size: 30px;
    position: relative;
    left: 20px
}
</style>