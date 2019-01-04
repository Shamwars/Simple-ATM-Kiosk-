// slightly revised for video kiosk - revised

class Account {
       private int balance = 100;

       public boolean debit(int a) {
              if((balance-a) >= 0) {
                     balance = balance -a;
                     return true;//debit successful
              }
              else {
                     return false;//insufficient funds
              }
       }

       public int getBalance() {
              return  balance;
       }
}