class SummaryRanges {
public:
    // Time complexity: O(log n) for addNum, O(n) for getIntervals
    // Space complexity: O(n)
    SummaryRanges() {
        dsu = vector<int>(10001, -1);
    }

    void addNum(int value) {
        if (dsu[value] != -1) return;
        dsu[value] = value;
        if (dsu[value - 1] != -1) {
            unionSets(value - 1, value);
        }
        if (dsu[value + 1] != -1) {
            unionSets(value, value + 1);
        }
    }

    vector<vector<int>> getIntervals() {
        vector<vector<int>> res;
        int start = -1;
        for (int i = 0; i < 10001; i++) {
            if (find(i) == i) {
                if (start == -1) start = i;
                else res.push_back({start, i});
                start = -1;
            }
        }
        return res;
    }

private:
    vector<int> dsu;

    int find(int x) {
        if (dsu[x] != x) dsu[x] = find(dsu[x]);
        return dsu[x];
    }

    void unionSets(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            dsu[rootX] = rootY;
        }
    }
};