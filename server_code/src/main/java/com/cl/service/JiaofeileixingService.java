package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiaofeileixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaofeileixingView;


/**
 * 缴费类型
 *
 * @author 
 * @email 
 * @date 2024-02-20 16:54:31
 */
public interface JiaofeileixingService extends IService<JiaofeileixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaofeileixingView> selectListView(Wrapper<JiaofeileixingEntity> wrapper);
   	
   	JiaofeileixingView selectView(@Param("ew") Wrapper<JiaofeileixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaofeileixingEntity> wrapper);
   	

}

