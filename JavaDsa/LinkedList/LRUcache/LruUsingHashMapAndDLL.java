package LRUcache;

import java.util.HashMap;

public class LruUsingHashMapAndDLL<K,V>{

    private HashMap<K,DLL<K,V>> map=new HashMap<>();

    private DLL<K,V> head=new DLL<>(null, null);
    private DLL<K,V> tail=new DLL<>(null, null);
    private int capacity;
    

    public LruUsingHashMapAndDLL(int capacity) {
        this.capacity=capacity;
        this.head.next=tail;
        this.tail.prev=head;
    }



    public void put(K key,V value){
        if(map.containsKey(key)){
          //IF EXIST JUST REPLACE VALUE
            DLL<K,V> node=map.get(key);
            node.value=value;
            moveToFront(node);

        }
        else{
             DLL<K,V> newNode=new DLL<>(key, value);
            //if we have left capacity
            if(map.size()<capacity){
               
                insertAfterHead(newNode);
              
              

            }
            else{
                // if no capacity remove from end and insert after head
                //remove least recently used which is before tail
                map.remove(tail.prev.key);
                delete(tail.prev);
                insertAfterHead(newNode);
            
            }
              map.put(key, newNode);

        }


    }
    public V get(K key){
        if(!map.containsKey(key)){
            return null;

        }
        else{
            DLL<K,V> node=map.get(key);
          
           moveToFront(node);
           return node.value;
        }
    }
    public void insertAfterHead(DLL<K,V> node){
        //adding after head 

        DLL<K,V> next=head.next;
        this.head.next=node;
        node.prev=head;
        node.next=next;
        next.prev=node;
      



    }
    public void display(){
        DLL<K,V> start=head.next;
        while(start!=tail){
         System.out.println(start.key+" : "+start.value);
         start=start.next;
        }
    }

    public void delete(DLL<K,V> node){
        //replacing pointer to delink the node garbage collector will clear it 

         DLL<K,V> prev=node.prev;
          DLL<K,V> next=node.next;

          prev.next=next;
          next.prev=prev;
          

    }
   private void moveToFront(DLL<K,V> node) {
    delete(node);
    insertAfterHead(node);
}



    private static class DLL <K,V>{
        private K key;
        private V value;
        private DLL<K,V> prev;
        private DLL<K,V> next;

        public DLL(K key, V value) {
            this.key = key;
            this.value = value;
        }

       
        
        

    }

    public static void main(String[] args) {
        LruUsingHashMapAndDLL<String,Integer> users=new LruUsingHashMapAndDLL<>(3);
        users.put("Sagar", 18);
           users.display();
        users.put("Basavaraju", 78);
      
        users.put("Hemavathi", 68);
        users.display();
        System.out.println(users.get("Basavaraju"));
        users.display();
        users.put("Rocky",9);
        users.display();

    }
    
}
