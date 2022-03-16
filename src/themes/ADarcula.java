package themes;

import com.formdev.flatlaf.FlatDarculaLaf;

public class ADarcula
        extends FlatDarculaLaf {
    public static final String NAME = "ADarcula";

    public static boolean setup() {
        return setup(new ADarcula());
    }

    public static void installLafInfo() {
        installLafInfo(NAME, ADarcula.class);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
