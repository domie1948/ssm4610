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


import com.dao.CaigoujinhuodanDao;
import com.entity.CaigoujinhuodanEntity;
import com.service.CaigoujinhuodanService;
import com.entity.vo.CaigoujinhuodanVO;
import com.entity.view.CaigoujinhuodanView;

@Service("caigoujinhuodanService")
public class CaigoujinhuodanServiceImpl extends ServiceImpl<CaigoujinhuodanDao, CaigoujinhuodanEntity> implements CaigoujinhuodanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CaigoujinhuodanEntity> page = this.selectPage(
                new Query<CaigoujinhuodanEntity>(params).getPage(),
                new EntityWrapper<CaigoujinhuodanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CaigoujinhuodanEntity> wrapper) {
		  Page<CaigoujinhuodanView> page =new Query<CaigoujinhuodanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CaigoujinhuodanVO> selectListVO(Wrapper<CaigoujinhuodanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CaigoujinhuodanVO selectVO(Wrapper<CaigoujinhuodanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CaigoujinhuodanView> selectListView(Wrapper<CaigoujinhuodanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CaigoujinhuodanView selectView(Wrapper<CaigoujinhuodanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
