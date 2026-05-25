package Other;
/*
The Receipt Validator

A cashier gives you a receipt as a string of digits.

Each receipt can be interpreted using these rules:

You can split the string into chunks of 1 digit or 2 digits
Each chunk must represent a number between 1 and 26
'0' cannot be used alone (invalid)
👉 Task

Return the total number of valid ways to interpret the receipt.

🧪 Example

Input: "121"

Valid interpretations:

1 2 1 → A B C
12 1 → L A
1 21 → A U

Output: 3


*/
public class TheReceiptValidator {
    static void validRecipt(String input,String output){
        if(input.isEmpty()){
            System.out.println(output);
            return;
        }
         char decoded;
        if(input.length()>=2){
           int num= Integer.parseInt(input.substring(0,2));
           if(num>=10 && num<=26){
           decoded = (char) ('A' + num - 1);
            validRecipt(input.substring(2), output+decoded);
           }
        }

        int num= input.charAt(0)-'0';
        if(num!=0){
         decoded = (char) ('A' + num - 1);
        
          validRecipt(input.substring(1), output+decoded);
        }

    }
    public static void main(String[] args) {
        String input="121";
        validRecipt(input, "");
    }
}
