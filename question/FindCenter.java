package com.huang.question;
//有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。
//
//        给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回 edges 所表示星型图的中心节点。
//
//         
//
//        示例 1：
//
//
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/find-center-of-star-graph
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class FindCenter {
    public static void main(String[] args) {
//        int[][] edges = {{1, 2}, {5,1}, {1,3},{1,4}};
        int[][] edges={{1,2},{2,3},{4,2}};
        int sum=findCenter(edges);
        System.out.println(sum);
    }
    public static int findCenter(int[][] edges) {
//        int n=edges.length+1;
//        int[][] adj=new int[n+1][n+1];
//        for(int i=0;i<edges.length;i++){
//            adj[edges[i][0]][edges[i][1]]=1;
//            adj[edges[i][1]][edges[i][0]]=1;
//        }
//        int sum=0;
//        for(int i=0;i<n+1;i++){
//            for(int j=0;j<n+1;j++) {
//                System.out.print(adj[i][j]+" ");
//            }
//            System.out.println();
//        }
//        for(int i=1;i<n+1;i++){
//            sum=0;
//            for(int j=1;j<n+1;j++){
//                if(adj[i][j]==1){
//                    sum++;
//                }
//            }
//            if(sum==n-1){
//                return i;
//            }
//        }
//        return 0;
        return edges[0][0]==edges[1][0]||edges[0][0]==edges[1][1]?edges[0][0]:edges[0][1];
    }
}
