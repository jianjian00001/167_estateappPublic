package com.cl.dao;

import com.cl.entity.ChangzhurenkouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChangzhurenkouView;


/**
 * 常住人口
 * 
 * @author 
 * @email 
 * @date 2024-02-20 16:54:32
 */
public interface ChangzhurenkouDao extends BaseMapper<ChangzhurenkouEntity> {
	
	List<ChangzhurenkouView> selectListView(@Param("ew") Wrapper<ChangzhurenkouEntity> wrapper);

	List<ChangzhurenkouView> selectListView(Pagination page,@Param("ew") Wrapper<ChangzhurenkouEntity> wrapper);
	
	ChangzhurenkouView selectView(@Param("ew") Wrapper<ChangzhurenkouEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChangzhurenkouEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChangzhurenkouEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChangzhurenkouEntity> wrapper);



}
