package game.entities;

import game.boundaries.Outputable;
import game.entities.cards.AbstractCard;
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
	private void initializeCards(Outputable gui){
		cards = new AbstractCard[NUMBER_OF_Cards];

		for (int i = 0; i < fields.length; i++) {
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
	}
}
