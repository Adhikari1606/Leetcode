class Pair {
    String str;
    int ind;

    Pair(String s, int i) {
        str = s;
        ind = i;
    }
}

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String s : wordList) {
            set.add(s);
        }
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(beginWord, 1));
        while (!que.isEmpty()) {
            Pair a = que.poll();
            String word = a.str;
            int step = a.ind;

            if (word.equals(endWord)) {
                return step;
            }

            char[] wordArray = word.toCharArray();

            for (int i = 0; i < wordArray.length; i++) {
                char originalChar = wordArray[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    wordArray[i] = j;
                    String word1 = new String(wordArray);

                    if (set.contains(word1)) {
                        que.add(new Pair(word1, step + 1));
                        set.remove(word1);
                    }
                }
                wordArray[i] = originalChar;
            }
        }

        return 0;
    }
}
