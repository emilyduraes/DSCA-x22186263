package ie.nci.CollaborativeDiagnosisService;

import java.util.Random;

public enum HealthCareProviders {
    NURSE, GENERAL_PRACTITIONER_DOCTOR, PHARMACIST, THERAPIST, OTHER_HEALTHCARE_PROVIDER;

    private static final Random RAND = new Random();

    public static HealthCareProviders randomHealthCareProviders()  {
        HealthCareProviders[] healthCareProviders = values();
        return healthCareProviders[RAND.nextInt(healthCareProviders.length)];
    }
}
