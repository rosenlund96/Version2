package game.resources;

import game.entities.cards.AbstractCard;


public class CardEffect {

	private static int players;
	private static int houses;
	private static int hotels;
	
//Hvordan skal jeg vide ovenst�ende? 

	
	
	public static final int[] CardNo_DATA = {
			1,2,3,4,5,6,7,8,9,10,11,12,
			13,14,15,16,17,18,19,20,21,
			22,23,24,25,26,27,28,29,30,
			31,32,33
	};
	public static final String[] CardText_DATA = {
			"De modtager deres aktieudbytte. Modtag kr. 1000 af banken",
			"Ryk frem til start.",
			"G� i f�ngsel. Ryk direkte til f�ngslet. Selvom de passere start, indkassere De ikke kr. 4000.",
			"G� i f�ngsel. Ryk direkte til f�ngslet. Selvom de passere start, indkassere De ikke kr. 4000.",
			"De har v�ret en tur i udlandet og har haft for mange cigaretter med hjem. Betal kr. 200 i told",
			"De har modtaget deres tandl�ge regning, betal kr. 2000.",
			"De havde en r�kke med 11 rigtige i tipning. Modtag kr. 1000",
			"Deres pr�mieobligation er kommet ud. Modtag kr. 1000 af banken.",
			"Deres pr�mieobligation er kommet ud. Modtag kr. 1000 af banken.",
			"Det er deres f�dselsdag. Modtag af hver spiller, kr. 200",
			"V�rdien af egen avl fra nyttehaven udg�r 200kr. Modtag kr. 200 af banken.",
			"Betal deres bilforsikring. Kr. 1000",
			"Ejendomsskatterne er steget, ekstraudgifterne er: 800kr pr hus, 2300kr pr hotel.",
			"Ryk frem til Gr�nningen, hvis De passere start. Indkasser da kr. 4000",
			"Ryk brikken frem til det n�rmeste redderi og betal ejeren to gange den leje, han ellers er berettiget til. Hvis selskabet ikke ejes af nogen, kan De k�be det af banken.",
			"Ryk brikken frem til det n�rmeste redderi og betal ejeren to gange den leje, han ellers er berettiget til. Hvis selskabet ikke ejes af nogen, kan De k�be det af banken.",
			"Tag med LB-f�rgerne --- Flyt brikken frem, og hvis de passere start, indkasser da kr. 4000",
			"I andledning af kongens f�dselsdag ben�des de herved for f�ngsel. Dette kort kan opbevares, indtil de f�r brug for det, eller de kan s�lge det.",
			"I andledning af kongens f�dselsdag ben�des de herved for f�ngsel. Dette kort kan opbevares, indtil de f�r brug for det, eller de kan s�lge det.",
			"Grundet dyrtiden har de f�et gageforh�jelse. Modtag kr. 1000",
			"Ryk frem til Frederiksberg All�,. Hvis de passere start, indkasser da kr. 4000.",
			"De har vundet i klasselotteriet, modtag kr. 500.",
			"Tag ind p� R�dhuspladsen.",
			"Ryk tre felter tilbage.",
			"Oliepriserne er steget, og De skal betale; kr. 500 pr hus, kr. 2000 pr hotel.",
			"Betal kr. 3000 for reparation af deres vogn.",
			"Betal kr. 3000 for reparation af deres vogn.",
			"De modtager det store Matadorlegat for v�rdigt tr�ngende, kr 40.000. Ved v�rdigt tr�ngende forst�s, at deres formue, dvs. deres kontakte penge, plus sk�der, plus penge, ike overstiger kr. 15.000",
			"Kommunen har eftergivet en kvartalsskat, h�v i banken kr. 3000.",
			"Modtag udbytte af deres aktier, kr. 1000",
			"Modtag udbytte af deres aktier, kr. 1000",
			"De er k�rt frem for fuld stop, betal kr. 1000 i b�de. ",
			"De har modtaget en parkeringsb�de, betal kr 200 i b�de.",
			
	};
	
	public static final int[] CardEffect_DATA = {
			1000,0,0,0,-200,-2000,1000,1000,
			1000,200,200,-1000,-(800*houses)-(2300*hotels),
			0,0,0,0,0,0,1000,0,500,0,0,-(500*houses)-(2000*hotels),
			-3000,-3000,40000,3000,1000,1000,-1000,-200
			
	};
	public static final int[] CardPositionEffect_Data = {
			
	};
	public static final AbstractCard.CardType[] CardType_DATA = {
			AbstractCard.CardType.REFUGE,
			AbstractCard.CardType.MOVE,
			AbstractCard.CardType.PRISON,
			AbstractCard.CardType.PRISON,
			AbstractCard.CardType.TAX,
			AbstractCard.CardType.TAX,
			AbstractCard.CardType.REFUGE,
			AbstractCard.CardType.REFUGE,
			AbstractCard.CardType.REFUGE,
			AbstractCard.CardType.REFUGE,
			AbstractCard.CardType.REFUGE,
			AbstractCard.CardType.TAX,
			AbstractCard.CardType.TAX,
			AbstractCard.CardType.MOVE,
			AbstractCard.CardType.MOVE,
			AbstractCard.CardType.MOVE,
			AbstractCard.CardType.MOVE,
			AbstractCard.CardType.PRISON,
			AbstractCard.CardType.PRISON,
			AbstractCard.CardType.REFUGE,
			AbstractCard.CardType.MOVE,
			AbstractCard.CardType.REFUGE,
			AbstractCard.CardType.MOVE,
			AbstractCard.CardType.MOVE,
			AbstractCard.CardType.TAX,
			AbstractCard.CardType.TAX,
			AbstractCard.CardType.TAX,
			AbstractCard.CardType.REFUGE,
			AbstractCard.CardType.REFUGE,
			AbstractCard.CardType.REFUGE,
			AbstractCard.CardType.REFUGE,
			AbstractCard.CardType.TAX,
			AbstractCard.CardType.TAX
			
			
			
			
			
	};
	

	
	
}
