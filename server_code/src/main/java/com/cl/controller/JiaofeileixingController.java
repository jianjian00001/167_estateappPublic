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

import com.cl.entity.JiaofeileixingEntity;
import com.cl.entity.view.JiaofeileixingView;

import com.cl.service.JiaofeileixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 缴费类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-20 16:54:31
 */
@RestController
@RequestMapping("/jiaofeileixing")
public class JiaofeileixingController {
    @Autowired
    private JiaofeileixingService jiaofeileixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaofeileixingEntity jiaofeileixing,
		HttpServletRequest request){
        EntityWrapper<JiaofeileixingEntity> ew = new EntityWrapper<JiaofeileixingEntity>();

		PageUtils page = jiaofeileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaofeileixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaofeileixingEntity jiaofeileixing, 
		HttpServletRequest request){
        EntityWrapper<JiaofeileixingEntity> ew = new EntityWrapper<JiaofeileixingEntity>();

		PageUtils page = jiaofeileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaofeileixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaofeileixingEntity jiaofeileixing){
       	EntityWrapper<JiaofeileixingEntity> ew = new EntityWrapper<JiaofeileixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaofeileixing, "jiaofeileixing")); 
        return R.ok().put("data", jiaofeileixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaofeileixingEntity jiaofeileixing){
        EntityWrapper< JiaofeileixingEntity> ew = new EntityWrapper< JiaofeileixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaofeileixing, "jiaofeileixing")); 
		JiaofeileixingView jiaofeileixingView =  jiaofeileixingService.selectView(ew);
		return R.ok("查询缴费类型成功").put("data", jiaofeileixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaofeileixingEntity jiaofeileixing = jiaofeileixingService.selectById(id);
		jiaofeileixing = jiaofeileixingService.selectView(new EntityWrapper<JiaofeileixingEntity>().eq("id", id));
        return R.ok().put("data", jiaofeileixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaofeileixingEntity jiaofeileixing = jiaofeileixingService.selectById(id);
		jiaofeileixing = jiaofeileixingService.selectView(new EntityWrapper<JiaofeileixingEntity>().eq("id", id));
        return R.ok().put("data", jiaofeileixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaofeileixingEntity jiaofeileixing, HttpServletRequest request){
    	jiaofeileixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaofeileixing);
        jiaofeileixingService.insert(jiaofeileixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaofeileixingEntity jiaofeileixing, HttpServletRequest request){
    	jiaofeileixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaofeileixing);
        jiaofeileixingService.insert(jiaofeileixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaofeileixingEntity jiaofeileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaofeileixing);
        jiaofeileixingService.updateById(jiaofeileixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaofeileixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
