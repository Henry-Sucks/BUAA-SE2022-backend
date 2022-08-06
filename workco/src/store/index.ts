import { createStore } from 'vuex';

const loginOptions = {
  namespaced: true,
  actions:{
  },
  mutations:{
      setLoggedIn(state: { loggedIn: boolean; }){
          if(!state.loggedIn){
              state.loggedIn = !state.loggedIn
          }
      },
      setLoggedOut(state: { loggedIn: boolean; }){
          if(!state.loggedIn)
              state.loggedIn = !state.loggedIn
      },
      setUserInfo(state: { userInfo: { id: any; }; }, value: any){
          state.userInfo.id = value
      }
  },
  state:{
        // 记录当前是否登录
        loggedIn: false,

        // 记录当前登录用户的所有信息
        userInfo: {
            uid: 1,
            userName: ''
            // ......
        }

  }
}

const teamOptions = {
    namespaced: true,
    actions:{
    },
    mutations:{

    },
    state:{
          // 记录当前查看组的所有信息
          teamInfo: {
              tid: 1,
              userName: ''
              // ......
          }
  
    }
  }

export default createStore({
  modules:{
      loginOptions,
      teamOptions
  }
})