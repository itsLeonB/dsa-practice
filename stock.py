testCases = [
    {
        "input": [4, 1, 2, 3],
        "want": 6
    },
    {
        "input": [1, 2, 10000000, 1, 2, 10000000],
        "want": 19999999
    },
    {
        "input": [1, 2, 3, 3, 2, 1, 5],
        "want": 7
    }
]


def find_max_profit(stock, holding, day):
    if day == len(stock):
        return 0

    if holding:
        sell = stock[day] + find_max_profit(stock, False, day+1)
        hold = find_max_profit(stock, True, day+1)
        return max(sell, hold)
    else:
        buy = -stock[day] + find_max_profit(stock, True, day+1)
        not_buy = find_max_profit(stock, False, day+1)
        return max(buy, not_buy)


def find_max_profit_dp(prices: list[int]) -> int:
    n = len(prices)
    if n == 0:
        return 0

    dp = [[0] * 2 for _ in range(n)]

    dp[0][1] = prices[0]

    for i in range(1, n):
        dp[i][0] = max(dp[i-1][0], dp[i-1][1] - prices[i])
        dp[i][1] = max(dp[i-1][1], dp[i-1][0] + prices[i])

    return dp[-1][1]


for testCase in testCases:
    got = find_max_profit_dp(testCase["input"])
    try:
        assert got == testCase["want"]
        print("Test case success")
    except:
        print(f"Test case {testCase} fail")
