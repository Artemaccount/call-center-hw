public class Main {
    private static int opsCount = 5;
    public static void main(String[] args) {
        PhoneStation phoneStation = new PhoneStation();
        phoneStation.start();
        for(int i = 1; i <= opsCount; i++){
            new Operator(phoneStation, ("Оператор " + i)).start();
        }
    }
}
