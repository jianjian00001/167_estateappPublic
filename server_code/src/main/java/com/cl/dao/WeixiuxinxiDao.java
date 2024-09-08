package com.cl.dao;

import com.cl.entity.WeixiuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WeixiuxinxiView;


/**
 * 维修信息
 * 
 * @author 
 * @email 
 * @date 2024-02-20 16:54:32
 */
public interface WeixiuxinxiDao extends BaseMapper<WeixiuxinxiEntity> {
	
	List<WeixiuxinxiView> selectListView(@Param("ew") Wrapper<WeixiuxinxiEntity> wrapper);

	List<WeixiuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<WeixiuxinxiEntity> wrapper);
	
	WeixiuxinxiView selectView(@Param("ew") Wrapper<WeixiuxinxiEntity> wrapper);
	

}
