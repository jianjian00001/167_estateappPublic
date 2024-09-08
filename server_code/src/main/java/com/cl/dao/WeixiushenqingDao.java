package com.cl.dao;

import com.cl.entity.WeixiushenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WeixiushenqingView;


/**
 * 维修申请
 * 
 * @author 
 * @email 
 * @date 2024-02-20 16:54:31
 */
public interface WeixiushenqingDao extends BaseMapper<WeixiushenqingEntity> {
	
	List<WeixiushenqingView> selectListView(@Param("ew") Wrapper<WeixiushenqingEntity> wrapper);

	List<WeixiushenqingView> selectListView(Pagination page,@Param("ew") Wrapper<WeixiushenqingEntity> wrapper);
	
	WeixiushenqingView selectView(@Param("ew") Wrapper<WeixiushenqingEntity> wrapper);
	

}
