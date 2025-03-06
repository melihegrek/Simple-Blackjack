import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BlackJack implements ActionListener {
	
	ArrayList<Card> dealerHand; //this is the arraylist for the dealer's hand.
	ArrayList<Card> playerHand; //this is the arraylist for the player's hand.
	Deck deck ; 
	
	
	int playerscore ;
	int dealerscore ; 
	
	
	JFrame frame;
	
	JLabel background = new JLabel();
	
	JLabel dealerScore = new JLabel("Dealer's Score :"); 
	JLabel playerScore = new JLabel("Player's Score :");
	
	
	JLabel dealer1 = new JLabel(); 
	JLabel dealer2 = new JLabel();
	JLabel dealer3 = new JLabel(); 
	JLabel dealer4 = new JLabel();
	JLabel dealer5 = new JLabel();
	JLabel dealer6 = new JLabel();
	
	JLabel Player1 = new JLabel() ; 
	JLabel Player2 = new JLabel();
	JLabel Player3 = new JLabel();
	JLabel Player4 = new JLabel();
	JLabel Player5 = new JLabel();
	JLabel Player6 = new JLabel();
	
	
	JButton hit = new JButton("HIT");
	JButton stay = new JButton("STAY");
	JButton deal = new JButton("DEAL");
	JButton again = new JButton("PLAY AGAIN");
	
	public BlackJack() {
		
		prepareGUI();
		addComponents();
		addActionEvent();
		enableDeal();
		
	    deck = new Deck();
	    deck.shuffleDeck(); //we randomize the deck.
	    
	    dealerHand = new ArrayList<Card>();
	    playerHand = new ArrayList<Card>();
	    
	  

	}
	
	
    public void prepareGUI() {
    	
        frame = new JFrame();
        frame.setTitle("---Basic BlackJack---");
        frame.setSize(1200,800);
  	  	frame.setLayout(null);
  	  
  	  	frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void addComponents() {
    	
    	
    	
    	dealer1.setBounds(100, 50, 120, 120);
    	frame.add(dealer1);
    	dealer2.setBounds(200, 50, 120, 120);
    	frame.add(dealer2);
    	dealer3.setBounds(300, 50, 120, 120);
    	frame.add(dealer3);
    	dealer4.setBounds(400, 50, 120, 120);
    	frame.add(dealer4);
    	dealer5.setBounds(500,50,120,120);
    	frame.add(dealer5);
    	dealer6.setBounds(600, 50, 120, 120);
    	frame.add(dealer6);
    	
    	Player1.setBounds(50, 300, 100, 120);
    	frame.add(Player1);
    	Player2.setBounds(150, 300, 100, 120);
    	frame.add(Player2);
    	Player3.setBounds(250, 300, 100, 120);
    	frame.add(Player3);
    	Player4.setBounds(350, 300, 100, 120);
    	frame.add(Player4);
    	Player5.setBounds(450,300,100,120);
    	frame.add(Player5);
    	Player6.setBounds(550,300, 100, 120);
    	frame.add(Player6);
    	
    	
        dealerScore.setForeground(Color.black);
        dealerScore.setFont(new Font("BOLD", Font.PLAIN, 25));
        dealerScore.setBounds(100, 200, 200, 30);
        frame.add(dealerScore);
    	
        
        playerScore.setForeground(Color.black);
        playerScore.setFont(new Font("BOLD", Font.PLAIN, 25));
        playerScore.setBounds(100, 500, 200, 30);
        frame.add(playerScore);
        
        hit.setBounds(1000, 200, 150, 70);
    	frame.add(hit);
    	
    	stay.setBounds(1000, 300, 150, 70);
    	frame.add(stay);
    	
    	deal.setBounds(1000, 400, 150, 70);
    	frame.add(deal);
    	
    	again.setBounds(1000, 500, 150, 70);
    	frame.add(again);
    	
    	
    	
    	
    }
    
    public void addActionEvent() {
    	again.addActionListener(this);
        hit.addActionListener(this);
        stay.addActionListener(this);
        deal.addActionListener(this);
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == deal) {
			
			enableStayAndHit();
			
		    for(int i = 0; i<2; i++) { //we add the first two cards on top of the deck to dealer's hand.
		        dealerHand.add(deck.getCard(i));
		      }
		      for(int i = 2; i<4; i++) { //we add the third and fourth card on top of the deck to the player's hand.
		        playerHand.add(deck.getCard(i));
		      }
		      for (int i = 0; i < 4; i++) { //we then remove these cards from the game. This way, we literally 'drew' the cards and those four cards are no longer in the deck.
		        deck.removeCard(0);
		      }
		      
		     //First Card
              Player1.setIcon(new ImageIcon(playerHand.get(0).AdressOfImage()));
             //Second Card
              Player2.setIcon(new ImageIcon(playerHand.get(1).AdressOfImage()));
              
            
              playerScore.setText("Player's Score :" + handValue(playerHand));
              
              //Dealer Cards
              //First Card
              dealer1.setIcon(new ImageIcon(dealerHand.get(0).AdressOfImage()));
              //Second Card
              dealer2.setIcon(new ImageIcon("C:\\Users\\melih\\OneDrive - Antalya Bilim University\\Desktop\\cs201jpg\\back.jpg"));
              dealerscore = dealerHand.get(0).getValue();
              dealerScore.setText("Dealer's Score :" + dealerscore);
              
              checkHand(playerHand, dealerHand);
              

		}
		
		else if (source == hit) {
			
			
			addCard(playerHand);
			
			
			if (playerHand.size()==3) {
                Player3.setIcon(new ImageIcon(playerHand.get(playerHand.size()-1).AdressOfImage()));
                
            } 
			else if (playerHand.size()==4) {
                Player4.setIcon(new ImageIcon(playerHand.get(playerHand.size()-1).AdressOfImage()));
                
            }
			else if (playerHand.size()==5) {
                Player5.setIcon(new ImageIcon(playerHand.get(playerHand.size()-1).AdressOfImage()));  
                
            }
            else if (playerHand.size()==6) {
            	Player6.setIcon(new ImageIcon(playerHand.get(playerHand.size()-1).AdressOfImage()));
            }
			
			checkHand(playerHand, dealerHand);
			playerScore.setText("Player's Score :" + handValue(playerHand));
            	
          
			
			
		}
		else if (source == stay) {
			dealer2.setIcon(new ImageIcon(dealerHand.get(dealerHand.size()-1).AdressOfImage()));
			
	        while (handValue(dealerHand)<17) { //if it is appropraite, the dealer draws a card.   
	        	
	            addCard(dealerHand);
	            
	            if (dealerHand.size()==3) {
	            	
	            	dealer3.setIcon(new ImageIcon(dealerHand.get(dealerHand.size()-1).AdressOfImage()));
	            	dealerScore.setText("Dealer's Score :" + handValue(dealerHand));}
	            	
	            else if (dealerHand.size()==4) {
	            	
	            	dealer4.setIcon(new ImageIcon(dealerHand.get(dealerHand.size()-1).AdressOfImage()));
	            	dealerScore.setText("Dealer's Score :" + handValue(dealerHand));}
	            
	            else if ( dealerHand.size()==5) {
	            	
	            	dealer4.setIcon(new ImageIcon(dealerHand.get(dealerHand.size()-1).AdressOfImage()));
	            	dealerScore.setText("Dealer's Score :" + handValue(dealerHand));}
	            	
	            	
	            	
	            	
	            checkHand(playerHand, dealerHand);
	            dealerScore.setText("Dealer's Score :" + handValue(dealerHand));
	          }
	          if ((handValue(dealerHand)<21) && handValue(playerHand)<21) {//if both hands didn't reach 21, we check which hand is better and print out the result.
	        	  
	            if(handValue(playerHand) > handValue(dealerHand)) {
	              
	              JOptionPane.showMessageDialog(frame, "PLAYER HAS WON BECAUSE OF A BETTER HAND!");
	             
	            }
	            else if  (handValue(playerHand) < handValue(dealerHand)){
	              
	              JOptionPane.showMessageDialog(frame, "DEALER HAS WON BECAUSE OF A BETTER HAND!");
	             
	            }
	            else 
	            	JOptionPane.showMessageDialog(frame, "There is no Winner !!!");
	            	
	          }
	        }
		
		else if ( source==again) {
			
				enableDeal();
			 	Player1.setIcon(null);
	            Player2.setIcon(null);
	            Player3.setIcon(null);
	            Player4.setIcon(null);
	            Player5.setIcon(null);
	            Player6.setIcon(null);
	            dealer1.setIcon(null);
	            dealer2.setIcon(null);
	            dealer3.setIcon(null);
	            dealer4.setIcon(null);
	            dealer5.setIcon(null);
	            dealer6.setIcon(null);
	            
			playerScore.setText("Player's Score : ");
			dealerScore.setText("Dealer's Score : ");
		    dealerHand = new ArrayList<Card>();
		    playerHand = new ArrayList<Card>();
		    deck = new Deck();
		    deck.shuffleDeck(); //we randomize the deck.
		    
            frame.repaint();
            
		}
			
		}
	
	
		
	

	public void enableDeal() {
		
		again.setEnabled(false);
		deal.setEnabled(true);
		hit.setEnabled(false);
		stay.setEnabled(false);
		
		
	}
	public void enableStayAndHit() {
		again.setEnabled(true);
		deal.setEnabled(false);
		hit.setEnabled(true);
		stay.setEnabled(true);
		
	}
	  public void addCard(ArrayList<Card> hand) {//this method adds a card to the hand.
		  
		    hand.add(deck.getCard(0)); //gets a card from the deck to the hand.
		    deck.removeCard(0); //removes the card from the deck.
		   
		  }
	  
	  public void checkHand (ArrayList<Card> playerHand , ArrayList<Card> dealerHand) {//this method literally checks the hand for a blackjack or bust.
		  
		  if ( handValue(playerHand)==21) {
			  JOptionPane.showMessageDialog(null, "PLAYER HAS DONE BLACKJACK! PLAYER HAS WON!"); //we print out the result ot JOptionPane.
			  
		  }
		  else if (handValue(playerHand)>21) {
			  JOptionPane.showMessageDialog(null, "PLAYER HAS BUSTED! DEALER HAS WON!");
		  }
		  else if (handValue(dealerHand)==21) {
			  JOptionPane.showMessageDialog(null, "DEALER HAS DONE BLACKJACK! DEALER HAS WON!");
			  
		  }
		  else if (handValue(dealerHand)>21){
			  JOptionPane.showMessageDialog(null, "DEALER HAS JUST BUSTED! PLAYER HAS WON!");
			  
		  }
	  }


	  
	  
	  public boolean hasAceInHand(ArrayList<Card> hand) {//this method checks if the hand has ace.
	        for (int i = 0; i < hand.size(); i++){ //we go through the hand that is given as a parameter and check for a card with a value of 11(Ace.)
	          if(hand.get(i).getValue() == 11) {
	            return true; //we return true if there is any.
	          }
	        }
	        return false; //we return false if not.
	      }
	    
	    
	    public int handValue(ArrayList<Card> Hand){
	    	int handValue1 = 0 ; 
	        for(int i = 0;i<Hand.size();i++){
	            
	            handValue1 += Hand.get(i).getValue();
	        }
	        if(handValue1>21 && hasAceInHand(Hand)==true){
	            handValue1-=10;
	        }
	        
	        return handValue1;
	        
	    } 

}
