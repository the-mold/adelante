const arr = [2, 8, 7, 1, 3, 5, 6, 4]

function QuickSort(arr, arrStart, arrEnd) {

  console.log("========================================")
  console.log("arrStart", arrStart)
  console.log("arrEnd", arrEnd)

  if (arrStart < arrEnd) {
    let lastSortedElem = Partition(arr, arrStart, arrEnd)

    if (arrStart < lastSortedElem - 1) {
      QuickSort(arr, arrStart, lastSortedElem - 1)
    }

    if (lastSortedElem < arrEnd) {
      QuickSort(arr, lastSortedElem, arrEnd)
    }
  }

  console.log("arr", arr)
  return arr
}

function Partition(arr, arrStart, arrEnd) {

  var i = arrStart - 1
  var pivotValue = arr[arrEnd]
  var j = 0
  var tempValue

  while (j < arrEnd) {
    if (arr[j] <= pivotValue) {
      i++
      tempValue = arr[i]
      //swap
      arr[i] = arr[j]
      arr[j] = tempValue
    }

    j++
  }

  //put pivot after the last sorted elem
  arr[arrEnd] = arr[i + 1]
  arr[i + 1] = pivotValue

  //[2, 1, 3, 4, 7, 5, 6, 8]

  return i + 1
}

//Partition(arr2, 0, arr2.length - 1)

QuickSort(arr, 0, arr.length - 1)

// Average complexity O(n^2)
// it is on average best performing sorting algorithm.