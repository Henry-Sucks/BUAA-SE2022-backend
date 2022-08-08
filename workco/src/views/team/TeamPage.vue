<template>
    <div>
        <el-page-header class="page-header" :content="'团队管理界面:'+ teamInfo.name" title="返回" @back="goBack"/>
        <team-header teamName="你好"></team-header>
        <el-tabs
            type="card"
            class="demo-tabs"
        >
            <el-tab-pane label="团队成员" name="first">
                <member-table></member-table>
            </el-tab-pane>
            <el-tab-pane label="团队项目" name="second">
                <project-manage :tid="teamInfo.tid"></project-manage>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>
<script lang="ts" setup>
import TeamHeader from '../../components/teams/TeamHeader.vue'
import MemberTable from '../../components/teams/MemberTable.vue'
import ProjectManage from '../projects/ProjectManage.vue'
import {reactive} from "vue"
import { useRouter } from 'vue-router';
const router = useRouter()


// 得到该组的完整信息：放在vuex上
const teamInfo = reactive({
    tid: 1,
    name: 'Dick',

})

function goBack(){
    router.go(-1)
}
</script>

<style scoped>
.page-header{
    position: relative;
    top: 30px;
    margin-bottom: 50px;
}
</style>