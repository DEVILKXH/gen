package com.core;

import java.util.HashMap;
import java.util.Map;

import com.core.extend.wx.constant.WeiXinWorkConstant;
import com.core.extend.wx.util.WexinPushUtil;
import com.core.extend.wx.vo.WeixinTemplateData;


/**
 * @TODO
 * @auth kexiaohong
 * @date 2019年3月15日
 * 
 */
public class Main {

	public static void main(String[] args) {
		String COLOR = "#110000";
		Map<String, WeixinTemplateData> data = new HashMap<String, WeixinTemplateData>();
		data.put("first", new WeixinTemplateData("原定本周末举行的王者荣耀比赛取消", "#110000"));
		data.put("keyword1", new WeixinTemplateData("", COLOR));
		data.put("keyword2", new WeixinTemplateData("", COLOR));
		data.put("keyword3", new WeixinTemplateData("", COLOR));
		data.put("keyword4", new WeixinTemplateData("", COLOR));
		data.put("remark", new WeixinTemplateData("点击查看详情！", COLOR));
		String []openId = {};
		String url = "";
		WexinPushUtil.sendTemplate(openId, data, url, WeiXinWorkConstant.TEMPLATE_TO_SERVICE);
	}

}
