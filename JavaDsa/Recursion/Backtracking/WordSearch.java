package Backtracking;

public class WordSearch {
    static boolean exist(char[][] board,String word){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                boolean[][] visited=new boolean[board.length][board[0].length];
                if(search(board,i,j,0,word,"",visited)){
                    return true;
                }
            }
        }
        System.out.println("no possibilty matched");
        return false;

    }
    static boolean search(char[][] board,int row,int col,int index,String word,String ans,boolean[][] visited){
    
        if(!isValid(board, row, col,visited)){
          //  System.out.println("reached wall or already visited");
           return false;
        }
        if(board[row][col]!=word.charAt(index)){
          //  System.out.println("char mismatch");
            return false;
        }

        //adding here after character is matched 

        ans=ans+board[row][col];



        if(index==word.length()-1){

           System.out.println(ans);
            return true;
        
        }


 visited[row][col]=true;     
boolean right=search(board, row, col+1,index+1, word, ans,visited);
boolean  down= search(board, row+1, col,index+1, word, ans,visited);
 boolean left= search(board, row, col-1,index+1, word, ans,visited);
 boolean up=search(board, row-1, col,index+1, word, ans,visited);
visited[row][col]=false;
 return (right||down||left||up);

     

    }
    static boolean isValid(char[][] board,int row,int col,boolean[][] visited){
        if(row<0 || col<0 || row>=board.length || col >=board[0].length || visited[row][col]){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };

        String word1 = "ABCCED"; 
        String word2 = "SEE";    
        String word3 = "ABCB";   

        System.out.println(exist(board, word1));
        System.out.println(exist(board, word2));
        System.out.println(exist(board, word3));
    }
    
}
