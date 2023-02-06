function BubleSort(arr) {
	if (arr.length === 1) {
		return arr
	}

	let swapped = true;
	let tempVar;
	while (swapped) {
		swapped = false;

		for (let i = 0; i < arr.length; i++) {
			if (arr[i] > arr[i + 1]) {
				console.log("arr[i] ", arr[i] , "  arr[i + 1]", arr[i + 1])

				tempVar = arr[i + 1]
				arr[i + 1] = arr[i]
				arr[i] = tempVar;
				swapped = true;
			}
		}

		console.log("res", arr)
		console.log("--------------------")
	}

	console.log("FINAL RES", arr)
	return arr
}

BubleSort([1,6,2,1,2,4,5,7,8,0])


Principle:
loop through all array while smth is swapped in array. Once condition
arr[i] > arr[i + 1] is met, this arr[i] is reassigned forward till it does not meet
higher arr[i + 1].

Complexity: О(n^2)

Sample output:
arr[i]  6        arr[i + 1] 2
arr[i]  6        arr[i + 1] 1
arr[i]  6        arr[i + 1] 2
arr[i]  6        arr[i + 1] 4
arr[i]  6        arr[i + 1] 5
arr[i]  8        arr[i + 1] 0
res [1, 2, 1, 2, 4, 5, 6, 7, 0, 8]
--------------------
arr[i]  2        arr[i + 1] 1
arr[i]  7        arr[i + 1] 0
res (10) [1, 1, 2, 2, 4, 5, 6, 0, 7, 8]
--------------------