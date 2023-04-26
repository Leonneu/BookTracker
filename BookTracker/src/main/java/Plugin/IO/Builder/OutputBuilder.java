package Plugin.IO.Builder;

import Plugin.Application.Model.Entry;

import java.util.List;

public interface OutputBuilder {
    void append(Entry entry);
    void append(List<Entry> entryList);
    String finalise();
    void reset();
}
