import axios from 'axios'
// import router from '@/router'

const state ={
    context : 'http://localhost:5002/'
}
const actions ={
    async search({commit},soccer) {
        axios.post(state.context + 'proxys/soccer' ,soccer,{
            authorization: 'JWT fefege..',
            Accept : 'application/json',
            'Content-Type': 'application/json'
        })
            .then(({data})=>{
                alert('검색된 결과수')
                commit('SEARCH',data)
                // router.push('/Home')
            })
            .catch(()=>{
                alert('통신실패!')
            })

    }
}
const mutations = {
    SEARCH() {
        alert("뮤테이션")
    }
}
const getters = {}




export  default {
    name:'soccer',
    namespaced: true,
    state,
    actions,
    mutations,
    getters
}