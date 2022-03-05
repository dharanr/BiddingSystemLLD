package Services;

import java.util.concurrent.atomic.AtomicLong;

public class IdentifierService {
    private AtomicLong count = new AtomicLong(1);
    private static IdentifierService idGeneratorService = new IdentifierService();
     
    public static IdentifierService getInstance() {
      return idGeneratorService;
    }
  
    public long generate() {
      return count.getAndIncrement();
    }
}
