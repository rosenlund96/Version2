package game.entities.fields;

import game.entities.*;
import game.entities.cards.ChanceCard;
import game.boundaries.*;


public class LuckyCard extends AbstractField{

	public ChanceCard[] cards;
	private final int JAIL = 10;
	
	
	public LuckyCard(FieldManager fieldManager, Outputable output) {
		super(fieldManager, FieldType.LUCKYCARD, output);
		this.output = output;
		init();
	}
	
	//Initialiser kortene, derefter kan de kaldes.
		private ChanceCard[] init(){
			String[] text = {
					"De modtager deres aktieudbytte. Modtag kr. 1000 af banken,0,0,1000,false,false",
					"Ryk frem til start.,0,0,0, false, false",
					"G� i f�ngsel. Ryk direkte til f�ngslet. Selvom de passere start indkassere De ikke kr. 4000., 0, 0, 0, false, true",
					"G� i f�ngsel. Ryk direkte til f�ngslet. Selvom de passere start indkassere De ikke kr. 4000., 0, 0, 0, false, true",
					"De har v�ret en tur i udlandet og har haft for mange cigaretter med hjem. Betal kr. 200 i told,0,0,-200, false, false",
					"De har modtaget deres tandl�ge regning betal kr. 2000.,0,0,-2000, false, false",
					"De havde en r�kke med 11 rigtige i tipning. Modtag kr. 1000,0,0,1000, false, false",
					"Deres pr�mieobligation er kommet ud. Modtag kr. 1000 af banken.,0,0,1000, false, false",
					"Deres pr�mieobligation er kommet ud. Modtag kr. 1000 af banken.,0,0,1000, false, false",
					"Det er deres f�dselsdag. Modtag af hver spiller kr. 200,0,0,200, false, false",
					"V�rdien af egen avl fra nyttehaven udg�r 200kr. Modtag kr. 200 af banken.,0,0,200, false, false",
					"Betal deres bilforsikring. Kr. 1000,0,0,1000, false, false",
			    	"Ryk frem til Gr�nningen hvis De passere start. Indkasser da kr. 4000,0,24,0,false,false",
					"Tag med LB-f�rgerne --- Flyt brikken frem og hvis de passere start indkasser da kr. 4000,0,6,0,false,false",
					"I andledning af kongens f�dselsdag ben�des de herved for f�ngsel. Dette kort kan opbevares indtil de f�r brug for det eller de kan s�lge det.,0,0,0,true,false",
					"I andledning af kongens f�dselsdag ben�des de herved for f�ngsel. Dette kort kan opbevares indtil de f�r brug for det eller de kan s�lge det.,0,0,0,true,false",
					"Grundet dyrtiden har de f�et gageforh�jelse. Modtag kr. 1000,0,0,1000,false,false",
					"Ryk frem til Frederiksberg All�. Hvis de passere start indkasser da kr. 4000.,0,11,0,false,false",
					"De har vundet i klasselotteriet modtag kr. 500.,0,0,500,false,false",
					"Tag ind p� R�dhuspladsen.,0,39,0,false,false",
					"Ryk tre felter tilbage.,-3,0,0, false, false",
			    	"Betal kr. 3000 for reparation af deres vogn.,0,0,-3000, false, false",
			    	"Betal kr. 3000 for reparation af deres vogn.,0,0,-3000, false, false",
					"De modtager det store Matadorlegat for v�rdigt tr�ngende kr 40.000. Ved v�rdigt tr�ngende forst�s at deres formue dvs. deres kontakte penge plus sk�der plus penge ikke overstiger kr. 15.000,0,0,40000,false,false",
					"Kommunen har eftergivet en kvartalsskat h�v i banken kr. 3000.,0,0,3000, false, false",
					"Modtag udbytte af deres aktier kr. 1000,0,0,1000, false, false",
					"Modtag udbytte af deres aktier kr. 1000,0,0,1000, false, false",
					"De er k�rt frem for fuld stop betal kr. 1000 i b�de.,0,0,-1000, false, false ",
					"De har modtaget en parkeringsb�de betal kr 200 i b�de.,0,0,-200, false, false"
					};
			
			cards = new ChanceCard[text.length];
			for (int i = 0; i < text.length; i++) {
				String[] splitString = text[i].split("\\s*,\\s*");
				cards[i] = new ChanceCard(splitString[0],Integer.parseInt(splitString[1]), Integer.parseInt(splitString[2]), Integer.parseInt(splitString[3]), Boolean.parseBoolean(splitString[4]), Boolean.parseBoolean(splitString[5]));
			}		
			for(int i = 0; i < cards.length; i++) {
				int j = (int) (Math.random()*cards.length);
				ChanceCard tmpCard = cards[i];
				cards[i] = cards[j];
				cards[j] = tmpCard;
			}
			return cards;
		}
		
		//Draw a card like in a queue
		public ChanceCard drawCard(){
			ChanceCard drawnCard;
			drawnCard=cards[0];
			for(int i = 0; i < (cards.length-1); i++){
				cards[i]=cards[i+1];
			}
			cards[cards.length-1]=drawnCard;	
			return drawnCard;
		}
	
	public void landOnField(Player player){
		ChanceCard drawn = drawCard();
		output.showCard(drawn.getCardText());
		//If the card is a refuge card
		if (drawn.getMoneyAmount()!=0){
			if (drawn.getMoneyAmount()>0){
				player.deposit(drawn.getMoneyAmount());
			}
		}
		//If the card is a Move card.
		else if (drawn.getMovePlayer()!=0){
			if(drawn.getMovePlayer()<0 && player.getPosition()<3){
				player.setPosition(39);
			}
			else
			player.setPosition(drawn.getMovePlayer());;
		}
		//If the card is a go to jail card
		else if (drawn.getJail()){
			player.setPosition(JAIL);
			player.setImprisoned(true);
		}
		//If the card is a jail card.
		else if (drawn.getJailCard()){
			player.setoutOfJailCard(1);
		}
		else if (drawn.getPosition()>=0){
			player.setPosition(drawn.getPosition());
		}
	}
	
	
}