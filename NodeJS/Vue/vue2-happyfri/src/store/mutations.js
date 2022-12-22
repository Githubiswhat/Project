const ADD_ITEM_NUM = 'ADD_ITEM_NUM'
const REMEMBER_ANSWER = 'REMEMBER_ANSWER'
const REMEMBER_TIME = 'REMEMBER_TIME'
const INITIALIZE_DATA = 'INITIALIZE_DATA'
export default {
    //点击进入下一题
    [ADD_ITEM_NUM](state, num) {
        state.itemNum += num;
    },
    //记录答案
    [REMEMBER_ANSWER](state, id) {
        state.answerId.push(id);
    },
    /*
    记录做题时间
     */
    [REMEMBER_TIME](state) {
        state.timer = setInterval(() => {
            state.allTime++;
        }, 1000)
    },
    /*
    初始化信息，
     */
    [INITIALIZE_DATA](state) {
        state.itemNum = 1;
        state.allTime = 0;
        state.answerId = [];
    },
}