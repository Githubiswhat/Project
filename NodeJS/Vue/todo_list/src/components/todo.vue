<template>
  <div v-show="!todo.isDelete" class="page lists-show">
    <!-- 头部模块 -->
    <nav>
      <!-- 当用户浏览车窗口尺寸小于40em时候，显示手机端的菜单图标 -->
      <div v-show="isUpdate" class="form list-edit-form">
        <!-- 当用户点击标题进入修改状态，就显示当前内容可以修改 -->
        <input v-model="todo.title" :disabled="todo.locked" type="text" @keyup.enter="updateTitle">
        <div class="nav-group right">
          <a class="nav-item" @click="isUpdate = false">
            <span class="icon-close">
            </span>
          </a>
        </div>
      </div>
      <div v-show="!isUpdate" class="nav-group" @click="$store.dispatch('updateMenu')">
        <!-- 在菜单的图标下面添加updateMenu时间，他可以直接调用vuex actions.js里面的updateMenu方法 -->
        <a class="nav-item">
          <span class="icon-list-unordered">
          </span>
        </a>
      </div>
      <!-- 显示标题和数字模块 -->
      <h1 v-show="!isUpdate" class="title-page" @click="isUpdate = true">
        <span class="title-wrapper">{{ todo.title }}</span>
        <!-- title:标题 绑定标题 -->
        <span class="count-list">{{ todo.count || 0 }}</span>
        <!-- count:数量 绑定代办单项熟练-->
      </h1>
      <!-- 右边显示删除图标和锁定图标的模块 -->
      <div v-show="!isUpdate" class="nav-group right">
        <div class="options-web">
          <a class=" nav-item" @click="onlock">
            <!-- cicon-lock锁定的图标
             icon-unlock：非锁定的图标-->
            <span v-if="todo.locked" class="icon-lock"></span>
            <span v-else class="icon-unlock">
            </span>
          </a>
          <a class="nav-item">
            <span class="icon-trash" @click="onDelete">
            </span>
          </a>
        </div>
      </div>
      <!-- 用户新增代办事项的input模块 -->
      <div class=" form todo-new input-symbol">
        <!-- 绑定disabled值，当todo.locked为绑定的时候，禁止input输入,双向绑定text,和监听input的回车事件@keyup.enter -->
        <input v-model="text" :disabled="todo.locked" placeholder='请输入' type="text" @keyup.enter="onAdd"/>
        <span class="icon-add"></span>
      </div>
    </nav>
    <!-- 列表主体模块 -->
    <div class="content-scrollable list-items">
      <div v-for="(item,index) in items">
        <item :id="todo.id" :index="index" :init="init" :item="item" :locked="todo.locked"></item>
      </div>
    </div>
  </div>
</template>
<script>

import item from './item';
import {addRecord, editTodo, getTodo} from '../api/api';

export default {
  data() {
    return {
      todo: {
        title: '星期一', // 标题
        count: 12, // 数量
        locked: false // 是否绑定
      },
      items: [  // 代办单项列表
      ],
      text: '', // 用户输入单项项绑定的输入
      isUpdate: false // 新增修改状态
    };
  },
  components: {
    item
  },
  watch: {
    '$route.params.id'() {
      // 监听$route.params.id的变化，如果这个id即代表用户点击了其他的待办项需要重新请求数据。
      this.init();
    }
  },
  created() {
    // created生命周期，在实例已经创建完成，页面还没渲染时调用init方法。
    this.init();
  },
  methods: {
    init() {
      const ID = this.$route.params.id;
      getTodo({id: ID}).then(res => {
        let {
          id, title, count, isDelete, locked, record
        } = res.data.todo;
        this.items = record;
        this.todo = {
          id: id,
          title: title,
          count: count,
          locked: locked,
          isDelete: isDelete
        };
      });
    },
    onAdd() {
      const ID = this.$route.params.id;
      addRecord({id: ID, text: this.text}).then(() => {
        this.text = '';
        this.init();
        this.$store.dispatch('getTodo');
      });
    },
    updateTodo() {
      let _this = this;
      editTodo({
        todo: this.todo
      }).then(() => {
        // _this.init();
        _this.$store.dispatch('getTodo');
      });
    },
    updateTitle() {
      this.updateTodo();
      this.isUpdate = false;
    },
    onDelete() {
      this.todo.isDelete = true;
      this.updateTodo();
    },
    onlock() {
      this.todo.locked = !this.todo.locked;
      this.updateTodo();
    }
  }
};
</script>

<style lang="less">
@import '../common/style/nav.less';
@import '../common/style/form.less';
@import '../common/style/todo.less';
</style>
