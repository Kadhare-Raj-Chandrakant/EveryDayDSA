class Encrypter {
public:
    unordered_map<char, string> keyMap;
    unordered_map<string, int> valMap;
    unordered_set<string> dictSet;

    Encrypter(vector<char>& keys, vector<string>& values, vector<string>& dictionary) {
        for (int i = 0; i < keys.size(); i++) {
            keyMap[keys[i]] = values[i];
            valMap[values[i]]++;
        }
        for (auto& word : dictionary) {
            dictSet.insert(word);
        }
    }

    string encrypt(string word1) {
        string res;
        for (auto& c : word1) {
            if (keyMap.find(c) == keyMap.end()) return "";
            res += keyMap[c];
        }
        return res;
    }

    int decrypt(string word2) {
        int n = word2.size();
        vector<int> dp(n + 1);
        dp[0] = 1;
        for (int i = 2; i <= n; i += 2) {
            string s = word2.substr(i - 2, 2);
            if (valMap.find(s) == valMap.end()) return 0;
            dp[i] = dp[i - 2] * valMap[s];
        }
        return dp[n];
    }
};