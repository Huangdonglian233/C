package cn.patten.bean;

import cn.patten.filter.DataFilter;
import cn.patten.filter.FilterChain;
import cn.patten.filter.LanguageFilter;
import cn.patten.filter.MsgProcessor;
import cn.patten.filter.SesitiveFilter;

public class UserDisplayContent extends DisplayContent{

	String str = "User display web content!";
	MsgProcessor mp = new MsgProcessor();
	@Override
	public void displayContent() {

		System.out.println("---------Original data!----------");
		System.out.println(str);
		mp.setMsg(str);
		FilterChain fc = new FilterChain();
		fc.addFilter(new DataFilter()).addFilter(new SesitiveFilter());
		FilterChain fc2 = new FilterChain();
		fc2.addFilter(new LanguageFilter());

		fc.addFilter(fc2);
		mp.setFc(fc);
		String result = mp.process();
		System.out.println("---------Filtered data!----------");
		System.out.println(result);
	}
}
