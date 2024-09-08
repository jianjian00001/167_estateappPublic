package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WeixiuleixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WeixiuleixingView;


/**
 * 维修类型
 *
 * @author 
 * @email 
 * @date 2024-02-20 16:54:31
 */
public interface WeixiuleixingService extends IService<WeixiuleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeixiuleixingView> selectListView(Wrapper<WeixiuleixingEntity> wrapper);
   	
   	WeixiuleixingView selectView(@Param("ew") Wrapper<WeixiuleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeixiuleixingEntity> wrapper);
   	

}

