package org.milan.marker;

/**
 * Custom marker interface
 * <p>
 * Here this marker interface is indicating to JVM about the runtime
 * behavior of objects. If class implement this interface,
 * it can be deleted from database
 *
 * @author Milan Rathod
 */
public interface CustomMarker {
}

/**
 * A class implementing {@link CustomMarker} interface
 */
class CustomMarkerClass implements CustomMarker {

}

/**
 * Normal class
 */
class NormalClass {

}

/**
 * Dummy Service class
 * <p>
 * Service class responsible for delete any Object from database
 * based on condition that object must be subclass of {@link CustomMarker}
 */
class CustomService {
    public boolean delete(Object o) {

        // Object is instance of CustomMarker we can delete it otherwise we can't
        if (!(o instanceof CustomMarker)) {
            return false;
        }
        // Delete implementation details
        // ...............
        return true;
    }
}
