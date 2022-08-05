import { createStore } from 'vuex'
const loginOptions = {
    namespaced: true,
    actions:{
    },
    mutations:{
        setLoggedIn(state){
            if(!state.loggedIn){
                state.loggedIn = !state.loggedIn
            }
        },
        setLoggedOut(state){
            if(!state.loggedIn)
                state.loggedIn = !state.loggedIn
        },
        setUserInfo(state, value){
            state.userInfo.id = value
        }
    },
    state:{
        loggedIn: false,
        userInfo: {
            id: 1,
            userName: ''
        }

    }


}

export default createStore({
    modules:{
        loginOptions
    }
})