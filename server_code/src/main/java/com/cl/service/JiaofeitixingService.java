package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiaofeitixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaofeitixingView;


/**
 * 缴费提醒
 *
 * @author 
 * @email 
 * @date 2024-02-20 16:54:32
 */
public interface JiaofeitixingService extends IService<JiaofeitixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaofeitixingView> selectListView(Wrapper<JiaofeitixingEntity> wrapper);
   	
   	JiaofeitixingView selectView(@Param("ew") Wrapper<JiaofeitixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaofeitixingEntity> wrapper);
   	

}

