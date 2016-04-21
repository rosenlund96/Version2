package game.entities.cards;

import game.boundaries.Outputable;
import game.controllers.GameController;
import game.entities.FieldManager;
import game.entities.Player;

public class Refuge extends AbstractCard {
	
	private int bonus;
	private int cardNo;
	private FieldManager fieldManager;
	private GameController gameController;

	public Refuge(Outputable output, int bonus, int cardNo) {
		super(output, CardType.REFUGE);
		this.bonus=bonus;
		this.cardNo = cardNo;
	
	}
	
	public int getCardNo(){
		return cardNo;
	}
	
	@Override
	public void drawCard(Player player) {
		switch (bonus) {
		case 1000:
			player.deposit(1000);
			output.showCard("De modtager deres aktieudbytte. Modtag kr. 1000 af banken");
			break;
		case 200:
			player.deposit(200);
			output.showCard("Værdien af egen avl fra nyttehaven udgør 200kr. Modtag kr. 200 af banken.");
			break;
		case 500:
			player.deposit(500);
			output.showCard("De har vundet i klasselotteriet, modtag kr. 500.");
			break;
		case 3000:
			player.deposit(3000);
			output.showCard("Kommunen har eftergivet en kvartalsskat, hæv i banken kr. 3000.");
			break;
		default:
			bonus = 200;
			int playerCount = gameController.names.size();
			player.deposit(bonus*playerCount);
			//Træk 200 fra hvermodspiller
		
		}
		
	}
	
	
	public int getBonus(){
		return bonus;
	}
	
	@Override
	public String toString(){
		return super.toString() + ", bonus=" + bonus;
	}

	
}
