package operations;

import java.io.IOException;
import java.sql.SQLException;

public abstract class CRUD {
    public abstract void performOperation() throws SQLException, IOException;
}
