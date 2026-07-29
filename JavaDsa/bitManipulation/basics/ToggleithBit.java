package basics;
public class ToggleithBit {
    public static void main(String[] args) {
        //to toggele we can make use of xor 
        //if we xor with 1 in that place bcs if its 0 it becomes different and becomes 1 if its 1 it becomes same and 0
        //as others places is 0 xor not changes it // if it was 0 we get 0 only if it was we get 1 only
        int num=13;//1101
        int i=1;
        int toggled1=num ^ (1<<i);
        System.out.println(Integer.toBinaryString(toggled1));

        int toggled2=toggled1 ^ (1<<i);
        System.out.println(Integer.toBinaryString(toggled2));
    }
    
}
