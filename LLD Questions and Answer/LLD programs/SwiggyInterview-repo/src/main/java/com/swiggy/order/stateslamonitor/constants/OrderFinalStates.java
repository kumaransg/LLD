package com.swiggy.order.stateslamonitor.constants;

public enum OrderFinalStates {

	CANCELLED, DELIVERED;
	
	public static boolean isOrderStateFinal(String state){
		for(OrderFinalStates stateEnum : OrderFinalStates.values()){
			if(stateEnum.name().equals(state)){
				return true;
			}
		}
		return false;
	}

}
