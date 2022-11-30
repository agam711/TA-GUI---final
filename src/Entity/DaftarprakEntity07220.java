
package Entity;

public class DaftarprakEntity07220 {
    private PraktikanEntity07220 praktikan;
    private boolean isVerified;
    private int IndexPraktikum;

    public DaftarprakEntity07220(PraktikanEntity07220 praktikan, boolean isVerified, int IndexPraktikum) {
        this.praktikan = praktikan;
        this.isVerified = isVerified;
        this.IndexPraktikum = IndexPraktikum;
    }

    public PraktikanEntity07220 getPraktikan() {
        return praktikan;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public int getIndexPraktikum() {
        return IndexPraktikum;
    }

    public void setIndexPraktikum(int IndexPraktikum) {
        this.IndexPraktikum = IndexPraktikum;
    }
}
