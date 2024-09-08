<template>
  <div>
    <div class="forget_view">
      <el-form :model="forgetForm" class="forget_box">
        <div class="forget_title">
          物业管理系统{{
            pageType == 1 ? '找回密码' : pageType == 2 ? '输入密保' : '重置密码'
          }}
        </div>
        <div class="tab_line">
          <div class="line"></div>
          <div class="num_line">
            <div
              class="line_number"
              :class="
                (pageType == 1 ? 'line_number1' : '',
                pageType > 1 ? 'line_number2' : '')
              "
            >
              <div class="number" v-if="pageType < 2">1</div>
              <el-icon v-else><Check /></el-icon>
            </div>
            <div
              class="line_number"
              :class="
                (pageType == 2 ? 'line_number1' : '',
                pageType > 2 ? 'line_number2' : '')
              "
            >
              <div class="number" v-if="pageType < 3">2</div>
              <el-icon v-else><Check /></el-icon>
            </div>
            <div
              class="line_number"
              :class="pageType == 3 ? 'line_number1' : ''"
            >
              <div class="number">3</div>
            </div>
          </div>
        </div>
      </el-form>
    </div>
  </div>
</template>
<script setup>
import { ref, getCurrentInstance, nextTick } from 'vue'
const context = getCurrentInstance()?.appContext.config.globalProperties
const pageType = ref(1)
const forgetForm = ref({})
const userForm = ref({})
//返回登录
const close = () => {
  context?.$router.push({
    path: '/login',
  })
}
</script>

<style lang="scss" scoped>
.forget_view {
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
  .forget_box {
    border-radius: 0px;
    padding: 30px 20px;
    margin: 0 0 0 54vw;
    background: #fff;
    display: flex;
    width: 30vw;
    justify-content: flex-start;
    flex-wrap: wrap;
    // 标题
    .forget_title {
      padding: 0px;
      margin: 0 auto 20px;
      color: #5d5b5c;
      font-weight: 600;
      width: 80%;
      font-size: 26px;
      text-align: left;
    }
    // tab
    // 盒子
    .tab_line {
      padding: 30px 0;
      flex-direction: column;
      display: flex;
      width: 100%;
      align-items: center;
      // 中间线
      .line {
        background: #ccc;
        width: 80%;
        height: 2px;
      }
      // item盒子
      .num_line {
        margin: -20px 0 0;
        display: flex;
        width: 80%;
        justify-content: space-between;
        align-items: center;
        height: 40px;
        // 默认样式
        .line_number {
          border: 4px solid #ddd;
          border-radius: 50%;
          color: #aaa;
          background: #eee;
          display: flex;
          width: 40px;
          font-size: 18px;
          justify-content: center;
          align-items: center;
          height: 40px;
        }
        // 选中样式
        .line_number1 {
          color: rgba(64, 158, 255, 1);
          font-size: 22px;
          border-color: rgba(64, 158, 255, 1);
        }
        // 完成样式
        .line_number2 {
          color: rgba(0, 170, 0, 1);
          border-color: rgba(0, 170, 0, 1);
        }
      }
    }
    // item
    .list_item {
      margin: 10px auto;
      display: flex;
      width: 80%;
      justify-content: flex-start;
      align-items: center;
      // label
      .item_label {
        display: none;
        width: 120px;
        font-size: 14px;
        box-sizing: border-box;
        text-align: right;
      }
      // 输入框
      :deep(.list_inp) {
        border: 1px solid #ddd;
        border-radius: 4px;
        padding: 0 10px;
        color: #666;
        width: 80%;
        line-height: 32px;
        box-sizing: border-box;
        height: 32px;
        //去掉默认样式
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
      //下拉框样式
      :deep(.list_sel) {
        border: 1px solid #ddd;
        border-radius: 4px;
        padding: 0 10px;
        color: #666;
        width: 80%;
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
    .list_btn {
      margin: 20px auto 0;
      display: flex;
      width: 80%;
      align-items: center;
      flex-wrap: wrap;
      // 获取密保
      :deep(.el-button--success) {
        border: 0;
        cursor: pointer;
        border-radius: 4px;
        padding: 0 24px;
        margin: 0 10px 0 0;
        outline: none;
        color: #fff;
        background: #4387b3;
        width: auto;
        font-size: 14px;
        height: 32px;
      }
      // 获取密保悬浮
      :deep(.el-button--success:hover) {
      }
      // 确认密保
      :deep(.el-button--primary) {
        border: 0;
        cursor: pointer;
        border-radius: 4px;
        padding: 0 24px;
        margin: 0 10px 0 0;
        outline: none;
        color: #fff;
        background: #4387b3;
        width: auto;
        font-size: 14px;
        height: 32px;
      }
      // 确认密保悬浮
      :deep(.el-button--primary:hover) {
      }
      // 重置密码
      :deep(.el-button--warning) {
        border: 0;
        cursor: pointer;
        border-radius: 4px;
        padding: 0 24px;
        margin: 0 10px 0 0;
        outline: none;
        color: #fff;
        background: #4387b3;
        width: auto;
        font-size: 14px;
        height: 32px;
      }
      // 重置密码悬浮
      :deep(.el-button--warning:hover) {
      }
      .r-login {
        cursor: pointer;
        padding: 10px 0 0;
        color: #999;
        width: 80%;
        font-size: 14px;
        text-align: right;
      }
    }
  }
}
</style>
