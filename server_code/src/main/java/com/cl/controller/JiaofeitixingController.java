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

import com.cl.entity.JiaofeitixingEntity;
import com.cl.entity.view.JiaofeitixingView;

import com.cl.service.JiaofeitixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 缴费提醒
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-20 16:54:32
 */
@RestController
@RequestMapping("/jiaofeitixing")
public class JiaofeitixingController {
    @Autowired
    private JiaofeitixingService jiaofeitixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaofeitixingEntity jiaofeitixing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yezhu")) {
			jiaofeitixing.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiaofeitixingEntity> ew = new EntityWrapper<JiaofeitixingEntity>();

		PageUtils page = jiaofeitixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaofeitixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaofeitixingEntity jiaofeitixing, 
		HttpServletRequest request){
        EntityWrapper<JiaofeitixingEntity> ew = new EntityWrapper<JiaofeitixingEntity>();

		PageUtils page = jiaofeitixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaofeitixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaofeitixingEntity jiaofeitixing){
       	EntityWrapper<JiaofeitixingEntity> ew = new EntityWrapper<JiaofeitixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaofeitixing, "jiaofeitixing")); 
        return R.ok().put("data", jiaofeitixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaofeitixingEntity jiaofeitixing){
        EntityWrapper< JiaofeitixingEntity> ew = new EntityWrapper< JiaofeitixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaofeitixing, "jiaofeitixing")); 
		JiaofeitixingView jiaofeitixingView =  jiaofeitixingService.selectView(ew);
		return R.ok("查询缴费提醒成功").put("data", jiaofeitixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaofeitixingEntity jiaofeitixing = jiaofeitixingService.selectById(id);
		jiaofeitixing = jiaofeitixingService.selectView(new EntityWrapper<JiaofeitixingEntity>().eq("id", id));
        return R.ok().put("data", jiaofeitixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaofeitixingEntity jiaofeitixing = jiaofeitixingService.selectById(id);
		jiaofeitixing = jiaofeitixingService.selectView(new EntityWrapper<JiaofeitixingEntity>().eq("id", id));
        return R.ok().put("data", jiaofeitixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaofeitixingEntity jiaofeitixing, HttpServletRequest request){
    	jiaofeitixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaofeitixing);
        jiaofeitixingService.insert(jiaofeitixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaofeitixingEntity jiaofeitixing, HttpServletRequest request){
    	jiaofeitixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaofeitixing);
        jiaofeitixingService.insert(jiaofeitixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaofeitixingEntity jiaofeitixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaofeitixing);
        jiaofeitixingService.updateById(jiaofeitixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaofeitixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
