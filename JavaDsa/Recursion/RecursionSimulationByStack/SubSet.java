//simulating the advantages given by recursion that is Stack and Stack frames with values called as State to hold 
//then keep on adding stack as reccursive function call until all function gets completed

package RecursionSimulationByStack;

import java.util.ArrayList;
import java.util.Stack;

//creating state class to hold data that a function used to hold

class State{
    int index;
    ArrayList<Integer> list;
    public State(int index,ArrayList<Integer> list){
        this.index=index;
        this.list=list;

    }
}

public class SubSet {
    public static void main(String[] args) {
        //array to find sub set
        int arr[]={1,2,3};

        Stack<State> stack=new Stack<>();
        //adding first state to stack similar to making first function call
        //adding a State to Stack is like calling the function for these value 

        stack.push(new State(0, new ArrayList<>()));
        // this while condition is similar to until the first function call returns 
        while(!stack.isEmpty()){
    
  //this pop is like taking the stack frame from top and start execting that function 
  //its like function execution from stack top
   State cur=stack.pop();

   if(cur.index==arr.length){
    System.out.println(cur.list);
    continue;
    //we are not ending here we end only when stack is empty 
    //this is only a one valid answer , after reaching array end

   }

   
    //including
  //creating and array list from prev state to include curr element
   ArrayList<Integer> include=new ArrayList<>(cur.list);
   include.add(arr[cur.index]);
   stack.push(new State(cur.index + 1, include));//this is the next call

   //excluding
  //creating and array list from prev state to exclude curr element means pass it as same
 ArrayList<Integer> exclude=new ArrayList<>(cur.list);
 stack.push(new State(cur.index + 1, exclude));


 //in actual recursion include supposed to be done first then exclude bcs of order
 // but here it doesnt work like that at a time we add both include and exclude to stack so last added will be executed first
        }
    }
    
}


// just recursion going forward is simulated 
//We are adding all decisions together, but real recursion doesn’t do that. It pauses, goes deep, then comes back and adds the next
// for backtracking and comming back we should not add all decisions in an level together
// for comming backward first go deep in one decision then only go to other
// for simulating real recursion we need to manage where it was pasued and where to continue
// now its completing the function adding all other function that needs to be done and this function work is over




/*in future add "phase" field in State class
 like in which phase it is starting is 0,
 after including is 1 and after excluding is 2
 so based on phase we can add frames to stack
*/