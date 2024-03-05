def two_sum(nums: list[int], target: int) -> list[int]:
    diction = {}
    n = len(nums)

    for i in range(n):
        complement = target - nums[i]
        if complement in diction.keys():
            return [diction[complement], i]
        diction[nums[i]] = i


def main():
    nums = list(map(int, input().split(" ")))
    target = int(input().strip())
    print(two_sum(nums, target))


if __name__ == "__main__":
    main()