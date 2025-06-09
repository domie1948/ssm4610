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


import com.dao.QichexiulidanDao;
import com.entity.QichexiulidanEntity;
import com.service.QichexiulidanService;
import com.entity.vo.QichexiulidanVO;
import com.entity.view.QichexiulidanView;

@Service("qichexiulidanService")
public class QichexiulidanServiceImpl extends ServiceImpl<QichexiulidanDao, QichexiulidanEntity> implements QichexiulidanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QichexiulidanEntity> page = this.selectPage(
                new Query<QichexiulidanEntity>(params).getPage(),
                new EntityWrapper<QichexiulidanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QichexiulidanEntity> wrapper) {
		  Page<QichexiulidanView> page =new Query<QichexiulidanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QichexiulidanVO> selectListVO(Wrapper<QichexiulidanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QichexiulidanVO selectVO(Wrapper<QichexiulidanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QichexiulidanView> selectListView(Wrapper<QichexiulidanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QichexiulidanView selectView(Wrapper<QichexiulidanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
