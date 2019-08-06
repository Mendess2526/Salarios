package Model;

import java.security.InvalidParameterException;

public class Constants {
    public static final double SocialSecurityTaxWorker = 0.1100;
    public static final double SocialSecurityTaxEmployer = 23.75;
    public static final double FCT = 0.100;

    public static double retentionTax(MaritalStatus m) {
        switch (m) {
            case Single: return 3.50;
            case Married1: return 1.20;
            case Married2: return 6.40;
            default: throw new InvalidParameterException();
        }
    }

    public static double retentionTax2(MaritalStatus m) {
        switch (m) {
            case Single: return 29.80;
            case Married1: return 24.10;
            case Married2: return 31.40;
            default: throw new InvalidParameterException();
        }
    }
}
