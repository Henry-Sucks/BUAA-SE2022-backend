<template>
    <el-row class="header">
        <el-button 
        color="#1F80B0" :icon="Plus" round
        >
        邀请用户
        </el-button>
        <el-button 
        type="danger" :icon="Delete" round
        >
        解散团队
        </el-button>
    </el-row>
    <el-table :data="memberData" style="width: 100%">
        <el-table-column label="成员">
            <template #default="scope">
                <span class="text">{{scope.row.name}}</span>
                <img class="pic" :src="getRoleTag(scope.row.role)" style="width:50px; ">
            </template>
        </el-table-column>
        <el-table-column label="成员邮箱">
            <template #default="scope">
                <span class="text">{{scope.row.email}}</span>
            </template>
        </el-table-column>
        <el-table-column label="操作">
            <template #default="scope">
                <el-button size="default" type="success" round v-if="selfRole !=2  && scope.row.role == 2"
                >任命管理员
                </el-button>
                <el-button size="default" type="warning" round v-if="selfRole == 0  && scope.row.role == 1"
                >解除管理员
                </el-button>
                <el-button size="default" type="danger" round v-if="selfRole !=2  && scope.row.role == 2"
                >移出团队
                </el-button>
            </template>
        </el-table-column>
    </el-table>
</template>

<script lang="ts" setup>
import {
  Delete,
  Plus
} from '@element-plus/icons-vue'
interface Member {
  name: string
  email: string
  role: number
}

let selfRole = 0

function getRoleTag(role: number){
    if(role == 0)
        return require('../../assets/team/teamTag0.png')
    else if(role == 1)
        return require('../../assets/team/teamTag1.png')
    else if(role == 2)
        return require('../../assets/team/teamTag2.png')
    else
        return null
}

const memberData: Member[] = [
    {
        name: 'Henry',
        email: '13078959526',
        role: 0
    },
    {
        name: 'ABBBBBBB',
        email: '13078959526',
        role: 1
    },
    {
        name: 'Henry',
        email: '13078959526',
        role: 2
    },
    
]
</script>
<style scoped>
.header{
    margin-bottom: 15px;
}

.pic{
    position: relative;
    top: 5px;
    left: 20px;
}
</style>