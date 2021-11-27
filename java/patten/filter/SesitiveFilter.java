package cn.patten.filter;

public class SesitiveFilter implements Filter {

	public String doFilter(String str) {
		
		String r = str + " + Sesitive Words Filter";		
		return r;
	}

}
