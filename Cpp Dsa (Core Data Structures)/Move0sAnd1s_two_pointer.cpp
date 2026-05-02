#include <vector>
using namespace std;

class Solution {
public:
    void swap(vector<int> &arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    void segregate0and1(vector<int> &arr) {
        int pointer1 = 0;
        int pointer2 = arr.size() - 1;

        while (pointer1 < pointer2) {
            while (pointer1 < arr.size() && arr[pointer1] == 0)
                pointer1++;

            while (pointer2 >= 0 && arr[pointer2] == 1)
                pointer2--;

            if (pointer1 < pointer2) {
                swap(arr, pointer1, pointer2);
                pointer1++;
                pointer2--;
            }
        }
    }
};
