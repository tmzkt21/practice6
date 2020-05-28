import axios from 'axios'

const state = {
    context : "http://localhost:5000/"
}
const actions = {
    async search({commit}, searchWord){
        axios.get(state.context +'naver/'+searchWord)
            .then(({data})=>{
                alert("액션진입")
                commit("SEARCH",data)
            })
            .catch(()=>{
                alert("액션진입실패")
            })
    }
}
const  mutations = {
    SEARCH(state,data){
        alert("뮤테이션 접속")
    }
}
const  getters = {}

export  default {
    name :naver,
    namespaces : true,
    state,
    actions,
    mutations,
    getters
}