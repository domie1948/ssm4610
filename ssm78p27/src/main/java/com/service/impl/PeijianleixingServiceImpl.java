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


import com.dao.PeijianleixingDao;
import com.entity.PeijianleixingEntity;
import com.service.PeijianleixingService;
import com.entity.vo.PeijianleixingVO;
import com.entity.view.PeijianleixingView;

@Service("peijianleixingService")
public class PeijianleixingServiceImpl extends ServiceImpl<PeijianleixingDao, PeijianleixingEntity> implements PeijianleixingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeijianleixingEntity> page = this.selectPage(
                new Query<PeijianleixingEntity>(params).getPage(),
                new EntityWrapper<PeijianleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeijianleixingEntity> wrapper) {
		  Page<PeijianleixingView> page =new Query<PeijianleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PeijianleixingVO> selectListVO(Wrapper<PeijianleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PeijianleixingVO selectVO(Wrapper<PeijianleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PeijianleixingView> selectListView(Wrapper<PeijianleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeijianleixingView selectView(Wrapper<PeijianleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
