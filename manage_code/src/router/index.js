	import {
		createRouter,
		createWebHashHistory
	} from 'vue-router'
	import news from '@/views/news/list'
	import yezhu from '@/views/yezhu/list'
	import jiaofeitixing from '@/views/jiaofeitixing/list'
	import weixiuxinxi from '@/views/weixiuxinxi/list'
	import cheweixinxi from '@/views/cheweixinxi/list'
	import laifangcheliang from '@/views/laifangcheliang/list'
	import jiaofeixinxi from '@/views/jiaofeixinxi/list'
	import changzhurenkou from '@/views/changzhurenkou/list'
	import weixiushenqing from '@/views/weixiushenqing/list'
	import cheliangchuchang from '@/views/cheliangchuchang/list'
	import jiaofeileixing from '@/views/jiaofeileixing/list'
	import weixiuleixing from '@/views/weixiuleixing/list'
	import config from '@/views/config/list'
	import cheliangruchang from '@/views/cheliangruchang/list'

export const routes = [{
		path: '/login',
		name: 'login',
		component: () => import('../views/login.vue')
	},{
		path: '/',
		name: '首页',
		component: () => import('../views/index'),
		children: [{
			path: '/',
			name: '首页',
			component: () => import('../views/HomeView.vue'),
			meta: {
				affix: true
			}
		}, {
			path: '/updatepassword',
			name: '修改密码',
			component: () => import('../views/updatepassword.vue')
		}
		
		,{
			path: '/news',
			name: '公告信息',
			component: news
		}
		,{
			path: '/yezhu',
			name: '业主',
			component: yezhu
		}
		,{
			path: '/jiaofeitixing',
			name: '缴费提醒',
			component: jiaofeitixing
		}
		,{
			path: '/weixiuxinxi',
			name: '维修信息',
			component: weixiuxinxi
		}
		,{
			path: '/cheweixinxi',
			name: '车位信息',
			component: cheweixinxi
		}
		,{
			path: '/laifangcheliang',
			name: '来访车辆',
			component: laifangcheliang
		}
		,{
			path: '/jiaofeixinxi',
			name: '缴费信息',
			component: jiaofeixinxi
		}
		,{
			path: '/changzhurenkou',
			name: '常住人口',
			component: changzhurenkou
		}
		,{
			path: '/weixiushenqing',
			name: '维修申请',
			component: weixiushenqing
		}
		,{
			path: '/cheliangchuchang',
			name: '车辆出场',
			component: cheliangchuchang
		}
		,{
			path: '/jiaofeileixing',
			name: '缴费类型',
			component: jiaofeileixing
		}
		,{
			path: '/weixiuleixing',
			name: '维修类型',
			component: weixiuleixing
		}
		,{
			path: '/config',
			name: '轮播图',
			component: config
		}
		,{
			path: '/cheliangruchang',
			name: '车辆入场',
			component: cheliangruchang
		}
		]
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router
