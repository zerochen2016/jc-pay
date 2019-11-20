package jc.base.service.impl;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dbmysql.entity.PayQrcode;
import com.dbmysql.entity.PayQrcodeExample;
import com.dbmysql.mapper.PayQrcodeMapper;

import jc.base.service.PayQrcodeService;
import jc.common.util.DateUtil;
import jc.mybatis.extension.util.ExampleBuildUtil;
import jc.mybatis.extension.util.PageModel;
import jc.pay.cache.CacheInternal;


@Service
public class PayQrcodeServiceImpl implements PayQrcodeService {


	@Autowired
	PayQrcodeMapper payQrcodeMapper;
	
//	@PostConstruct
//	public void init() {
//		List<Integer> moneyList = new ArrayList<Integer>();
//		moneyList.add(3900);
//		moneyList.add(6900);
//		moneyList.add(9900);
//		moneyList.add(14900);
//		moneyList.add(19900);
//		moneyList.add(39900);
//		moneyList.add(49900);
//		moneyList.add(79900);
//		moneyList.add(99900);
//		moneyList.add(199900);
//		moneyList.add(299900);
//		moneyList.add(499900);
//		int cutPriceRange = 50;
//		moneyList.stream().forEachOrdered(money->{
//			for(int i = 0; i < cutPriceRange;i++) {
//				if((money + i) % 10 == 0) {
//					continue;
//				}
//				String cutPriceMoney = new BigDecimal((money + i)).divide(new BigDecimal(100),2,RoundingMode.HALF_DOWN).toString();
//				PayQrcodeExample example = new PayQrcodeExample();
//				example.createCriteria().andMoneyEqualTo(cutPriceMoney);
//				example.setLimitStart(0);
//				example.setLimitLength(1);
//				if(CollectionUtils.isEmpty(this.payQrcodeMapper.selectByExample(example))) {
//					PayQrcode record = new PayQrcode();
//					record.setAccount("laotie");
//					record.setCodeType(3);
//					record.setMoneyKey(new BigDecimal(money).divide(new BigDecimal(100),2,RoundingMode.HALF_DOWN).toString());
//					record.setMoney(cutPriceMoney);
//					record.setOktime(0l);
//					record.setQrcodeUrl("https://xcmpic.oss-cn-hongkong.aliyuncs.com/laotie.png");
//					record.setStatus(1);
//					record.setUserId("");
//					this.payQrcodeMapper.insertSelective(record);	
//				}
//			}
//		});
//	}
	
//	@PostConstruct
//	public void init() {
//		List<Integer> moneyList = new ArrayList<Integer>();
//		moneyList.add(3800);
//		moneyList.add(6800);
//		moneyList.add(9800);
//		moneyList.add(15800);
//		moneyList.add(19800);
//		moneyList.add(39800);
//		moneyList.add(49800);
//		moneyList.add(79800);
//		moneyList.add(99800);
//		moneyList.add(199800);
//		moneyList.add(300000);
//		moneyList.add(500000);
//		int cutPriceRange = 50;
//		moneyList.stream().forEachOrdered(money->{
//			for(int i = 0; i < cutPriceRange;i++) {
//				if((money + i) % 10 == 0) {
//					continue;
//				}
//				String cutPriceMoney = new BigDecimal((money + i)).divide(new BigDecimal(100),2,RoundingMode.HALF_DOWN).toString();
//				PayQrcodeExample example = new PayQrcodeExample();
//				example.createCriteria().andMoneyEqualTo(cutPriceMoney);
//				example.setLimitStart(0);
//				example.setLimitLength(1);
//				if(CollectionUtils.isEmpty(this.payQrcodeMapper.selectByExample(example))) {
//					PayQrcode record = new PayQrcode();
//					record.setAccount("DAMING");
//					record.setCodeType(3);
//					record.setMoneyKey(new BigDecimal(money).divide(new BigDecimal(100),2,RoundingMode.HALF_DOWN).toString());
//					record.setMoney(cutPriceMoney);
//					record.setOktime(0l);
//					record.setQrcodeUrl("https://xcmpic.oss-cn-hongkong.aliyuncs.com/yunshanghua.png");
//					record.setStatus(1);
//					record.setUserId("");
//					this.payQrcodeMapper.insertSelective(record);	
//				}
//			}
//		});
//	}
	
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

	@Override
	public PayQrcode getQRCode(String moneyKey,String userId) {
		long now = DateUtil.getSystemTimeLong();
		//是否有1分钟内为过期订单
		PayQrcodeExample ex = new PayQrcodeExample();
		ex.createCriteria().andMoneyKeyEqualTo(moneyKey).andStatusEqualTo(1).andUserIdEqualTo(userId)
		.andOktimeGreaterThan(now + 60000l);
		List<PayQrcode> el = this.payQrcodeMapper.selectByExample(ex);
		if(!CollectionUtils.isEmpty(el)) {
			return el.get(0);
		}
		PayQrcodeExample example = new PayQrcodeExample();
		example.createCriteria().andMoneyKeyEqualTo(moneyKey).andStatusEqualTo(1).andOktimeLessThanOrEqualTo(now);
		List<PayQrcode> list = this.payQrcodeMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(list)) {
			Collections.shuffle(list);
			PayQrcode record = list.get(0);
			PayQrcode update = new PayQrcode();
			update.setId(record.getId());
			long oktime = now + CacheInternal.orderExpireTimeMilliSecond();
			update.setOktime(oktime);
			update.setUserId(userId);
			int up = this.payQrcodeMapper.updateByPrimaryKeySelective(update);
			record.setOktime(oktime);
			if(up>0) {
				return record;
			}
		}
		return null;
	}
	
	@Override
	public PayQrcode getQRCode(String moneyKey, String userId, String account) {
		long now = DateUtil.getSystemTimeLong();
		//是否有1分钟内为过期订单
		PayQrcodeExample ex = new PayQrcodeExample();
		ex.createCriteria().andMoneyKeyEqualTo(moneyKey).andStatusEqualTo(1).andUserIdEqualTo(userId)
		.andAccountEqualTo(account).andOktimeGreaterThan(now + 60000l);
		List<PayQrcode> el = this.payQrcodeMapper.selectByExample(ex);
		if(!CollectionUtils.isEmpty(el)) {
			return el.get(0);
		}
		PayQrcodeExample example = new PayQrcodeExample();
		example.createCriteria().andMoneyKeyEqualTo(moneyKey).andAccountEqualTo(account).andStatusEqualTo(1).andOktimeLessThanOrEqualTo(now);
		List<PayQrcode> list = this.payQrcodeMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(list)) {
			Collections.shuffle(list);
			PayQrcode record = list.get(0);
			PayQrcode update = new PayQrcode();
			update.setId(record.getId());
			long oktime = now + CacheInternal.orderExpireTimeMilliSecond();
			update.setOktime(oktime);
			update.setUserId(userId);
			int up = this.payQrcodeMapper.updateByPrimaryKeySelective(update);
			record.setOktime(oktime);
			if(up>0) {
				return record;
			}
		}
		return null;
	}
}
