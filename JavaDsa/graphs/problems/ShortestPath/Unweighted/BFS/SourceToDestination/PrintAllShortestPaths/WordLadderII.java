package graphs.problems.ShortestPath.Unweighted.BFS.SourceToDestination.PrintAllShortestPaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//problem is explained deeply in below comments
public class WordLadderII {

    public static ArrayList<String> getNeighbours(String word, HashSet<String> wordList) {
        ArrayList<String> neighbours = new ArrayList<>();
        int len = word.length();

        StringBuilder sb = new StringBuilder("");
        sb.append(word);
        for (int i = 0; i < len; i++) {

            for (int j = 0; j < 26; j++) {

                char ch = (char) (j + 'a');
                sb.setCharAt(i, ch);

                if (wordList.contains(sb.toString())) {

                    neighbours.add(sb.toString());

                }
                sb.setLength(0);
                sb.append(word);
            }

        }
        return neighbours;

    }

    public static ArrayList<ArrayList<String>> getAllShortestLadder(String beginWord, String endWord,
            List<String> wordList) {
        HashSet<String> wordListSet = new HashSet<>(wordList);
        Queue<ArrayList<String>> q = new LinkedList<>();

        ArrayList<ArrayList<String>> allShortestLadders = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        words.add(beginWord);

        q.offer(new ArrayList<>(words));

        if (wordListSet.contains(beginWord)) {
            wordListSet.remove(beginWord);
        }

        while (!q.isEmpty()) {
            int size = q.size();
            HashSet<String> usedThisLevel = new HashSet<>();
            boolean found = false;
            for (int i = 0; i < size; i++) {
                ArrayList<String> path = q.poll();
                String cur = path.get(path.size() - 1);

                if (cur.equals(endWord)) {
                    allShortestLadders.add(path);
                    found = true;
                    continue;
                }
                for (String neighbour : getNeighbours(cur, wordListSet)) {
                  
                        usedThisLevel.add(neighbour);
                        ArrayList<String> thisPath = new ArrayList<>(path);
                        thisPath.add(neighbour);
                        q.offer(thisPath);
                    

                }

            }
            if (found) {
                return allShortestLadders;
            }
            for (String usedWord : usedThisLevel) {
                wordListSet.remove(usedWord);
            }

        }
        return allShortestLadders;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String[] wordArray = { "hot", "dot", "dog", "lot", "log", "cog" };
        String endWord = "cog";
        List<String> wordList = Arrays.asList(wordArray);
        ArrayList<ArrayList<String>> paths = getAllShortestLadder(beginWord, endWord, wordList);
        for (ArrayList<String> path : paths) {
            System.out.println(path);
        }

    }

}

