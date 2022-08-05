<template>
    <el-card :body-style="{ padding: '0px'}" style="width: 170px" shadow="hover">
        <img
          :src="teamAvatar"
          class="image"
          style="width: 170px; height: 100px; object-fit: cover"
        />
        <div class="middle" style="padding: 14px">
          <span class="text" style="width: 120px">{{team.name}}</span>
        </div>
        <div class="bottom">
            <img
                :src="teamTag"
                class="image"
                style="width: 60px; object-fit: contain"
            />
        </div>
    </el-card> 
</template>

<script>
import teamTag0 from '../assets/team/teamTag0.png'
import teamTag1 from '../assets/team/teamTag1.png'
import teamTag2 from '../assets/team/teamTag2.png'
export default {
    name: 'TeamCard',

    data() {
        return {
            teamAvatar: 'https://us.123rf.com/450wm/kaisorn/kaisorn1507/kaisorn150700059/43462346-office-workplace-flat-design.jpg',
        }
    },

    props:['team'],

    computed: {
        teamTag(){
            if(this.team.role === 0)
                return teamTag0;
            else if(this.team.role === 1)
                return teamTag1;
            else if(this.team.role === 2)
                return teamTag2;
            else
                return '';
            // 错误怎么处理？
        }
    },
}
</script>

<style>
.bottom {
  margin-bottom: 8px;
  margin-right: 5px;
  float:right
}

.middle{
    display: flex;
    justify-content: flex-start;
    align-items: center;
    margin-left: 0px;
}

.image {
  width: 100%;
  display: block;
}

.text{
    text-align: left;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    font-family: "Microsoft Yahei";
    
}
</style>