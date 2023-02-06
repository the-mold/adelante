let arr = [12, 1 , 2, 4, 5, 6, 7]

function insertionSort(arr) {
	let key;
	let res = arr;
	let i;
	for (let j = 1; j < res.length; j++) {
		//1. temporary store key in variable;
		key = res[j];
		i = j -1;
		while (i > -1 && res[i] > key) {
			//2. if arr[i] is bigger than key then it should be moved to the right to position arr[i+1]
			res[i + 1] = res[i]
			i = i - 1
			console.log("res", res)
		}
		//3. assign key back to arr. Either arr goes to step 2 or not the key is assigned to this place;
		res[i+1] = key;
	}

	return res;
}

//INSIGHT
//console.log of moving target. When cell is moved it is duplicated in the array.
//The duplication is then fixed in step 3 above.
// res (7) [12, 12, 2, 4, 5, 6, 7]
// res (7) [1, 12, 12, 4, 5, 6, 7]
// res (7) [1, 2, 12, 12, 5, 6, 7]
// res (7) [1, 2, 4, 12, 12, 6, 7]
// res (7) [1, 2, 4, 5, 12, 12, 7]
// res (7) [1, 2, 4, 5, 6, 12, 12]


Complexity:
O(n^2)
