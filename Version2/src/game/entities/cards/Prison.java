package game.entities.cards;

import game.boundaries.Outputable;
import game.entities.Player;

public class Prison extends AbstractOwnable {

	
	
	public Prison(Outputable output, int cardNo) {
		super(output, CardType.PRISON);
		this.cardNo=cardNo;
	}

	
	public int getCardNo(){
		return cardNo;
	}
	@Override
	public void drawCard(Player player) {
		this.setOwner(player);
		player.setoutOfJailCard(player.getoutOfJailCard()+1);
	}
	

}
