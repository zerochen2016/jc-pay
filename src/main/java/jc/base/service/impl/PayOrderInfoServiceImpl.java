package jc.base.service.impl;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dbmysql.entity.PayOrderInfo;
import com.dbmysql.entity.PayOrderInfoExample;
import com.dbmysql.entity.PayQrcode;
import com.dbmysql.entity.PayQrcodeExample;
import com.dbmysql.mapper.PayOrderInfoMapper;
import com.dbmysql.mapper.PayQrcodeMapper;

import jc.base.service.PayOrderInfoService;
import jc.common.util.DateUtil;
import jc.common.util.RandomUtil;
import jc.mybatis.extension.util.ExampleBuildUtil;
import jc.mybatis.extension.util.PageModel;
import jc.pay.cache.CacheInternal;

@Service
public class PayOrderInfoServiceImpl implements PayOrderInfoService {


	@Autowired
	PayOrderInfoMapper payOrderInfoMapper;
	@Autowired
	PayQrcodeMapper payQrcodeMapper;


	@Override
	public PageModel<PayOrderInfo> pagePayOrderInfo(PayOrderInfo record, PageModel<PayOrderInfo> pageModel) {
		PayOrderInfoExample example = new PayOrderInfoExample();
		ExampleBuildUtil.buildExample(PayOrderInfo.class, record, example);
		ExampleBuildUtil.setPageParam(pageModel, example);
		example.setOrderByClause("create_time DESC");
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

	@Override
	public boolean checkOrder(String usingId) {
		PayOrderInfoExample example = new PayOrderInfoExample();
		example.createCriteria().andUserIdEqualTo(usingId);
		example.setLimitStart(0);
		example.setLimitLength(1);
		List<PayOrderInfo> ois = this.payOrderInfoMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(ois)) {
			if(ois.get(0).getStatus() == 2) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public PayOrderInfo create(Integer qrcodeId, String money, String tradeNo, String userId, String account) {
		long time = DateUtil.getSystemTimeLong();
		PayOrderInfo order = new PayOrderInfo();
		order.setOrderNo(RandomUtil.getRandomChar("OR", 20));
		order.setMoney(new BigDecimal(money));
		order.setQrcodeId(qrcodeId);
		order.setStatus(1);
		order.setCreateTime(time);
		order.setUpdateTime(time);
		order.setExpireTime(time + CacheInternal.orderExpireTimeMilliSecond());
		order.setTradeNo(tradeNo);
		order.setAccount(account);
		order.setUserId(userId);
		this.payOrderInfoMapper.insertSelective(order);
		return order;
	}
	
	@Override
	public PayOrderInfo create(Integer qrcodeId, String money, String tradeNo, String userId, String account, String mobile) {
		long time = DateUtil.getSystemTimeLong();
		PayOrderInfo order = new PayOrderInfo();
		order.setOrderNo(RandomUtil.getRandomChar("OR", 20));
		order.setMoney(new BigDecimal(money));
		order.setQrcodeId(qrcodeId);
		order.setStatus(1);
		order.setCreateTime(time);
		order.setUpdateTime(time);
		order.setExpireTime(time + CacheInternal.orderExpireTimeMilliSecond());
		order.setTradeNo(tradeNo);
		order.setAccount(account);
		order.setUserId(userId);
		order.setMobile(mobile);
		this.payOrderInfoMapper.insertSelective(order);
		return order;
	}
	
	@Override
	public PayOrderInfo successCallback(String account,String money) {
		PayQrcodeExample example = new PayQrcodeExample();
		example.createCriteria().andAccountEqualTo(account).andMoneyEqualTo(money);
		List<PayQrcode> qrs = this.payQrcodeMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(qrs)) {
			return null;
		}
		PayQrcode qr = qrs.get(0);
		long now = DateUtil.getSystemTimeLong();
		PayOrderInfoExample example1 = new PayOrderInfoExample();
		example1.createCriteria().andQrcodeIdEqualTo(qr.getId()).andStatusEqualTo(1).andExpireTimeGreaterThanOrEqualTo(now);
		example1.setOrderByClause("create_time DESC");
		List<PayOrderInfo> orders = this.payOrderInfoMapper.selectByExample(example1);
		if(CollectionUtils.isEmpty(orders)) {
			return null;
		}
		PayOrderInfo order = orders.get(0);
		PayOrderInfo update = new PayOrderInfo();
		update.setOrderNo(order.getOrderNo());
		update.setStatus(2);
		int up = this.payOrderInfoMapper.updateByPrimaryKeySelective(update);
		if(up < 0) {
			return null;
		}
		return order;
		
	}
	
	@Override
	public boolean checkPay(String orderNo) {
		PayOrderInfo order = this.payOrderInfoMapper.selectByPrimaryKey(orderNo);
		if(order != null && order.getStatus() == 2) {
			return true;
		}
		return false;
	}
}
