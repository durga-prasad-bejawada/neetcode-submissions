class MyHashMap {

    class Node{
        int key;
        int value;
        Node next;
    }

    Node map [];

    public MyHashMap() {
        map = new Node [1000];
        
    }
    
    public void put(int key, int value) {
        Node curr = map[hash(key)];

        while(curr!=null){
            if(curr.key==key){
                curr.value=value;
                return;
            }
            curr=curr.next;
        }

        Node ne = new Node();
        ne.key=key;
        ne.value=value;
        ne.next=map[hash(key)];
        map[hash(key)]=ne; 
    }
    
    public int get(int key) {
        Node curr = map[hash(key)];
        while(curr!=null){
            if(curr.key==key){
                return curr.value;
            }
            curr=curr.next;
        }
        return -1;
        
    }
    
    public void remove(int key) {
        Node curr = map[hash(key)];
        Node prev = null;
        while(curr!=null){
            if(curr.key==key){
                if(prev==null){
                    map[hash(key)]=curr.next;
                }else{
                    prev.next=curr.next;
                }
                return;
            }
            prev=curr;
            curr = curr.next;
        }


        
    }

    public int hash(int key){
        return key%1000;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */