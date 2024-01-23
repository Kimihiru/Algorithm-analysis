package dp;

import java.util.Arrays;
import java.util.Stack;

/**
 * 利用动态规划求解最短路径问题
 * f(0)=0
 * f(i)=min(f(i)+dp[j][i])
 */

public class OneRouteDjsterMinDistance {
    // 计算最短距离
    public static int[] calMinDistance(int[][] distance) {
        int[] dist = new int[distance.length];
        dist[0] = 0;
        for (int i = 1; i < distance.length; i++) {
            int iMinDist = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (distance[j][i] != 0) {
                    if ((dist[j] + distance[j][i]) < iMinDist) {
                        iMinDist = dist[j] + distance[j][i];
                    }
                }
            }
            dist[i] = iMinDist;
        }
        return dist;
    }

    // 计算路径
    public static String calTheRoute(int[][] distance, int[] dist) {
        Stack<Integer> st = new Stack<>();
        StringBuilder buf = new StringBuilder();
        int i = distance.length - 1;
        // 将尾插入
        st.add(i);
        while (i > 0) {
            for (int j = 0; j < i; j++) {
                if (distance[j][i] != 0) {
                    if (dist[i] - distance[j][i] == dist[j]) {
                        st.add(j);
                    }
                }
            }
            i = st.peek();
        }

        String arrow = "-->";
        while (!st.empty()) {
            buf.append(st.pop()).append(arrow);
        }
        String result = buf.toString();
        result = result.substring(0, result.length()-arrow.length());
        return result;
    }


    public static void main(String[] args) {
//          6个点
        int[][] map = new int[6][6];
        map[0][1]=2;map[0][2]=3;map[0][3]=6;
        map[1][0]=2;map[1][4]=4;map[1][5]=6;
        map[2][0]=3;map[2][3]=2;
        map[3][0]=6;map[3][2]=2;map[3][4]=1;map[3][5]=3;
        map[4][1]=4;map[4][3]=1;
        map[5][1]=6;map[5][3]=3;
//        11个点
//        int[][] map = new int[11][11];
//        map[0][1]=5;map[0][2]=3;
//        map[1][0]=5;map[1][3]=1;map[1][4]=6;map[1][5]=8;
//        map[2][0]=3;map[2][4]=8;map[2][6]=4;
//        map[3][1]=1;map[3][7]=5;map[3][8]=6;
//        map[4][1]=6;map[4][2]=8;map[4][7]=5;
//        map[5][1]=3;map[5][9]=8;
//        map[6][2]=4;map[6][9]=3;
//        map[7][3]=5;map[7][4]=5;map[7][10]=3;
//        map[8][3]=6;map[8][10]=4;
//        map[9][5]=8;map[9][6]=3;map[9][10]=3;
        int[] dist = calMinDistance(map);
        for (int i=0;i<map.length;i++){
            for (int j=0;j<map.length;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("dist：" + Arrays.toString(dist));
        System.out.println("最短路径长度为：" + dist[map.length - 1]);
        System.out.println("最短路径为：" + calTheRoute(map, dist));
    }
}