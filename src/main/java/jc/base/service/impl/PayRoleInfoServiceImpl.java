package jc.base.service.impl;


import jc.mybatis.extension.util.ExampleBuildUtil;
import jc.mybatis.extension.util.PageModel;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.dbmysql.entity.PayRoleInfo;
import com.dbmysql.entity.PayRoleInfoExample;
import com.dbmysql.mapper.PayRoleInfoMapper;
import jc.base.service.PayRoleInfoService;


public class PayRoleInfoServiceImpl implements PayRoleInfoService {


	@Autowired
	PayRoleInfoMapper payRoleInfoMapper;


	@Override
	public PageModel<PayRoleInfo> pagePayRoleInfo(PayRoleInfo record, PageModel<PayRoleInfo> pageModel) {
		PayRoleInfoExample example = new PayRoleInfoExample();
		ExampleBuildUtil.buildExample(PayRoleInfo.class, record, example);
		ExampleBuildUtil.setPageParam(pageModel, example);
		List<PayRoleInfo> list = this.payRoleInfoMapper.selectByExample(example);
		long totalCount = this.payRoleInfoMapper.countByExample(example);
		return pageModel.build(list, totalCount, pageModel);
	}


	@Override
	public List<PayRoleInfo> listPayRoleInfo(PayRoleInfo record) {
		PayRoleInfoExample example = new PayRoleInfoExample();
		ExampleBuildUtil.buildExample(PayRoleInfo.class, record, example);
		List<PayRoleInfo> list = this.payRoleInfoMapper.selectByExample(example);
		return list;
	}


	@Override
	public PayRoleInfo getPayRoleInfo(PayRoleInfo record) {
		PayRoleInfoExample example = new PayRoleInfoExample();
		ExampleBuildUtil.buildExample(PayRoleInfo.class, record, example);
		example.setLimitStart(0);
		example.setLimitLength(1);
		List<PayRoleInfo> list = this.payRoleInfoMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}


	@Override
	public PayRoleInfo getPayRoleInfoById(Integer id) {
		PayRoleInfoExample example = new PayRoleInfoExample();
		example.createCriteria().andIdEqualTo(id);
		example.setLimitStart(0);
		example.setLimitLength(1);
		List<PayRoleInfo> list = this.payRoleInfoMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}


	@Override
	public int updatePayRoleInfoById(PayRoleInfo record,Integer id) {
		PayRoleInfoExample example = new PayRoleInfoExample();
		example.createCriteria().andIdEqualTo(id);
		return this.payRoleInfoMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayRoleInfoById(Integer id) {
		PayRoleInfoExample example = new PayRoleInfoExample();
		example.createCriteria().andIdEqualTo(id);
		return this.payRoleInfoMapper.deleteByExample(example);
	}


	@Override
	public int insertPayRoleInfo(PayRoleInfo record) {
		return this.payRoleInfoMapper.insertSelective(record);
	}


	@Override
	public int updatePayRoleInfo(PayRoleInfo record) {
		PayRoleInfoExample example = new PayRoleInfoExample();
		ExampleBuildUtil.buildExample(PayRoleInfo.class, record, example);
		return this.payRoleInfoMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayRoleInfo(PayRoleInfo record) {
		PayRoleInfoExample example = new PayRoleInfoExample();
		ExampleBuildUtil.buildExample(PayRoleInfo.class, record, example);
		return this.payRoleInfoMapper.deleteByExample(example);
	}


}
