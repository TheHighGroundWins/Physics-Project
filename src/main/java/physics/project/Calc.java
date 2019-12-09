package physics.project;

public class Calc {

    public static double calculateFinalTemperature(double mass1, double mass2, double specificHeat1, double specificHeat2, double temperature1, double temperature2) {
        double numerator = (mass1 * specificHeat1 * temperature1) + (mass2 * specificHeat2 * temperature2);
        double denominator = (mass1 * specificHeat1) + (mass2 * specificHeat2);
        double before = (numerator / denominator);
        int inte = (int)(before*10000);
        double after = ((double)(inte))/10000;
        return after;
    }

    public static double[] calculateEnergyLoss(double mass1, double mass2, double specificHeat1, double specificHeat2, double temperature1, double temperature2) {
        double[] returner = new double[2];
        returner[0] = Math.abs(calculateFinalTemperature(mass1, mass2, specificHeat1, specificHeat2, temperature1, temperature2) - temperature1);
        returner[1] = Math.abs(calculateFinalTemperature(mass1, mass2, specificHeat1, specificHeat2, temperature1, temperature2) - temperature2);
        double[] realReturner = new double[2];
        int int1 = (int) (returner[0] * 10000);
        realReturner[0] = ((double) int1) / 10000;
        int int2 = (int) (returner[1] * 10000);
        realReturner[1] = ((double) int2) / 10000;
        return realReturner;
    }

    public static double calculateFinalMass(double mass1, double mass2) {
        int int1 = (int)(mass1*10000);
        double realMass1 = ((double)int1)/10000;
        int int2 = (int)(mass2*10000);
        double realMass2 = ((double)int2)/10000;
        return realMass1 + realMass2;
    }

}
