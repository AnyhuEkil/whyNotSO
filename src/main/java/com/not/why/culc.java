package com.not.why;

public class culc {

	
	public static double cucu(){
		double ans = 100;
		for (int i = 0;  ans>1 ; i++){
			ans = ans - (ans/100);
			if(true){
				System.out.println(i+1+":"+ans);
			}
		}
		return ans; 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		culc.cucu();
	}

}
