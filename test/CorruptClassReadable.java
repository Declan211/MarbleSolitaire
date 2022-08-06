import java.io.IOException;
import java.nio.CharBuffer;


/**
 * corrupt class for readable.
 */
public class CorruptClassReadable implements Readable {

  @Override
  public int read(CharBuffer cb) throws IOException {
    throw new IOException("Reading failed");
  }
}
