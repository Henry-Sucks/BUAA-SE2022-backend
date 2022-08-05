<template>
  <el-container class="layout-container-demo" style="height: 500px">
    <el-container>
      <el-header >
        <el-row :gutter="20">
          <el-col :span="8"><img src="../assets/WorkCo.png"></el-col>
          <el-col :span="8"><h1>软工小组</h1></el-col>
          <el-col :span="7"><el-dropdown>
              <el-button >操作</el-button>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item>解散</el-dropdown-item>
                  <el-dropdown-item>邀请</el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown></el-col>
        </el-row>
      </el-header>
      <br>
			<el-header>
        <el-row :gutter="30">
          <el-col :span="12"><h1>Jeff</h1></el-col>
          <el-col :span="12"><img src="../assets/teamTag0.png"></el-col>
        </el-row>
      </el-header>
    <el-container>
      <el-aside>

      </el-aside>
      <el-main class="el-main">
        <el-scrollbar class="scrollbar" >
          <el-table :data="tableData">
            <el-table-column prop="pos" label="职务" />
            <el-table-column prop="name" label="姓名"/>
            <el-table-column prop="mail" label="邮箱" />
            <el-table-column label="操作">
            <el-dropdown>
            <el-button >查看</el-button>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item>升职</el-dropdown-item>
                <el-dropdown-item>降职</el-dropdown-item>
                <el-dropdown-item>踢出</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
          </el-table-column>
          </el-table>
        </el-scrollbar>
      </el-main>
      <el-aside></el-aside>
    </el-container>
      
    </el-container>
  </el-container>
</template>

<script scope setup>
import { ref } from 'vue'

const item = {
  pos: '创建人',
  name: 'Tom',
  mail: 'xxxx@qq.com',
}
const tableData = ref(Array.from({ length: 20 }).fill(item))
</script>

<style scoped>
.layout-container-demo .el-header {
  position: relative;
  background-color: var(--el-color-primary-light-7);
  color: var(--el-text-color-primary);
  height: 75px;
}
.layout-container-demo .el-aside {
  color: var(--el-text-color-primary-light-9);
  background: var(--el-color-primary-light-9);
  width: 400px;
  height:555px;
}
.layout-container-demo .el-menu {
  border-right: none;
}
.layout-container-demo .el-main {
  padding: 0;
  text-align: center;
}
.layout-container-demo .toolbar {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  right: 20px;
}
.scrollbar {
  width: 850px;
  height: 555px;
}
</style>
