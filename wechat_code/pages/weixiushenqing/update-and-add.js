// pages/edit/edit.js
const {
detail,
option,
update,
add,
list,
follow,
faceMatch,
session,
rubbish,
baiduIdentify
} = require("../../api/index.js")

const des = require('../../utils/des.js')
const utils = require("../../utils/index.js")

Page({

/**
* 页面的初始数据
*/
data: {
    imgIcon: "../../static/upload.png",
editStatus: false,
baseURL:'',
sessionReadArr:[],

detailList: null,
id: "",
cross:"",
ruleForm:{},
userid:getApp().globalData.userInfo.id,
userInfo:getApp().globalData.userInfo,
ro:{
},

yezhuzhanghao:"",
yezhuxingming:"",
loudonghao:"",
fanghao:"",
    weixiuleixingList:"${column.customize}".split(','),
    weixiuleixingIndex:null,
baoxiushijian:"请选择时间",
showbaoxiushijian:false,
weixiuzhuangtai: '未维修',
baoxiuneirong:"",
},


/**
* 生命周期函数--监听页面加载
*/
async onLoad(options) {
let userid
if (options.id) {
this.setData({
editStatus: true
})


}
if(!this.data.userid){
let nowTable = wx.getStorageSync("nowTable");
const res = await session(nowTable)
getApp().globalData.userInfo=res?.data
userid = res?.data.id
}
let baseURL =wx.getStorageSync('baseURL') + '/'
const id = getApp().globalData.detailId
this.setData({
userid,
refid:id,
baseURL
})
//人脸识别
const weixiuleixingres = await option('weixiuleixing/weixiuleixing')
    weixiuleixingres.data.unshift('请选择维修类型')
this.setData({
    weixiuleixingList: weixiuleixingres.data
})
this.setData({
    weixiuzhuangtaiList:  "已维修,未维修".split(',')
})



let  ro=this.data.ro
if(options?.cross){
var obj = wx.getStorageSync('crossObj');

for (var o in obj){

if(o=='yezhuzhanghao'){
            this.setData({
                            yezhuzhanghao: obj[o],
        })
        ro.yezhuzhanghao = true;
    continue;
}else{
    }


if(o=='yezhuxingming'){
            this.setData({
                            yezhuxingming: obj[o],
        })
        ro.yezhuxingming = true;
    continue;
}else{
    }


if(o=='loudonghao'){
            this.setData({
                            loudonghao: obj[o],
        })
        ro.loudonghao = true;
    continue;
}else{
    }


if(o=='fanghao'){
            this.setData({
                            fanghao: obj[o],
        })
        ro.fanghao = true;
    continue;
}else{
    }


if(o=='weixiuleixing'){
            this.setData({
                            weixiuleixing: obj[o],
        })
        ro.weixiuleixing = true;
    continue;
}else{
    }


if(o=='baoxiuneirong'){
            this.setData({
                            baoxiuneirong: obj[o],
        })
        ro.baoxiuneirong = true;
    continue;
}else{
    }


if(o=='baoxiushijian'){
            this.setData({
                            baoxiushijian: obj[o],
        })
        ro.baoxiushijian = true;
    continue;
}else{
    }


if(o=='weixiuzhuangtai'){
            this.setData({
                            weixiuzhuangtai: obj[o],
        })
        ro.weixiuzhuangtai = true;
    continue;
}else{
    }

}
let  statusColumnName=wx.getStorageSync('statusColumnName');
statusColumnName=statusColumnName.replace('[',"").replace(']',"");
this.setData({
ro,
cross:options?.cross,
statusColumnName
})
}

if(id){
// 如果上一级页面传递了id，获取改id数据信息
const   data=getApp().globalData.detailList
    weixiuleixingres.data.map((item, index) => {
    if (item == data.weixiuleixing) {
        this.setData({
                weixiuleixingIndex: index,
                weixiuleixing: item
        })
                                                                                                                                                                            }else if (this.data.weixiuleixingList.length == 1) {
        this.setData({
                weixiuleixingIndex: 0,
                weixiuleixing: v
        })
    }
})


const  def_8=  "未维修"  ;
this.data.weixiuzhuangtaiList.map((v, index) => {
    if (v == data.weixiuzhuangtai|| (v == def_8 && def_8 !=null)) {
        this.setData({
                weixiuzhuangtaiIndex: index,
                weixiuzhuangtai: v
        })
    }else if (this.data.weixiuzhuangtaiList.length == 1) {
        this.setData({
                weixiuzhuangtaiIndex: 0,
                weixiuzhuangtai: v,
                weixiuzhuangtaiList:[def_8]
        })
    }
})




const url = wx.getStorageSync("baseURL") + "/"
const detailList = data
let  objtemp= {
detailList,
        yezhuzhanghao: data.yezhuzhanghao,
        yezhuxingming: data.yezhuxingming,
        loudonghao: data.loudonghao,
        fanghao: data.fanghao,
        baoxiuneirong: data.baoxiuneirong,
        baoxiushijian:utils.getCurrentDate("yMDhms"),
}
this.setData(objtemp);

//ss读取
let c = this.data
this.setData({
});

}else {
this.setData({
})
}



// ss读取
let sessionReadArr=[]
let yezhuzhanghao= getApp().globalData.userInfo.yezhuzhanghao
ro.yezhuzhanghao=true
this.setData({
        yezhuzhanghao,
})
sessionReadArr.push('yezhuzhanghao')
let yezhuxingming= getApp().globalData.userInfo.yezhuxingming
ro.yezhuxingming=true
this.setData({
        yezhuxingming,
})
sessionReadArr.push('yezhuxingming')
let loudonghao= getApp().globalData.userInfo.loudonghao
ro.loudonghao=true
this.setData({
        loudonghao,
})
sessionReadArr.push('loudonghao')
let fanghao= getApp().globalData.userInfo.fanghao
ro.fanghao=true
this.setData({
        fanghao,
})
sessionReadArr.push('fanghao')
ro.weixiuzhuangtai=true

this.setData({
cross:options?.cross,
ro,
id,
sessionReadArr

})



},

getUUID () {
return new Date().getTime();
},
onUnload: function () {
console.log('页面被卸载，执行销毁操作');
},
onShow() {







this.setData({
    baoxiushijian:utils.getCurrentDate("yMDhms")
})


},













































async weixiuleixingChange(e) {
const selectedIndex = e.detail.value;
let  weixiuleixing=this.data.weixiuleixingList[selectedIndex]
this.setData({
    weixiuleixingIndex: selectedIndex,
    weixiuleixing
});
},








baoxiuneirongInput(e) {
this.setData({
    baoxiuneirong: e.detail.value // 每次输入变化时更新文本框的值
});
},









onbaoxiushijianTap(){
this.setData({
showbaoxiushijian: true,
})
},
baoxiushijianTap(e) {
this.setData({
baoxiushijian: e.detail.data
})

},








async weixiuzhuangtaiChange(e) {
const selectedIndex = e.detail.value;
let  weixiuzhuangtai=this.data.weixiuzhuangtaiList[selectedIndex]
this.setData({
    weixiuzhuangtaiIndex: selectedIndex,
    weixiuzhuangtai
});
},






async submit() {
let that = this
var query = wx.createSelectorQuery();
// 在 Page 中的某个方法中调用

query.select('#baoxiuneirong').boundingClientRect();
query.exec(function (res) {
//res就是 所有标签为v1的元素的信息 的数组
that.setData({
    baoxiuneirong: res[0].dataset.info
})
})







if(this.data.baoxiushijian?.includes("请选择") || this.data.baoxiushijian==""){
wx.showToast({
icon: "none",
title: `报修时间不能为空`,
})
return
}


const baseURL = wx.getStorageSync('baseURL') + "/"
const regex = new RegExp(baseURL, "g");
const obj={
yezhuzhanghao: this.data. yezhuzhanghao,
yezhuxingming: this.data. yezhuxingming,
loudonghao: this.data. loudonghao,
fanghao: this.data. fanghao,
weixiuleixing: this.data. weixiuleixing,
baoxiushijian: this.data. baoxiushijian,
weixiuzhuangtai: this.data. weixiuzhuangtai,
baoxiuneirong:this.data. baoxiuneirong,
}
const detailId= getApp().globalData.detailId
const tableName= `weixiushenqing`

//跨表计算判断
var obj2;
var  ruleForm=obj
obj2 = ruleForm
this.data.refid==""? ruleForm['refid']= getApp().globalData.detailId:""
ruleForm['userid']=getApp().globalData.userInfo.id
var userInfo=getApp().globalData.userInfo


const sessionReadArr=this.data.sessionReadArr
const phonePattern = /^\(?\d{3}\)?[-.\s]?\d{3}[-.\s]?\d{4}$/;
const mobilePattern = /^(?:\+?86)?1[3-9]\d{9}$/;
const emailPattern = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
const idPattern = /^[1-9]\d{5}(18|19|20)\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2]\d|3[0-1])\d{3}[\dxX]$/;
const urlPattern = /^(http|https):\/\/[\w\-]+(\.[\w\-]+)+[/#?]?.*$/;










































if(this.data.weixiuleixingList[this.data.weixiuleixingIndex]==undefined ){
wx.showToast({
icon: "none",
title: `维修类型不能为空`,
})
return
}



























if(this.data.weixiuzhuangtaiList[this.data.weixiuzhuangtaiIndex]==undefined ){
wx.showToast({
icon: "none",
title: `维修状态不能为空`,
})
return
}







//更新跨表属性
var crossuserid;
var crossrefid;
var crossoptnum;

if(this.data.cross) {
wx.setStorageSync('crossCleanType', true);
var statusColumnName = wx.getStorageSync('statusColumnName');
var statusColumnValue = wx.getStorageSync('statusColumnValue');
if (statusColumnName != '') {
obj2 = wx.getStorageSync('crossObj');
if (!statusColumnName.startsWith("[")) {
for (var o in obj2) {
if (statusColumnName.includes(o)){
    obj2[o] = statusColumnValue;
}

}
var table = wx.getStorageSync('crossTable');
await update(table, obj2)
} else {

crossuserid =getApp().globalData.userInfo.id
crossrefid =  this.data.id
crossoptnum = wx.getStorageSync('statusColumnName');
crossoptnum = crossoptnum.replace(/\[/, "").replace(/\]/, "");
}
}
}
this.data.cross ? (crossrefid = this.data.id, crossuserid =this.data.userid) : ""

if(crossrefid && crossuserid) {
ruleForm['crossuserid'] = this.data.userid
ruleForm['crossrefid'] =this.data.id

this.setData({
ruleForm
})
let params = {
page: 1,
limit: 10,
crossuserid: crossuserid,
crossrefid: crossrefid,
}
const tips = wx.getStorageSync('tips')
let corssRes = await list(`weixiushenqing`, params)
crossoptnum = wx.getStorageSync('statusColumnName');
crossoptnum = crossoptnum.match(/\d+/g);
if (corssRes.data.total >= parseInt(crossoptnum)) {
wx.showToast({
icon: "none",
title: tips,
})
wx.removeStorageSync('crossCleanType');
return ;
}
else {


//跨表计算









if (ruleForm.id ) {
await update(`weixiushenqing`, ruleForm)
}
else {
await add(`weixiushenqing`, ruleForm)
}
}


}
else {


//跨表计算
if (ruleForm.id || this.data.editStatus) {
this.data.editStatus?ruleForm['id']= getApp().globalData.detailId:""
await update(`weixiushenqing`, ruleForm)
}
else {
await add(`weixiushenqing`, ruleForm)
}
}
getApp().globalData.editorContent=''
wx.showToast({
title: '提交成功',
icon: "none"
})
const preId = getApp().globalData.detailId

if(table){
let res = await detail(table, preId)
if(res.code==0){
getApp().globalData.detailList = res.data
}

}



wx.navigateBack({
delta: 1,
complete: () => {
// 触发事件通知，传递需要更新的数据
const pages = getCurrentPages();
if (pages.length >= 1) {
const prePage = pages[pages.length - 1];
prePage.onLoad(); //
}
}
})













},

onHide() {

},

/**
* 生命周期函数--监听页面卸载
*/
onUnload() {

},


/**
* 页面相关事件处理函数--监听用户下拉动作
*/
onPullDownRefresh() {

},

/**
* 页面上拉触底事件的处理函数
*/
onReachBottom() {

},

/**
* 用户点击右上角分享
*/
onShareAppMessage() {

}
})