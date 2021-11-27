package cn.patten.filter;

public class LanguageFilter implements Filter {

	public String doFilter(String str) {
		String r = str + " + Language Filter";
		return r;
	}
}
