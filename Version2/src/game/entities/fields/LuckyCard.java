package game.entities.fields;

import game.entities.*;
import game.entities.cards.AbstractCard;
import game.entities.cards.AbstractCard.CardType;
import game.resources.CardEffect;
import game.util.XMLReader;
import game.entities.cards.ChanceCard;
import game.entities.cards.MovaActivePlayer;
import game.boundaries.*;


public class LuckyCard extends AbstractField{

	public AbstractCard[] cards;
	private final int NUMBER_OF_Cards = 33;
	private CardManager cardManager;
	private Outputable output;
	String userHome = System.getProperty("user.home");
	XMLReader reader = new XMLReader(userHome+"/git/IT--2semester/Projekt-Software/resources/language2.xml");
	
	
	public LuckyCard(FieldManager fieldManager, Outputable output) {
		super(fieldManager, FieldType.LUCKYCARD, output);
		this.output = output;
		initializeCards(output);
	}
	
	
	/************************************************************
	 * Creates the array of fields use from the FieldData class *
	 ************************************************************/
	public AbstractCard[] initializeCards(Outputable gui){
		cards = new AbstractCard[NUMBER_OF_Cards];

		for (int i = 0; i < NUMBER_OF_Cards; i++) {
			switch(CardEffect.CardType_DATA[i]){
			case MOVE:
				cards[i] = new MovaActivePlayer(gui, CardEffect.CardNo_DATA[i]);
				cards[i].setText(reader.getElement("cards", CardEffect.CardNo_DATA[i]-1));
				break;
			case PRISON:
				cards[i] = new game.entities.cards.Prison(gui, CardEffect.CardNo_DATA[i]);
				cards[i].setText(reader.getElement("cards", CardEffect.CardNo_DATA[i]-1));
				break;
			case REFUGE:
				cards[i] = new game.entities.cards.Refuge(gui, CardEffect.CardEffect_DATA[i], CardEffect.CardNo_DATA[i]);
				cards[i].setText(reader.getElement("cards", CardEffect.CardNo_DATA[i]-1));
				break;
			case TAX:
				cards[i] = new game.entities.cards.Tax(gui, CardEffect.CardEffect_DATA[i], CardEffect.CardNo_DATA[i]);
				cards[i].setText(reader.getElement("cards", CardEffect.CardNo_DATA[i]-1));
				break;
			}	
		}	
		for(int i = 0; i < cards.length; i++) {
			int j = (int) (Math.random()*cards.length);
			AbstractCard tmpCard = cards[i];
			cards[i] = cards[j];
			cards[j] = tmpCard;
		}
		return cards;
	}
	
	//Draw a card like in a queue
			public AbstractCard drawCard(Player player){
				AbstractCard drawnCard;
				drawnCard=cards[0];
				drawnCard.drawCard(player);
				for(int i = 0; i < (cards.length-1); i++){
					cards[i]=cards[i+1];
				}
				cards[cards.length-1]=drawnCard;	
				output.showCard(drawnCard.getText());
				return drawnCard;
			}
	public void landOnField(Player player){
	drawCard(player);
		}
}
