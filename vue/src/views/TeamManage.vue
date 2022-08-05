<template>
    <el-container>
      <el-header>
        <el-row>
          <el-col :span="7"></el-col>
          <el-col :span="8">
            <el-input v-model="searchInput" class="input" placeholder="通过队名搜索团队">
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
            :key="data.id" 
            :data="data"
            :span="4">
            <team-card class="page-item" @click="enterTeam(data.tid)"  :team="data"></team-card>
            </el-col>
        </el-row>
      </el-main>
      <el-footer>
        <el-row>
          <el-col :span="7"></el-col>
            <div class="demo-pagination-block">
              <el-pagination
                :hide-on-single-page="ifSinglePage"
                :background="background"
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

<script>
import TeamCard from '@/components/TeamCard.vue'
export default {
    name: 'TeamManage',
    components: {
        TeamCard
    },

    data(){
      return{
          datas:[
            {tid: -1, name:'新建团队', role:-1, avatar:'https://cdn-icons.flaticon.com/png/512/3018/premium/3018447.png?token=exp=1659691511~hmac=d23404e2e5b8e5d4896cfa2e241e730b'},
            {tid: 1, name:'1', role:0, avatar:'https://us.123rf.com/450wm/kaisorn/kaisorn1507/kaisorn150700059/43462346-office-workplace-flat-design.jpg'},{name:'2', role:1},{name:'3', role:2},{name:'1', role:0},{name:'2', role:1},{name:'3', role:2},{name:'1', role:0},{name:'2', role:1},{name:'3', role:2},{name:'1', role:0},{name:'2', role:1},{name:'3', role:2},{name:'1', role:0},{name:'2', role:1},{name:'3', role:2},{name:'1', role:0},{name:'2', role:1},{name:'3', role:2},
          ],

          // 分页功能
          perPage: 12,
          // 注意，这里不是index而是页数，从1开始
          curPage: 1,

          // 搜索群组
          searchInput: ''
      }
    },

    computed:{
      totalItems(){
        return this.datas.length;
      },
      totalPages(){
        console.log(this.totalPages)
        return this.datas.length / this.perPage;
      },
      ifSinglePage(){
        if(this.totalPages > 1)
          return false;
        else
          return true;
      },
      paginatedData(){
        let start = (this.curPage -1) * this.perPage, end = start + this.perPage
        return this.filteredData.slice(start, end)
      },

      filteredData(){
        if(this.searchInput !== '')
          return this.datas.filter(data => data.name.includes(this.searchInput))
        else
          return this.datas
      }
    },

    methods:{
      enterTeam(tid){
        this.$router.push({
            name: 'TeamPage',
            params: {
                tid: tid
            }
        })
      }
    }
}
</script>

<style>
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

.main{
  margin-top: 40px;
}
</style>