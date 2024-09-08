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

import com.cl.entity.WeixiuleixingEntity;
import com.cl.entity.view.WeixiuleixingView;

import com.cl.service.WeixiuleixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 维修类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-20 16:54:31
 */
@RestController
@RequestMapping("/weixiuleixing")
public class WeixiuleixingController {
    @Autowired
    private WeixiuleixingService weixiuleixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeixiuleixingEntity weixiuleixing,
		HttpServletRequest request){
        EntityWrapper<WeixiuleixingEntity> ew = new EntityWrapper<WeixiuleixingEntity>();

		PageUtils page = weixiuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiuleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WeixiuleixingEntity weixiuleixing, 
		HttpServletRequest request){
        EntityWrapper<WeixiuleixingEntity> ew = new EntityWrapper<WeixiuleixingEntity>();

		PageUtils page = weixiuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiuleixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeixiuleixingEntity weixiuleixing){
       	EntityWrapper<WeixiuleixingEntity> ew = new EntityWrapper<WeixiuleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weixiuleixing, "weixiuleixing")); 
        return R.ok().put("data", weixiuleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeixiuleixingEntity weixiuleixing){
        EntityWrapper< WeixiuleixingEntity> ew = new EntityWrapper< WeixiuleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weixiuleixing, "weixiuleixing")); 
		WeixiuleixingView weixiuleixingView =  weixiuleixingService.selectView(ew);
		return R.ok("查询维修类型成功").put("data", weixiuleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeixiuleixingEntity weixiuleixing = weixiuleixingService.selectById(id);
		weixiuleixing = weixiuleixingService.selectView(new EntityWrapper<WeixiuleixingEntity>().eq("id", id));
        return R.ok().put("data", weixiuleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeixiuleixingEntity weixiuleixing = weixiuleixingService.selectById(id);
		weixiuleixing = weixiuleixingService.selectView(new EntityWrapper<WeixiuleixingEntity>().eq("id", id));
        return R.ok().put("data", weixiuleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WeixiuleixingEntity weixiuleixing, HttpServletRequest request){
    	weixiuleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiuleixing);
        weixiuleixingService.insert(weixiuleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WeixiuleixingEntity weixiuleixing, HttpServletRequest request){
    	weixiuleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiuleixing);
        weixiuleixingService.insert(weixiuleixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WeixiuleixingEntity weixiuleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiuleixing);
        weixiuleixingService.updateById(weixiuleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        weixiuleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
