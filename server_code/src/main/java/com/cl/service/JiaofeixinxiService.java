package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiaofeixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaofeixinxiView;


/**
 * 缴费信息
 *
 * @author 
 * @email 
 * @date 2024-02-20 16:54:31
 */
public interface JiaofeixinxiService extends IService<JiaofeixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaofeixinxiView> selectListView(Wrapper<JiaofeixinxiEntity> wrapper);
   	
   	JiaofeixinxiView selectView(@Param("ew") Wrapper<JiaofeixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaofeixinxiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<JiaofeixinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<JiaofeixinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<JiaofeixinxiEntity> wrapper);



}

