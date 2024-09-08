package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChangzhurenkouEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChangzhurenkouView;


/**
 * 常住人口
 *
 * @author 
 * @email 
 * @date 2024-02-20 16:54:32
 */
public interface ChangzhurenkouService extends IService<ChangzhurenkouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChangzhurenkouView> selectListView(Wrapper<ChangzhurenkouEntity> wrapper);
   	
   	ChangzhurenkouView selectView(@Param("ew") Wrapper<ChangzhurenkouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChangzhurenkouEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ChangzhurenkouEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ChangzhurenkouEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ChangzhurenkouEntity> wrapper);



}

