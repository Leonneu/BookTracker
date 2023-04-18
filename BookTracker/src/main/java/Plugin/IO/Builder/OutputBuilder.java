package Plugin.IO.Builder;

import Plugin.Application.Model.Entry;

import java.util.List;

public interface OutputBuilder {
    public void append(Entry entry);
    public void append(List<Entry> entryList);
    public String finalise();
}
