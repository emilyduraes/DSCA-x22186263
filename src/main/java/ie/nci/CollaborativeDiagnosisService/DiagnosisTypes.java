package ie.nci.CollaborativeDiagnosisService;

import ie.nci.HealthBehaviorLoggingService.ExercisesTypes;

import java.util.Random;

public enum DiagnosisTypes {
    ALZHEIMER_DISEASE, ARRHYTHMIA, ARTHRITIS, ALLERGIES, COLD_FLU, CONJUNCTIVITIS, OTHER_DIAGNOSIS;

    private static final Random RAND = new Random();

    public static DiagnosisTypes randomDiagnosisTypes()  {
        DiagnosisTypes[] diagnosisTypes = values();
        return diagnosisTypes[RAND.nextInt(diagnosisTypes.length)];
    }
}
