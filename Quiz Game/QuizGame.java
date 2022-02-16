import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.Container;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.*;

class WillkommenSeite extends JPanel {		// MenÃ¼ Fernster
	JButton Worte, Starten;
	static boolean go  = false ;
	
	WillkommenSeite (JFrame window) {		// Willkommen Seite
		
		// create font
		Font Title  = new Font("DejaVu Serif", Font.BOLD, 20);
		Font Font_Starten = new Font("Serif", Font.BOLD, 20);
		
		//Panel and Window
		setSize(window.getSize().width, window.getSize().height);
		setLayout(null);
		setBackground(Color.DARK_GRAY);
		window.setContentPane(this);
		
		JPanel Pan = new JPanel();
		Pan.setLayout(null);
		Pan.setBorder(BorderFactory.createLineBorder(Color.gray));
		Pan.setBackground(Color.DARK_GRAY);
		window.setContentPane(Pan);
		setLayout(null);
		setBackground(new Color(255, 213, 152));
		setBounds(125/2, 50, 675, 360);
		Pan.add(this);
		
		// Label "herzlich...
		Worte = new JButton("HERZLICH WILLKOMMEN ZUM KENNTNISSE - QUIZ!");
		Worte.setFont(Title); Worte.setForeground(Color.BLACK);
		Worte.setBackground(new Color(255, 161, 161)); //cam 
		Worte.setBounds(125/2, 50, 550, 80);
		add(Worte);
		 
		//Button Starten
		Starten = new JButton("STARTEN");
		Starten.setBackground(new Color(255, 200, 0)); //orange 
		Starten.setBounds(475/2, 200, 200, 50);
		Starten.setFont(Font_Starten);
		add(Starten);
		 
        window.setVisible(true);
	}
		
	void choose_Start () {	// Wie Button Starten funktioniert
		 Starten.addActionListener((ActionEvent e) -> {
             go = true ;
             setVisible(false);
         });
		 
		 while (!go) {
	            try {
	                Thread.sleep(0);
	            } catch (InterruptedException ex) {}
	        }
		 go = false;
	}
}

class Form_Fragen {		// Class Form von Fragen
	String Frage, An1, An2, An3, An4, Res, In4;
	
	Form_Fragen(String F, String A1, String A2, String A3, String A4, String Result, String MehrInfor) {
		this.Frage = F; this.An1 = A1; this.An2 = A2;
		this.An3 = A3; this.An4 = A4; this.Res = Result; this.In4 = MehrInfor;
	}
}

class Question extends JPanel{		//Window of Question
	JLabel F, I;
	JTextArea Quest, Infor;
	JButton Wahl1, Wahl2, Wahl3, Wahl4, Weiter;
	String Answer;
	static int Punkte = 0;
	static boolean next = false, Pass = false;
	
