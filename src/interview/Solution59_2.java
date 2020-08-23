package interview;

import java.util.ArrayList;
import java.util.List;

/*面试题59 - II. 队列的最大值
请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
若队列为空，pop_front 和 max_value 需要返回 -1
输入:
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]
 */
public class Solution59_2 {
    private List<Integer> queue;
    private int i,curr,max;

    public Solution59_2() {
        i = 0;
        curr= -1;
        queue = new ArrayList<>();
        max = -1;
    }

    public int max_value() {
        if(max == -1 || max >= queue.size()){
            return -1;
        }
        return queue.get(max);
    }

    public void push_back(int value) {
        ++curr;
        queue.add(value);
        if(max == -1){
            max = curr;
        }
        if(queue.get(max) <= value){
            max = curr;
        }
    }

    public int pop_front() {
        if(queue.isEmpty() || i >= queue.size()){
            return -1;
        }
        int first = queue.get(i);
        if(i == max){
            int j = ++i;
            ++max;
            while(j < queue.size()){
                max = queue.get(max) <= queue.get(j) ? j : max;
                ++j;
            }
        } else {
            ++i;
        }
        return first;
    }


/**
 * Your MaxQueue object will be instantiated实例化 and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */

}
