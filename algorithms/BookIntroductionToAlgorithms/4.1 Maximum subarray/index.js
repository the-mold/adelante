// Time complexity: O(N).

const arr = [13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7]

function FindMaxSubArray(arr) {
  let currentMax = 0
  let max = 0
  for (let i = 0; i < arr.length; i++) {
    currentMax = Math.max(0, currentMax + arr[i])
    max = Math.max(max, currentMax)
  }

  return max
}

FindMaxSubArray(arr) //returns 43: subarray [18, 20, -7, 12]
