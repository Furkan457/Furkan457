import java.util.Random;

public class Lab5_Q2 {
    public static void main(String[] args) {
        Random rand = new Random() ;
        String cardDeck = "123456789TJQK" ;
        String playDeck = "" ;
        String firstPlayer = "" ;
        String secondPlayer = "" ;
        boolean isFinish = false ;
        int h = 0 ;

        int count = -1 ;
        System.out.println("Starting the game with the following deck: ");
        
        for(int i = 0; i < 13 ; i++)
        {
            count++ ;
            for(int j = 0 ; j < 4 ; j++)
            {
                if(cardDeck.charAt(count) == 'K')
                {
                    if(j == 0)
                    {
                        j++ ; 
                    }
                    playDeck += cardDeck.charAt(count) ;
                }
                else
                {
                playDeck += cardDeck.charAt(count) ; 
                }           
            }
        }
        System.out.println(playDeck + "\n");
        
        for(int a = 2 ; a < 53 ; a++)
        {   
            int stringLength = playDeck.length() ;
            if(a % 2 == 0)
            {
                int randomChoice = rand.nextInt(stringLength) ;
                String charToString = Character.toString(playDeck.charAt(randomChoice)) ;
                firstPlayer += playDeck.charAt(randomChoice) ;
                playDeck = playDeck.replaceFirst(charToString, "") ;
            }
            else
            {     
                int randomChoice = rand.nextInt(stringLength) ;
                String charToString = Character.toString(playDeck.charAt(randomChoice)) ;
                secondPlayer += playDeck.charAt(randomChoice) ;
                playDeck = playDeck.replaceFirst(charToString, "") ;   
            } 
        }
        System.out.println("Initial cards are dealing...");
        System.out.println(firstPlayer);
        System.out.println(secondPlayer + "\n");

        System.out.println("Pairs are removed:");
        for(int q = 0 ; q < firstPlayer.length() - 1 ; q++)
        {   
            int w = q + 1 ;
            for(w = q + 1 ; w < firstPlayer.length()  ; w++)
            {           
                    if(firstPlayer.charAt(q) == firstPlayer.charAt(w))
                    {
                    String charToString2 = Character.toString(firstPlayer.charAt(q)) ;
                    String charToString3 = Character.toString(firstPlayer.charAt(w)) ;
                    firstPlayer = firstPlayer.replaceFirst(charToString2, "") ;
                    firstPlayer = firstPlayer.replaceFirst(charToString3, "") ;
                    q--  ;
                    w = 100000 ;
                    }      
            }
        }        
        System.out.println("Player-1 hand: " + firstPlayer);
        
        for(int q = 0 ; q < secondPlayer.length() - 1 ; q++)
        {   int w = q + 1 ;
            for(w = q+1 ; w < secondPlayer.length()  ; w++)
            {
                    if(secondPlayer.charAt(q) == secondPlayer.charAt(w))
                    {
                    String charToString2 = Character.toString(secondPlayer.charAt(q)) ;
                    String charToString3 = Character.toString(secondPlayer.charAt(w)) ;
                    secondPlayer = secondPlayer.replaceFirst(charToString2, "") ;
                    secondPlayer = secondPlayer.replaceFirst(charToString3, "") ;
                    q--  ;
                    w = 100000 ;
                     }
            }
        }        
        System.out.println("Player-2 hand: " + secondPlayer + "\n");

    do{ 
        if(h % 2 == 1)
        {
        int randomCard = rand.nextInt(secondPlayer.length()) ;
        String drawingCard = secondPlayer.substring(randomCard, randomCard + 1) ;
        secondPlayer = secondPlayer.replace(drawingCard, "") ;
        firstPlayer = firstPlayer + drawingCard ;

        System.out.println("Start drawing...");
        System.out.println("Player-1 is drawing the card: " + drawingCard + " from Player-2...");
        System.out.println("\t Player-1 hand: " + firstPlayer);
        System.out.println("\t Player-2 hand: " + secondPlayer);
        System.out.println();
        h++ ;
        }
        else
        {
            int randomCard = rand.nextInt(firstPlayer.length()) ;
            String drawingCard = firstPlayer.substring(randomCard, randomCard + 1) ;
            firstPlayer = firstPlayer.replace(drawingCard, "") ;
            secondPlayer = secondPlayer + drawingCard ;
    
            System.out.println("Start drawing...");
            System.out.println("Player-2 is drawing the card: " + drawingCard + " from Player-1...");
            System.out.println("\t Player-1 hand: " + firstPlayer);
            System.out.println("\t Player-2 hand: " + secondPlayer);
            System.out.println();
            h++ ;
        }

        System.out.println("Pairs are removed:");
        for(int q = 0 ; q < firstPlayer.length() - 1 ; q++)
        {   
            int w = q + 1 ;
            for(w = q + 1 ; w < firstPlayer.length()  ; w++)
            {    
                    if(firstPlayer.charAt(q) == firstPlayer.charAt(w))
                    {
                    String charToString2 = Character.toString(firstPlayer.charAt(q)) ;
                    String charToString3 = Character.toString(firstPlayer.charAt(w)) ;
                    firstPlayer = firstPlayer.replaceFirst(charToString2, "") ;
                    firstPlayer = firstPlayer.replaceFirst(charToString3, "") ;
                    q--  ;
                    w = 100000 ;
                    }        
            }
        }        
        System.out.println("Player-1 hand: " + firstPlayer);
        
        for(int q = 0 ; q < secondPlayer.length() - 1 ; q++)
        {   int w = q + 1 ;
            for(w = q+1 ; w < secondPlayer.length()  ; w++)
            {
                    if(secondPlayer.charAt(q) == secondPlayer.charAt(w))
                    {
                    String charToString2 = Character.toString(secondPlayer.charAt(q)) ;
                    String charToString3 = Character.toString(secondPlayer.charAt(w)) ;
                    secondPlayer = secondPlayer.replaceFirst(charToString2, "") ;
                    secondPlayer = secondPlayer.replaceFirst(charToString3, "") ;
                    q--  ;
                    w = 100000 ;
                     }
            }
        }        
        System.out.println("Player-2 hand: " + secondPlayer + "\n");

        if(secondPlayer == "" || firstPlayer == "")
        {
            isFinish = true ;
        }
        
    }while(!isFinish) ;

    System.out.println("Game Over!");

        if(firstPlayer == "")
        {
            System.out.println("Player-1 Wins! ");
        }
        else
        {
            System.out.println("Player-2 Wins ");
        }
        System.out.println("\t Player-1 hand: " + firstPlayer);
        System.out.println("\t Player-2 hand: " + secondPlayer);
     }
}
