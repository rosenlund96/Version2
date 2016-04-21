package game.entities.cards;

import game.boundaries.Outputable;
import game.entities.Player;

public class MovaActivePlayer extends AbstractCard {
	private int fieldNo;
	private int cardNo;
	
	
	public MovaActivePlayer(Outputable output, int cardNo) {
		super(output, CardType.MOVE);
		this.cardNo = cardNo;
		
	}
	
	public int getCardNo(){
		return cardNo;
	}

	@Override
	public void drawCard(Player player) {
		int currentPosition = player.getPosition();
		int difference;
		switch (cardNo) {
		
		case (24)://Ryk tre felter tilbage
			player.setPosition(Math.abs((currentPosition-3)) % 41);
			break;	
		case (3)://G� til f�ngsel
			fieldNo = 11;
			player.setPosition(fieldNo);
			break;	
		case (4)://G� til f�ngsel
			fieldNo = 11;
			player.setPosition(fieldNo);
			break;	
		case (2)://G� til start
			fieldNo=1;
			difference = getCount(currentPosition, fieldNo);
			player.setPosition((currentPosition + difference) % 41);
			if(passStart(currentPosition,fieldNo)==true){ player.deposit(4000);}
			break;	
		case(14)://G� til Gr�nningen
			fieldNo = 25;
			difference = getCount(currentPosition, fieldNo);
			player.setPosition((currentPosition + difference) % 41);
			if(passStart(currentPosition,fieldNo)==true){ player.deposit(4000);}
			break;	
		case(15)://N�rmeste redderi
			fieldNo = closestRefuge(currentPosition);
			difference = getCount(currentPosition, fieldNo);
			player.setPosition((currentPosition +difference) % 41);	
			break;
		case(16)://N�rmeste redderi
			fieldNo = closestRefuge(currentPosition);
			difference = getCount(currentPosition, fieldNo);
			player.setPosition((currentPosition + difference) % 41);
			break;	
		case(17)://LB f�rgerne
			fieldNo=6;
			difference = getCount(currentPosition, fieldNo);
			player.setPosition((currentPosition +difference) % 41);
			if(passStart(currentPosition,fieldNo)==true){ player.deposit(4000);}
			break;
		case(21)://Frederiksberg Alle
			fieldNo=12;
			difference = getCount(currentPosition, fieldNo);
			player.setPosition((currentPosition + difference) % 41);
			if(passStart(currentPosition,fieldNo)==true){ player.deposit(4000);}
			break;
		case(23)://R�dhuspladsen
			player.setPosition(40);
			break;		
			//Denne klasse er meget ucharmerende, men den virker	
		}	
	}	

	public int getCount(int currentPosition, int fieldNo){
		int count = 0;
		while(currentPosition != fieldNo){
			if(currentPosition<=40)
			currentPosition++;
			count++;
			
			if(currentPosition==41){
			currentPosition=0;
			count++;
			}
		}
		return count;
	}
	public boolean passStart(int currentPosition, int fieldNo){
		if (currentPosition+getCount(currentPosition,fieldNo)<=40) {
			return false;
		}
		return true;
	}
	public int closestRefuge(int currentPosition){
		int r1= 6;
		int r2 = 13;
		int r3 = 29;
		
		int difference1 = getCount(currentPosition, r1);
		int difference2 = getCount(currentPosition, r2);
		int difference3 = getCount(currentPosition, r3);
		
		if(difference1<difference2 && difference1<difference3){
		    return r1;
		}else if(difference2<difference3 && difference2<difference1){
		    return r2;
		}else{
		    return r3;
		}
	}
	
	@Override
	public String toString(){
		return super.toString() + ", cardNo=" + cardNo ;
	}
}
