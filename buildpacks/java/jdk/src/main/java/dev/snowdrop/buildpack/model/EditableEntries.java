package dev.snowdrop.buildpack.model;

import io.sundr.builder.Editable;

public class EditableEntries extends dev.snowdrop.buildpack.model.Entries implements io.sundr.builder.Editable<dev.snowdrop.buildpack.model.EntriesBuilder> {


    public EditableEntries() {
        super();
    }

    public dev.snowdrop.buildpack.model.EntriesBuilder edit() {
        return new EntriesBuilder(this);
    }

}
