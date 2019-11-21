package jc.base.service.impl;


import jc.mybatis.extension.util.ExampleBuildUtil;
import jc.mybatis.extension.util.PageModel;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.dbmysql.entity.PayOperator;
import com.dbmysql.entity.PayOperatorExample;
import com.dbmysql.mapper.PayOperatorMapper;
import jc.base.service.PayOperatorService;

@Service
public class PayOperatorServiceImpl implements PayOperatorService {


	@Autowired
	PayOperatorMapper payOperatorMapper;


	@Override
	public PageModel<PayOperator> pagePayOperator(PayOperator record, PageModel<PayOperator> pageModel) {
		PayOperatorExample example = new PayOperatorExample();
		ExampleBuildUtil.buildExample(PayOperator.class, record, example);
		ExampleBuildUtil.setPageParam(pageModel, example);
		List<PayOperator> list = this.payOperatorMapper.selectByExample(example);
		long totalCount = this.payOperatorMapper.countByExample(example);
		return pageModel.build(list, totalCount, pageModel);
	}


	@Override
	public List<PayOperator> listPayOperator(PayOperator record) {
		PayOperatorExample example = new PayOperatorExample();
		ExampleBuildUtil.buildExample(PayOperator.class, record, example);
		List<PayOperator> list = this.payOperatorMapper.selectByExample(example);
		return list;
	}


	@Override
	public PayOperator getPayOperator(PayOperator record) {
		PayOperatorExample example = new PayOperatorExample();
		ExampleBuildUtil.buildExample(PayOperator.class, record, example);
		example.setLimitStart(0);
		example.setLimitLength(1);
		List<PayOperator> list = this.payOperatorMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}


	@Override
	public PayOperator getPayOperatorByAccount(String account) {
		PayOperatorExample example = new PayOperatorExample();
		example.createCriteria().andAccountEqualTo(account);
		example.setLimitStart(0);
		example.setLimitLength(1);
		List<PayOperator> list = this.payOperatorMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}


	@Override
	public int updatePayOperatorByAccount(PayOperator record,String account) {
		PayOperatorExample example = new PayOperatorExample();
		example.createCriteria().andAccountEqualTo(account);
		return this.payOperatorMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayOperatorByAccount(String account) {
		PayOperatorExample example = new PayOperatorExample();
		example.createCriteria().andAccountEqualTo(account);
		return this.payOperatorMapper.deleteByExample(example);
	}


	@Override
	public int insertPayOperator(PayOperator record) {
		return this.payOperatorMapper.insertSelective(record);
	}


	@Override
	public int updatePayOperator(PayOperator record) {
		PayOperatorExample example = new PayOperatorExample();
		ExampleBuildUtil.buildExample(PayOperator.class, record, example);
		return this.payOperatorMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayOperator(PayOperator record) {
		PayOperatorExample example = new PayOperatorExample();
		ExampleBuildUtil.buildExample(PayOperator.class, record, example);
		return this.payOperatorMapper.deleteByExample(example);
	}


}
