package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.WeixiuxiangmuDao;
import com.entity.WeixiuxiangmuEntity;
import com.service.WeixiuxiangmuService;
import com.entity.vo.WeixiuxiangmuVO;
import com.entity.view.WeixiuxiangmuView;

@Service("weixiuxiangmuService")
public class WeixiuxiangmuServiceImpl extends ServiceImpl<WeixiuxiangmuDao, WeixiuxiangmuEntity> implements WeixiuxiangmuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeixiuxiangmuEntity> page = this.selectPage(
                new Query<WeixiuxiangmuEntity>(params).getPage(),
                new EntityWrapper<WeixiuxiangmuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeixiuxiangmuEntity> wrapper) {
		  Page<WeixiuxiangmuView> page =new Query<WeixiuxiangmuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WeixiuxiangmuVO> selectListVO(Wrapper<WeixiuxiangmuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WeixiuxiangmuVO selectVO(Wrapper<WeixiuxiangmuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WeixiuxiangmuView> selectListView(Wrapper<WeixiuxiangmuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeixiuxiangmuView selectView(Wrapper<WeixiuxiangmuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
