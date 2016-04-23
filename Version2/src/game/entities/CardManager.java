package game.entities;

import game.boundaries.Outputable;
import game.entities.cards.AbstractCard;
import game.entities.cards.MovaActivePlayer;
import game.resources.CardEffect;
import game.util.XMLReader;


public class CardManager {
	public final int NUMBER_OF_Cards = 33;
	public AbstractCard[] cards;
	String userHome = System.getProperty("user.home");
	XMLReader reader = new XMLReader(userHome+"/git/IT--2semester/Projekt-Software/resources/language2.xml");

	
	/**************************************************
	 * Construktor, takes a gui to pass to the fields *
	 **************************************************/
	public CardManager(Outputable gui){
		initializeCards(gui);

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
				return drawnCard;
			}
}
