import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from "../components/Home";
import Movie from "../components/Movie";
import Music from "../components/Music";
import Soccer from "../components/Soccer";
import MovieDetail from "../components/MovieDetail";

Vue.use(VueRouter)
export default  new VueRouter({
    made:'history',
    base : process.env.BASE_URL,
    routes : [
        {path: '/', component:Home},
        {path: '/movie', component:Movie},
        {path: '/music', component:Music},
        {path: '/soccer', component:Soccer},
        {path: '/movieDetail', component:MovieDetail }

    ]
})


