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

import com.cl.entity.CheliangchuchangEntity;
import com.cl.entity.view.CheliangchuchangView;

import com.cl.service.CheliangchuchangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 车辆出场
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-20 16:54:32
 */
@RestController
@RequestMapping("/cheliangchuchang")
public class CheliangchuchangController {
    @Autowired
    private CheliangchuchangService cheliangchuchangService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CheliangchuchangEntity cheliangchuchang,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yezhu")) {
			cheliangchuchang.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<CheliangchuchangEntity> ew = new EntityWrapper<CheliangchuchangEntity>();

		PageUtils page = cheliangchuchangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheliangchuchang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CheliangchuchangEntity cheliangchuchang, 
		HttpServletRequest request){
        EntityWrapper<CheliangchuchangEntity> ew = new EntityWrapper<CheliangchuchangEntity>();

		PageUtils page = cheliangchuchangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheliangchuchang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CheliangchuchangEntity cheliangchuchang){
       	EntityWrapper<CheliangchuchangEntity> ew = new EntityWrapper<CheliangchuchangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cheliangchuchang, "cheliangchuchang")); 
        return R.ok().put("data", cheliangchuchangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CheliangchuchangEntity cheliangchuchang){
        EntityWrapper< CheliangchuchangEntity> ew = new EntityWrapper< CheliangchuchangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cheliangchuchang, "cheliangchuchang")); 
		CheliangchuchangView cheliangchuchangView =  cheliangchuchangService.selectView(ew);
		return R.ok("查询车辆出场成功").put("data", cheliangchuchangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CheliangchuchangEntity cheliangchuchang = cheliangchuchangService.selectById(id);
		cheliangchuchang = cheliangchuchangService.selectView(new EntityWrapper<CheliangchuchangEntity>().eq("id", id));
        return R.ok().put("data", cheliangchuchang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CheliangchuchangEntity cheliangchuchang = cheliangchuchangService.selectById(id);
		cheliangchuchang = cheliangchuchangService.selectView(new EntityWrapper<CheliangchuchangEntity>().eq("id", id));
        return R.ok().put("data", cheliangchuchang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CheliangchuchangEntity cheliangchuchang, HttpServletRequest request){
    	cheliangchuchang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cheliangchuchang);
        cheliangchuchangService.insert(cheliangchuchang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CheliangchuchangEntity cheliangchuchang, HttpServletRequest request){
    	cheliangchuchang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cheliangchuchang);
        cheliangchuchangService.insert(cheliangchuchang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CheliangchuchangEntity cheliangchuchang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cheliangchuchang);
        cheliangchuchangService.updateById(cheliangchuchang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        cheliangchuchangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
