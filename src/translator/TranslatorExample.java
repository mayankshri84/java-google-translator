package translator;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.darkprograms.speech.translator.GoogleTranslate;
import com.google.api.client.http.UrlEncodedContent;

public class TranslatorExample {
	

	
	public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");
	
	public static void main(String i[]){
		String text= "Perustajat alun perin rajoittivat verkkosivuston jäsenyyttä Harvardin opiskelijoille ja myöhemmin Columbialle, Stanfordille ja Yale-opiskelijoille. Jäsenyys laajeni lopulta muille Ivy League kouluille, MIT: lle ja Bostonin korkeakouluille. Facebook lisäsi vähitellen tukea eri yliopistojen opiskelijoille ja lopulta myös lukiolaisille. Vuodesta 2006 lähtien kuka tahansa, joka väittää olevansa vähintään 13-vuotias, on saanut tulla Facebookin rekisteröityksi käyttäjäksi, vaikka tässä vaatimuksessa on vaihteluja paikallisten lakien mukaan. Nimi on peräisin amerikkalaisille yliopisto-opiskelijoille usein annetuista kirjakirjoista. Facebook järjesti ensimmäisen julkisen tarjouksensa (IPO) helmikuussa 2012 ja arvosteli yhtiötä 104 miljardin dollarin arvosta. Se alkoi myydä osakkeita yleisölle kolme kuukautta myöhemmin. Facebook tekee suurimman osan tuloistaan ​​näytöllä näkyvistä mainoksista.";
		new TranslatorExample().translation(text);
		char[] charArray = text.toCharArray();
		List<String> myList = new ArrayList<>();
		String second = "";
		for(int j=0; j<charArray.length;j++){
			
			if(charArray[j]=='.'){
				second = second+charArray[j];
				myList.add(second);
				second = "";
				continue;
			}
			second = second+charArray[j];
		}
		System.out.println(myList);
		StringBuilder str = new StringBuilder();
		for(String s : myList){
			/*byte[] ptext = s.getBytes(ISO_8859_1); 
			String value = new String(ptext, UTF_8); */
			str.append(new TranslatorExample().translation(s)+" ");
		}
		System.out.println(str);
		
	}
	
	
	public String translation(String given){
		String myString = "";
		try{
			myString = GoogleTranslate.translate("en",given);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return myString;
	}
	
}
