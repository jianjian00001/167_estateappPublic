package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.CheweixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheweixinxiView;


/**
 * 车位信息
 *
 * @author 
 * @email 
 * @date 2024-02-20 16:54:32
 */
public interface CheweixinxiService extends IService<CheweixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CheweixinxiView> selectListView(Wrapper<CheweixinxiEntity> wrapper);
   	
   	CheweixinxiView selectView(@Param("ew") Wrapper<CheweixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CheweixinxiEntity> wrapper);
   	

}

