package com.cl.dao;

import com.cl.entity.JiaofeitixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaofeitixingView;


/**
 * 缴费提醒
 * 
 * @author 
 * @email 
 * @date 2024-02-20 16:54:32
 */
public interface JiaofeitixingDao extends BaseMapper<JiaofeitixingEntity> {
	
	List<JiaofeitixingView> selectListView(@Param("ew") Wrapper<JiaofeitixingEntity> wrapper);

	List<JiaofeitixingView> selectListView(Pagination page,@Param("ew") Wrapper<JiaofeitixingEntity> wrapper);
	
	JiaofeitixingView selectView(@Param("ew") Wrapper<JiaofeitixingEntity> wrapper);
	

}
