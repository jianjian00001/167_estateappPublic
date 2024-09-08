package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YezhuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YezhuView;


/**
 * 业主
 *
 * @author 
 * @email 
 * @date 2024-02-20 16:54:31
 */
public interface YezhuService extends IService<YezhuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YezhuView> selectListView(Wrapper<YezhuEntity> wrapper);
   	
   	YezhuView selectView(@Param("ew") Wrapper<YezhuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YezhuEntity> wrapper);
   	

}

