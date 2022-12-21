<template>
  <transition name="slide-fade">
    <div v-show="!item.isDelete" :class="{checked: item.checked}" class="list-item  editingClass editing ">
      <label class="checkbox">
        <input v-model="item.checked" :disabled="locked" name="checked" type="checkbox" @change="onChange">
        <span class="checkbox-custom"></span>
      </label>
      <input v-model="item.text" :disabled=" item.checked || locked" placeholder='写点什么。。。' type="text"
             @keyup.enter="onChange">
      <a v-if="item.checked && !locked" class="delete-item" @click="item.isDelete = true;onChange()">
        <span class="icon-trash"></span>
      </a>
    </div>
  </transition>
</template>
<script>
// item 是todo的子组件,他接受一个对象item,来进行处理
import {editRecord} from '../api/api';

export default {
  props: {
    item: {
      type: Object,
      default: () => {
        return {
          checked: false,
          text: '你好,世界'
        };
      }
    },
    'index': {},
    'id': {},
    'init': {},
    'locked': {}
  },
  methods: {
    // 用户无论删除,修改，锁定都可以利用这个方法。
    onChange() {
      editRecord({
        id: this.id, record: this.item, index: this.index
      }).then(() => {
        this.init();
        this.$store.dispatch('getTodo');
      });
    }
  }
};
</script>
<style lang="less">
@import '../common/style/list-items.less';

.slide-fade-enter-active {
  transition: all .3s ease;
}

.slide-fade-leave-active {
  transition: all .3s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}

.slide-fade-enter, .slide-fade-leave-active {
  transform: translateX(10px);
  opacity: 0;
}
</style>
