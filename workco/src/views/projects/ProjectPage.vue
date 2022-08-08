<template>
    <div>
        <el-page-header class="page-header" :content="'项目管理界面:'+ projectInfo.name" title="返回" @back="goBack"/>
        <team-header teamName="你好"></team-header>
        <el-tabs
            type="card"
            class="demo-tabs"
        >
            <el-tab-pane label="团队成员" name="first">
                <member-table></member-table>
            </el-tab-pane>
            <el-tab-pane label="团队项目" name="second">
                <project-manage></project-manage>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>

<script lang="ts" setup>
import {reactive} from "vue"
import ProjectHeader from '../../components/projects/ProjectHeader.vue'
import { useRouter } from 'vue-router';
const router = useRouter()

// 得到该项目的完整信息：放在vuex上
const projectInfo = reactive({
    pid: 1,
    name: 'Dick',
    tid: 1
})
</script>