package cn.patten.filter;

public class DataFilter implements Filter {

	public String doFilter(String str) {
		String r = str + " + Data Filter";
		return r;
	}

}