	Question(Form_Fragen Obj, JFrame Window, int Nummer) {		
		//Create Font
		Font Frag  = new Font("DejaVuSans", Font.BOLD, 15);		
		Font Ans = new Font("Serif", Font.BOLD, 15);
		Font font = new Font("BMW1", Font.PLAIN, 15);
		Font font2 = new Font("BMW1", Font.ITALIC, 13);
		Font font3 = new Font("Dialog", Font.BOLD, 15);

		// Set all Button
		F = new JLabel("FRAGE " + Nummer + ": "); 
		I = new JLabel("MEHR INFORMATIONEN:");
		Quest = new JTextArea(Obj.Frage);
		Wahl1 = new JButton (Obj.An1);
		Wahl2 = new JButton (Obj.An2);
		Wahl3 = new JButton (Obj.An3);
		Wahl4 = new JButton (Obj.An4);
		Weiter = new JButton ("Weiter");
		Answer = Obj.Res;
		Infor = new JTextArea(Obj.In4); Infor.setEditable(false);
		
		//Set Informationen of Panel
		JPanel Pan = new JPanel();
		Pan.setLayout(null);
		Pan.setBorder(BorderFactory.createLineBorder(Color.gray));
		Pan.setBackground(Color.DARK_GRAY);
		Window.setContentPane(Pan);
		setLayout(null);
		setBackground(Color.getHSBColor(154, 254, 25));
		setBounds(90, 56, 600, 348);
		setBorder(BorderFactory.createLineBorder(Color.black));
		Pan.add(this);
		
		//Add Button. The "Infor" wil be added later
		add(F); add(Quest); add(Wahl1); add(Wahl2); 
		add(Wahl3); add(Wahl4); add(Weiter); 
		
		// Set Font
		Quest.setFont(font);
		Infor.setFont(font2);
		Quest.setEditable( false );
		F.setFont(Frag);
		I.setFont(Frag);
		Wahl1.setFont(Ans);
		Wahl2.setFont(Ans);
		Wahl3.setFont(Ans);
		Wahl4.setFont(Ans);
		Weiter.setFont(font3);
		
		// Set Bound - Koordination
		Quest.setBounds(90, 8, 440, 48);
		F.setBounds(5, 8, 88, 20);
		Wahl1.setBounds(90, 75, 200, 40); Wahl1.setBackground(new Color(255, 255, 255));
		Wahl2.setBounds(90, 145, 200, 40); Wahl2.setBackground(new Color(255, 255, 255));
		Wahl3.setBounds(330, 75, 200, 40); Wahl3.setBackground(new Color(255, 255, 255));
		Wahl4.setBounds(330, 145, 200, 40); Wahl4.setBackground(new Color(255, 255, 255));
		Weiter.setBounds(512, 300, 80, 40); Weiter.setBackground(new Color(0, 0, 0)); Weiter.setForeground(Color.white);
		Quest.setBackground(new Color(255,242,131));
		
		//set Border
		Quest.setBorder(new LineBorder(Color.green, 2, true));
		Wahl1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED)); 
	    Wahl2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
	    Wahl3.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
	    Wahl4.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
	    Weiter.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
	    	    	 
	    Window.setVisible(true);
	}
	
	void getInformation() {		// Zeig "Mehr Informationen" NAch dem Wahl der Menshcen
		add(I); add(Infor);
		I.setBounds(5, 210, 300, 20);
		Infor.setBounds(90, 240, 440, 80);
		Infor.setBackground(Color.getHSBColor(154, 254, 25));
	}
	
	void Deaktivieren() {	// deactivated
		Wahl1.setEnabled(false);
		Wahl2.setEnabled(false);
		Wahl3.setEnabled(false);
		Wahl4.setEnabled(false);
	}
	
	void getAnswer() throws InterruptedException {
		
		Wahl1.addActionListener((ActionEvent e) -> {	//Wenn man "Answer 1" wÃ¤hlt aus. Ich kann es nicht wie ein Methode abkÃ¼rzen :(
			if(Wahl1.getText().equals(Answer)) {		//Wenn Answer 1 richtig ist
				Punkte++;
				Wahl1.setBackground(Color.GREEN);
			}
			else {
				Wahl1.setBackground(Color.RED);			//Wenn Answer 1 false ist. Set Answer 1 to red background
				//Show the true Answer with Green Background
				if(Wahl4.getText().equals(Answer)) Wahl4.setBackground(Color.GREEN);	
				if(Wahl2.getText().equals(Answer)) Wahl2.setBackground(Color.GREEN);
				if(Wahl3.getText().equals(Answer)) Wahl3.setBackground(Color.GREEN);
			}
			Deaktivieren();			// Man darf nur ein Button einmal drÃ¼cken.
			getInformation();
			next = true;
		});
		
		Wahl2.addActionListener((ActionEvent e) -> {
			if(Wahl2.getText().equals(Answer)) {
				Punkte++;
				Wahl2.setBackground(Color.GREEN);
			}
			else {
				Wahl2.setBackground(Color.RED);
				if(Wahl1.getText().equals(Answer)) Wahl1.setBackground(Color.GREEN);
				if(Wahl4.getText().equals(Answer)) Wahl4.setBackground(Color.GREEN);
				if(Wahl3.getText().equals(Answer)) Wahl3.setBackground(Color.GREEN);
			}
				Deaktivieren();
			getInformation();
			next = true;
		});
		
		Wahl3.addActionListener((ActionEvent e) -> {
			if(Wahl3.getText().equals(Answer)) {
				Punkte++;
				Wahl3.setBackground(Color.GREEN);
			}
			else {
				Wahl3.setBackground(Color.RED);
				if(Wahl1.getText().equals(Answer)) Wahl1.setBackground(Color.GREEN);
				if(Wahl2.getText().equals(Answer)) Wahl2.setBackground(Color.GREEN);
				if(Wahl4.getText().equals(Answer)) Wahl4.setBackground(Color.GREEN);
			}
				Deaktivieren();
			getInformation();
			next = true;
		});
		
		Wahl4.addActionListener((ActionEvent e) -> {
			if(Wahl4.getText().equals(Answer)) {
				Punkte++;
				Wahl4.setBackground(Color.GREEN);
			}
			else  {
				Wahl4.setBackground(Color.RED);
				if(Wahl1.getText().equals(Answer)) Wahl1.setBackground(Color.GREEN);
				if(Wahl2.getText().equals(Answer)) Wahl2.setBackground(Color.GREEN);
				if(Wahl3.getText().equals(Answer)) Wahl3.setBackground(Color.GREEN);
			}
				Deaktivieren();
			getInformation();
			next = true;
		});
		
		Weiter.addActionListener((ActionEvent e) -> {
            Pass = true ;
            //setVisible(false);
        });
		
		while (!Pass) {
	           try {
	               Thread.sleep(0);
	           } catch (InterruptedException e) {}
	    }
		Pass = false;
		
		while (!next) {
            try {        
                Thread.sleep(0);
            } catch (InterruptedException ex) {}
        }
		
		next = false;
	}
	
	int getScore() {return Punkte;}
	void Reset() {
		Punkte = 0;
	}
}

