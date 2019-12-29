package demo.model.observer.java;

/**
 * @author Ning
 * @date Create in 2019/3/20
 */
public abstract class AbseractDisplayElement implements DisplayElement {

    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
