package Basic;

public class NextLetterInSorted {
    static Character getNextLetter(Character[] letters,Character letter){
        int start=0;
        int end=letters.length-1;
        Character nextLetter='#';
        while(start<=end){
            int mid=start+(end-start)/2;
            if(letters[mid]==letter){
                start=mid+1;
            }
            else if(letters[mid]<letter){
                start=mid+1;


            }
            else{
                nextLetter=letters[mid];
                end=mid-1;
            }

        }
        return nextLetter;
    }
    public static void main(String[] args) {
        Character[] letters={'a','c','f','g','h'};
        System.out.println(getNextLetter(letters, 'g'));
    }
    
}
