<template>
  <div>
    <div class="login_view">
      <el-form :model="loginForm" class="login_form">
        <div class="title_view">物业管理系统登录</div>
        <div class="list_item" v-if="loginType == 1">
          <input
            class="list_inp"
            v-model="loginForm.username"
            placeholder="请输入账号"
          />
        </div>
        <div class="list_item" v-if="loginType == 1">
          <input
            class="list_inp"
            v-model="loginForm.password"
            type="password"
            placeholder="请输入密码"
            @keydown.enter.native="handleLogin"
          />
        </div>
        <div class="list_type" v-if="userList.length > 1">
          <el-select v-model="loginForm.role" placeholder="请选择用户类型">
            <el-option
              v-for="(item, index) in userList"
              :label="item.roleName"
              :value="item.roleName"
            ></el-option>
          </el-select>
        </div>
        <div class="btn_view">
          <el-button
            class="login"
            v-if="loginType == 1"
            type="success"
            @click="handleLogin"
            >登录</el-button
          >
        </div>
      </el-form>
    </div>
  </div>
</template>
<script setup>
import { ref, getCurrentInstance, nextTick, onMounted } from 'vue'
const userList = ref([])
const menus = ref([])
const loginForm = ref({
  role: '',
  username: '',
  password: '',
})
const tableName = ref('')
const loginType = ref(1)
const context = getCurrentInstance()?.appContext.config.globalProperties
const handleLogin = () => {
  if (!loginForm.value.username) {
    context?.$toolUtil.message('请输入用户名', 'error')

    return
  }
  if (!loginForm.value.password) {
    context?.$toolUtil.message('请输入密码', 'error')

    return
  }
  if (userList.value.length > 1) {
    if (!loginForm.value.role) {
      context?.$toolUtil.message('请选择角色', 'error')
      verifySlider.value.reset()
      return
    }
    for (let i = 0; i < menus.value.length; i++) {
      if (menus.value[i].roleName == loginForm.value.role) {
        tableName.value = menus.value[i].tableName
      }
    }
  } else {
    tableName.value = userList.value[0].tableName
    loginForm.value.role = userList.value[0].roleName
  }
  login()
}
const login = () => {
  context
    ?.$http({
      url: `${tableName.value}/login?username=${loginForm.value.username}&password=${loginForm.value.password}`,
      method: 'post',
    })
    .then(
      (res) => {
        context?.$toolUtil.storageSet('Token', res.data.token)
        context?.$toolUtil.storageSet('role', loginForm.value.role)
        context?.$toolUtil.storageSet('sessionTable', tableName.value)
        context?.$toolUtil.storageSet('adminName', loginForm.value.username)
        context?.$router.push('/')
      },
      (err) => {}
    )
}
//获取菜单
const getMenu = () => {
  let params = {
    page: 1,
    limit: 1,
    sort: 'id',
  }

  context
    ?.$http({
      url: 'menu/list',
      method: 'get',
      params: params,
    })
    .then((res) => {
      menus.value = JSON.parse(res.data.data.list[0].menujson)
      for (let i = 0; i < menus.value.length; i++) {
        if (menus.value[i].hasBackLogin == '是') {
          userList.value.push(menus.value[i])
        }
      }
      loginForm.value.role = userList.value[0].roleName
      context?.$toolUtil.storageSet('menus', JSON.stringify(menus.value))
    })
}
//初始化
const init = () => {
  getMenu()
}
onMounted(() => {
  init()
})
</script>

<style lang="scss" scoped>
.login_view {
  background-repeat: no-repeat;
  flex-direction: column;
  background-size: cover;
  background: url(http://localhost:8080/cl4085620/file/653c874587284998875920e0d70a9d11.jpg)
    no-repeat center center / cover;
  display: flex;
  min-height: 100vh;
  justify-content: center;
  align-items: center;
  position: relative;
  background-position: center center;
  // 表单盒子
  .login_form {
    border-radius: 0px;
    padding: 30px 20px;
    margin: 0 0 0 54vw;
    background: #fff;
    display: flex;
    width: 30vw;
    justify-content: flex-start;
    flex-wrap: wrap;
  }
  .title_view {
    padding: 0 0 30px;
    margin: 0 auto 20px;
    color: #5d5b5c;
    background: url(http://localhost:8080/cl4085620/file/0f7f5c7f72e94c929cc9841d0835f49d.png)
      no-repeat left bottom;
    font-weight: 600;
    width: 80%;
    font-size: 26px;
    text-align: left;
  }
  // item盒子
  .list_item {
    margin: 10px auto;
    display: flex;
    width: 80%;
    justify-content: flex-start;
    align-items: center;
    // 输入框
    .list_inp {
      border: 1px solid #ddd;
      border-radius: 4px;
      padding: 0 10px;
      color: #666;
      width: 100%;
      line-height: 32px;
      height: 32px;
    }
  }
  .list_type {
    margin: 10px auto;
    display: flex;
    width: 80%;
    justify-content: flex-start;
    align-items: center;
    order: 3;
    .list_label {
      width: 100px;
      font-size: 14px;
      text-align: right;
    }
    // 下拉框样式
    :deep(.el-select) {
      border: 1px solid #ddd;
      border-radius: 4px;
      padding: 0 10px;
      color: #666;
      background: #fff;
      width: 100%;
      line-height: 32px;
      box-sizing: border-box;
      //去掉默认样式
      .select-trigger {
        height: 100%;
        .el-input {
          height: 100%;
          .el-input__wrapper {
            border: none;
            box-shadow: none;
            background: none;
            border-radius: 0;
            height: 100%;
            padding: 0;
          }
          .is-focus {
            box-shadow: none !important;
          }
        }
      }
    }
  }
  // 按钮盒子
  .btn_view {
    padding: 0;
    margin: 10px auto 0;
    display: flex;
    width: 80%;
    justify-content: flex-start;
    align-items: center;
    flex-wrap: wrap;
    order: 5;
    // 登录
    .login {
      border: 0;
      cursor: pointer;
      border-radius: 4px;
      padding: 0 24px;
      margin: 0 auto 10px;
      outline: none;
      color: #fff;
      background: #4387b3;
      width: 100%;
      font-size: 14px;
      height: 40px;
    }
  }
}
</style>
