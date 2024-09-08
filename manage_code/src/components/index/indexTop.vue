<template>
  <div class="top_view">
    <div class="top_left_view">
      <div class="fold_view" @click="toggleClick">
        <el-icon class="icons">
          <Fold v-if="!collapse" />
          <Expand v-else />
        </el-icon>
      </div>
    </div>

    <div class="projectTitle">物业管理系统</div>
    <div class="top_right_view">
      <el-dropdown class="avatar-container right-menu-item" trigger="hover">
        <div class="avatar-wrapper">
          <div class="nickname">
            欢迎 {{ $toolUtil.storageGet('adminName') }}
          </div>
          <img class="user-avatar" src="@/assets/img/avatar.png" />
          <el-icon class="el-icon--right">
            <arrow-down />
          </el-icon>
        </div>
        <template #dropdown>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item @click="centerClick" v-if="roleName != '管理员'">
              个人中心
            </el-dropdown-item>
            <el-dropdown-item @click="updatepasswordClick">
              修改密码
            </el-dropdown-item>
            <el-dropdown-item>
              <span style="display: block" @click="onLogout">退出登录</span>
            </el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script setup>
import axios from 'axios'
import { ElMessageBox } from 'element-plus'
import {
  toRefs,
  defineEmits,
  getCurrentInstance,
  ref,
  onBeforeUnmount,
} from 'vue'
import { useStore } from 'vuex'
const store = useStore()
import { useRouter } from 'vue-router'
const props = defineProps({
  collapse: Boolean,
})
const { collapse } = toRefs(props)

const router = useRouter()
const context = getCurrentInstance()?.appContext.config.globalProperties
const emit = defineEmits(['collapseChange'])
const role = context?.$toolUtil.storageGet('sessionTable')
const roleName = context?.$toolUtil.storageGet('role')
const toggleClick = () => {
  emit('collapseChange')
}
const getSession = () => {
  context
    ?.$http({
      url: `${context?.$toolUtil.storageGet('sessionTable')}/session`,
      method: 'get',
    })
    .then((res) => {
      context?.$toolUtil.storageSet('userid', res.data.data.id)
    })
}
// 退出登录
const onLogout = () => {
  let toolUtil = context?.$toolUtil
  store.dispatch('delAllCachedViews')
  store.dispatch('delAllVisitedViews')
  toolUtil.storageClear()
  router.replace({
    name: 'login',
  })
}
// 个人中心
const centerClick = () => {
  router.push(`/${role}Center`)
}
// 修改密码
const updatepasswordClick = () => {
  router.push(`/updatepassword`)
}
getSession()
</script>

<style lang="scss" scoped>
// 总盒子
.top_view {
  z-index: 9;
  color: #fff;
  top: 0;
  left: 0;
  background: linear-gradient(
    90deg,
    rgba(28, 156, 147, 1) 0%,
    rgba(132, 113, 199, 1) 100%
  );
  display: flex;
  width: 100%;
  font-size: 24px;
  justify-content: space-between;
  align-items: center;
  position: fixed;
  height: 54px;
  // 左边盒子
  .top_left_view {
    display: flex;
    width: 300px;
    align-items: center;
    height: 100%;
    // 折叠按钮盒子
    .fold_view {
      padding: 0 15px;
      // 图标
      .icons {
      }
    }
  }
  // 标题
  .projectTitle {
    font-size: 18px;
  }
  // 右部盒子
  .top_right_view {
    display: flex;
    width: 300px;
    justify-content: flex-end;
    height: 100%;
    // 头像盒子
    .avatar-container {
      cursor: pointer;
      margin: 0 30px 0 0;
      color: #fff;
      display: flex;
      align-items: center;
      height: 50px;
      .avatar-wrapper {
        margin: 5px 0 0;
        display: flex;
        position: relative;
        align-items: center;
        // 昵称
        .nickname {
          cursor: pointer;
          margin: 0 5px;
          color: #fff;
          line-height: 44px;
        }
        // 头像
        .user-avatar {
          cursor: pointer;
          border-radius: 10px;
          width: 40px;
          height: 40px;
        }
        // 图标
        .el-icon--right {
          color: #fff;
        }
      }
    }
  }
}
// 下拉盒子
.el-dropdown-menu {
  background: #fff;
  min-width: 100px;
  // 下拉盒子itme
  :deep(.el-dropdown-menu__item) {
    color: #555;
    background: none;
  }
  // item悬浮
  :deep(.el-dropdown-menu__item:hover) {
    color: #fff;
    background: linear-gradient(
      90deg,
      rgba(28, 156, 147, 1) 0%,
      rgba(132, 113, 199, 1) 100%
    );
  }
}
</style>
