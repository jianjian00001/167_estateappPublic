<template>
	<div class="home_view">
		<div class="projectTitle">欢迎使用 {{projectName}}</div>
		<div class="count_list">
			<el-collapse-transition v-if="btnAuth('jiaofeixinxi','首页总数')">
				<el-card v-show="countTypeList.closejiaofeixinxiCountType" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								缴费信息
							</div>
							<div class="card_head_right">
								<el-icon @click="countTypeClick('hiddenjiaofeixinxiCountType')" class="showIcons"
									:class="countTypeList.hiddenjiaofeixinxiCountType?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="countTypeClick('closejiaofeixinxiCountType')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
							
						</div>
					</template>
					<el-collapse-transition>
						<div class="count_item" v-show="countTypeList.hiddenjiaofeixinxiCountType">
							<div class="count_title">缴费信息总数</div>
							<div class="count_num">{{jiaofeixinxiCount}}</div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
			<el-collapse-transition v-if="btnAuth('changzhurenkou','首页总数')">
				<el-card v-show="countTypeList.closechangzhurenkouCountType" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								常住人口
							</div>
							<div class="card_head_right">
								<el-icon @click="countTypeClick('hiddenchangzhurenkouCountType')" class="showIcons"
									:class="countTypeList.hiddenchangzhurenkouCountType?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="countTypeClick('closechangzhurenkouCountType')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
							
						</div>
					</template>
					<el-collapse-transition>
						<div class="count_item" v-show="countTypeList.hiddenchangzhurenkouCountType">
							<div class="count_title">常住人口总数</div>
							<div class="count_num">{{changzhurenkouCount}}</div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
		</div>
		<div class="card_list">
			<el-collapse-transition v-if="btnAuth('jiaofeixinxi','首页统计')">
				<el-card v-show="cardTypeList.closejiaofeixinxiChartType1" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								缴费信息
							</div>
							<div class="card_head_right">
								<el-icon @click="cardTypeClick('hiddenjiaofeixinxiChartType1')" class="showIcons"
									:class="cardTypeList.hiddenjiaofeixinxiChartType1?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="cardTypeClick('closejiaofeixinxiChartType1')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="card_item" v-show="cardTypeList.hiddenjiaofeixinxiChartType1">
							<div id="jiaofeixinxijiaofeileixingEchart1" style="width: 100%;height: 400px;"></div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
			<el-collapse-transition v-if="btnAuth('jiaofeixinxi','首页统计')">
				<el-card v-show="cardTypeList.closejiaofeixinxiChartType2" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								缴费信息
							</div>
							<div class="card_head_right">
								<el-icon @click="cardTypeClick('hiddenjiaofeixinxiChartType2')" class="showIcons"
									:class="cardTypeList.hiddenjiaofeixinxiChartType2?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="cardTypeClick('closejiaofeixinxiChartType2')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="card_item" v-show="cardTypeList.hiddenjiaofeixinxiChartType2">
							<div id="jiaofeixinxijineEchart2" style="width: 100%;height: 400px;"></div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
			<el-collapse-transition v-if="btnAuth('changzhurenkou','首页统计')">
				<el-card v-show="cardTypeList.closechangzhurenkouChartType1" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								常住人口
							</div>
							<div class="card_head_right">
								<el-icon @click="cardTypeClick('hiddenchangzhurenkouChartType1')" class="showIcons"
									:class="cardTypeList.hiddenchangzhurenkouChartType1?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="cardTypeClick('closechangzhurenkouChartType1')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="card_item" v-show="cardTypeList.hiddenchangzhurenkouChartType1">
							<div id="changzhurenkouxinzengrenkouEchart1" style="width: 100%;height: 400px;"></div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
			<el-collapse-transition v-if="btnAuth('changzhurenkou','首页统计')">
				<el-card v-show="cardTypeList.closechangzhurenkouChartType2" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								常住人口
							</div>
							<div class="card_head_right">
								<el-icon @click="cardTypeClick('hiddenchangzhurenkouChartType2')" class="showIcons"
									:class="cardTypeList.hiddenchangzhurenkouChartType2?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="cardTypeClick('closechangzhurenkouChartType2')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="card_item" v-show="cardTypeList.hiddenchangzhurenkouChartType2">
							<div id="changzhurenkouruzhurenkouEchart2" style="width: 100%;height: 400px;"></div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
			<el-collapse-transition v-if="btnAuth('changzhurenkou','首页统计')">
				<el-card v-show="cardTypeList.closechangzhurenkouChartType3" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								常住人口
							</div>
							<div class="card_head_right">
								<el-icon @click="cardTypeClick('hiddenchangzhurenkouChartType3')" class="showIcons"
									:class="cardTypeList.hiddenchangzhurenkouChartType3?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="cardTypeClick('closechangzhurenkouChartType3')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="card_item" v-show="cardTypeList.hiddenchangzhurenkouChartType3">
							<div id="changzhurenkoulikairenkouEchart3" style="width: 100%;height: 400px;"></div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
		</div>
	</div>
