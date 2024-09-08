package com.cl.dao;

import com.cl.entity.CheliangruchangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheliangruchangView;


/**
 * 车辆入场
 * 
 * @author 
 * @email 
 * @date 2024-02-20 16:54:32
 */
public interface CheliangruchangDao extends BaseMapper<CheliangruchangEntity> {
	
	List<CheliangruchangView> selectListView(@Param("ew") Wrapper<CheliangruchangEntity> wrapper);

	List<CheliangruchangView> selectListView(Pagination page,@Param("ew") Wrapper<CheliangruchangEntity> wrapper);
	
	CheliangruchangView selectView(@Param("ew") Wrapper<CheliangruchangEntity> wrapper);
	

}
