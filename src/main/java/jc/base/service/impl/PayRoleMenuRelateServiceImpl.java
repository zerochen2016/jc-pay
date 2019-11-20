package jc.base.service.impl;


import jc.mybatis.extension.util.ExampleBuildUtil;
import jc.mybatis.extension.util.PageModel;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.dbmysql.entity.PayRoleMenuRelate;
import com.dbmysql.entity.PayRoleMenuRelateExample;
import com.dbmysql.mapper.PayRoleMenuRelateMapper;
import jc.base.service.PayRoleMenuRelateService;


public class PayRoleMenuRelateServiceImpl implements PayRoleMenuRelateService {


	@Autowired
	PayRoleMenuRelateMapper payRoleMenuRelateMapper;


	@Override
	public PageModel<PayRoleMenuRelate> pagePayRoleMenuRelate(PayRoleMenuRelate record, PageModel<PayRoleMenuRelate> pageModel) {
		PayRoleMenuRelateExample example = new PayRoleMenuRelateExample();
		ExampleBuildUtil.buildExample(PayRoleMenuRelate.class, record, example);
		ExampleBuildUtil.setPageParam(pageModel, example);
		List<PayRoleMenuRelate> list = this.payRoleMenuRelateMapper.selectByExample(example);
		long totalCount = this.payRoleMenuRelateMapper.countByExample(example);
		return pageModel.build(list, totalCount, pageModel);
	}


	@Override
	public List<PayRoleMenuRelate> listPayRoleMenuRelate(PayRoleMenuRelate record) {
		PayRoleMenuRelateExample example = new PayRoleMenuRelateExample();
		ExampleBuildUtil.buildExample(PayRoleMenuRelate.class, record, example);
		List<PayRoleMenuRelate> list = this.payRoleMenuRelateMapper.selectByExample(example);
		return list;
	}


	@Override
	public PayRoleMenuRelate getPayRoleMenuRelate(PayRoleMenuRelate record) {
		PayRoleMenuRelateExample example = new PayRoleMenuRelateExample();
		ExampleBuildUtil.buildExample(PayRoleMenuRelate.class, record, example);
		example.setLimitStart(0);
		example.setLimitLength(1);
		List<PayRoleMenuRelate> list = this.payRoleMenuRelateMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}


	@Override
	public PayRoleMenuRelate getPayRoleMenuRelateById(Integer id) {
		PayRoleMenuRelateExample example = new PayRoleMenuRelateExample();
		example.createCriteria().andIdEqualTo(id);
		example.setLimitStart(0);
		example.setLimitLength(1);
		List<PayRoleMenuRelate> list = this.payRoleMenuRelateMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}


	@Override
	public int updatePayRoleMenuRelateById(PayRoleMenuRelate record,Integer id) {
		PayRoleMenuRelateExample example = new PayRoleMenuRelateExample();
		example.createCriteria().andIdEqualTo(id);
		return this.payRoleMenuRelateMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayRoleMenuRelateById(Integer id) {
		PayRoleMenuRelateExample example = new PayRoleMenuRelateExample();
		example.createCriteria().andIdEqualTo(id);
		return this.payRoleMenuRelateMapper.deleteByExample(example);
	}


	@Override
	public List<PayRoleMenuRelate> listPayRoleMenuRelateByRoleId(Integer roleId) {
		PayRoleMenuRelateExample example = new PayRoleMenuRelateExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		List<PayRoleMenuRelate> list = this.payRoleMenuRelateMapper.selectByExample(example);
		return list;
	}


	@Override
	public int updatePayRoleMenuRelateByRoleId(PayRoleMenuRelate record,Integer roleId) {
		PayRoleMenuRelateExample example = new PayRoleMenuRelateExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		return this.payRoleMenuRelateMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayRoleMenuRelateByRoleId(Integer roleId) {
		PayRoleMenuRelateExample example = new PayRoleMenuRelateExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		return this.payRoleMenuRelateMapper.deleteByExample(example);
	}


	@Override
	public List<PayRoleMenuRelate> listPayRoleMenuRelateByMenuId(Integer menuId) {
		PayRoleMenuRelateExample example = new PayRoleMenuRelateExample();
		example.createCriteria().andMenuIdEqualTo(menuId);
		List<PayRoleMenuRelate> list = this.payRoleMenuRelateMapper.selectByExample(example);
		return list;
	}


	@Override
	public int updatePayRoleMenuRelateByMenuId(PayRoleMenuRelate record,Integer menuId) {
		PayRoleMenuRelateExample example = new PayRoleMenuRelateExample();
		example.createCriteria().andMenuIdEqualTo(menuId);
		return this.payRoleMenuRelateMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayRoleMenuRelateByMenuId(Integer menuId) {
		PayRoleMenuRelateExample example = new PayRoleMenuRelateExample();
		example.createCriteria().andMenuIdEqualTo(menuId);
		return this.payRoleMenuRelateMapper.deleteByExample(example);
	}


	@Override
	public int insertPayRoleMenuRelate(PayRoleMenuRelate record) {
		return this.payRoleMenuRelateMapper.insertSelective(record);
	}


	@Override
	public int updatePayRoleMenuRelate(PayRoleMenuRelate record) {
		PayRoleMenuRelateExample example = new PayRoleMenuRelateExample();
		ExampleBuildUtil.buildExample(PayRoleMenuRelate.class, record, example);
		return this.payRoleMenuRelateMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayRoleMenuRelate(PayRoleMenuRelate record) {
		PayRoleMenuRelateExample example = new PayRoleMenuRelateExample();
		ExampleBuildUtil.buildExample(PayRoleMenuRelate.class, record, example);
		return this.payRoleMenuRelateMapper.deleteByExample(example);
	}


}
