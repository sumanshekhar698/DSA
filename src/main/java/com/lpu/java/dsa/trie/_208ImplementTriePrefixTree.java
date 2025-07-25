package com.lpu.java.dsa.trie;

import java.util.HashMap;

public class _208ImplementTriePrefixTree {


    class Trie {

        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curTrieNode = this.root;
            for (int i = 0; i < word.length(); i++) {
                if (!curTrieNode.children.containsKey(word.charAt(i))) {
                    curTrieNode.children.put(word.charAt(i), new TrieNode());
                }
                curTrieNode = curTrieNode.children.get(word.charAt(i));//if the character exist we will switch to that node
            }
            curTrieNode.endOfWord = true;//marking the last node as end of the word
        }

        public boolean search(String word) {

            TrieNode curTrieNode = this.root;
            for (int i = 0; i < word.length(); i++) {
                if (!curTrieNode.children.containsKey(word.charAt(i))) {
                    return false;
                } else
                    curTrieNode = curTrieNode.children.get(word.charAt(i));
            }
            return curTrieNode.endOfWord;//if the last node is marked end of the word
        }

        public boolean startsWith(String prefix) {
            TrieNode curTrieNode = this.root;
            for (int i = 0; i < prefix.length(); i++) {
                if (!curTrieNode.children.containsKey(prefix.charAt(i))) {
                    return false;
                } else
                    curTrieNode = curTrieNode.children.get(prefix.charAt(i));
            }
            return true;
        }
    }

    class TrieNode {
        HashMap<Character, TrieNode> children;//keeps track of childern nodes
        boolean endOfWord;//tells if the node is an end of the word

        public TrieNode() {
            this.children = new HashMap<>();
        }
    }

}
