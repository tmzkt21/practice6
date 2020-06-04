<template>
    <div>
        <h3>movieSeq :{{item.movieSeq}}</h3>
        <h3>movieSeq : {{item.rank}}</h3>
        <h3>movieSeq : {{item.title}}</h3>
        <h3>movieSeq : {{item.rankDate}}</h3>
    </div>
</template>

<script>
    import {mapState} from "vuex";

    export default {
        created() {
        },
        computed: {
            ...mapState({

                item: state => state.search.item
            })
        },

    }
</script>

