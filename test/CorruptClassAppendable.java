import java.io.IOException;

/**
 * Corrupt class for appendable.
 */
public class CorruptClassAppendable implements Appendable {

  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("Transmission to view failed");
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("Transmission to view failed");
  }

  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("Transmission to view failed");
  }
}
