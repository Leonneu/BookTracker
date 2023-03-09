package Model.Data;

import java.util.Objects;

public final class DIContainer {
    private Library library;
    private Library wishList;

    public DIContainer(
            Library library,
            Library wishList
    ) {
        this.library = library;
        this.wishList = wishList;
    }

    public Library GetLibrary() {
        return library;
    }
    public void SetLibrary(Library library) {
        this.library = library;
    }

    public Library GetWishList() {
        return wishList;
    }

    public void SetWishlist(Library library) {
        wishList = library;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (DIContainer) obj;
        return Objects.equals(this.library, that.library) &&
                Objects.equals(this.wishList, that.wishList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(library, wishList);
    }

    @Override
    public String toString() {
        return "DIContainer[" +
                "library=" + library + ", " +
                "wishList=" + wishList + ']';
    }


}
