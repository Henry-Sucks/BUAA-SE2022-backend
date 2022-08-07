<template>
    <el-container>
      <el-header>
        <el-row>
          <el-col :span="7">
          <el-button 
            color="#1F80B0" class="input new-button" round
          >
            新建项目
          </el-button>
          </el-col>
          <el-col :span="8">
            <el-input v-model="searchInput" class="input" placeholder="通过项目名搜索项目">
                <template #prefix>
                  <el-icon><search /></el-icon>
                </template>
          </el-input>
          </el-col>
        </el-row>
      </el-header>
      <el-main>
        <el-row class="main">
            <el-col 
            v-for="data in paginatedData"
            :key="data.pid" 
            :data="data"
            :span="4">
            <team-card class="page-item" @click="enterProject(data.pid)"  :team="data"></team-card>
            </el-col>
        </el-row>
      </el-main>
      <el-footer>
        <el-row>
          <el-col :span="7"></el-col>
            <div class="demo-pagination-block">
              <el-pagination
                :hide-on-single-page="ifSinglePage"
                layout="total, prev, pager, next, jumper"
                :total="filteredData.length"
                :page-size="perPage"
                v-model:current-page="curPage"
              />
          </div>
        </el-row>
      </el-footer>
    </el-container>
</template>

<script lang="ts" setup>
import TeamCard from '../../components/TeamCard.vue'
import {reactive, ref, computed} from 'vue'
import {useRouter} from 'vue-router'

// 所有数据
const datas = [
            {pid: 1, name:'1'},{pid: 2, name:'1'}
          ]

// 分页功能
const perPage = ref(12)
// 注意，这里不是index而是页数，从1开始
const curPage = ref(1)
// 搜索群组
let searchInput = ref('')

let totalItems = computed(() => {
    return datas.length;
})

let totalPages = computed(() => {
    console.log(totalPages)
    return datas.length / perPage.value;
})

let ifSinglePage = computed(() => {
    if(totalPages.value > 1)
        return false;
    else
        return true;
})

let paginatedData = computed(() => {
    let start = (curPage.value -1) * perPage.value, end = start + perPage.value
    return filteredData.value.slice(start, end)
})

let filteredData = computed(() => {
    if(searchInput.value !== '')
        return datas.filter(data => data.name.includes(searchInput.value))
    else
        return datas
})

const router = useRouter()
function enterProject(pid: number){
    router.push({
            name: 'ProjectPage',
            params: {
                pid: pid
            }
        })
}

// 分页



</script>

<style scoped>
.page-item{
  margin-left: 10px;
  margin-bottom: 30px;
}

.page-header{
  margin-top: 20px;
  color:  #1F80B0
}

.input{
  margin-top: 15px;
  margin-bottom: 0px;
  
}

.new-button{
  position:relative;
  left: 150px
}

.main{
  margin-top: 40px;
}
</style>