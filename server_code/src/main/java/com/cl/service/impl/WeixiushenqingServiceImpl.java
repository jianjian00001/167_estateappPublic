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


import com.cl.dao.WeixiushenqingDao;
import com.cl.entity.WeixiushenqingEntity;
import com.cl.service.WeixiushenqingService;
import com.cl.entity.view.WeixiushenqingView;

@Service("weixiushenqingService")
public class WeixiushenqingServiceImpl extends ServiceImpl<WeixiushenqingDao, WeixiushenqingEntity> implements WeixiushenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeixiushenqingEntity> page = this.selectPage(
                new Query<WeixiushenqingEntity>(params).getPage(),
                new EntityWrapper<WeixiushenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeixiushenqingEntity> wrapper) {
		  Page<WeixiushenqingView> page =new Query<WeixiushenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<WeixiushenqingView> selectListView(Wrapper<WeixiushenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeixiushenqingView selectView(Wrapper<WeixiushenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
