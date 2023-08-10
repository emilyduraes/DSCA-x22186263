package ie.nci.CollaborativeDiagnosisService;

import ie.nci.HealthBehaviorLoggingService.ExercisesTypes;

import java.util.Random;

public enum HealthCareProviders {
    NURSE, GENERAL_PRACTITIONER_DOCTOR, PHARMACIST, THERAPIST, OTHER_HEALTHCARE_PROVIDER;

    private static final Random RAND = new Random();

    public static HealthCareProviders randomHealthCareProviders()  {
        HealthCareProviders[] healthCareProviders = values();
        return healthCareProviders[RAND.nextInt(healthCareProviders.length)];
    }
}
