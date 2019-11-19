package jc.base.service.impl;


import jc.mybatis.extension.util.ExampleBuildUtil;
import jc.mybatis.extension.util.PageModel;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import com.dbmysql.entity.PayOrderInfo;
import com.dbmysql.entity.PayOrderInfoExample;
import com.dbmysql.mapper.PayOrderInfoMapper;
import jc.base.service.PayOrderInfoService;


public class PayOrderInfoServiceImpl implements PayOrderInfoService {


	@Autowired
	PayOrderInfoMapper payOrderInfoMapper;


	@Override
	public PageModel<PayOrderInfo> pagePayOrderInfo(PayOrderInfo record, PageModel<PayOrderInfo> pageModel) {
		PayOrderInfoExample example = new PayOrderInfoExample();
		ExampleBuildUtil.buildExample(PayOrderInfo.class, record, example);
		ExampleBuildUtil.setPageParam(pageModel, example);
		List<PayOrderInfo> list = this.payOrderInfoMapper.selectByExample(example);
		long totalCount = this.payOrderInfoMapper.countByExample(example);
		return pageModel.build(list, totalCount, pageModel);
	}


	@Override
	public List<PayOrderInfo> listPayOrderInfo(PayOrderInfo record) {
		PayOrderInfoExample example = new PayOrderInfoExample();
		ExampleBuildUtil.buildExample(PayOrderInfo.class, record, example);
		List<PayOrderInfo> list = this.payOrderInfoMapper.selectByExample(example);
		return list;
	}


	@Override
	public PayOrderInfo getPayOrderInfo(PayOrderInfo record) {
		PayOrderInfoExample example = new PayOrderInfoExample();
		ExampleBuildUtil.buildExample(PayOrderInfo.class, record, example);
		example.setLimitStart(0);
		example.setLimitLength(1);
		List<PayOrderInfo> list = this.payOrderInfoMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}


	@Override
	public PayOrderInfo getPayOrderInfoByOrderNo(String orderNo) {
		PayOrderInfoExample example = new PayOrderInfoExample();
		example.createCriteria().andOrderNoEqualTo(orderNo);
		example.setLimitStart(0);
		example.setLimitLength(1);
		List<PayOrderInfo> list = this.payOrderInfoMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}


	@Override
	public int updatePayOrderInfoByOrderNo(PayOrderInfo record,String orderNo) {
		PayOrderInfoExample example = new PayOrderInfoExample();
		example.createCriteria().andOrderNoEqualTo(orderNo);
		return this.payOrderInfoMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayOrderInfoByOrderNo(String orderNo) {
		PayOrderInfoExample example = new PayOrderInfoExample();
		example.createCriteria().andOrderNoEqualTo(orderNo);
		return this.payOrderInfoMapper.deleteByExample(example);
	}


	@Override
	public List<PayOrderInfo> listPayOrderInfoByQrcodeId(Integer qrcodeId) {
		PayOrderInfoExample example = new PayOrderInfoExample();
		example.createCriteria().andQrcodeIdEqualTo(qrcodeId);
		List<PayOrderInfo> list = this.payOrderInfoMapper.selectByExample(example);
		return list;
	}


	@Override
	public int updatePayOrderInfoByQrcodeId(PayOrderInfo record,Integer qrcodeId) {
		PayOrderInfoExample example = new PayOrderInfoExample();
		example.createCriteria().andQrcodeIdEqualTo(qrcodeId);
		return this.payOrderInfoMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayOrderInfoByQrcodeId(Integer qrcodeId) {
		PayOrderInfoExample example = new PayOrderInfoExample();
		example.createCriteria().andQrcodeIdEqualTo(qrcodeId);
		return this.payOrderInfoMapper.deleteByExample(example);
	}


	@Override
	public PayOrderInfo getPayOrderInfoByTradeNo(String tradeNo) {
		PayOrderInfoExample example = new PayOrderInfoExample();
		example.createCriteria().andTradeNoEqualTo(tradeNo);
		example.setLimitStart(0);
		example.setLimitLength(1);
		List<PayOrderInfo> list = this.payOrderInfoMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}


	@Override
	public int updatePayOrderInfoByTradeNo(PayOrderInfo record,String tradeNo) {
		PayOrderInfoExample example = new PayOrderInfoExample();
		example.createCriteria().andTradeNoEqualTo(tradeNo);
		return this.payOrderInfoMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayOrderInfoByTradeNo(String tradeNo) {
		PayOrderInfoExample example = new PayOrderInfoExample();
		example.createCriteria().andTradeNoEqualTo(tradeNo);
		return this.payOrderInfoMapper.deleteByExample(example);
	}


	@Override
	public int insertPayOrderInfo(PayOrderInfo record) {
		return this.payOrderInfoMapper.insertSelective(record);
	}


	@Override
	public int updatePayOrderInfo(PayOrderInfo record) {
		PayOrderInfoExample example = new PayOrderInfoExample();
		ExampleBuildUtil.buildExample(PayOrderInfo.class, record, example);
		return this.payOrderInfoMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int deletePayOrderInfo(PayOrderInfo record) {
		PayOrderInfoExample example = new PayOrderInfoExample();
		ExampleBuildUtil.buildExample(PayOrderInfo.class, record, example);
		return this.payOrderInfoMapper.deleteByExample(example);
	}


}
