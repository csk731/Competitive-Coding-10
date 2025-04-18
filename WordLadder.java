import java.util.*;

// TC: O(n * m^2)
// SC: O(n * m)
// where n is the number of words in the wordList and m is the length of each word

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        int m = beginWord.length();

        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        for(String e : wordList) set.add(e);

        q.add(beginWord);
        int ans = 1;
        while(!q.isEmpty()){
            int size = q.size();
            // Level By Level Traversal using Queue
            while(size>0){
                StringBuffer polled = new StringBuffer(q.poll());
                // Explore Combinations
                for(int i=0;i<m;i++){
                    char orgChar = polled.charAt(i);
                    for(char j='a';j<='z';j++){
                        polled.setCharAt(i, j);
                        String pts = polled.toString();
                        if(set.contains(pts)){
                            if(endWord.equals(pts)) return ans+1;
                            q.add(pts);
                            set.remove(pts);
                        }
                    }
                    polled.setCharAt(i, orgChar);
                }
                size--;
            }
            ans++;
        }
        return 0;
    }
}
