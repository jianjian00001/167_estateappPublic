package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.CheliangchuchangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheliangchuchangView;


/**
 * 车辆出场
 *
 * @author 
 * @email 
 * @date 2024-02-20 16:54:32
 */
public interface CheliangchuchangService extends IService<CheliangchuchangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CheliangchuchangView> selectListView(Wrapper<CheliangchuchangEntity> wrapper);
   	
   	CheliangchuchangView selectView(@Param("ew") Wrapper<CheliangchuchangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CheliangchuchangEntity> wrapper);
   	

}

