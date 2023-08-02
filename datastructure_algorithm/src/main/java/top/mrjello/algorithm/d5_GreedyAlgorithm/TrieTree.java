package top.mrjello.algorithm.d5_GreedyAlgorithm;

import org.junit.jupiter.api.Test;

/**
 * @author jason@mrjello.top
 * @date 2023/7/24 19:29
 */
public class TrieTree {
    /**
     * 前缀树: 通常来说，一个前缀树是用来存储字符串的。前缀树的两个节点之间的路代表一个字符（前缀）。
     * 每存储一个字符串，就会有一个节点的end++，代表这个节点是一个字符串的结尾。
     */
    public static class TrieNode {
        //path个通过该节点的路径数量
        public int path;
        //end个字符串的结尾节点
        public int end;
        //记录后续节点
        public TrieNode[] nexts;

        public TrieNode() {
            path = 0;
            end = 0;
            //26个英文字母，但是并不一定都有值，如果数量特别多，可以换成HashMap<Char,Node> nexts;
            //如果希望路与路之间有序组织则可以使用有序表TreeMap<Char,Node>nexts;
            nexts = new TrieNode[26];
        }
    }

    /**
     * 前缀树根节点
     */
    public static class Trie {
        //表示头结点，ps：根节点的path代表目前TrieNode数组的数量
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /**
         * 插入字符串
         * @param word 待插入的字符串
         */
        public void insert(String word) {
            if (word == null) {
                return;
            }
            //将字符串转换为字符数组
            char[] chs = word.toCharArray();
            //node从根节点出发
            TrieNode node = root;
            //index代表字符在TrieNode数组中的下标
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                //当前字符减ascii码，比如，a-'a'=0 c-'a'=2
                index =chs[i] - 'a';
                //如果node的后续节点为null，则新建节点，否则直接移动，同时path的计数++
                if(node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                //如果node的后续节点不为null，则直接移动，同时path的计数++
                node = node.nexts[index];
                node.path++;
            }
            //node.end++，代表这个节点是一个字符串的结尾。
            node.end++;
        }

        /**
         * 删除字符串
         * @param word 待删除的字符串
         */
        public void delete(String word) {
            //先确认树中是否加入过word
            if (search(word) != 0) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    //沿途path值不断--，如果遇到某个节点path减为0，则直接移除该节点
                    if(--node.nexts[index].path == 0) {
                        //后续节点为null，代表没有字符串经过该节点，直接移除该节点
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                //node.end--，代表这个节点是一个字符串的结尾。
                node.end--;
            }
        }

        /**
         * 查询字符串出现的次数
         * @param word 待查询的字符串
         * @return 字符串出现的次数
         */
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            //将字符串转换为字符数组
            char[] chs = word.toCharArray();
            //node从根节点出发
            TrieNode node = root;
            //index代表字符在TrieNode数组中的下标
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index =chs[i] - 'a';
                //如果node的后续节点为null，则代表没有该字符串
                if(node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            //返回字符串出现的次数,end代表这个节点是一个字符串的结尾。
            return node.end;
        }

        /**
         * 前缀查询
         * 在所有加入的字符串中，有几个是以pre字符串为前缀的
         * @param pre 前缀字符串
         * @return 前缀字符串出现的次数
         */
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index =chs[i] - 'a';
                if(node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            //返回字符串出现的次数,path代表通过该节点的路径数量
            return node.path;
        }
    }


    @Test
    public void test() {
        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixNumber("zuo"));
    }
}
