package fr.takoyadev.car.back.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecurityConst {

    public static final String SCOPE_READ_CARS = "read:cars";
    public static final String SCOPE_WRITE_CARS = "write:cars";
    public static final String SCOPE_READ_MAINTENANCE = "read:maintenance";
    public static final String SCOPE_WRITE_MAINTENANCE = "write:maintenance";
    public static final String SCOPE_READ_LABEL = "read:label";
    public static final String SCOPE_WRITE_LABEL = "write:label";
    public static final String SCOPE_READ_OWNER = "read:owner";
    public static final String SCOPE_WRITE_OWNER = "write:owner";

}
