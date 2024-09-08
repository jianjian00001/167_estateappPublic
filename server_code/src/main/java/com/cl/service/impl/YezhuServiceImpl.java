package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.YezhuDao;
import com.cl.entity.YezhuEntity;
import com.cl.service.YezhuService;
import com.cl.entity.view.YezhuView;

@Service("yezhuService")
public class YezhuServiceImpl extends ServiceImpl<YezhuDao, YezhuEntity> implements YezhuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YezhuEntity> page = this.selectPage(
                new Query<YezhuEntity>(params).getPage(),
                new EntityWrapper<YezhuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YezhuEntity> wrapper) {
		  Page<YezhuView> page =new Query<YezhuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YezhuView> selectListView(Wrapper<YezhuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YezhuView selectView(Wrapper<YezhuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
