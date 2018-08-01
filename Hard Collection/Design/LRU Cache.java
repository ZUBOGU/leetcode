/* LRU Cache

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2); capacity
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 */

// Use custom double linked list impl. It has O(1) for deletion and add opeartions
// Custom Node class used for double linked list.
class LRUCache {
    // Double LinkedList Impl
    Node head, tail;
    int count;
    int capacity;
    HashMap<Integer, Node> hm;
    
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node (int k, int v) {
            this.key = k;
            this.val = v;
        }
    }
    
    public void addAfterHead(Node node) {
        node.prev = this.head;
        node.next = this.head.next;

        this.head.next.prev = node;
        this.head.next = node;
    }

    public void remove (Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public void moveToHead(Node node) {
        this.remove(node);
        this.addAfterHead(node);
    }

    public Node removeTail() {
        Node node = tail.prev;
        this.remove(node);
        return node;
    }

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        this.hm = new HashMap<>();

        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        Node node = this.hm.get(key);
        if (node == null) {
            return -1;
        }
        this.moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = hm.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            this.hm.put(key, newNode);
            this.addAfterHead(newNode);

            count++;
            if (count > capacity) {
                Node removeTail = this.removeTail();
                this.hm.remove(removeTail.key);
                count--;
            }
        } else {
            node.val = value;
            this.moveToHead(node);
        }
    }
    

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */