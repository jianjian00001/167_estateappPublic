package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.WeixiushenqingEntity;
import com.cl.entity.view.WeixiushenqingView;

import com.cl.service.WeixiushenqingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 维修申请
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-20 16:54:31
 */
@RestController
@RequestMapping("/weixiushenqing")
public class WeixiushenqingController {
    @Autowired
    private WeixiushenqingService weixiushenqingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeixiushenqingEntity weixiushenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yezhu")) {
			weixiushenqing.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WeixiushenqingEntity> ew = new EntityWrapper<WeixiushenqingEntity>();

		PageUtils page = weixiushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiushenqing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WeixiushenqingEntity weixiushenqing, 
		HttpServletRequest request){
        EntityWrapper<WeixiushenqingEntity> ew = new EntityWrapper<WeixiushenqingEntity>();

		PageUtils page = weixiushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiushenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeixiushenqingEntity weixiushenqing){
       	EntityWrapper<WeixiushenqingEntity> ew = new EntityWrapper<WeixiushenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weixiushenqing, "weixiushenqing")); 
        return R.ok().put("data", weixiushenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeixiushenqingEntity weixiushenqing){
        EntityWrapper< WeixiushenqingEntity> ew = new EntityWrapper< WeixiushenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weixiushenqing, "weixiushenqing")); 
		WeixiushenqingView weixiushenqingView =  weixiushenqingService.selectView(ew);
		return R.ok("查询维修申请成功").put("data", weixiushenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeixiushenqingEntity weixiushenqing = weixiushenqingService.selectById(id);
		weixiushenqing = weixiushenqingService.selectView(new EntityWrapper<WeixiushenqingEntity>().eq("id", id));
        return R.ok().put("data", weixiushenqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeixiushenqingEntity weixiushenqing = weixiushenqingService.selectById(id);
		weixiushenqing = weixiushenqingService.selectView(new EntityWrapper<WeixiushenqingEntity>().eq("id", id));
        return R.ok().put("data", weixiushenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WeixiushenqingEntity weixiushenqing, HttpServletRequest request){
    	weixiushenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiushenqing);
        weixiushenqingService.insert(weixiushenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WeixiushenqingEntity weixiushenqing, HttpServletRequest request){
    	weixiushenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiushenqing);
        weixiushenqingService.insert(weixiushenqing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WeixiushenqingEntity weixiushenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiushenqing);
        weixiushenqingService.updateById(weixiushenqing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        weixiushenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
