package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WeixiushenqingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WeixiushenqingView;


/**
 * 维修申请
 *
 * @author 
 * @email 
 * @date 2024-02-20 16:54:31
 */
public interface WeixiushenqingService extends IService<WeixiushenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeixiushenqingView> selectListView(Wrapper<WeixiushenqingEntity> wrapper);
   	
   	WeixiushenqingView selectView(@Param("ew") Wrapper<WeixiushenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeixiushenqingEntity> wrapper);
   	

}