class Score extends JPanel {			//Window von "Punktestand zeigen"
	JButton Nochmal, Raus;
	JLabel ScoreLabel;
	
	static boolean again = false;
	
	Score(JFrame window, int score, int total) {
		Font abc = new Font("Dialog", Font.BOLD, 15);
		setSize(window.getSize().width,window.getSize().height);
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        window.setContentPane(this);
        
        // Nochmal Button
        Nochmal = new JButton("Zurück zum Menü");		
        Nochmal.setBackground(new Color(105, 255, 213));
        Nochmal.setBounds(200, 225, 400, 50);
        Nochmal.setFont(abc);
        add(Nochmal);
        
        // Exit Button
        Raus = new JButton ("Rausgehen!");
        Raus.setBackground(new Color(255, 205, 240));
        Raus.setBounds(300, 325, 200, 50);
        Raus.setFont(abc);
        add(Raus);
        
        // Punkte zeigen Button
        ScoreLabel = new JLabel("Ihr Punktestand: " + score + "/" + total);
        ScoreLabel.setHorizontalAlignment(JLabel.CENTER);
        ScoreLabel.setFont(new Font ("Verdana", Font.BOLD, 30));
        ScoreLabel.setBackground(new Color(181, 225, 255));
        ScoreLabel.setForeground(Color.white);
        ScoreLabel.setBorder(new LineBorder(Color.white, 2, true));
        ScoreLabel.setBounds(100,75,600,100);
        add(ScoreLabel);
        
        window.setVisible(true);
	}
	
	void choose() {
		Nochmal.addActionListener((ActionEvent e) -> {
			again = true;
		});
		
		Raus.addActionListener((ActionEvent e) -> {
			System.exit(0);
		});
		
		while (!again) {
            try {        
                Thread.sleep(0);
            } catch (InterruptedException ex) {}
        }
		again = false;
	}
}

class QuizSpieler {
	int Fragen_Zahl = 3;
	static int Total_Question = 15;
	public QuizSpieler (int Fragen_Zahl, int Total) {
		this.Fragen_Zahl = Fragen_Zahl;
		this.Total_Question = Total;
	}
	
