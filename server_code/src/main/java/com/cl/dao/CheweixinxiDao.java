package com.cl.dao;

import com.cl.entity.CheweixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheweixinxiView;


/**
 * 车位信息
 * 
 * @author 
 * @email 
 * @date 2024-02-20 16:54:32
 */
public interface CheweixinxiDao extends BaseMapper<CheweixinxiEntity> {
	
	List<CheweixinxiView> selectListView(@Param("ew") Wrapper<CheweixinxiEntity> wrapper);

	List<CheweixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<CheweixinxiEntity> wrapper);
	
	CheweixinxiView selectView(@Param("ew") Wrapper<CheweixinxiEntity> wrapper);
	

}
