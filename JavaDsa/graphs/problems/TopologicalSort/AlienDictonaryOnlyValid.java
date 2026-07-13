package graphs.problems.TopologicalSort;

import java.util.ArrayList;

import java.util.Collections;

/**
 * AlienDictonaryOnlyValid
 */

public class AlienDictonaryOnlyValid {
    static ArrayList<Integer> getAlphabetsOrder(String[] dictonary, int k) {
        ArrayList<Integer> alphabets = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int index = 0; index < dictonary.length - 1; index++) {
            String str1 = dictonary[index];
            String str2 = dictonary[index + 1];
            int minlen = Math.min(str1.length(), str2.length());

            // comparing 2 pairs and finding the letter which caused this order in dictonary
            // the first different letters we get from both string are in order str1's comes
            // before str2's
            for (int i = 0; i < minlen; i++) {
                if (str1.charAt(i) != str2.charAt(i)) {

                    adjList.get(str1.charAt(i) - 'a').add(str2.charAt(i) - 'a');
                    break;
                }

            }

        }
        // now i want to return the alphabets from graph in topo order i can use dfs or
        // bfs with khan
        boolean[] visited = new boolean[26];

        boolean[] present = new boolean[26];
        // marking which are letters are available in dict so that we dont ordering for
        // which doesnt exists
        for (String word : dictonary) {
            for (char ch : word.toCharArray()) {
                present[ch - 'a'] = true;
            }
        }
        // this loop bcs we need all connected components in graph
        for (int node = 0; node < 26; node++) {
            if (!visited[node] && present[node]) {
                getTopoOrder(adjList, alphabets, visited, node, present);
            }
        }
        // we got reverse topo from dfs so reverse before retuning
        Collections.reverse(alphabets);

        return alphabets;
    }

    static void getTopoOrder(ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> topo, boolean[] visited,
            int source, boolean[] present) {
        visited[source] = true;
        for (int neigbhour : adjList.get(source)) {
            //checking neigbour is present or not is not actually needed bcs i onlt add present alphabets in graph
            if (!visited[neigbhour] && present[neigbhour]) {
                getTopoOrder(adjList, topo, visited, neigbhour, present);
            }
        }

        topo.add(source);

    }

    public static void main(String[] args) {
        String[] dictonary = { "wrt", "wrf", "er", "ett", "rftt" };
        int k = 5;
        ArrayList<Integer> alphabets = getAlphabetsOrder(dictonary, k);
        for (int alphabet : alphabets) {
            System.out.print((char) (alphabet + 'a'));
        }
    }
}