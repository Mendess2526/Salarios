package Model;

import java.security.InvalidParameterException;

public class Constants {
    public static final int SocialSecurityTaxWorker = 1100;
    public static final int SocialSecurityTaxEmployer = 2375;
    public static final int FCT = 100;

    public static int maritalToPercentage(MaritalStatus m) {
        switch (m) {
            case Single: return 350;
            case Married1: return 120;
            case Married2: return 640;
            default: throw new InvalidParameterException();
        }
    }

    public static int maritalToPercentage2(MaritalStatus m) {
        switch (m) {
            case Single: return 2980;
            case Married1: return 2410;
            case Married2: return 3140;
            default: throw new InvalidParameterException();
        }
    }
}
