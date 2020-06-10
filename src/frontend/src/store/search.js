import router from "@/router";
import axios from "axios";

const state ={
    context : "http://localhost:5000",
    searchWord : 'null',
    pageNumber: '0',
    list : [],
    pages : [],
    pager: {},
    item : {}

}
const actions ={
    async find({commit},searchWord){
        commit("SEARCHWORD",searchWord)
        switch (searchWord) {
            case '영화': router.push("/movie")
                break
            case '음악': router.push("/music")

                break
            case '축구': router.push("/soccer")
                break
        }
    },
    async transferPage({commit},payload){
        axios.
        get(`${state.context}/${payload.cate}/${payload.searchWord}/${payload.pageNumber}`)
            .then(({data})=>{
                commit("TRANSFER",data)
            })
            .catch()
    },
    async next({commit},payload){
    axios.
    get(`${state.context}/${payload.cate}/${payload.searchWord}/${payload.pageNumber}`)
        .then(({data})=>{
            commit("NEXT",data)
        })
        .catch(()=>{
            alert("액션실패!")
        })
    },
    async retrieveOne({commit},payload){
        axios.get(`${state.context}/${payload.cate}/${payload.searchWord}`)
            .then(({data})=>{
                commit("DETAIL",data)
                router.push('/moviedetail')
            })
            .catch(()=>{
                alert("액션실패!")
            })
    }

}
const mutations ={
    NEXT(state, data){
        state.searchWord = data
    },
    TRANSFER(state, data){
        state.pager = data.pager
        state.list = data.list
    },
    DETAIL(state, data){
        state.item = data
    }

}
export default {
    name:"search",
    namespaced: true,
    state,
    actions,
    mutations
}