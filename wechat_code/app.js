// app.js
App({
    onLaunch() {
        const tabarList=[]
        const genPages=[]
tabarList.push("news")
    tabarList.push("cheweixinxi")
        this.globalData.tabarList=tabarList
    },
    globalData: {
        name: null,
        goodsList: [],
        detailList: {},
        detailId: null,
        tabarList:[],
        userInfo:{},
        total:"",
        editorContent:''

    },

})