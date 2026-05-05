#include<vector>
using namespace std;
class Solution {
public:
    void segregate0and1(vector<int> &arr) {
        int zeros = 0, ones = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr[i] == 0)
                zeros++;
            else
                ones++;
        }

        int pos = 0;
        while (zeros--) arr[pos++] = 0;
        while (ones--)  arr[pos++] = 1;
    }
};
