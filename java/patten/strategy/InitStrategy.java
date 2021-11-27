package cn.patten.strategy;

public class InitStrategy {

	InitFunctions ifuncs;


	public InitFunctions getIfuncs() {
		return ifuncs;
	}


	public void setIfuncs(InitFunctions ifuncs) {
		this.ifuncs = ifuncs;
	}


	public void Init(String str,String username) {
		if(str.equalsIgnoreCase("admin")){
			this.setIfuncs(new InitFunctionsForAdmin());
		}else if(str.equalsIgnoreCase("user")){
			this.setIfuncs(new InitFunctionsForUser());
		}else{
			this.setIfuncs(new InitFunctionsFail());
		}		
		this.ifuncs.initFunc(str,username);
	}
}
