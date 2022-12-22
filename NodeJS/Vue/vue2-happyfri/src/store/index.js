import Vue from 'vue'
import Vuex from 'vuex'
import mutations from './mutations'
import actions from './action'
import Mock from 'mockjs';

Vue.use(Vuex)

let itemDetail = []

const state = {
    level: '第一周', //活动周数
    itemNum: 1, // 第几题
    allTime: 0,  //总共用时
    timer: '', //定时器
    itemDetail,
    answerId: [], //答案id
}

for (let i = 1; i <= 5; i++) {
    let topic_id = i
    itemDetail.push(Mock.mock(
        {
            "topic_id": topic_id,
            "active_topic_id": 4,
            "type": "ONE",
            "topic_name": "题目",
            "active_id": 1,
            "active_title": Mock.Random.csentence(),
            "active_topic_phase": "第一周",
            "active_start_time": "1479139200",
            "active_end_time": "1482163200",
            "topic_answer": [{
                "topic_answer_id": 1,
                "topic_id": topic_id,
                "answer_name": Mock.Random.csentence(),
                "is_standard_answer": 0
            }, {
                "topic_answer_id": 2,
                "topic_id": topic_id,
                "answer_name": Mock.Random.csentence(),
                "is_standard_answer": 0
            }, {
                "topic_answer_id": 3,
                "topic_id": topic_id,
                "answer_name": Mock.Random.csentence(),
                "is_standard_answer": 0
            }, {
                "topic_answer_id": 4,
                "topic_id": topic_id,
                "answer_name": Mock.Random.csentence(),
                "is_standard_answer": 1
            }]
        }
    ));
}


export default new Vuex.Store({
    state,
    actions,
    mutations
})


