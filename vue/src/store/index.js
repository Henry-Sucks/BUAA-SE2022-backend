import { createStore } from 'vuex'
import axios from 'axios'
const loginOptions = {
    namespaced: true,
    actions:{
        getUserInfByEmail(context, email){
            axios({
                method: 'GET',
                url: 'http://localhost:9090/user',
                params: {
                  userEmail: email,
                }
              }).then(response => {
                console.log(response)
                if(response !== null)
                    return 0;
                else
                    return -1;
              })
        }
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
            id: 0,
        }

    }


}

export default createStore({
    modules:{
        loginOptions
    }
})