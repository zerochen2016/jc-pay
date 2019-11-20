package jc.base.service.impl;


import jc.mybatis.extension.util.ExampleBuildUtil;
import jc.mybatis.extension.util.PageModel;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.dbmysql.entity.PayAccountNotify;
import com.dbmysql.entity.PayAccountNotifyExample;
import com.dbmysql.mapper.PayAccountNotifyMapper;
import jc.base.service.PayAccountNotifyService;

@Service
public class PayAccountNotifyServiceImpl implements PayAccountNotifyService {


	@Autowired
	PayAccountNotifyMapper payAccountNotifyMapper;


	@Override
	public PageModel<PayAccountNotify> pagePayAccountNotify(PayAccountNotify record, PageModel<PayAccountNotify> pageModel) {
		PayAccountNotifyExample example = new PayAccountNotifyExample();
		ExampleBuildUtil.buildExample(PayAccountNotify.class, record, example);
		ExampleBuildUtil.setPageParam(pageModel, example);
		List<PayAccountNotify> list = this.payAccountNotifyMapper.selectByExample(example);
		long totalCount = this.payAccountNotifyMapper.countByExample(example);
		return pageModel.build(list, totalCount, pageModel);
	}


	@Override
	public List<PayAccountNotify> listPayAccountNotify(PayAccountNotify record) {
		PayAccountNotifyExample example = new PayAccountNotifyExample();
		ExampleBuildUtil.buildExample(PayAccountNotify.class, record, example);
		List<PayAccountNotify> list = this.payAccountNotifyMapper.selectByExample(example);
		return list;
	}


	@Override
	public PayAccountNotify getPayAccountNotify(PayAccountNotify record) {
		PayAccountNotifyExample example = new PayAccountNotifyExample();
		ExampleBuildUtil.buildExample(PayAccountNotify.class, record, example);
		example.setLimitStart(0);
		example.setLimitLength(1);
		List<PayAccountNotify> list = this.payAccountNotifyMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}


	@Override
	public PayAccountNotify getPayAccountNotifyByAccount(String account) {
		PayAccountNotifyExample example = new PayAccountNotifyExample();
		example.createCriteria().andAccountEqualTo(account);
		example.setLimitStart(0);
		example.setLimitLength(1);
		List<PayAccountNotify> list = this.payAccountNotifyMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}


	@Override
	public int updatePayAccountNotifyByAccount(PayAccountNotify record,String account) {
		PayAccountNotifyExample example = new PayAccountNotifyExample();
		example.createCriteria().andAccountEqualTo(account);
		return this.payAccountNotifyMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayAccountNotifyByAccount(String account) {
		PayAccountNotifyExample example = new PayAccountNotifyExample();
		example.createCriteria().andAccountEqualTo(account);
		return this.payAccountNotifyMapper.deleteByExample(example);
	}


	@Override
	public int insertPayAccountNotify(PayAccountNotify record) {
		return this.payAccountNotifyMapper.insertSelective(record);
	}


	@Override
	public int updatePayAccountNotify(PayAccountNotify record) {
		PayAccountNotifyExample example = new PayAccountNotifyExample();
		ExampleBuildUtil.buildExample(PayAccountNotify.class, record, example);
		return this.payAccountNotifyMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayAccountNotify(PayAccountNotify record) {
		PayAccountNotifyExample example = new PayAccountNotifyExample();
		ExampleBuildUtil.buildExample(PayAccountNotify.class, record, example);
		return this.payAccountNotifyMapper.deleteByExample(example);
	}


}
