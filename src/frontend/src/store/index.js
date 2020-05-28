import Vue from 'vue'
import Vuex from 'vuex'
import crawling from "./crawling"
import soccer from "./soccer"
import naver from  "./naver"

Vue.use(Vuex)

export const store = new Vuex.Store({
    modules : {
        crawling,soccer,naver
    }
})