	Form_Fragen[] Biblio = {	//15 Fragen in Bibliothek
			new Form_Fragen(" Welches Land hat die meisten Zeitzonen?", "Frankreich", "Russland", "USA", "Canada", "Frankreich", "Die große Zahl erklärt sich durch die französischen Überseegebiete, \ndie ebenfalls zum Staatsgebiet Frankreichs gehören. Es folgen \ndie USA mit 11 Zeitzonen und Russland mit 9 Zeitzonen."),
			new Form_Fragen(" Wer ist der Autor von „Die drei Musketiere“?", "Willam Shakespeare", "Alexandre Dumas", "Victor Hugo", "Mark Twain", "Alexandre Dumas", "Er war ein franzözischer Schriftsteller und produzierte auch \nWerke wie „Der Graf von Monte Christo“, „Die schwarze Tulpe“,..."),
			new Form_Fragen(" Welcher Fußballverein hat ein Stadion mit dem Spitznamen \n „Theater der Träume“?", "Barcelona", "Bayern München", "Manchester United", "Paris Saint German", "Manchester United", "Old Trafford ist der wirkliche Name des Stadions von Manchester United, \nder größten Mannschaft in England. Dies ist das zweitgrößte Stadion \nin Großbritannien mit 75.000 Sitzplätzen."),
			new Form_Fragen(" Wer wurde mit der Film „Forrest Gump“ mit dem Oscar für den \n besten Hauptdarsteller ausgezeichnet?", "Leonardo DiCaprio", "Tom Hanks", "Joaoquin Phoenix", "Tom Cruise", "Tom Hanks", "Er gehört zu den profiliertesten Charakterdarstellern Hollywoods \nund wurde für seine Hauptrollen in den Filmen Philadelphia (1993) \nauch mit dem Oscar als Bester Hauptdarsteller ausgezeichnet."),
			new Form_Fragen(" Wie heißt die Bombe, die 1945 von den USA auf Nagasaki \n abgeworfen wurde?", "Tsar", "Fat Man", "Little Boy", "Enola Gay", "Fat Man", "Zusammen mit „Little Boy“ wurde die Bombe auf Hiroshima abgeworfen, \nwas indirekt dazu führte, dass sich die Japaner bedingungslos aufgeben \nund den Alliierten dem Sieg im Zweiten Weltkrieg näher kamen."),
			new Form_Fragen(" Kann man die Chinesische Mauer mit bloßem Auge vom Mond \n aus sehen?", "Ja", "Nur im Winter", "Nein", "Nur im Sommer", "Nein", "Dies ist ein Missverständnis vieler Menschen. \nEs ist, als würde man ein Haar in 3 km Entfernung betrachten."),
			new Form_Fragen(" Wer ist der einzige Tennisspieler, der dreimal \n Grand-Slam-Titel in einer Saison gewann?", "Roger Federer", "Novak Djokovic", "Rafael Nadal", "Andy Murray", "Roger Federer", "Er ist ein Schweizer Tennisspieler. Mit insgesamt 310 Wochen, davon \ndie Rekordzahl von 237 Wochen in Serie, führte Federer die \nWeltrangliste bislang am längsten an."),
			new Form_Fragen(" Wer unten ist, ist 1 von 2 einzigen Menschen, die \n Nobelpreise auf zwei unterschiedlichen Fachgebieten erhielt?", "Stephen Hawking", "Nikola Tesla", "Marie Curie", "Albert Einstein", "Marie Curie", "Sie war eine franzözische Physikerin und Chemikerin mit polnischer \nHerkunft. Sie gewann 1903 den Physikpreis für die Entdeckung der \nRadioaktivität und 1911 den Nobelpreis für Chemie für die Entdeckung \nzweier chemischer Elemente, Polonium und Radium."),
			new Form_Fragen(" Wer ist der Vater der Psychoanalyse?", "Carl Gustav Jung", "Louis Pasteur", "Hannibal Lector", "Sigmund Freud", "Sigmund Freud","Er war ein österreichischer Arzt, Neurophysiologe, Tiefenpsychologe, \nKulturtheoretiker und Religionskritiker. Er ist Vater des umstrittenen \nÖdipuskomplex und Pionier bei der Entschlüsselung von Träumen."),
			new Form_Fragen(" Welche Planet ist der heisste Planet unseres Sonnensystems?", "Sonne", "Venus", "Merkur", "Mars", "Venus", "Auf der Venus herrschen höllische Temperatur von \nknapp 500 Grad Celsius – und die „Luft“ auf der Venus ist \ngar keine: Sie besteht hauptsächlich aus giftigem Kohlendioxid."), 
			new Form_Fragen(" Wer hat Microsoft zusammen mit Bill Gates gegründet?", "Steve Jobs", "Paul Allen", "Steve Ballmer", "Mary Gates", "Paul Allen", "Zusammen mit Bill Gates gründete er das Softwareunternehmen \nMicrosoft und war mit ihm von 1975 bis 1983 im Vorstand. Laut Forbes \nwar er 2015 der 51. unter den reichsten Menschen der Welt mit einem \nVermögen von 17,5 Milliarden US-Dollar."),
			new Form_Fragen(" Wo ist Sagrada Família?", "Madrid", "Lisabon", "Sagres", "Barcelona", "Barcelona", "Die Sagrada Família, der „Sühnetempel der Heiligen Familie“, ist das \nletzte Werk von Antoni Gaudí und eine einzigartige Sehenswürdigkeit in \nBarcelona, die nach ihrer Fertigstellung die höchste Kirche der Welt \nsein wird. Es handelt sich um Gaudís bedeutendstes Meisterwerk." ),
			new Form_Fragen(" Wer ist der Auto des Bildes „Das Mädchen mit dem \nPerlenohrgehänge“?", "Jan Vermeer", "Van Gogh", "Leonardo da Vinci", "Pablo Picasso", "Jan Vermeer", "Mädchen mit Perlenohrgehänge, Ölgemälde auf Leinwand (um 1665) \ndes niederländischen Künstlers Jan Vermeer (Johhannes Vermeer), \neines seiner bekanntesten Werke."),
			new Form_Fragen(" In welchem ​​Jahr begann der Erste Weltkrieg?", "1912", "1918", "1916", "1914", "1914", "Der Erste Weltkrieg wurde von 1914 bis 1918 in Europa, im Nahen Osten, \nin Afrika, Ostasien und auf den Ozeanen geführt. Etwa 18 Millionen \nMenschen verloren durch ihn ihr Leben. Er begann am 28. Juli 1914 mit \nder Kriegserklärung Österreich-Ungarns an Serbien." ),
			new Form_Fragen(" Wer war der einzige US-Präsident, der zurücktrat?", "Richard Nixon", "Warren Harding", "Andrew Johnson", "Franklin Pierce", "Richard Nixon", "Er war von 1969 bis 1974 der 37. Präsident der Vereinigten Staaten. \nInfolge der Watergate-Affäre trat Nixon als bisher einziger \nUS-Präsident der Geschichte von seinem Amt zurück." )
	};
	