/*
 * ---------------------------- WORD LADDER II --------------------------------
 *
 * Goal:
 * Find ALL shortest transformation sequences from beginWord to endWord.
 *
 * ============================================================================
 * FIRST PRINCIPLE
 * ============================================================================
 *
 * Whenever multiple paths meet at the same node, ask only ONE question:
 *
 *      "Can I forget HOW I reached this node?"
 *
 * If YES  -> Merge all paths into ONE state.
 *            (BFS / DP)
 *
 * If NO   -> Keep paths separate.
 *            (DFS / Backtracking or store complete paths)
 *
 *
 * ============================================================================
 * THE BIGGEST MISTAKE ABOUT "visited"
 * ============================================================================
 *
 * I used to think:
 *
 *      visited means
 *      "I have already visited this node."
 *
 * That's NOT the real meaning.
 *
 * visited actually means:
 *
 *      "From now on,
 *       revisiting this node cannot give me
 *       any NEW information for this problem."
 *
 * So always ask:
 *
 *      Can another visit improve my answer?
 *
 * NO
 *      -> Mark visited immediately.
 *
 * YES, but only ONE value changes
 *      -> Don't explore again,
 *         but update that value.
 *
 * YES, because the ENTIRE PATH changes
 *      -> Don't mark immediately.
 *
 * The meaning of visited changes depending
 * on what the problem is asking.
 *
 *
 * ============================================================================
 * WHAT BFS REALLY DOES
 * ============================================================================
 *
 * BFS spreads LEVEL by LEVEL.
 *
 *              hit
 *
 *              hot
 *
 *          dot     lot
 *
 *          dog     log
 *
 *              cog
 *
 * BFS naturally discovers FACTS about each node.
 *
 * These facts are unique no matter which path reached the node.
 *
 * Examples:
 *
 *      dist[node]
 *      level[node]
 *      visited[node]
 *      minimum cost
 *      maximum score
 *      number of shortest paths
 *      parent (if only one shortest path is needed)
 *
 * These are NODE properties.
 *
 * Since every node has only ONE such value,
 * BFS can merge all paths into one state.
 *
 *
 * ============================================================================
 * WHAT BFS CANNOT COMPRESS
 * ============================================================================
 *
 * Path is NOT a node property.
 *
 * Example:
 *
 *      hit -> hot -> dot -> dog
 *
 *      hit -> hot -> lot -> dog
 *
 * Which path belongs to dog?
 *
 * There isn't one answer.
 *
 * There may be
 *
 *      Path 1
 *      Path 2
 *      Path 3
 *      ...
 *
 * So BFS cannot summarize "path" into one state.
 *
 *
 * ============================================================================
 * WHY WE CANNOT KEEP ONLY ONE PATH VARIABLE IN BFS
 * ============================================================================
 *
 * BFS explores MANY branches at the SAME TIME.
 *
 * Example:
 *
 *          S
 *         / \
 *        A   B
 *
 * Queue contains both
 *
 *      S->A
 *      S->B
 *
 * Suppose we keep only one global path.
 *
 * First
 *
 *      path = S->A
 *
 * then while processing B
 *
 *      path = S->B
 *
 * Now S->A is LOST.
 *
 * Later when BFS comes back to continue A's branch,
 * that previous state no longer exists.
 *
 * Since many branches are alive simultaneously,
 * each branch needs its own path.
 *
 * This is why storing complete paths inside BFS
 * copies the path for every queue element.
 *
 *
 * ============================================================================
 * WHY DFS CAN USE ONLY ONE PATH VARIABLE
 * ============================================================================
 *
 * DFS explores ONLY ONE branch at a time.
 *
 *      S
 *      |
 *      A
 *      |
 *      C
 *      |
 *      D
 *
 * Path variable becomes
 *
 *      [S]
 *      [S,A]
 *      [S,A,C]
 *      [S,A,C,D]
 *
 * After finishing,
 *
 *      pop()
 *
 * restores previous state.
 *
 * So one mutable path is enough.
 *
 * DFS is naturally good at generating
 *
 *      all paths
 *      subsets
 *      permutations
 *      Sudoku
 *      N Queens
 *
 * But DFS alone does NOT guarantee shortest path,
 * because it keeps going deeper before exploring
 * all shorter possibilities.
 *
 *
 * ============================================================================
 * WHY NORMAL BFS MARKS VISITED IMMEDIATELY
 * ============================================================================
 *
 * In many problems,
 * once a node is reached,
 * every future visit is useless.
 *
 * Example:
 *
 *      traversal
 *      shortest distance
 *      reachability
 *      minimum steps
 *      topological sort
 *
 * So
 *
 *      if(!visited)
 *      {
 *          visited = true;
 *          push neighbour;
 *      }
 *
 * Every later path gets blocked because
 * it cannot improve the answer anymore.
 *
 *
 * ============================================================================
 * SOMETIMES WE BLOCK BUT STILL UPDATE BEST VALUE
 * ============================================================================
 *
 * Some problems only care about ONE BEST VALUE.
 *
 * Example:
 *
 *      Maximum number of 1's collected.
 *
 * Suppose X is reached with
 *
 *      ones = 5
 *
 * Later
 *
 *      ones = 8
 *
 * Even though X was already visited,
 * we don't process it again,
 * but inside the
 *
 *      else      // already visited
 *
 * part,
 * we can still update
 *
 *      best[X] = max(best[X], newValue)
 *
 * because only ONE optimal value matters.
 *
 * We BLOCK the node,
 * but still UPDATE its stored information.
 *
 * Same idea appears in:
 *
 *      number of shortest paths
 *      DP on graphs
 *      Dijkstra (better distance)
 *      maximum score problems
 *
 * Multiple paths are still merged
 * into ONE state.
 *
 *
 * ============================================================================
 * WHY THAT DOESN'T WORK HERE
 * ============================================================================
 *
 * In Word Ladder II,
 * there is NO single "best value".
 *
 * We don't want
 *
 *      shortest distance
 *
 * or
 *
 *      maximum score.
 *
 * We want
 *
 *      EVERY shortest path.
 *
 * There is no single variable like
 *
 *      best[word]
 *
 * which can represent
 *
 *      hit->hot->dot->dog
 *
 * AND
 *
 *      hit->hot->lot->dog
 *
 * together.
 *
 * The entire path itself is the answer.
 *
 * Another visit changes the WHOLE PATH,
 * not just one value.
 *
 * Therefore one state is impossible.
 *
 *
 * ============================================================================
 * WHY WE DON'T MARK VISITED IMMEDIATELY HERE
 * ============================================================================
 *
 * Example:
 *
 *              hit
 *               |
 *              hot
 *             /   \
 *          dot     lot
 *             \   /
 *              dog
 *
 * Both dot and lot belong to the SAME BFS level.
 *
 * Both deserve a chance to reach dog.
 *
 * If dot immediately removes dog,
 * then lot loses a valid shortest path.
 *
 * Therefore
 *
 *      During current level
 *              don't permanently remove words.
 *
 * Instead
 *
 *      usedThisLevel.add(word)
 *
 * After ENTIRE level finishes
 *
 *      remove all used words together.
 *
 * This allows every shortest parent
 * from the current level,
 * while still blocking longer paths
 * from future levels.
 *
 * Notice the difference:
 *
 * Previous BFS problems:
 *
 *      Second visit
 *          ->
 *      Update ONE value.
 *
 * Word Ladder II:
 *
 *      Second visit
 *          ->
 *      Creates a NEW ANSWER.
 *
 *
 * ============================================================================
 * THIS SOLUTION
 * ============================================================================
 *
 * Queue stores COMPLETE PATHS.
 *
 * Example:
 *
 *      [hit]
 *
 *      [hit,hot]
 *
 *      [hit,hot,dot]
 *
 * Every neighbour gets
 *
 *      new ArrayList<>(currentPath)
 *
 * because every BFS branch needs
 * its own independent history.
 *
 * When first path reaches endWord,
 * that entire level is the shortest level.
 *
 * Every other path reaching endWord
 * in that SAME level
 * is also shortest.
 *
 *
 * ============================================================================
 * MORE OPTIMIZED APPROACH
 * ============================================================================
 *
 * Instead of storing full paths inside BFS:
 *
 * STEP 1
 * ------
 *
 * BFS computes only
 *
 *      dist[word]
 *
 * Distance is a node property,
 * so one integer per node is enough.
 *
 *
 * STEP 2
 * ------
 *
 * DFS starts from endWord.
 *
 * Move only to neighbours satisfying
 *
 *      dist[next] == dist[curr] - 1
 *
 * Since every move decreases distance by one,
 * DFS walks only through shortest paths.
 *
 * DFS generates one path,
 * backtracks,
 * generates another,
 * without storing thousands of path copies.
 *
 * This is a perfect division of work:
 *
 * BFS
 *      -> Discover FACTS.
 *
 * DFS
 *      -> Generate STORIES.
 *
 * Each algorithm performs the job
 * it is naturally best at.
 *
 *
 * ============================================================================
 * GOLDEN RULE
 * ============================================================================
 *
 * Whenever multiple paths reach the same node,
 * ask:
 *
 *      "Can everything I need about this node
 *       be summarized into ONE fixed state?"
 *
 * YES
 * ----
 *
 * Merge them.
 *
 * Examples:
 *
 *      distance
 *      visited
 *      minimum cost
 *      maximum score
 *      number of shortest paths
 *      DP value
 *      best number of 1's
 *
 *
 * NO
 * ---
 *
 * Keep paths separate.
 *
 * Examples:
 *
 *      print all paths
 *      Word Ladder II
 *      subsets
 *      permutations
 *      Sudoku
 *      N Queens
 *
 *
 * Easy way to remember:
 *
 *      BFS discovers FACTS.
 *
 *          distance
 *          level
 *          minimum
 *          maximum
 *          reachability
 *
 *      DFS discovers STORIES.
 *
 *          "Exactly how did I get here?"
 *
 * Facts can be merged.
 * Stories cannot.
 *
 * The trick is NOT choosing BFS or DFS.
 *
 * The trick is asking:
 *
 *      "Am I discovering FACTS,
 *       or am I generating STORIES?"
 *
 * That's why the optimal solution is:
 *
 *      BFS
 *          -> Discover shortest distance.
 *
 *      DFS
 *          -> Reconstruct every shortest path.
 *
 * ============================================================================
 */