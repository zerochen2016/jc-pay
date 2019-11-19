package jc.base.service.impl;


import jc.mybatis.extension.util.ExampleBuildUtil;
import jc.mybatis.extension.util.PageModel;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.dbmysql.entity.PayQrcode;
import com.dbmysql.entity.PayQrcodeExample;
import com.dbmysql.mapper.PayQrcodeMapper;
import jc.base.service.PayQrcodeService;


public class PayQrcodeServiceImpl implements PayQrcodeService {


	@Autowired
	PayQrcodeMapper payQrcodeMapper;


	@Override
	public PageModel<PayQrcode> pagePayQrcode(PayQrcode record, PageModel<PayQrcode> pageModel) {
		PayQrcodeExample example = new PayQrcodeExample();
		ExampleBuildUtil.buildExample(PayQrcode.class, record, example);
		ExampleBuildUtil.setPageParam(pageModel, example);
		List<PayQrcode> list = this.payQrcodeMapper.selectByExample(example);
		long totalCount = this.payQrcodeMapper.countByExample(example);
		return pageModel.build(list, totalCount, pageModel);
	}


	@Override
	public List<PayQrcode> listPayQrcode(PayQrcode record) {
		PayQrcodeExample example = new PayQrcodeExample();
		ExampleBuildUtil.buildExample(PayQrcode.class, record, example);
		List<PayQrcode> list = this.payQrcodeMapper.selectByExample(example);
		return list;
	}


	@Override
	public PayQrcode getPayQrcode(PayQrcode record) {
		PayQrcodeExample example = new PayQrcodeExample();
		ExampleBuildUtil.buildExample(PayQrcode.class, record, example);
		example.setLimitStart(0);
		example.setLimitLength(1);
		List<PayQrcode> list = this.payQrcodeMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}


	@Override
	public PayQrcode getPayQrcodeById(Integer id) {
		PayQrcodeExample example = new PayQrcodeExample();
		example.createCriteria().andIdEqualTo(id);
		example.setLimitStart(0);
		example.setLimitLength(1);
		List<PayQrcode> list = this.payQrcodeMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}


	@Override
	public int updatePayQrcodeById(PayQrcode record,Integer id) {
		PayQrcodeExample example = new PayQrcodeExample();
		example.createCriteria().andIdEqualTo(id);
		return this.payQrcodeMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayQrcodeById(Integer id) {
		PayQrcodeExample example = new PayQrcodeExample();
		example.createCriteria().andIdEqualTo(id);
		return this.payQrcodeMapper.deleteByExample(example);
	}


	@Override
	public List<PayQrcode> listPayQrcodeByAccount(String account) {
		PayQrcodeExample example = new PayQrcodeExample();
		example.createCriteria().andAccountEqualTo(account);
		List<PayQrcode> list = this.payQrcodeMapper.selectByExample(example);
		return list;
	}


	@Override
	public int updatePayQrcodeByAccount(PayQrcode record,String account) {
		PayQrcodeExample example = new PayQrcodeExample();
		example.createCriteria().andAccountEqualTo(account);
		return this.payQrcodeMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayQrcodeByAccount(String account) {
		PayQrcodeExample example = new PayQrcodeExample();
		example.createCriteria().andAccountEqualTo(account);
		return this.payQrcodeMapper.deleteByExample(example);
	}


	@Override
	public List<PayQrcode> listPayQrcodeByMoneyKey(String moneyKey) {
		PayQrcodeExample example = new PayQrcodeExample();
		example.createCriteria().andMoneyKeyEqualTo(moneyKey);
		List<PayQrcode> list = this.payQrcodeMapper.selectByExample(example);
		return list;
	}


	@Override
	public int updatePayQrcodeByMoneyKey(PayQrcode record,String moneyKey) {
		PayQrcodeExample example = new PayQrcodeExample();
		example.createCriteria().andMoneyKeyEqualTo(moneyKey);
		return this.payQrcodeMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayQrcodeByMoneyKey(String moneyKey) {
		PayQrcodeExample example = new PayQrcodeExample();
		example.createCriteria().andMoneyKeyEqualTo(moneyKey);
		return this.payQrcodeMapper.deleteByExample(example);
	}


	@Override
	public int insertPayQrcode(PayQrcode record) {
		return this.payQrcodeMapper.insertSelective(record);
	}


	@Override
	public int updatePayQrcode(PayQrcode record) {
		PayQrcodeExample example = new PayQrcodeExample();
		ExampleBuildUtil.buildExample(PayQrcode.class, record, example);
		return this.payQrcodeMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayQrcode(PayQrcode record) {
		PayQrcodeExample example = new PayQrcodeExample();
		ExampleBuildUtil.buildExample(PayQrcode.class, record, example);
		return this.payQrcodeMapper.deleteByExample(example);
	}


}
