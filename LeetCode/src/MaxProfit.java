/**
 * @Author: nekotako
 * @Description: 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 <b>某一天</b> 买入这只股票，并选择在 <b>未来的某一个不同的日子</b> 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * <p>
 * 示例 2：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * @Date: 2023/11/20 18:59 星期一
 */

public class MaxProfit {
    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int profit = maxProfit.maxProfit(new int[]{3, 2, 5, 1});
//        int profit = maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(profit);
    }

    public int maxProfit(int[] prices) {
        int minPriceIndex = 0;
        int maxPriceIndex = minPriceIndex;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[minPriceIndex]) {
                minPriceIndex = i;
            } else if (prices[i] > prices[maxPriceIndex]) {
                maxPriceIndex = i;
            }
        }
        if (maxPriceIndex < minPriceIndex) {
            maxPriceIndex = minPriceIndex;
            for (int i = minPriceIndex; i < prices.length; i++) {
                if (prices[i] > prices[maxPriceIndex]) {
                    maxPriceIndex = i;
                }
            }
        } else if (maxPriceIndex > minPriceIndex) {
            minPriceIndex = 0;
            for (int i = 0; i < maxPriceIndex; i++) {
                if (prices[i] < prices[minPriceIndex]) {
                    minPriceIndex = i;
                }
            }
        } else {
            return 0;
        }
        return (prices[maxPriceIndex] - prices[minPriceIndex]);
    }
}
