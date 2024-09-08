
<template>
	<div>
		<div class="app-contain">
			<el-form class="userinfo_form" ref="userinfoFormRef" :model="form" label-width="$template2.back.add.form.base.labelWidth">
				<el-row>
					<el-col :span="24">
						<el-form-item label="业主账号" prop="yezhuzhanghao">
							<el-input class="list_inp" v-model="user.yezhuzhanghao" readonly placeholder="业主账号" clearable />
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="业主姓名" prop="yezhuxingming">
							<el-input class="list_inp" v-model="user.yezhuxingming"  placeholder="业主姓名" clearable />
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="头像" prop="touxiang">
							<uploads
								action="file/upload" 
								tip="请上传头像" 
								:limit="3" 
								style="width: 100%;text-align: left;"
								:fileUrls="user.touxiang?user.touxiang:''" 
								@change="yezhutouxiangUploadSuccess">
							</uploads>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="性别" prop="xingbie">
							<el-select 
								class="list_sel" 
								v-model="user.xingbie" 
								placeholder="请选择性别"
								>
								<el-option v-for="item in yezhuxingbieLists" :label="item" :value="item"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="手机号码" prop="shoujihaoma">
							<el-input class="list_inp" v-model="user.shoujihaoma"  placeholder="手机号码" clearable />
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="楼栋号" prop="loudonghao">
							<el-input class="list_inp" v-model="user.loudonghao"  placeholder="楼栋号" clearable />
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="房号" prop="fanghao">
							<el-input class="list_inp" v-model="user.fanghao"  placeholder="房号" clearable />
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="身份证" prop="shenfenzheng">
							<el-input class="list_inp" v-model="user.shenfenzheng"  placeholder="身份证" clearable />
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="车牌号" prop="chepaihao">
							<el-input class="list_inp" v-model="user.chepaihao"  placeholder="车牌号" clearable />
						</el-form-item>
					</el-col>
					<span class="userinfo_form_btn_box">
						<el-button class='userinfo_confirm' type="primary" @click="onSubmit">保存</el-button>
					</span>
				</el-row>
			</el-form>
		</div>
	</div>
</template>

<script setup>
	import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/toolUtil";
	import {
		reactive,
		ref,
		getCurrentInstance
	} from 'vue'
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const tableName = ref('yezhu')
	const user = ref({})
	const yezhuxingbieLists = ref([])
	const init = () => {
		yezhuxingbieLists.value = "男,女".split(',')
	}
	const yezhutouxiangUploadSuccess=(fileUrls)=> {
	    user.value.touxiang = fileUrls;
	}
	const onSubmit = () => {
		if((!user.value.yezhuzhanghao)){
			context?.$toolUtil.message(`业主账号不能为空`,'error')
			return false
		}
		if((!user.value.mima)){
			context?.$toolUtil.message(`密码不能为空`,'error')
			return false
		}
		if((!user.value.yezhuxingming)){
			context?.$toolUtil.message(`业主姓名不能为空`,'error')
			return false
		}
		if(user.value.touxiang!=null){
			user.value.touxiang = user.value.touxiang.replace(new RegExp(context?.$config.url,"g"),"");
		}
		if((user.value.shoujihaoma)&&(!context?.$toolUtil.isMobile(user.value.shoujihaoma))){
			context?.$toolUtil.message(`手机号码应输入手机格式`,'error')
			return false
		}
		if((user.value.shenfenzheng)&&(!context?.$toolUtil.checkIdCard(user.value.shenfenzheng))){
			context?.$toolUtil.message(`身份证应输入身份证格式`,'error')
			return false
		}
		context?.$http({
			url: `${tableName.value}/update`,
			method: 'post',
			data: user.value
		}).then(res => {
			context?.$toolUtil.message('修改成功','success')
		})

	}
	const getInfo = () => {
		context?.$http({
			url: `${tableName.value}/session`,
			method: 'get'
		}).then(res => {
			user.value = res.data.data
			init()
		})
	}
	getInfo()
</script>

<style lang="scss" scoped>
	// 表单
	.userinfo_form {
		border: 1px solid #ddd;
		border-radius: 4px;
		padding: 30px;
		margin: 0;
		background: #fff;
		// form item
		:deep(.el-form-item) {
			margin: 0 0 20px 0;
			display: flex;
			// 内容盒子
			.el-form-item__content{
				display: flex;
				width: calc(100% - 120px);
				justify-content: flex-start;
				align-items: center;
				flex-wrap: wrap;
			}
			// 输入框
			.list_inp {
				border: 1px solid #ddd;
				border-radius: 4px;
				padding: 0 10px;
				width: auto;
				line-height: 36px;
				box-sizing: border-box;
				min-width: 350px;
				height: 36px;
				//去掉默认样式
				.el-input__wrapper{
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
			.list_sel {
				border: 1px solid #ddd;
				border-radius: 4px;
				padding: 0 10px;
				width: auto;
				line-height: 36px;
				box-sizing: border-box;
				min-width: 350px;
				//去掉默认样式
				.select-trigger{
					height: 100%;
					.el-input{
						height: 100%;
						.el-input__wrapper{
							border: none;
							box-shadow: none;
							background: none;
							border-radius: 0;
							height: 100%;
						}
						.is-focus {
							box-shadow: none !important;
						}
					}
				}
			}
			//图片上传样式
			.el-upload-list  {
				//提示语
				.el-upload__tip {
					margin: 7px 0 0;
					color: #999;
					display: flex;
					font-size: 14px;
					justify-content: flex-start;
					align-items: center;
				}
				//外部盒子
				.el-upload--picture-card {
					border: 1px solid #ddd;
					cursor: pointer;
					background-color: #fff;
					border-radius: 4px;
					width: 120px;
					line-height: 70px;
					text-align: center;
					height: 60px;
					//图标
					.el-icon{
						color: #bbb;
						font-size: 32px;
					}
				}
				.el-upload-list__item {
					border: 1px solid #ddd;
					cursor: pointer;
					background-color: #fff;
					border-radius: 4px;
					width: 120px;
					line-height: 70px;
					text-align: center;
					height: 60px;
				}
			}

		}
		// 按钮盒子
		.userinfo_form_btn_box {
			display: flex;
			width: 100%;
			justify-content: center;
			align-items: center;
			// 确定按钮
			.userinfo_confirm {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 0 20px 0 0;
				outline: none;
				color: #fff;
				background: #1c9c93;
				width: auto;
				font-size: 14px;
				min-width: 100px;
				height: 36px;
			}
			// 确定按钮-悬浮
			.userinfo_confirm:hover {
				background: #1c9c9390;
			}
		}
	}
</style>
