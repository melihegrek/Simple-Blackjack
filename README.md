# Simple Blackjack

## Project Overview
**Simple Blackjack** is a Java-based simulation of the classic card game Blackjack. This project focuses on modeling a deck of 52 cards and implementing the basic features needed for Blackjack gameplay. The deck is shuffled and cards are dealt to players, with each card having its own value (according to Blackjack rules). This project serves as a foundation for building a more complex Blackjack game, where players aim to reach a total of 21 points without going over.

## Features
- **Card Creation**: A deck of 52 cards is created with 4 suits (Clubs, Spades, Diamonds, Hearts) and 13 ranks (Ace, 2-10, Jack, Queen, King).
- **Card Values**: Card values are set for Blackjack (Ace = 11, Face Cards = 10, Numeric Cards = Their Value).
- **Deck Shuffling**: The cards are shuffled randomly before the game begins.
- **Card Management**: The ability to retrieve, remove, and shuffle cards in the deck.
- **Card Image Representation**: Each card has a corresponding image file path for visual representation.

## Class Overview

### `Card` Class
Represents a single card in the deck, with the following attributes:
- **suit**: The suit of the card (0 = Clubs, 1 = Spades, 2 = Diamonds, 3 = Hearts).
- **rank**: The rank of the card (1 = Ace, 2-10 for numbered cards, 11 = Jack, 12 = Queen, 13 = King).
- **value**: The value of the card used in the game (11 for Ace, 10 for Face Cards, and the rank value for other cards).

#### Methods:
- `getValue()`: Returns the card's value.
- `getSuit()`: Returns the suit of the card.
- `getRank()`: Returns the rank of the card.
- `SpecialAdress()`: Returns a string representation of the card (e.g., "Ace of Spades").
- `AdressOfImage()`: Returns the file path for the card's image (used for visual representation).

### `Deck` Class
Represents the deck of 52 cards and provides methods to manipulate the deck.

#### Methods:
- `shuffleDeck()`: Shuffles the deck of cards to randomize their order.
- `getCard(int i)`: Returns the ith card in the deck.
- `removeCard(int i)`: Removes and returns the ith card from the deck.

## How It Works
1. **Card Creation**: The deck is created by looping through all 4 suits and 13 ranks. Each card has its value set accordingly (Ace = 11, Face Cards = 10, other cards use their rank as the value).
2. **Shuffling**: The `shuffleDeck()` method uses `Collections.shuffle()` to shuffle the deck for random card order.
3. **Card Representation**: The `SpecialAdress()` and `AdressOfImage()` methods provide string representations and file paths for each card, useful for visual representation in the game.
4. **Card Removal**: Cards can be removed from the deck once they are drawn.

## Example Usage

Here’s an example of how to initialize and interact with the deck:

```java
public class SimpleBlackjack {
    public static void main(String[] args) {
        // Create a new deck of cards
        Deck deck = new Deck();
        
        // Shuffle the deck to randomize the order
        deck.shuffleDeck();
        
        // Draw the top card from the deck
        Card topCard = deck.getCard(0);
        System.out.println("Drawn Card: " + topCard.SpecialAdress());  // Output the card's special address
        
        // Get the file path of the card image
        String cardImagePath = topCard.AdressOfImage();
        System.out.println("Card Image Path: " + cardImagePath);
        
        // Remove the card from the deck after drawing it
        deck.removeCard(0);
    }
}
```

### Expected Output:
```
Drawn Card: Ace of Spades
Card Image Path: C:\Users\melih\OneDrive - Antalya Bilim University\Desktop\cs201jpg\ace_s.jpg
```

## Requirements
- **Java 8** or higher is required to run this project.

## Folder Structure
- `Card.java`: Contains the Card class with attributes and methods for managing a single card.
- `Deck.java`: Contains the Deck class for managing and manipulating the entire card deck.

## License
This project is open-source and free for educational and personal use. Feel free to modify and adapt it for your own Blackjack game.
