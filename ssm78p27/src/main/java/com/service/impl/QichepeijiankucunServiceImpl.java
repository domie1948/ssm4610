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


import com.dao.QichepeijiankucunDao;
import com.entity.QichepeijiankucunEntity;
import com.service.QichepeijiankucunService;
import com.entity.vo.QichepeijiankucunVO;
import com.entity.view.QichepeijiankucunView;

@Service("qichepeijiankucunService")
public class QichepeijiankucunServiceImpl extends ServiceImpl<QichepeijiankucunDao, QichepeijiankucunEntity> implements QichepeijiankucunService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QichepeijiankucunEntity> page = this.selectPage(
                new Query<QichepeijiankucunEntity>(params).getPage(),
                new EntityWrapper<QichepeijiankucunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QichepeijiankucunEntity> wrapper) {
		  Page<QichepeijiankucunView> page =new Query<QichepeijiankucunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QichepeijiankucunVO> selectListVO(Wrapper<QichepeijiankucunEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QichepeijiankucunVO selectVO(Wrapper<QichepeijiankucunEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QichepeijiankucunView> selectListView(Wrapper<QichepeijiankucunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QichepeijiankucunView selectView(Wrapper<QichepeijiankucunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
