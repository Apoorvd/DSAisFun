package com.heyshubham.leetcode;

public class LeetCode_121 {

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

    public int maxProfit(int[] prices)
    {
        int i = 0;
        int min = Integer.MAX_VALUE;
        int profit = 0;
        int max = 0;
        for ( i = 0 ; i < prices.length ; i++)
        {
            min = min > prices[i] ? prices[i] : min;
            profit =  prices[i] - min;
            max = profit <  max ? max : profit;
        }
        return max;
    }

}

/*same as above
 public int maxProfit(int[] prices) {

        int buy=prices[0];
        int p = Integer.MIN_VALUE;
        for(int i=1;i<prices.length;i++){
            if(buy<prices[i]){
                p=Math.max(p,prices[i]-buy);

            }
            else{
                buy=prices[i];
            }
        }

        if(p==Integer.MIN_VALUE)return 0;
        return p;

    }
 */

/*
public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 1){
            return 0;
        }

        int min = prices[0], result = 0;

        for(int i = 0; i < prices.length; i++){
            int max = prices[i];
            if(max < min){
                min = max;
            }
            else{
                if(max - min > result){
                    result = max - min;
                }
            }
        }

        return result;
    }
 */

/*
public int maxProfit(int[] prices) {

		if(prices==null || prices.length==0) {
			return 0;
		}
		int minBuy = -1;
		int maxSell = -1;
		int tempProfit = 0;
		int maxProfit =0;
		for (int i = 0; i < prices.length; i++) {
			if(prices[i]<minBuy || minBuy ==-1) {
				minBuy = prices[i];
				maxSell =0;
			}
			if(prices[i]>maxSell  ) {
				maxSell = prices[i];
			}
			 tempProfit = maxSell-minBuy;
			if(tempProfit>maxProfit) {
				maxProfit = tempProfit;
			}
		}
		return maxProfit;

    }
 */

/*
 public int maxProfit(int[] prices) {

        int lowestDayValue = Integer.MAX_VALUE;
        int maxSum = 0;

        for (int i=0; i<prices.length;i++){
            if(prices[i] < lowestDayValue){
                lowestDayValue = prices[i];
                System.out.println("lowestDayValue "+ lowestDayValue);
            }
            if (maxSum < prices[i] - lowestDayValue){
                maxSum= prices[i] - lowestDayValue;
                System.out.println("maxSum "+ maxSum);
                  System.out.println("prices[i] "+ prices[i]);

            }
        }
        return maxSum;
    }
 */

/*
public int maxProfit(int[] prices)
    {
        Stack<Integer> sto=new Stack<>();
        sto.push(prices[0]);
        int ans=0;
        int n=prices.length;
        for(int i=1;i<n;i++)
        {
            if(prices[i]>sto.peek())
            {

                int temp=prices[i]-sto.peek();
                ans=Math.max(ans,temp);
            }
            else
            {
                sto.push(prices[i]);
            }
        }

        if(sto.size()==n)
        {
            return 0;
        }
        System.gc();
        return ans;
    }
 */