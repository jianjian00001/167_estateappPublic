<template>
	<div style="height: 100%;">
		<index-aside :collapse="collapse" :class="collapse?'index-aside-collapse':'index-aside'"></index-aside>
		<el-main class="main_view index_transition" style="max-width:100%" :class="collapse?'main_view-collapse':''">
			<index-header class="index_header index_transition" :collapse="collapse"
				@collapseChange="collapseChange" :style="{'width':'100%','max-width':'100%'}">
			</index-header>
			<index-tags class="index_tags" :style="{'width':'100%','max-width':'100%'}">
			</index-tags>
			<router-view class="router-view index_transition"
				style="background: transparent;max-width:100%" v-slot="{Component}">
				<keep-alive>
					<transition name="el-zoom-in-center" mode="out-in">
						<component :is="Component" />
					</transition>
				</keep-alive>
			</router-view>
		</el-main>
	</div>
</template>

<script setup>
	import IndexAside from '@/components/index/indexMenu'
	import IndexHeader from '@/components/index/indexTop'
	import IndexTags from '@/components/index/indexTags'
	import menu from "@/utils/menu";
	import router from '../../router'
	import {
		ref,
		getCurrentInstance
	} from 'vue'
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const collapse = ref( false)
	const collapseChange = () => {
		collapse.value = !collapse.value
	}
	const menuList = ref(null)
	const role = ref('')
	const init = () => {
		const menus = menu.list()
		if (menus) {
			menuList.value = menus
		}
		role.value = context?.$toolUtil.storageGet('role')
		for (let i = 0; i < menuList.value.length; i++) {
			if (menuList.value[i].roleName == role.value) {
				menuList.value = menuList.value[i].backMenu;
				break;
			}
		}
		let arr = makeMenu(menuList.value)

		router.addRoute(arr)
	}
	const makeMenu = (menu) => {
		let brr = {
			path: '/1',
			component: () => import('../../views/index'),
			children: []
		}
		for (let x in menu) {
			for (let i in menu[x].child) {
				brr.children.push({
					path: '/' + menu[x].child[i].tableName,
					name: menu[x].child[i].menu,
					component: () => import(`../../views/${menu[x].child[i].tableName}/list.vue`)
				})
			}
		}
		return brr
	}
	// init()
</script>
<style lang="scss" scoped>

	a:hover {
		background: #00c292;
	}

	.el-main {
		padding: 0;
		margin: 0 0 0 210px;
		background: #f0f0f0;
	}
	.main_view-collapse {
		padding: 0;
		margin: 0 0 0 64px;
	}
	.main_view {
		position: relative;
		padding:0;
	}

	.index-aside {
		overflow: hidden;
		top: 88px;
		left: 0;
		background: #ffffff;
		width: 210px;
		border-color: #eee;
		border-width: 0 1px 0 0;
		position: fixed;
		border-style: solid;
		height: 100%;
	}
	.index-aside-collapse {
		overflow: hidden;
		top: 88px;
		left: 0;
		background: #ffffff;
		width: 64px;
		border-color: #eee;
		border-width: 0 1px 0 0;
		position: fixed;
		border-style: solid;
		height: 100%;
	}

	.index_header {
		width: 100%;
		z-index: 999;
	}

	.index_tags {
		width: 100%;
		z-index: 999;
	}

	.app-contain {
		padding: 10px 30px;
		margin: 88px 0 0;
		min-height: 100vh;
		height: auto;
	}
	.index_transition{
		transition:all .35s;
	}
</style>