</template>

<script setup>
	import {
		inject,
		nextTick,
		ref,
		getCurrentInstance
	} from 'vue';
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const projectName = context.$project.projectName
	const countTypeList = ref({
	})
	const getCountList=()=>{
		countTypeList.value.closejiaofeixinxiCountType = true
		countTypeList.value.hiddenjiaofeixinxiCountType = true
		if(btnAuth('jiaofeixinxi','首页总数')){
			getjiaofeixinxiCount()
		}
		countTypeList.value.closechangzhurenkouCountType = true
		countTypeList.value.hiddenchangzhurenkouCountType = true
		if(btnAuth('changzhurenkou','首页总数')){
			getchangzhurenkouCount()
		}
	}
	const jiaofeixinxiCount = ref(0)
	const getjiaofeixinxiCount = () => {
		context?.$http({
			url:'jiaofeixinxi/count',
			method: 'get'
		}).then(res=>{
			jiaofeixinxiCount.value = res.data.data
		})
	}
	const changzhurenkouCount = ref(0)
	const getchangzhurenkouCount = () => {
		context?.$http({
			url:'changzhurenkou/count',
			method: 'get'
		}).then(res=>{
			changzhurenkouCount.value = res.data.data
		})
	}
	const countTypeClick = (e) => {
		countTypeList.value[e] = !countTypeList.value[e]
	}
	const init=()=>{
		getCountList()
		getCardList()
	}
	//权限验证
	const btnAuth = (e,a)=>{
		return context?.$toolUtil.isAuth(e,a)
	}
	let echarts = inject("echarts")
	const cardTypeClick = (e) =>{
		cardTypeList.value[e] = !cardTypeList.value[e]
		setTimeout(()=>{
			getCardList()
		},1000)
	}
	const cardTypeList = ref({
		closejiaofeixinxiChartType1: true,
		hiddenjiaofeixinxiChartType1: true,
		closejiaofeixinxiChartType2: true,
		hiddenjiaofeixinxiChartType2: true,
		closechangzhurenkouChartType1: true,
		hiddenchangzhurenkouChartType1: true,
		closechangzhurenkouChartType2: true,
		hiddenchangzhurenkouChartType2: true,
		closechangzhurenkouChartType3: true,
		hiddenchangzhurenkouChartType3: true,
	})
	const getCardList = () => {
		if(btnAuth('jiaofeixinxi','首页统计')){
			getjiaofeixinxiChart1()
		}
		if(btnAuth('jiaofeixinxi','首页统计')){
			getjiaofeixinxiChart2()
		}
		if(btnAuth('changzhurenkou','首页统计')){
			getchangzhurenkouChart1()
		}
		if(btnAuth('changzhurenkou','首页统计')){
			getchangzhurenkouChart2()
		}
		if(btnAuth('changzhurenkou','首页统计')){
			getchangzhurenkouChart3()
		}
	}
	const getjiaofeixinxiChart1 = () => {
		nextTick(()=>{
			var jiaofeileixingEchart1 = echarts.init(document.getElementById("jiaofeixinxijiaofeileixingEchart1"),'macarons');
			context?.$http({
				url: "jiaofeixinxi/group/jiaofeileixing",
				method: "get",
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let pArray = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].jiaofeileixing);
				    yAxis.push(parseFloat((res[i].total)));
				    pArray.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].jiaofeileixing
				    })
				}
				var option = {};
                option = {
                    title: {
                        text: '缴费类型统计',
                        left: 'center'
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left'
                    },
                    tooltip: {
						trigger: 'item',
						formatter: '{b} : {c} ({d}%)'
                    },
                    series: [
                        {
                            type: 'pie',
                            radius: '55%',
                            center: ['50%', '60%'],
                            data: pArray,
                            emphasis: {
                                itemStyle: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
									shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };
				jiaofeileixingEchart1.clear()
				// 使用刚指定的配置项和数据显示图表。
				jiaofeileixingEchart1.setOption(option);
				//根据窗口的大小变动图表
				jiaofeileixingEchart1.resize();
			})
		})
	}
	const getjiaofeixinxiChart2 = () => {
		nextTick(()=>{
			var jineEchart2 = echarts.init(document.getElementById("jiaofeixinxijineEchart2"),'macarons');
			context?.$http({
				url: `jiaofeixinxi/value/jiaofeimingcheng/jine`,
				method: "get",
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let pArray = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].jiaofeimingcheng);
				    yAxis.push(parseFloat((res[i].total)));
				    pArray.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].jiaofeimingcheng
				    })
				}
				var option = {};
                option = {
                    title: {
                        text: '缴费统计',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis,
                        axisLabel: {
                            rotate: 40
                        }
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
				// 使用刚指定的配置项和数据显示图表。
				jineEchart2.clear()
				jineEchart2.setOption(option);
				//根据窗口的大小变动图表
				jineEchart2.resize();
			})
		})
	}
	const getchangzhurenkouChart1 = () => {
		nextTick(()=>{
			var xinzengrenkouEchart1 = echarts.init(document.getElementById("changzhurenkouxinzengrenkouEchart1"),'macarons');
			context?.$http({
				url: `changzhurenkou/value/dengjishijian/xinzengrenkou`,
				method: "get",
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let pArray = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].dengjishijian);
				    yAxis.push(parseFloat((res[i].total)));
				    pArray.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].dengjishijian
				    })
				}
				var option = {};
                option = {
                    title: {
                        text: '新增人口统计分析',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis,
                        axisLabel: {
                            rotate: 40
                        }
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
				xinzengrenkouEchart1.clear()
				// 使用刚指定的配置项和数据显示图表。
				xinzengrenkouEchart1.setOption(option);
				//根据窗口的大小变动图表
				xinzengrenkouEchart1.resize();
			})
		})
	}
	const getchangzhurenkouChart2 = () => {
		nextTick(()=>{
			var ruzhurenkouEchart2 = echarts.init(document.getElementById("changzhurenkouruzhurenkouEchart2"),'macarons');
			context?.$http({
				url: `changzhurenkou/value/dengjishijian/ruzhurenkou`,
				method: "get",
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let pArray = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].dengjishijian);
				    yAxis.push(parseFloat((res[i].total)));
				    pArray.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].dengjishijian
				    })
				}
				var option = {};
				option = {
				    title: {
				        text: '入住人口分析',
				        left: 'center'
				    },
				    tooltip: {
				      trigger: 'item',
				      formatter: '{b} : {c}'
				    },
				    xAxis: {
				        type: 'category',
				        boundaryGap: false,
				        data: xAxis
				    },
				    yAxis: {
				        type: 'value'
				    },
				    series: [{
				        data: yAxis,
				        type: 'line',
                    }]
                };
				// 使用刚指定的配置项和数据显示图表。
				ruzhurenkouEchart2.clear()
				ruzhurenkouEchart2.setOption(option);
				//根据窗口的大小变动图表
				ruzhurenkouEchart2.resize();
			})
		})
	}
	const getchangzhurenkouChart3 = () => {
		nextTick(()=>{
        //  likairenkou
			var likairenkouEchart3 = echarts.init(document.getElementById("changzhurenkoulikairenkouEchart3"),'macarons');
			context?.$http({
				url: `changzhurenkou/value/dengjishijian/likairenkou`,
				method: "get",
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let pArray = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].dengjishijian);
				    yAxis.push(parseFloat((res[i].total)));
				    pArray.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].dengjishijian
				    })
				}
				var option = {};
				option = {
				    title: {
				        text: '离开人口统计',
				        left: 'center'
				    },
				    tooltip: {
				      trigger: 'item',
				      formatter: '{b} : {c}'
				    },
				    xAxis: {
				        type: 'category',
				        boundaryGap: false,
				        data: xAxis
				    },
				    yAxis: {
				        type: 'value'
				    },
				    series: [{
				        data: yAxis,
				        type: 'line',
						areaStyle: {},
						smooth: true
                    }]
                };
				// 使用刚指定的配置项和数据显示图表。
				likairenkouEchart3.clear()
				likairenkouEchart3.setOption(option);
				//根据窗口的大小变动图表
				likairenkouEchart3.resize();
			})
		})
	}
	init()
