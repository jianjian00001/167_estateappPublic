package com.cl.dao;

import com.cl.entity.JiaofeileixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaofeileixingView;


/**
 * 缴费类型
 * 
 * @author 
 * @email 
 * @date 2024-02-20 16:54:31
 */
public interface JiaofeileixingDao extends BaseMapper<JiaofeileixingEntity> {
	
	List<JiaofeileixingView> selectListView(@Param("ew") Wrapper<JiaofeileixingEntity> wrapper);

	List<JiaofeileixingView> selectListView(Pagination page,@Param("ew") Wrapper<JiaofeileixingEntity> wrapper);
	
	JiaofeileixingView selectView(@Param("ew") Wrapper<JiaofeileixingEntity> wrapper);
	

}
