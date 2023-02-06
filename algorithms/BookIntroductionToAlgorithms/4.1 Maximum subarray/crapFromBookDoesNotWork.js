const arr = [13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7]

function findMaxCrossingSubArray(arr, low, mid, high) {
  //check left side
  let leftSum = 0
  let leftIDX
  let sum = 0
  let i
  for (i = mid; i > low; i--) {
    sum = sum + arr[i]

    if (sum > leftSum) {
      leftIDX = i
      leftSum = sum
    }
  }

  //check right side
  let rightSum = 0
  let rightIDX
  sum = 0
  for (let j = mid + 1; j < high; j++) {
    sum = sum + arr[j]
    if (sum > rightSum) {
      rightIDX = j
      rightSum = sum
    }
  }

  let max = {
    leftIDX,
    rightIDX,
    sum: leftSum + rightSum
  }

  // return object describing the max subarray that crosses the middle.
  return {
    leftIDX,
    rightIDX,
    sum: leftSum + rightSum
  }
}


//2. Find Max Subarray
function findMaxSubarray(arr, low, high) {

  //console.log("arr", arr)
  //console.log("low", low)
  //console.log("high", high)

  //base case/exit recursion: arr consists of 1 element
  if (low === high) {
    return {
      left: low,
      right: high,
      sum: arr[low]
    }
  }

  let mid = Math.floor((high + low) / 2)

  let leftArr = findMaxSubarray(arr, low, mid)
  let rightArr = findMaxSubarray(arr, mid + 1, high)
  let crossArr = findMaxCrossingSubArray(arr, low, mid, high)

  if (leftArr.sum >= rightArr.sum && leftArr.sum >= crossArr.sum) {
    return {
      left: leftArr.low,
      right: leftArr.high,
      sum: sumArray(arr, leftArr.low, leftArr.high)
    }
  } else if (rightArr.sum >= leftArr.sum && rightArr.sum >= crossArr.sum) {
    return {
      left: rightArr.low,
      right: rightArr.high,
      sum: sumArray(arr, rightArr.low, rightArr.high)
    }
  } else {
    return {
      left: crossArr.low,
      right: crossArr.high,
      sum: sumArray(arr, crossArr.low, crossArr.high)
    }
  }
}

function sumArray(arr, low, high) {
  let sum = 0
  for (let i = low; i <= high; i++) {
    sum = sum + arr[i]
  }
  return sum
}


findMaxSubarray(arr, 0, arr.length - 1)
