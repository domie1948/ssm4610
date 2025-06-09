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


import com.dao.QichexiulitaizhangDao;
import com.entity.QichexiulitaizhangEntity;
import com.service.QichexiulitaizhangService;
import com.entity.vo.QichexiulitaizhangVO;
import com.entity.view.QichexiulitaizhangView;

@Service("qichexiulitaizhangService")
public class QichexiulitaizhangServiceImpl extends ServiceImpl<QichexiulitaizhangDao, QichexiulitaizhangEntity> implements QichexiulitaizhangService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QichexiulitaizhangEntity> page = this.selectPage(
                new Query<QichexiulitaizhangEntity>(params).getPage(),
                new EntityWrapper<QichexiulitaizhangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QichexiulitaizhangEntity> wrapper) {
		  Page<QichexiulitaizhangView> page =new Query<QichexiulitaizhangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QichexiulitaizhangVO> selectListVO(Wrapper<QichexiulitaizhangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QichexiulitaizhangVO selectVO(Wrapper<QichexiulitaizhangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QichexiulitaizhangView> selectListView(Wrapper<QichexiulitaizhangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QichexiulitaizhangView selectView(Wrapper<QichexiulitaizhangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
