public class Main {
    public static void main(String[] args) {
        PhoneStation phoneStation = new PhoneStation();
        Operator operator1 = new Operator(phoneStation, "Оператор 1");
        Operator operator2 = new Operator(phoneStation, "Оператор 2");
        Operator operator3 = new Operator(phoneStation, "Оператор 3");
        Operator operator4 = new Operator(phoneStation, "Оператор 4");
        Operator operator5 = new Operator(phoneStation, "Оператор 5");
        phoneStation.start();
        operator1.start();
        operator2.start();
        operator3.start();
        operator4.start();
        operator5.start();
    }
}
