package jc.base.service;


import jc.mybatis.extension.util.PageModel;


import java.util.List;
import com.dbmysql.entity.PayOrderInfo;


public interface PayOrderInfoService {


	PageModel<PayOrderInfo> pagePayOrderInfo(PayOrderInfo record, PageModel<PayOrderInfo> pageModel);


	List<PayOrderInfo> listPayOrderInfo(PayOrderInfo record);


	PayOrderInfo getPayOrderInfo(PayOrderInfo record);


	PayOrderInfo getPayOrderInfoByOrderNo(String orderNo);


	int updatePayOrderInfoByOrderNo(PayOrderInfo record,String orderNo);


	int deletePayOrderInfoByOrderNo(String orderNo);


	List<PayOrderInfo> listPayOrderInfoByQrcodeId(Integer qrcodeId);


	int updatePayOrderInfoByQrcodeId(PayOrderInfo record,Integer qrcodeId);


	int deletePayOrderInfoByQrcodeId(Integer qrcodeId);


	PayOrderInfo getPayOrderInfoByTradeNo(String tradeNo);


	int updatePayOrderInfoByTradeNo(PayOrderInfo record,String tradeNo);


	int deletePayOrderInfoByTradeNo(String tradeNo);


	int insertPayOrderInfo(PayOrderInfo record);


	int updatePayOrderInfo(PayOrderInfo record);


	int deletePayOrderInfo(PayOrderInfo record);


}
