public class Main {
    static String arrToString(double[] arr) {
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            res = res.concat("[" + arr[i] + "]");
        }

        return res;
    }

    static public void report(double[][] data) {
        int numberOfDays = data.length;
        int numberOfChecks = data[0].length;

        // get average for each day
        double[] dayAverageArr = new double[numberOfDays];
        for (int i = 0; i < numberOfDays; i++) {
            double daySum = 0;
            for (int j = 0; j < numberOfChecks; j++) {
                daySum = daySum + data[i][j];
            }

            System.out.println(daySum);

            dayAverageArr[i] = daySum / numberOfChecks;
        }

        System.out.println(arrToString(dayAverageArr));

        // get total avarage
        double totalAverage;
        double totalSum = 0;
        for (int j = 0; j < dayAverageArr.length; j++) {
            totalSum = totalSum + dayAverageArr[j];
        }
        totalAverage = totalSum / dayAverageArr.length;

        double diff;
        int idx;
        for (int j = 0; j < dayAverageArr.length; j++) {
            diff = dayAverageArr[j] - totalAverage;
            idx = j + 1;
            System.out.println("Temp on day " + idx + " is " + Math.round(diff * 100.0) / 100.0 + " different from the overall average.");
        }
    }

    static public void main(String[] args) {
        double[][] data = {
                {18.3, 21.0, 22.2, 19.7},
                {23.0, 24.1, 19.6, 20.1},
                {16.3, 18.5, 20.4, 19.2}
        };

        report(data);
    }
}
