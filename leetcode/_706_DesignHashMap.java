public class _706_DesignHashMap {
    class MyHashMap {
        ListNode[] hashmap;

        /** Initialize your data structure here. */
        public MyHashMap() {
            hashmap = new ListNode[10000];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int hash = getHash(key);
            if (hashmap[hash] == null) {
                hashmap[hash] = new ListNode(-1, 1);
            }
            ListNode prev = find(hashmap[hash], key);
            if (prev.next == null) {
                prev.next = new ListNode(key, value);
            } else {
                prev.next.val = value;
            }
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int hash = getHash(key);
            if (hashmap[hash] == null)
                return -1;
            ListNode node = find(hashmap[hash], key);
            return node.next == null ? -1 : node.next.val;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int hash = getHash(key);
            if (hashmap[hash] != null) {
                ListNode node = find(hashmap[hash], key);
                if (node.next != null) {
                    node.next = node.next.next;
                }
            }
        }

        public ListNode find(ListNode bucket, int key) {
            ListNode node = bucket, prev = null;
            while (node != null && node.key != key) {
                prev = node;
                node = node.next;
            }
            return prev;
        }

        public int getHash(int key) {
            return key % String.valueOf(key).length();
        }

        class ListNode {
            int key;
            int val;
            ListNode next;

            public ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}
