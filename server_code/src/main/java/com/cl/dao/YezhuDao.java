package com.cl.dao;

import com.cl.entity.YezhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YezhuView;


/**
 * 业主
 * 
 * @author 
 * @email 
 * @date 2024-02-20 16:54:31
 */
public interface YezhuDao extends BaseMapper<YezhuEntity> {
	
	List<YezhuView> selectListView(@Param("ew") Wrapper<YezhuEntity> wrapper);

	List<YezhuView> selectListView(Pagination page,@Param("ew") Wrapper<YezhuEntity> wrapper);
	
	YezhuView selectView(@Param("ew") Wrapper<YezhuEntity> wrapper);
	

}
