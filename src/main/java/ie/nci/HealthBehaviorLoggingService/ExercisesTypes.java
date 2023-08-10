package ie.nci.HealthBehaviorLoggingService;

import java.util.Random;

public enum ExercisesTypes {
    RUNNING, SWIMMING, WALKING, CIRCUIT_TRAINING, CYCLING, HIKING, OTHER_WORKOUT;

    private static final Random RAND = new Random();

    public static ExercisesTypes randomExercisesTypes()  {
        ExercisesTypes[] exercisesTypes = values();
        return exercisesTypes[RAND.nextInt(exercisesTypes.length)];
    }
}
