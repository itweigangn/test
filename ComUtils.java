package com.wei.util;

import com.asinma.framework.util.DataFormat;
import com.cobra.creeper.entity.StockDailyBean;

/**
 * 普通类
 * 封装一些高频的方法
 * 
 * @author weigang
 *
 */
public class ComUtils {

	/**
	 * 判断股票是否涨停
	 * 
	 * 涨停类型,Z 涨停板,D 跌停板,0 其他
	 * StockDailyBean
	 * @param oldPrice
	 * @param newPrice
	 * @return
	 */
	public static String isBan(StockDailyBean info)
	{
		String bReturn = "非";
		double dOldPrice = info.getZs();//昨收
		double dNewPrice = info.getZxj();//今收
		//根据昨收/今收计算是否涨停
		if(dNewPrice !=0 && dOldPrice != 0)
		{
			double dBanPrice_z = DataFormat.formatDouble(new Double(dOldPrice * 1.1), 2);//涨停价
			double dBanPrice_d = DataFormat.formatDouble(new Double(dOldPrice * 0.9), 2);//跌停价
			if(dNewPrice == dBanPrice_z || dNewPrice > dBanPrice_z)
			{
				//如果计算出的涨停价 = 今收，则涨停
				bReturn = "涨停";
			}
			if(dNewPrice == dBanPrice_d || dNewPrice < dBanPrice_d)
			{
				//如果计算出的涨停价 = 今收，则涨停
				bReturn = "跌停";
			}
		}
		return bReturn; 
	}	
	
	/**
	 * 休眠
	 * @param haomiao
	 */
	public static void sleep(int haomiao) 
	{
		try {
			if(haomiao <= 0)
			{
				haomiao = 2000;
			}
			Thread.sleep(haomiao);// 括号里面的代表 毫秒
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