	public void Start() {
		JFrame Window = new JFrame ("Quiz Game");	//Frame
		Window.setSize(800, 500);
		Window.setLocationRelativeTo(null);
		Window.setVisible(true);
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window.setResizable(false);
		
		while (true) {	// "Wenn man nochmal spielen mÃ¶chte. Wenn nicht, drÃ¼ckt man "Rausgehen
		
			WillkommenSeite welcome = new WillkommenSeite (Window);
			welcome.choose_Start();
			
			int [] ID_Fragen = 
			new int [Fragen_Zahl];
			ID_Fragen = Fragen_waehlen(Fragen_Zahl);
			
			Form_Fragen [] NewQuiz = new Form_Fragen[Fragen_Zahl];		//Fragen wÃ¤hlen mit der Reihenfolgen oberer Liste
			for(int i = 0; i < Fragen_Zahl; ++i) 
				NewQuiz[i] = Biblio[ID_Fragen[i] - 1];
			
			int cnt = 0, Punkt = 0;
			while(cnt < NewQuiz.length) {
				Question Person1 = new Question(NewQuiz[cnt], Window, cnt + 1);		//Frage ausgeben
				try {
					Person1.getAnswer();					//Check the answer
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Punkt = Person1.getScore();					//Score jeder Frage
				if(cnt == NewQuiz.length - 1) Person1.Reset();	//Reset Point = 0 for "nochmal" Spiele
				cnt++;				
			}		
			Score score1 = new Score (Window, Punkt, NewQuiz.length);	//Print the answer
			score1.choose();
		}
	}
	
	public static int [] Fragen_waehlen(int F_Zahl) {  //My Random Methode.
		int Random[] = new int[F_Zahl];
		
		List<Integer> solution = new ArrayList<>();
		for (int i = 1; i <= Total_Question; i++) 
		    solution.add(i);	
		Collections.shuffle(solution);
		
		for(int i = 0; i < F_Zahl; ++i)
			Random[i] = solution.get(i);
		return Random;
		/*
		 * Wenn man normale Random-Methdode benutzen, es kann Unendlichkeit fÃ¼hren, 
		 * um x unterschiedliche Fragen zu herstellen.
		 * Ich benutze eine List, und "shuffle" dieser List in beliebigen Reihenfolgen.
		 */
	}
}

public class QuizGame {
	public static void main(String[] args) throws InterruptedException {
		QuizSpieler Los = new QuizSpieler(3, 15);
		Los.Start();
	}
}