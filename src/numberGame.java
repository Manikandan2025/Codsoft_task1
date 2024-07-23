import java.util.*;


public class numberGame {

    public static void play_game() throws InterruptedException{
        int round=1;
        boolean lose=false;
        Random random = new Random();
        Scanner scan=new Scanner(System.in);
        int no_of_round=5;

        while(no_of_round>=round){
            int attempts=0;
            int chances=5;
            int min_val=1 , max_val=100;
            int randomNumber = random.nextInt(101);

            Thread.sleep(1000);
            System.out.println("round:"+round);
            Thread.sleep(1000);
            System.out.println("Guess the Number between ( 1 to 100 )");
            Thread.sleep(1000);
            
           
            while(true){
            Thread.sleep(1000);
            System.out.printf("\nyou have %d chances\n",chances);
            Thread.sleep(1000);
            System.out.println("Enter the guessed number :");
            int guess=scan.nextInt();
            Thread.sleep(1000);
            if(guess<=min_val || guess>=max_val){
               System.out.printf("Invalid Enter the Number between %d and %d\n",min_val,max_val);
               
            }
            else if(guess==randomNumber){
             

                int score =cal_score(attempts) ;
               
                round++;
                
                System.out.printf("Correct! You've guessed the number in %d attempts.\n", chances);
                System.out.printf("Your score is: %d \n", score);
                break;
            }
            else if(guess>randomNumber){
                max_val=guess;
                System.out.printf("the guessed number  is high the number is between %d and %d\n",min_val,max_val);
                attempts+=1;
                chances-=1;
            }
            else{
                min_val=guess;
                System.out.printf("the guessed number is low the number is betwen %d and %d\n",min_val,max_val);
                attempts+=1;
                chances-=1;

            }  

            if(chances==0){
                System.out.println("you lose ");
                System.out.println("the number is :"+randomNumber );
                lose=true;
                break;
               }
           }
         
           if(lose){
            break;
           }
            }

    }
    public static int cal_score(int attempts){
        int baseScore = 100;
        int score = baseScore - (attempts * 20) ;

        return Math.max(score, 0);
    }

    public static void main(String[] args) throws InterruptedException{
    Scanner scan=new Scanner(System.in);
    String name;

    System.out.println("\n----------------------NUMBER GUESSING GAME----------------------\n");
    Thread.sleep(1000);

    System.out.println("Enter your Name");
    name= scan.nextLine();

    Thread.sleep(1000);
    System.out.printf("Hi %s Welcome to the Number game\n\n",name);
    Thread.sleep(1000);

  

    System.out.printf("About Game: there are totally %d rounds in each round there are totally 5 attempts win to enter next round\n",5);
    Thread.sleep(1000);
    boolean playAgain;
    do {
        play_game();
        System.out.print("Do you want to play again? (yes/no): ");
        playAgain = scan.next().equalsIgnoreCase("yes");
    } while (playAgain);
    scan.close();
}
}
