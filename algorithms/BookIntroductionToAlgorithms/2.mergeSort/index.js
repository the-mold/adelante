let Arr = [1, 4, 10, 2, 6, 20]
let Arr2 = [5,78,9,3,21,2]

function mergeSort(arr) {
	if (arr.length === 1) {
		return arr
	}

	let middle = Math.floor(arr.length / 2)
	let left = arr.slice(0, middle)
	let right = arr.slice(middle)

	return merge(mergeSort(left), mergeSort(right))
}

function merge(left, right) {
	let res = []
	let leftIDX = 0
	let rightIDX = 0

	while (leftIDX < left.length || rightIDX < right.length) {
		if (leftIDX < left.length && rightIDX < right.length){
			if (left[leftIDX] < right[rightIDX]){
				res.push(left[leftIDX]);
				leftIDX++;
			}else{
				res.push(right[rightIDX]);
				rightIDX++
			}
		} else if (leftIDX < left.length){
			res.push(left[leftIDX]);
			leftIDX++;
		} else{
			res.push(right[rightIDX]);
			rightIDX++;
		}
	}

	console.log("res", res)

	return res;
}

mergeSort(Arr)


//Principle:
//Divide the initial arr into subarrays(down to arrays with just one number in left and right arrays)
//and then merge them into the final array recursively.

Complexity: О(ln n)
