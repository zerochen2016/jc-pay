package jc.base.service.impl;


import jc.mybatis.extension.util.ExampleBuildUtil;
import jc.mybatis.extension.util.PageModel;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.dbmysql.entity.PayConfigInfo;
import com.dbmysql.entity.PayConfigInfoExample;
import com.dbmysql.mapper.PayConfigInfoMapper;
import jc.base.service.PayConfigInfoService;


public class PayConfigInfoServiceImpl implements PayConfigInfoService {


	@Autowired
	PayConfigInfoMapper payConfigInfoMapper;


	@Override
	public PageModel<PayConfigInfo> pagePayConfigInfo(PayConfigInfo record, PageModel<PayConfigInfo> pageModel) {
		PayConfigInfoExample example = new PayConfigInfoExample();
		ExampleBuildUtil.buildExample(PayConfigInfo.class, record, example);
		ExampleBuildUtil.setPageParam(pageModel, example);
		List<PayConfigInfo> list = this.payConfigInfoMapper.selectByExample(example);
		long totalCount = this.payConfigInfoMapper.countByExample(example);
		return pageModel.build(list, totalCount, pageModel);
	}


	@Override
	public List<PayConfigInfo> listPayConfigInfo(PayConfigInfo record) {
		PayConfigInfoExample example = new PayConfigInfoExample();
		ExampleBuildUtil.buildExample(PayConfigInfo.class, record, example);
		List<PayConfigInfo> list = this.payConfigInfoMapper.selectByExample(example);
		return list;
	}


	@Override
	public PayConfigInfo getPayConfigInfo(PayConfigInfo record) {
		PayConfigInfoExample example = new PayConfigInfoExample();
		ExampleBuildUtil.buildExample(PayConfigInfo.class, record, example);
		example.setLimitStart(0);
		example.setLimitLength(1);
		List<PayConfigInfo> list = this.payConfigInfoMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}


	@Override
	public PayConfigInfo getPayConfigInfoByConfigKey(String configKey) {
		PayConfigInfoExample example = new PayConfigInfoExample();
		example.createCriteria().andConfigKeyEqualTo(configKey);
		example.setLimitStart(0);
		example.setLimitLength(1);
		List<PayConfigInfo> list = this.payConfigInfoMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}


	@Override
	public int updatePayConfigInfoByConfigKey(PayConfigInfo record,String configKey) {
		PayConfigInfoExample example = new PayConfigInfoExample();
		example.createCriteria().andConfigKeyEqualTo(configKey);
		return this.payConfigInfoMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayConfigInfoByConfigKey(String configKey) {
		PayConfigInfoExample example = new PayConfigInfoExample();
		example.createCriteria().andConfigKeyEqualTo(configKey);
		return this.payConfigInfoMapper.deleteByExample(example);
	}


	@Override
	public List<PayConfigInfo> listPayConfigInfoByConfigType(Integer configType) {
		PayConfigInfoExample example = new PayConfigInfoExample();
		example.createCriteria().andConfigTypeEqualTo(configType);
		List<PayConfigInfo> list = this.payConfigInfoMapper.selectByExample(example);
		return list;
	}


	@Override
	public int updatePayConfigInfoByConfigType(PayConfigInfo record,Integer configType) {
		PayConfigInfoExample example = new PayConfigInfoExample();
		example.createCriteria().andConfigTypeEqualTo(configType);
		return this.payConfigInfoMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayConfigInfoByConfigType(Integer configType) {
		PayConfigInfoExample example = new PayConfigInfoExample();
		example.createCriteria().andConfigTypeEqualTo(configType);
		return this.payConfigInfoMapper.deleteByExample(example);
	}


	@Override
	public int insertPayConfigInfo(PayConfigInfo record) {
		return this.payConfigInfoMapper.insertSelective(record);
	}


	@Override
	public int updatePayConfigInfo(PayConfigInfo record) {
		PayConfigInfoExample example = new PayConfigInfoExample();
		ExampleBuildUtil.buildExample(PayConfigInfo.class, record, example);
		return this.payConfigInfoMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayConfigInfo(PayConfigInfo record) {
		PayConfigInfoExample example = new PayConfigInfoExample();
		ExampleBuildUtil.buildExample(PayConfigInfo.class, record, example);
		return this.payConfigInfoMapper.deleteByExample(example);
	}


}
