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


import com.dao.PeijianshenqingDao;
import com.entity.PeijianshenqingEntity;
import com.service.PeijianshenqingService;
import com.entity.vo.PeijianshenqingVO;
import com.entity.view.PeijianshenqingView;

@Service("peijianshenqingService")
public class PeijianshenqingServiceImpl extends ServiceImpl<PeijianshenqingDao, PeijianshenqingEntity> implements PeijianshenqingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeijianshenqingEntity> page = this.selectPage(
                new Query<PeijianshenqingEntity>(params).getPage(),
                new EntityWrapper<PeijianshenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeijianshenqingEntity> wrapper) {
		  Page<PeijianshenqingView> page =new Query<PeijianshenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PeijianshenqingVO> selectListVO(Wrapper<PeijianshenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PeijianshenqingVO selectVO(Wrapper<PeijianshenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PeijianshenqingView> selectListView(Wrapper<PeijianshenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeijianshenqingView selectView(Wrapper<PeijianshenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
