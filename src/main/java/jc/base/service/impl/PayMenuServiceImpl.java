package jc.base.service.impl;


import jc.mybatis.extension.util.ExampleBuildUtil;
import jc.mybatis.extension.util.PageModel;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.dbmysql.entity.PayMenu;
import com.dbmysql.entity.PayMenuExample;
import com.dbmysql.mapper.PayMenuMapper;
import jc.base.service.PayMenuService;


public class PayMenuServiceImpl implements PayMenuService {


	@Autowired
	PayMenuMapper payMenuMapper;


	@Override
	public PageModel<PayMenu> pagePayMenu(PayMenu record, PageModel<PayMenu> pageModel) {
		PayMenuExample example = new PayMenuExample();
		ExampleBuildUtil.buildExample(PayMenu.class, record, example);
		ExampleBuildUtil.setPageParam(pageModel, example);
		List<PayMenu> list = this.payMenuMapper.selectByExample(example);
		long totalCount = this.payMenuMapper.countByExample(example);
		return pageModel.build(list, totalCount, pageModel);
	}


	@Override
	public List<PayMenu> listPayMenu(PayMenu record) {
		PayMenuExample example = new PayMenuExample();
		ExampleBuildUtil.buildExample(PayMenu.class, record, example);
		List<PayMenu> list = this.payMenuMapper.selectByExample(example);
		return list;
	}


	@Override
	public PayMenu getPayMenu(PayMenu record) {
		PayMenuExample example = new PayMenuExample();
		ExampleBuildUtil.buildExample(PayMenu.class, record, example);
		example.setLimitStart(0);
		example.setLimitLength(1);
		List<PayMenu> list = this.payMenuMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}


	@Override
	public PayMenu getPayMenuById(Integer id) {
		PayMenuExample example = new PayMenuExample();
		example.createCriteria().andIdEqualTo(id);
		example.setLimitStart(0);
		example.setLimitLength(1);
		List<PayMenu> list = this.payMenuMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}


	@Override
	public int updatePayMenuById(PayMenu record,Integer id) {
		PayMenuExample example = new PayMenuExample();
		example.createCriteria().andIdEqualTo(id);
		return this.payMenuMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayMenuById(Integer id) {
		PayMenuExample example = new PayMenuExample();
		example.createCriteria().andIdEqualTo(id);
		return this.payMenuMapper.deleteByExample(example);
	}


	@Override
	public List<PayMenu> listPayMenuByPid(Integer pid) {
		PayMenuExample example = new PayMenuExample();
		example.createCriteria().andPidEqualTo(pid);
		List<PayMenu> list = this.payMenuMapper.selectByExample(example);
		return list;
	}


	@Override
	public int updatePayMenuByPid(PayMenu record,Integer pid) {
		PayMenuExample example = new PayMenuExample();
		example.createCriteria().andPidEqualTo(pid);
		return this.payMenuMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayMenuByPid(Integer pid) {
		PayMenuExample example = new PayMenuExample();
		example.createCriteria().andPidEqualTo(pid);
		return this.payMenuMapper.deleteByExample(example);
	}


	@Override
	public List<PayMenu> listPayMenuByStatus(Integer status) {
		PayMenuExample example = new PayMenuExample();
		example.createCriteria().andStatusEqualTo(status);
		List<PayMenu> list = this.payMenuMapper.selectByExample(example);
		return list;
	}


	@Override
	public int updatePayMenuByStatus(PayMenu record,Integer status) {
		PayMenuExample example = new PayMenuExample();
		example.createCriteria().andStatusEqualTo(status);
		return this.payMenuMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayMenuByStatus(Integer status) {
		PayMenuExample example = new PayMenuExample();
		example.createCriteria().andStatusEqualTo(status);
		return this.payMenuMapper.deleteByExample(example);
	}


	@Override
	public int insertPayMenu(PayMenu record) {
		return this.payMenuMapper.insertSelective(record);
	}


	@Override
	public int updatePayMenu(PayMenu record) {
		PayMenuExample example = new PayMenuExample();
		ExampleBuildUtil.buildExample(PayMenu.class, record, example);
		return this.payMenuMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayMenu(PayMenu record) {
		PayMenuExample example = new PayMenuExample();
		ExampleBuildUtil.buildExample(PayMenu.class, record, example);
		return this.payMenuMapper.deleteByExample(example);
	}


}
