package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WeixiuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WeixiuxinxiView;


/**
 * 维修信息
 *
 * @author 
 * @email 
 * @date 2024-02-20 16:54:32
 */
public interface WeixiuxinxiService extends IService<WeixiuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeixiuxinxiView> selectListView(Wrapper<WeixiuxinxiEntity> wrapper);
   	
   	WeixiuxinxiView selectView(@Param("ew") Wrapper<WeixiuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeixiuxinxiEntity> wrapper);
   	

}

