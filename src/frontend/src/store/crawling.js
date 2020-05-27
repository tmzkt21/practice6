import  axios from  'axios'
import router from '@/router'

const state = {
    context : 'http://localhost:5000/',
    bugsmusic : [],
    count : 0

}
const actions = {
    async search({commit},searchWord){
        alert('검색어:' +searchWord)

        axios.post(state.context + `bugsmusic`,searchWord,{

                authorization: 'JWT fefege..',
                Accept : 'application/json',
                'Content-Type': 'application/json'

        })
            .then(({data})=>{
                alert('검색된 결과수'+data.count)
                commit('SEARCH',data)
                router.push('/retriever')
            })
            .catch(()=>{
                alert('통신 실패!')
            })
    }
}
const mutations = {
    SEARCH(state, data) {
        alert('뮤테이션에서 결과수 :' + data.count)
        state.bugsmusic = []
        state.count = data.count
        data.list.forEach(item =>{
            state.bugsmusic.push(
                // {seq:item.seq,
                //     artist:item.artist,
                //      title:item.title,
                //     thumbnail:item.thumbnail}
                [item.seq,
                item.artist,
                item.title,
                item.thumbnail]
                )}
        )


    }
}
const  getters = {
    bugsmusic : state => state.bugsmusic,
    count :state => state.count


    //자바 스크립트는 funcion 이있고  funcion 에의해 리턴값이 있다
    // Function<Integer, T> f = inventory::get;
}

export default {
    name:'crawling',
    namespaced : true,
    state,
    actions,
    mutations,
    getters

}















// import axios from 'axios'
//
// const state = {
//     context : 'http://localhost:3000/'
//     fail : false,
//     crawer : {}
// }
// const actions = {
//     async search({commit},searchWord){
//         const url = state.context + `crawlings/${searchWord.userId}/access`
//         const headerx = {
//             authorization: 'JWT fefege..',
//             Accept : 'application/json',
//             'Content-Type' : 'application/json'
//         }
//         axios.post(url,search,headerx)
//             .then(({data})=>{
//                 if (data.result){
//                     alert('액션 커밋 성공')
//                     commit('UPDATE',data)
//                 }else{
//                     alert('액션 커밋 성공')
//                     commit('FAIL_COMMIT')
//                 }
//             })
//             .catch(()=>{
//                 alert('서버 전송 실패')
//                 state.fail = true
//             })
//     }
// }
// const mutations = {
//     UPDATE(state,data){
//         state.crawer = data.crawer
//         localStorage.setItem('token', data.token)
//         localStorage.setItem('userid'data.crawer.userId)
//         if (data.userId =!  )
//     }
// }
// const getters = {}
//
// export  default  {}