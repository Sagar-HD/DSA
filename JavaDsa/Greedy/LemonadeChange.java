package Greedy;


public class LemonadeChange {
    public static void main(String[] args) {
      int[] customerMoney={5,5,10,10,20};
      int five=0,ten=0, twenty=0;
      for(int money: customerMoney){
        if(money==5){
          
          five++;
        }
        else if(money==10){
          if(five>0){
            ten++;
            five--;
          }
          else{
            System.out.println("false");
            return;
          }
        }
        else{
          if(ten>0&&five>0){
            twenty++;
            ten--;
            five--;
          }
          else if(five>=3){
            twenty++;
            five-=3;
          }
          else{
            System.out.println("false");
            return;
          }
        }
          
        }
      
      System.out.println("true");
    }
}