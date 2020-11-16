package pl.nullpointerexeption.restapi;

public class PrzykladowaKlasa1 {

    //Przykłady definiowania zmiennych

    private char znak = 'a';
    private String napisPrywatny = "napisPrywatny";
    public String napisPubliczny = "napisPubliczny";
    public int number1 = 1;
    public long number4 = 1L;
    public float number2 = 1.1231231231231f;
    public double number3 = 1.12312123123123;
    public Integer wrappedNumber1 = 1;
    public Integer wrappedNumber11 = Integer.valueOf("1");
    public Long wrappedNumber2 = 1L;
    public Long wrappedNumber22 = Long.valueOf("1");
    public Float wrappedNumber3 = 1.123123123f;
    public Float wrappedNumber33 = Float.valueOf("1.123123123");
    public Double wrappedNumber4 = 1.123123123123;
    public Double wrappedNumber44 = Double.valueOf("1.123123123123");

    //Przykłady definiowania stałych

    public final String poleFinalneNiezainicjalizowane; // Musi być zainicjalizowane w konstruktorze
    public static final String POLE_FINALNE_2 = "poleFinalne"; // Może być użyte bez tworzenia obiektu tej klasy

    //Przykłady definiowania konstruktorów

    public PrzykladowaKlasa1(String poleFinalneNiezainicjalizowane) {
        this.poleFinalneNiezainicjalizowane = poleFinalneNiezainicjalizowane;
    }

    public PrzykladowaKlasa1(char znak,
                             String napisPrywatny,
                             int number1,
                             long number4,
                             float number2,
                             double number3,
                             Integer wrappedNumber1,
                             Integer wrappedNumber11,
                             Long wrappedNumber2,
                             Long wrappedNumber22,
                             Float wrappedNumber3,
                             Float wrappedNumber33,
                             Double wrappedNumber4,
                             Double wrappedNumber44,
                             String poleFinalneNiezainicjalizowane) {
        this.znak = znak;
        this.napisPrywatny = napisPrywatny;
        this.number1 = number1;
        this.number4 = number4;
        this.number2 = number2;
        this.number3 = number3;
        this.wrappedNumber1 = wrappedNumber1;
        this.wrappedNumber11 = wrappedNumber11;
        this.wrappedNumber2 = wrappedNumber2;
        this.wrappedNumber22 = wrappedNumber22;
        this.wrappedNumber3 = wrappedNumber3;
        this.wrappedNumber33 = wrappedNumber33;
        this.wrappedNumber4 = wrappedNumber4;
        this.wrappedNumber44 = wrappedNumber44;
        this.poleFinalneNiezainicjalizowane = poleFinalneNiezainicjalizowane;
    }

    // Gettery i Settery

    public char getZnak() {
        return znak;
    }

    public void setZnak(char znak) {
        this.znak = znak;
    }

    public String getNapisPrywatny() {
        return napisPrywatny;
    }

    public void setNapisPrywatny(String napisPrywatny) {
        this.napisPrywatny = napisPrywatny;
    }

    public String getNapisPubliczny() {
        return napisPubliczny;
    }

    public void setNapisPubliczny(String napisPubliczny) {
        this.napisPubliczny = napisPubliczny;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public long getNumber4() {
        return number4;
    }

    public void setNumber4(long number4) {
        this.number4 = number4;
    }

    public float getNumber2() {
        return number2;
    }

    public void setNumber2(float number2) {
        this.number2 = number2;
    }

    public double getNumber3() {
        return number3;
    }

    public void setNumber3(double number3) {
        this.number3 = number3;
    }

    public Integer getWrappedNumber1() {
        return wrappedNumber1;
    }

    public void setWrappedNumber1(Integer wrappedNumber1) {
        this.wrappedNumber1 = wrappedNumber1;
    }

    public Integer getWrappedNumber11() {
        return wrappedNumber11;
    }

    public void setWrappedNumber11(Integer wrappedNumber11) {
        this.wrappedNumber11 = wrappedNumber11;
    }

    public Long getWrappedNumber2() {
        return wrappedNumber2;
    }

    public void setWrappedNumber2(Long wrappedNumber2) {
        this.wrappedNumber2 = wrappedNumber2;
    }

    public Long getWrappedNumber22() {
        return wrappedNumber22;
    }

    public void setWrappedNumber22(Long wrappedNumber22) {
        this.wrappedNumber22 = wrappedNumber22;
    }

    public Float getWrappedNumber3() {
        return wrappedNumber3;
    }

    public void setWrappedNumber3(Float wrappedNumber3) {
        this.wrappedNumber3 = wrappedNumber3;
    }

    public Float getWrappedNumber33() {
        return wrappedNumber33;
    }

    public void setWrappedNumber33(Float wrappedNumber33) {
        this.wrappedNumber33 = wrappedNumber33;
    }

    public Double getWrappedNumber4() {
        return wrappedNumber4;
    }

    public void setWrappedNumber4(Double wrappedNumber4) {
        this.wrappedNumber4 = wrappedNumber4;
    }

    public Double getWrappedNumber44() {
        return wrappedNumber44;
    }

    public void setWrappedNumber44(Double wrappedNumber44) {
        this.wrappedNumber44 = wrappedNumber44;
    }

    public String getPoleFinalneNiezainicjalizowane() {
        return poleFinalneNiezainicjalizowane;
    }

    public static String getPoleFinalne2() {
        return POLE_FINALNE_2;
    }

    // Przykłady definiowania metod

    public void metodaCoNicNieZwraca() {
        System.out.println("metodaCoNicNieZwraca");
    }

    public void metodaCoNicNieZwracaZParametrami(String jakisNapis, int jakasLiczba) {
        System.out.println("metodaCoNicNieZwracaZParametrami: " + jakisNapis + " , " + jakasLiczba);
    }

    public int metodaCoCosZwraca() {
        System.out.println("metodaCoCosZwraca");
        return 123;
    }

    public int metodaCoCosZwracaZParametrami(int jakasCyfra, PrzykladowaKlasa2 przykladowaKlasa2) {
        System.out.println("metodaCoCosZwracaZParametrami");
        return jakasCyfra;
    }

    // Przykłady definiowania metod statycznych

    public static void metodaStatycznaCoNicNieZwraca() {
        System.out.println("metodaStatycznaCoNicNieZwraca");
    }

    public static void metodaStatycznaCoNicNieZwracaZParametrami(String jakisNapis, int jakasLiczba) {
        System.out.println("metodaStatycznaCoNicNieZwracaZParametrami: " + jakisNapis + " , " + jakasLiczba);
    }

    public static int metodaStatycznaCoCosZwraca() {
        System.out.println("metodaStatycznaCoCosZwraca");
        return 234536;
    }

    public static int metodaStatycznaCoCosZwracaZParametrami(int jakasCyfra, PrzykladowaKlasa2 przykladowaKlasa2) {
        System.out.println("metodaStatycznaCoCosZwracaZParametrami");
        return jakasCyfra;
    }
}
