package com.cl.dao;

import com.cl.entity.CheliangchuchangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheliangchuchangView;


/**
 * 车辆出场
 * 
 * @author 
 * @email 
 * @date 2024-02-20 16:54:32
 */
public interface CheliangchuchangDao extends BaseMapper<CheliangchuchangEntity> {
	
	List<CheliangchuchangView> selectListView(@Param("ew") Wrapper<CheliangchuchangEntity> wrapper);

	List<CheliangchuchangView> selectListView(Pagination page,@Param("ew") Wrapper<CheliangchuchangEntity> wrapper);
	
	CheliangchuchangView selectView(@Param("ew") Wrapper<CheliangchuchangEntity> wrapper);
	

}
