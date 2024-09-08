package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.LaifangcheliangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LaifangcheliangView;


/**
 * 来访车辆
 *
 * @author 
 * @email 
 * @date 2024-02-20 16:54:32
 */
public interface LaifangcheliangService extends IService<LaifangcheliangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LaifangcheliangView> selectListView(Wrapper<LaifangcheliangEntity> wrapper);
   	
   	LaifangcheliangView selectView(@Param("ew") Wrapper<LaifangcheliangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LaifangcheliangEntity> wrapper);
   	

}

