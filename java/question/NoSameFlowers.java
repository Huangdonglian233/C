package com.huang.question;
//1042. 不邻接植花
//有 n 个花园，按从 1 到 n 标记。另有数组 paths ，其中 paths[i] = [xi, yi] 描述了花园 xi 到花园 yi 的双向路径。在每个花园中，你打算种下四种花之一。
//
//        另外，所有花园 最多 有 3 条路径可以进入或离开.
//
//        你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
//
//        以数组形式返回 任一 可行的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1、2、3、4 表示。保证存在答案。
//
//         
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/flower-planting-with-no-adjacent
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class NoSameFlowers {
    public static void main(String[] args) {
        int n = 3;
        int[][] paths = {{1,2},{2,3},{3,1}};
        int[] result=gardenNoAdj(n,paths);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
    public static int[] gardenNoAdj(int n, int[][] paths) {
        int[] type=new int[n];
        int flower=1;
        type[0]=flower;
        while(flower<n){
            for(int i=0;i<paths.length;i++){
                for(int j=0;j<2;j++){

                }
            }
        }
        return type;
    }
}
//        int[] ans = new int[N];
//        LinkedList<Integer>[] adj =(LinkedList<Integer>[]) new LinkedList[N + 1];//邻接表数组
//        for(int i = 0; i < adj.length; i++)
//        adj[i] = new LinkedList<Integer>();
//        for(int[] temp : paths) {//建立邻接表
//        adj[temp[0]].add(temp[1]);
//        adj[temp[1]].add(temp[0]);
//        }
//        for(int i = 1; i <= N; i++) {//从1号花园开始种花
//        boolean[] color = new boolean[5];//每个花园初始都有4种可选，false意为没被用过
//        for(int id : adj[i])
//        color[ans[id - 1]] = true;//邻接顶点花园使用过的种类，不能再用
//        for(int j = 1; j <= 4; j++) {//找剩余的可用种类
//        if(!color[j]) {
//        ans[i - 1] = j;
//        break;
//        }
//        }
//        }
//        return ans;
