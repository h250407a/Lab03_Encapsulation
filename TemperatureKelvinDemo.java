// Shows encapsulation shielding internal representation (Kelvin) while providing stable APIs.
class TemperatureKelvin {
    // Internal representation: always stored in Kelvin
    private double kelvin;

    public TemperatureKelvin(double kelvin) {
        setKelvin(kelvin);
    }

    public void setKelvin(double kelvin) {
        if (kelvin < 0.0) {
            throw new IllegalArgumentException("Temperature cannot be below absolute zero (0.0 K). Given: " + kelvin);
        }
        this.kelvin = kelvin;
    }

    public double getKelvin() {
        return kelvin;
    }

    // Public API exposing Celsius
    public double getCelsius() {
        return kelvin - 273.15;
    }

    public void setCelsius(double celsius) {
        setKelvin(celsius + 273.15);
    }

    // Public API exposing Fahrenheit
    public double getFahrenheit() {
        return (getCelsius() * 9.0 / 5.0) + 32.0;
    }

    public void setFahrenheit(double fahrenheit) {
        double c = (fahrenheit - 32.0) * 5.0 / 9.0;
        setCelsius(c);
    }
}

public class TemperatureKelvinDemo {
    public static void main(String[] args) {
        // Create temperature object at boiling point of water (100 C = 373.15 K)
        TemperatureKelvin temp = new TemperatureKelvin(373.15);
        System.out.printf("Internal: %.2f K | Celsius: %.2f °C | Fahrenheit: %.2f °F%n",
                temp.getKelvin(), temp.getCelsius(), temp.getFahrenheit());

        temp.setCelsius(25.0); // Room temperature
        System.out.printf("After setting to 25°C -> Internal: %.2f K | Fahrenheit: %.2f °F%n",
                temp.getKelvin(), temp.getFahrenheit());

        // Demonstrating validation against values below absolute zero
        try {
            System.out.println("\nAttempting to set temperature below absolute zero (-300 °C):");
            temp.setCelsius(-300.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught invariant violation: " + e.getMessage());
        }

        System.out.println("\nEncapsulation benefit:");
        System.out.println("The internal representation can change (e.g. from Celsius to Kelvin) without breaking external code using getCelsius() or getFahrenheit().");
    }
}
