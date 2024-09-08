package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.CheliangruchangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheliangruchangView;


/**
 * 车辆入场
 *
 * @author 
 * @email 
 * @date 2024-02-20 16:54:32
 */
public interface CheliangruchangService extends IService<CheliangruchangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CheliangruchangView> selectListView(Wrapper<CheliangruchangEntity> wrapper);
   	
   	CheliangruchangView selectView(@Param("ew") Wrapper<CheliangruchangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CheliangruchangEntity> wrapper);
   	

}

