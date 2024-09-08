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

import com.cl.entity.ChangzhurenkouEntity;
import com.cl.entity.view.ChangzhurenkouView;

import com.cl.service.ChangzhurenkouService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 常住人口
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-20 16:54:32
 */
@RestController
@RequestMapping("/changzhurenkou")
public class ChangzhurenkouController {
    @Autowired
    private ChangzhurenkouService changzhurenkouService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChangzhurenkouEntity changzhurenkou,
		HttpServletRequest request){
        EntityWrapper<ChangzhurenkouEntity> ew = new EntityWrapper<ChangzhurenkouEntity>();

		PageUtils page = changzhurenkouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changzhurenkou), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChangzhurenkouEntity changzhurenkou, 
		HttpServletRequest request){
        EntityWrapper<ChangzhurenkouEntity> ew = new EntityWrapper<ChangzhurenkouEntity>();

		PageUtils page = changzhurenkouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changzhurenkou), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChangzhurenkouEntity changzhurenkou){
       	EntityWrapper<ChangzhurenkouEntity> ew = new EntityWrapper<ChangzhurenkouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( changzhurenkou, "changzhurenkou")); 
        return R.ok().put("data", changzhurenkouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChangzhurenkouEntity changzhurenkou){
        EntityWrapper< ChangzhurenkouEntity> ew = new EntityWrapper< ChangzhurenkouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( changzhurenkou, "changzhurenkou")); 
		ChangzhurenkouView changzhurenkouView =  changzhurenkouService.selectView(ew);
		return R.ok("查询常住人口成功").put("data", changzhurenkouView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChangzhurenkouEntity changzhurenkou = changzhurenkouService.selectById(id);
		changzhurenkou = changzhurenkouService.selectView(new EntityWrapper<ChangzhurenkouEntity>().eq("id", id));
        return R.ok().put("data", changzhurenkou);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChangzhurenkouEntity changzhurenkou = changzhurenkouService.selectById(id);
		changzhurenkou = changzhurenkouService.selectView(new EntityWrapper<ChangzhurenkouEntity>().eq("id", id));
        return R.ok().put("data", changzhurenkou);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChangzhurenkouEntity changzhurenkou, HttpServletRequest request){
    	changzhurenkou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(changzhurenkou);
        changzhurenkouService.insert(changzhurenkou);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChangzhurenkouEntity changzhurenkou, HttpServletRequest request){
    	changzhurenkou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(changzhurenkou);
        changzhurenkouService.insert(changzhurenkou);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChangzhurenkouEntity changzhurenkou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(changzhurenkou);
        changzhurenkouService.updateById(changzhurenkou);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        changzhurenkouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	





    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<ChangzhurenkouEntity> ew = new EntityWrapper<ChangzhurenkouEntity>();
        List<Map<String, Object>> result = changzhurenkouService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ChangzhurenkouEntity> ew = new EntityWrapper<ChangzhurenkouEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = changzhurenkouService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<ChangzhurenkouEntity> ew = new EntityWrapper<ChangzhurenkouEntity>();
        List<Map<String, Object>> result = changzhurenkouService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ChangzhurenkouEntity> ew = new EntityWrapper<ChangzhurenkouEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = changzhurenkouService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<ChangzhurenkouEntity> ew = new EntityWrapper<ChangzhurenkouEntity>();
        List<Map<String, Object>> result = changzhurenkouService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,ChangzhurenkouEntity changzhurenkou, HttpServletRequest request){
        EntityWrapper<ChangzhurenkouEntity> ew = new EntityWrapper<ChangzhurenkouEntity>();
        int count = changzhurenkouService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changzhurenkou), params), params));
        return R.ok().put("data", count);
    }


}
