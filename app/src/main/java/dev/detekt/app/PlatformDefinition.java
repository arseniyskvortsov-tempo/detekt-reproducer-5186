package dev.detekt.app;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlatformDefinition {
    private final int id;
    private final String nullable;
    private final String nonNullable;
    private final String undefined;

    public PlatformDefinition(int id, @Nullable String nullable, @NotNull String nonNullable, String undefined) {
        this.id = id;
        this.nullable = nullable;
        this.nonNullable = nonNullable;
        this.undefined = undefined;
    }

    public int getId() {
        return id;
    }

    @Nullable
    public String getNullable() {
        return nullable;
    }

    @NotNull
    public String getNonNullable() {
        return nonNullable;
    }

    public String getUndefined() {
        return undefined;
    }

    public static List<PlatformDefinition> getSample() {
        return List.of(
                new PlatformDefinition(1, null, "sure", "guess it")
        );
    }
    public static List<Map.Entry<String, Integer>> getSampleEntries() {
        var map = new HashMap<String, Integer>();
        map.put(null, 1);
        map.put("sure", 2);
        return List.copyOf(map.entrySet());
    }
}
