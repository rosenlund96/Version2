package game.entities;

import game.boundaries.Outputable;
import game.entities.cards.AbstractCard;
import game.entities.cards.ChanceCard;
import game.entities.fields.AbstractField;
import game.entities.fields.Fleet;
import game.entities.fields.LaborCamp;
import game.entities.fields.LuckyCard;
import game.entities.fields.Prison;
import game.entities.fields.Refuge;
import game.entities.fields.Start;
import game.entities.fields.Tax;
import game.entities.fields.Territory;
import game.resources.FieldData;

public class CardManager {
	public final int NUMBER_OF_Cards = 33;
	private AbstractCard[] cards;

	
	/**************************************************
	 * Construktor, takes a gui to pass to the fields *
	 **************************************************/
	public CardManager(Outputable gui){
		initializeCards(gui);

	}
	
	/************************************************************
	 * Creates the array of fields use from the FieldData class *
	 ************************************************************/
	private AbstractCard[] initializeCards(Outputable gui){
		cards = new AbstractCard[NUMBER_OF_Cards];

		for (int i = 0; i < NUMBER_OF_Cards; i++) {
			switch(FieldData.FIELDTYPE_DATA[i]){
			case TERRITORY: 
				fields[i] = new Territory(this, FieldData.FIELDBUYPRICE_DATA[i],FieldData.FIELDRENT1_DATA[i], FieldData.FIELDNUMBER[i], gui);
				break;
			case LABOR_CAMP: 
				fields[i] = new LaborCamp(this, FieldData.FIELDBUYPRICE_DATA[i], FieldData.FIELDRENT1_DATA[i], gui);
				break;
			case FLEET: 
				fields[i] = new Fleet(this, FieldData.FIELDBUYPRICE_DATA[i], gui);
				break;
			case TAX: 
				fields[i] = new Tax(this, FieldData.FIELDRENT1_DATA[i], gui);
				break;
			case REFUGE: 
				fields[i] = new Refuge(this, FieldData.FIELDRENT1_DATA[i], gui);
				break;
			case PRISON:
				fields[i] = new Prison(this,gui,FieldData.FIELDNUMBER[i]);
				break;
			case LUCKYCARD:
				fields[i] = new LuckyCard(this, gui);
				break;
			case START:
				fields[i] = new Start(this, 4000,FieldData.FIELDNUMBER[i], gui);
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
			public AbstractCard drawCard(){
				AbstractCard drawnCard;
				drawnCard=cards[0];
				for(int i = 0; i < (cards.length-1); i++){
					cards[i]=cards[i+1];
				}
				cards[cards.length-1]=drawnCard;	
				return drawnCard;
			}
}
