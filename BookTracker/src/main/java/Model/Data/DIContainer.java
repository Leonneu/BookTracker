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

}
