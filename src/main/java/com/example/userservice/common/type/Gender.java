package com.example.userservice.common.type;

import java.util.Arrays;
import java.util.Optional;

public enum Gender {
    MALE,
    FEMALE;

    private static final Gender[] VALUES = values();

    public static Optional<Gender> of(String value) {
        if (value != null) {
            return Arrays.stream(VALUES)
                    .filter(item -> item.name().equalsIgnoreCase(value.trim()))
                    .findFirst();
        }
        return Optional.empty();
    }
}
