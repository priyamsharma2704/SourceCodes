
def findSum(nums, target):
	res = {}
	#print(len(nums))
	for i in range(len(nums)):
		#res[nums[i]] = i
		if nums[i] in res:
			if res[nums[i]] >= 0:
				return [res[nums[i]], i]
		res[target - nums[i]] = i

	print(res)
x = findSum([3,3], 6)
print(x)

y = []
y.append(2)
print(y)
