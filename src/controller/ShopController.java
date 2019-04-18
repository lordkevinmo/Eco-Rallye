package controller;

import model.OPTION;
import model.User;

import java.util.HashMap;
import java.util.Map;
import model.UserSingeleton;

public class ShopController {
	private User user = UserSingeleton.getUser();
	private Map<OPTION,Double> prix= new HashMap<OPTION,Double>();
	public ShopController() {
		//map prix init
		prix.put(OPTION.RX, 100.0);
		prix.put(OPTION.TIMER, 120.0);
	}
	public String buyItem(OPTION op) {
		
		switch(op) {
		case RX : 
			System.out.println("RX ");
			if(user.getScore() < prix.get(OPTION.RX) )
				return "Pas assez de credit"; 
			user.addScore(-1* prix.get(OPTION.RX));//achat 
			user.setRX(true);//maj
			return "Operation réussie !";
			
		case TIMER : if(user.getScore() < prix.get(OPTION.TIMER)) 
			return "Pas assez de credit !";
			user.addScore(-1*prix.get(OPTION.TIMER));
			user.setTimer(true);
			return "Opération réussie !";
		
		default : return "Impossible";
		}
	}
}
