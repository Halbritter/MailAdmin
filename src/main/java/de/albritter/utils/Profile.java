package de.albritter.utils;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class Profile {
    @Setter
    @Getter

    private String dbname;
    @Setter
    @Getter
    private String username;
    @Setter
    @Getter
    private String server;
    @Setter
    @Getter
    private int id;
}
