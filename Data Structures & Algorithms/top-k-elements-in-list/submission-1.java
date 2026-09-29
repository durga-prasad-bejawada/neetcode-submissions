class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int offset = 1000;
        int[] fr = new int[2001];

        for (int n : nums) {
            fr[n + offset]++;
        }

        // Min-heap storing the indices of 'fr', ordered by frequency ascending
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> fr[a] - fr[b]);

        for (int i = 0; i < fr.length; i++) {
            if (fr[i] > 0) {
                pq.offer(i);
                // Keep only the top k most frequent indices in the heap
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        // Extract the k elements and convert back from index to original number
        int[] ans = new int[k];
        for (int j = 0; j < k; j++) {
            ans[j] = pq.poll() - offset;
        }

        return ans;
    }
}
