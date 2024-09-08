package com.cl.dao;

import com.cl.entity.WeixiuleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WeixiuleixingView;


/**
 * 维修类型
 * 
 * @author 
 * @email 
 * @date 2024-02-20 16:54:31
 */
public interface WeixiuleixingDao extends BaseMapper<WeixiuleixingEntity> {
	
	List<WeixiuleixingView> selectListView(@Param("ew") Wrapper<WeixiuleixingEntity> wrapper);

	List<WeixiuleixingView> selectListView(Pagination page,@Param("ew") Wrapper<WeixiuleixingEntity> wrapper);
	
	WeixiuleixingView selectView(@Param("ew") Wrapper<WeixiuleixingEntity> wrapper);
	

}
