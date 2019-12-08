package physics.project;

public class Calc {
	public static double calculateFinalTemperature(double mass1, double mass2, double specificHeat1, double specificHeat2, double temperature1 , double temperature2)
	{
		double numerator = (mass1*specicHeat1*temperature1)+(mass2*specificHeat2*temperature2);
		double denominator = (mass1*specificHeat1)+(mass2*specificHeat2);
		return (numerator/denominator);
	}

	public static double calculateEnergyLoss(temperature1, temperature2)
	{
		return Math.abs(temperature1-temperature2);
	}
	
	public static double calculateFinalMass(mass1, mass2)
	{
		return mass1+mass2;
	}


}
