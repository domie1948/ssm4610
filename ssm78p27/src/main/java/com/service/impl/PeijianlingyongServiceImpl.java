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


import com.dao.PeijianlingyongDao;
import com.entity.PeijianlingyongEntity;
import com.service.PeijianlingyongService;
import com.entity.vo.PeijianlingyongVO;
import com.entity.view.PeijianlingyongView;

@Service("peijianlingyongService")
public class PeijianlingyongServiceImpl extends ServiceImpl<PeijianlingyongDao, PeijianlingyongEntity> implements PeijianlingyongService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeijianlingyongEntity> page = this.selectPage(
                new Query<PeijianlingyongEntity>(params).getPage(),
                new EntityWrapper<PeijianlingyongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeijianlingyongEntity> wrapper) {
		  Page<PeijianlingyongView> page =new Query<PeijianlingyongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PeijianlingyongVO> selectListVO(Wrapper<PeijianlingyongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PeijianlingyongVO selectVO(Wrapper<PeijianlingyongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PeijianlingyongView> selectListView(Wrapper<PeijianlingyongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeijianlingyongView selectView(Wrapper<PeijianlingyongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