</script>
<style lang="scss">
	.projectTitle{
		padding: 20px 0;
		margin: 20px 0 20px;
		font-weight: bold;
		display: flex;
		width: 100%;
		font-size: 30px;
		justify-content: center;
		align-items: center;
		height: auto;
	}

	.showIcons {
		transition: transform 0.3s;
		margin-right: 10px;
	}

	.showIcons1 {
		transform: rotate(-180deg);
	}
	
	// 总数盒子
	.count_list{
		padding: 0 0 20px;
		display: flex;
		width: 100%;
		justify-content: center;
		align-items: flex-start;
		flex-wrap: wrap;
		// 总数card
		.card_view {
			border: 1px solid #ddd;
			box-shadow: 0px 0px 0px rgba(0,0,0,.12);
			margin: 0 1% 10px;
			flex: 1;
			width: 100%;
			box-sizing: border-box;
			height: auto;
			// card头部
			.el-card__header {
				border: 1px solid #ddd;
				background: linear-gradient(90deg, rgba(28,156,147,.1) 0%, rgba(132,113,199,.1) 100%);
				width: 100%;
				border-width: 0 0 1px;
				// 头部盒子
				.index_card_head {
					display: flex;
					width: 100%;
					justify-content: space-between;
					align-items: center;
					height: 10px;
					// 标题
					.card_head_title {
						color: #666;
						font-size: 14px;
					}
					// 按钮盒子
					.card_head_right {
						display: flex;
						align-items: center;
						// 按钮
						.el-icon {
							cursor: pointer;
							color: #aaa;
							font-size: 20px;
						}
					}
				}
			}
			// body
			.el-card__body {
				padding: 0;
				// body盒子
				.count_item{
					padding: 30px;
					text-align: center;
					// 总数标题
					.count_title{
						color: #333;
						font-size: 16px;
						line-height: 2;
					}
					// 总数数字
					.count_num{
						color: #c00;
						font-size: 30px;
						line-height: 2;
					}
				}
			}
		}
	}
	// 首页盒子
	.home_view {
		padding: 0px 30px;
		margin: 88px 0 0;
		background: url(http://clfile.zggen.cn/20240203/dbc8b5149f284e5e86989e5e938abb79.png) no-repeat center top / 100% 100% !important;
		width: 100%;
		min-height: 100vh;
		height: auto;
	}
	// 统计图盒子
	.card_list {
		padding: 0 0 20px;
		display: flex;
		width: 100%;
		justify-content: space-between;
		align-items: flex-start;
		flex-wrap: wrap;
		// 统计图card
		.card_view {
			border: 1px solid #ddd;
			box-shadow: 0px 0px 0px rgba(0,0,0,.12);
			margin: 0 1% 30px;
			width: 48%;
			box-sizing: border-box;
			height: auto;
			// 头部
			.el-card__header {
				border: 1px solid #ddd;
				background: linear-gradient(90deg, rgba(28,156,147,.1) 0%, rgba(132,113,199,.1) 100%);
				width: 100%;
				border-width: 0 0 1px;
				// 头部盒子
				.index_card_head {
					display: flex;
					width: 100%;
					justify-content: space-between;
					align-items: center;
					height: 10px;
					// 标题
					.card_head_title {
						color: #f00;
						font-size: 14px;
					}
					// 按钮盒子
					.card_head_right {
						display: flex;
						align-items: center;
						// 按钮
						.el-icon{
							cursor: pointer;
							color: #aaa;
							font-size: 20px;
						}
					}
				}
			}
			// body
			.el-card__body {
				padding: 0;
				// body盒子
				.card_item{
					padding: 30px;
					text-align: center;
				}
			}
		}
	}
</style>
