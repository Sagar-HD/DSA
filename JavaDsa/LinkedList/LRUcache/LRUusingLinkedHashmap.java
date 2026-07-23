package LRUcache;

import java.util.LinkedHashMap;


public class LRUusingLinkedHashmap<K,V> extends LinkedHashMap<K,V> {
  
    int capacity;

    public LRUusingLinkedHashmap(int capacity) {
        super(capacity,0.75f,true);
        this.capacity = capacity;

        }
          
 
    public void display(){
       this.forEach((key,value)->System.out.println(key+" : "+value));

    }

    public static void main(String[] args) {
        LRUusingLinkedHashmap<String,Integer> users=new LRUusingLinkedHashmap<>(3);
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
