package StateLogic;

import Model.Library;

public enum State {
    INIT(new IConsoleCommand[]{new LoadLibrary(),new Exit()}),
    MAIN(new IConsoleCommand[]{new ShowLibrary(),new EditLibrary(),new ShowWishList(),new EditWishList(),new ShowStatistics(),new Exit()}),
    EDITLIBRARY(new IConsoleCommand[]{new AddBook(),new DeleteBook(),new Cancle()}),
    EDITWISHLIST(new IConsoleCommand[]{new AddBook(),new DeleteBook(),new Cancle()}),
    EXIT(new IConsoleCommand[]{});

    public final IConsoleCommand[] options;
    public Library library;
    public Library wishlist;

    State(IConsoleCommand[] options) {
        this.options =options;
    }

}
