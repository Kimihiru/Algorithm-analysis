package backtrack;

/**
 * @author Sakura
 * @date 2021/5/25 - 22:13
 * @description
 * 二.针对旅行售货员问题，写出问题分析、回溯法设计思想、步骤、代码实现过程，并进行总结分析
 */
public class TravelingSalesmanProblem {
    //图G的顶点数
    public static int n;
    //当前解路径
    public static int[] x;
    //最优解路径
    public static int[] bestx;
    //图G的邻接矩阵
    public static int[][] a;
    //当前路径x[1:i]的费用
    public static int cc;
    //最优解费用
    public static int bestc;
    //无边标记、最大值
    public static int NoEdge = Integer.MAX_VALUE;

    // 回溯算法
    public static void BackTrack(int i){
        if (i == n) {
            // 若点n-1和点n有连线且点1和n有连线且比最优路径短
            if (a[x[n-1]][x[n]] != NoEdge && a[x[n]][1] != NoEdge
                    && (cc + a[x[n - 1]][n] + a[x[n]][1] < bestc || bestc == NoEdge)) {
                for (int j = 1; j <= n; j++) {
                    // 将最优路径保存进bestx
                    bestx[j] = x[j];
                }
                // 最优值
                bestc = cc + a[x[n - 1]][x[n]] + a[x[n]][1];
            }
            return;
        }
        for (int j = i; j <= n; j++) {
            // 点i-1和点j是否存在路径且比最优路径短
            if (a[x[i - 1]][x[j]] != NoEdge && (cc + a[x[i - 1]][x[j]] < bestc || bestc == NoEdge)) {
                // 搜索子树
                swap(x, i, j);
                cc += a[x[i - 1]][x[i]];
                BackTrack(i+1);
                cc -= a[x[i - 1]][x[i]];
                swap(x, i, j);
            }
        }
    }

    public static void swap(int[] x, int i, int j){
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }

    public static int tsp(int[] v){
        x = new int[n + 1];
        // 初始化
        for (int i = 1; i <= n; i++) {
            x[i] = i;
        }
        // 初始化设置最少花费为最大值
        bestc = NoEdge;
        // 最优路径为v
        bestx = v;
        // 当前花费为0
        cc = 0;
        // 从2开始搜索，搜索x[2:n]的全排列
        BackTrack(2);
        return bestc;
    }

    public static void main(String[] args) {
        // 测试数据
        n = 4;
        a = new int[][]{
                {0, 0, 0, 0, 0},
                {0, NoEdge, 30, 6, 4},
                {0, 30, NoEdge, 5, 10},
                {0, 6, 5, NoEdge, 20},
                {0, 4, 10, 20, NoEdge}
        };
        int[] v = new int[n + 1];
        int bestcc = tsp(v);
        System.out.println("最优费用为：" + bestcc);
        System.out.print("最优路径为：");
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if(i==n){
                stringBuilder.append(bestx[i]).append("->").append(bestx[1]);
            }
            else{
                stringBuilder.append(bestx[i]).append("->");
            }
        }
        String path=stringBuilder.toString();
        System.out.println(path);
        /**
         * 运行结果
         * 最优费用为：25
         * 最优路径为：1->3->2->4
         */
    }
}