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

import com.cl.entity.LaifangcheliangEntity;
import com.cl.entity.view.LaifangcheliangView;

import com.cl.service.LaifangcheliangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 来访车辆
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-20 16:54:32
 */
@RestController
@RequestMapping("/laifangcheliang")
public class LaifangcheliangController {
    @Autowired
    private LaifangcheliangService laifangcheliangService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LaifangcheliangEntity laifangcheliang,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yezhu")) {
			laifangcheliang.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LaifangcheliangEntity> ew = new EntityWrapper<LaifangcheliangEntity>();

		PageUtils page = laifangcheliangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, laifangcheliang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LaifangcheliangEntity laifangcheliang, 
		HttpServletRequest request){
        EntityWrapper<LaifangcheliangEntity> ew = new EntityWrapper<LaifangcheliangEntity>();

		PageUtils page = laifangcheliangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, laifangcheliang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LaifangcheliangEntity laifangcheliang){
       	EntityWrapper<LaifangcheliangEntity> ew = new EntityWrapper<LaifangcheliangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( laifangcheliang, "laifangcheliang")); 
        return R.ok().put("data", laifangcheliangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LaifangcheliangEntity laifangcheliang){
        EntityWrapper< LaifangcheliangEntity> ew = new EntityWrapper< LaifangcheliangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( laifangcheliang, "laifangcheliang")); 
		LaifangcheliangView laifangcheliangView =  laifangcheliangService.selectView(ew);
		return R.ok("查询来访车辆成功").put("data", laifangcheliangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LaifangcheliangEntity laifangcheliang = laifangcheliangService.selectById(id);
		laifangcheliang = laifangcheliangService.selectView(new EntityWrapper<LaifangcheliangEntity>().eq("id", id));
        return R.ok().put("data", laifangcheliang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LaifangcheliangEntity laifangcheliang = laifangcheliangService.selectById(id);
		laifangcheliang = laifangcheliangService.selectView(new EntityWrapper<LaifangcheliangEntity>().eq("id", id));
        return R.ok().put("data", laifangcheliang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LaifangcheliangEntity laifangcheliang, HttpServletRequest request){
    	laifangcheliang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(laifangcheliang);
        laifangcheliangService.insert(laifangcheliang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LaifangcheliangEntity laifangcheliang, HttpServletRequest request){
    	laifangcheliang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(laifangcheliang);
        laifangcheliangService.insert(laifangcheliang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LaifangcheliangEntity laifangcheliang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(laifangcheliang);
        laifangcheliangService.updateById(laifangcheliang);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<LaifangcheliangEntity> list = new ArrayList<LaifangcheliangEntity>();
        for(Long id : ids) {
            LaifangcheliangEntity laifangcheliang = laifangcheliangService.selectById(id);
            laifangcheliang.setSfsh(sfsh);
            laifangcheliang.setShhf(shhf);
            list.add(laifangcheliang);
        }
        laifangcheliangService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        laifangcheliangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
