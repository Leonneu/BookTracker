package ConsoleCommands;

import Plugin.Application.Model.Entry;
import Plugin.IO.Builder.OutputBuilder;

import java.util.List;

public class OutputBuilderMock implements OutputBuilder {
    public boolean finaliseWasCalled = false;
    public boolean resetWasCalled = false;

    @Override
    public void append(Entry entry) {
        return;
    }

    @Override
    public void append(List<Entry> entryList) {
        return;
    }

    @Override
    public String finalise() {
        finaliseWasCalled = true;
        return "";
    }

    @Override
    public void reset() {
        resetWasCalled = true;
    }

    public void resetMock() {
        resetWasCalled = false;
        finaliseWasCalled = false;
    }
}
