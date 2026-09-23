class Solution {
    static class Node {
        int[] remain;
        int prod;

        Node(int k) {
            remain = new int[k];
            prod = 1;
        }
    }

    static class SegmentTree {
        int n;
        int k;
        Node[] tree;

        SegmentTree(int[] nums, int k) {
            this.n = nums.length;
            this.k = k;
            this.tree = new Node[4 * n];
            build(nums, 0, 0, n - 1);
        }

        private Node merge(Node left, Node right) {
            Node res = new Node(k);
            res.prod = (left.prod * right.prod) % k;
            for (int i = 0; i < k; i++) {
                res.remain[i] = left.remain[i];
            }
            for (int i = 0; i < k; i++) {
                res.remain[(i * left.prod) % k] += right.remain[i];
            }
            return res;
        }

        private void build(int[] nums, int node, int start, int end) {
            if (start == end) {
                tree[node] = new Node(k);
                tree[node].remain[nums[start]] = 1;
                tree[node].prod = nums[start];
                return;
            }
            int mid = start + (end - start) / 2;
            build(nums, 2 * node + 1, start, mid);
            build(nums, 2 * node + 2, mid + 1, end);
            tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2]);
        }

        public void update(int index, int val) {
            update(0, 0, n - 1, index, val);
        }

        private void update(int node, int start, int end, int index, int val) {
            if (start == end) {
                tree[node] = new Node(k);
                tree[node].remain[val] = 1;
                tree[node].prod = val;
                return;
            }
            int mid = start + (end - start) / 2;
            if (index <= mid) {
                update(2 * node + 1, start, mid, index, val);
            } else {
                update(2 * node + 2, mid + 1, end, index, val);
            }
            tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2]);
        }

        public Node query(int l, int r) {
            return query(0, 0, n - 1, l, r);
        }

        private Node query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) {
                return new Node(k);
            }
            if (l <= start && end <= r) {
                return tree[node];
            }
            int mid = start + (end - start) / 2;
            Node leftRes = query(2 * node + 1, start, mid, l, r);
            Node rightRes = query(2 * node + 2, mid + 1, end, l, r);
            return merge(leftRes, rightRes);
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] %= k;
        }

        SegmentTree st = new SegmentTree(nums, k);
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1] % k;
            int start = queries[i][2];
            int x = queries[i][3];

            st.update(index, value);
            Node resNode = st.query(start, n - 1);
            result[i] = resNode.remain[x];
        }

        return result;
    }
}