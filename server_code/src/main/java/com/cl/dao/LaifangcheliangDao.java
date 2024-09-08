package com.cl.dao;

import com.cl.entity.LaifangcheliangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LaifangcheliangView;


/**
 * 来访车辆
 * 
 * @author 
 * @email 
 * @date 2024-02-20 16:54:32
 */
public interface LaifangcheliangDao extends BaseMapper<LaifangcheliangEntity> {
	
	List<LaifangcheliangView> selectListView(@Param("ew") Wrapper<LaifangcheliangEntity> wrapper);

	List<LaifangcheliangView> selectListView(Pagination page,@Param("ew") Wrapper<LaifangcheliangEntity> wrapper);
	
	LaifangcheliangView selectView(@Param("ew") Wrapper<LaifangcheliangEntity> wrapper);
	

}
