import java.util.ArrayList;

public class Trie {
    private TrieNode root;

    public Trie(){
        this.root=new TrieNode();
    }

    private static class TrieNode{
        private TrieNode[] childrens;
        private boolean endOfWord;
        
        private TrieNode(){
            this.childrens=new TrieNode[26];
        }


    }

    public void insert(String word){
        word=word.toLowerCase();
        TrieNode curNode=this.root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(curNode.childrens[index]==null){
                curNode.childrens[index]=new TrieNode();
            }
            //at end word marking as true
            if(i==word.length()-1){
                curNode.childrens[index].endOfWord=true;
            }
             //moving to next char node which was inserted
            curNode=curNode.childrens[index];


        }

    }

    public boolean search(String word){
        word=word.toLowerCase();
        TrieNode curNode=this.root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(curNode.childrens[index]==null){
                return false;
            }
            //if its last index check if its end word
            if(i==word.length()-1){
                if(curNode.childrens[index].endOfWord==false){
                   return false;
                }

            }
            curNode=curNode.childrens[index];

        }
        //if we complete all chars in word then we found the word
        return true;
    }

    public boolean startsWith(String word){
       word=word.toLowerCase();
        TrieNode curNode=this.root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(curNode.childrens[index]==null){
                return false;
            }
           
            curNode=curNode.childrens[index];

        }
        //if we complete all chars in word then we found the word starts with this word
        return true;
        
    }
    public ArrayList<String> getSuggestions(String word){
        ArrayList<String> suggestions=new ArrayList<>();
        word=word.toLowerCase();
        TrieNode curNode=this.root;
       
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';

            if(curNode.childrens[index]==null){
                return suggestions;
            }

            curNode=curNode.childrens[index];
            


        }
        //now we curNode is in end word
        //we need to collect add possible words from here of all childrens 
        //ill write a helper function to recursively do this
        //all letters word from here

        //if this word itself present add this also 
        
        if(curNode.endOfWord){
            suggestions.add(word);
        }


        for(int i=0;i<26;i++){

        getAllWordsFromHere(curNode.childrens[i], word, i, suggestions);

        }

        return suggestions;

    }
    private  void getAllWordsFromHere(TrieNode node,String prefix,int index,ArrayList<String> words){

         if(node==null){
            return;
         }
          
            char letter=(char) ('a' + index);;
            prefix = prefix + letter;

         if(node.endOfWord==true){
            words.add(prefix);
         }

         for(int i=0;i<26;i++){
         getAllWordsFromHere(node.childrens[i], prefix, i ,words);
         }


    }


    public static void main(String[] args) {

        Trie myTrie=new Trie();
        myTrie.insert("sagar");
         myTrie.insert("sambar");
          myTrie.insert("sage");
           myTrie.insert("sentiment");
            myTrie.insert("danger");
        System.out.println(myTrie.search("sagar"));
        System.out.println(myTrie.search("shaiva"));
        System.out.println(myTrie.startsWith("sag"));
        System.out.println(myTrie.startsWith("gar"));

        System.out.println(myTrie.getSuggestions("s"));
        
    }




    
}
