package DisjointSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * MergeAccounts1
 */

public class MergeAccounts {
    //this method by considering account as nodes 
    static ArrayList<ArrayList<String>> getMergedByAccountAsNode( String[][] accounts){
        DisjointSet dsj=new DisjointSet(accounts.length);
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<accounts.length;i++){
            for(int j=1;j<accounts[i].length;j++){
                String mail=accounts[i][j];
                if(!map.containsKey(mail)){
                    map.put(mail,i);
                }
                else{
                    dsj.unionBySize(map.get(mail), i);
                }

            }
        }


     ArrayList<ArrayList<String>>  mergedMail=new ArrayList<>();
     for(int i=0;i<accounts.length;i++){
        mergedMail.add(new ArrayList<>());
     }
     

      for(Map.Entry<String,Integer> entry : map.entrySet()){
        String mail=entry.getKey();
        int node=entry.getValue();
        int ulimateParent=dsj.getUltimateParent(node);
        mergedMail.get(ulimateParent).add(mail);


      }
         ArrayList<ArrayList<String>>  ans=new ArrayList<>();
     for(int i=0;i<mergedMail.size();i++){
        if(mergedMail.get(i).size()!=0){
           ArrayList<String> mails=mergedMail.get(i);
           mails.sort((mail1,mail2)->mail1.compareToIgnoreCase(mail2));
           mails.add(0,accounts[i][0]);
           ans.add(mails);

        }
     }

     return ans;
    }


    //this method considers email as nodes
     static List<ArrayList<String>> getMergedByEmailAsNode(String[][] accounts){
        HashMap<String,Integer> mailToId=new HashMap<>();
        HashMap<String,String> mailToName=new HashMap<>();
        int id=0;
          for(int i=0;i<accounts.length;i++){
            for(int j=1;j<accounts[i].length;j++){
                String mail=accounts[i][j];
                if(!mailToId.containsKey(mail)){
                    mailToId.put(mail,id);
                    id++;
                    mailToName.put(mail, accounts[i][0]);
                }

            }
        }
        DisjointSet dsj=new DisjointSet(mailToId.size());
          for(int i=0;i<accounts.length;i++){
            for(int j=2;j<accounts[i].length;j++){
                String mail=accounts[i][j];
                int mailId=mailToId.get(mail);
                int prevMailId=mailToId.get(accounts[i][j-1]);
                
                    dsj.unionBySize(mailId, prevMailId);
                
                
                

            }
        }
        List<ArrayList<String>> ans=new ArrayList<>();
        for(int i=0;i<mailToId.size();i++){
            ans.add(new ArrayList<>());
        }

         for(Map.Entry<String,Integer> entry : mailToId.entrySet()){
                String mail=entry.getKey();
                int ultimateParent=dsj.getUltimateParent(mailToId.get(mail));
                ans.get(ultimateParent).add(mail);

         }
         ans= ans.stream().filter((mails)->mails.size()>0)
          .map((mails)->{ 
            mails.add(0,mailToName.get(mails.get(0))); return mails;
        }).collect(Collectors.toList());
        return ans;




        


     }
    public static void main(String[] args) {
        String[][] accounts = {
    {"John", "johnsmith@mail.com", "john_newyork@mail.com"},
    {"John", "johnsmith@mail.com", "john00@mail.com"},
    {"Mary", "mary@mail.com"},
    {"John", "johnnybravo@mail.com"},
    {"John", "john00@mail.com", "johnny00@mail.com"},
    {"Mary", "mary@mail.com", "mary_work@mail.com"}
    };

  List<ArrayList<String>>  ans=getMergedByAccountAsNode(accounts);
 for(ArrayList<String> account:ans){
    System.out.println(account);
 }
List<ArrayList<String>>  ans2=getMergedByEmailAsNode(accounts);
 for(ArrayList<String> account:ans2){
    System.out.println(account);
 }

    }

    
}