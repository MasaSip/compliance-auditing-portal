package na.org.ecb.complianceauditingportal.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.Instant;

public class InstantTimeSerializer extends StdSerializer<Instant> {

    public InstantTimeSerializer() {
        super(Instant.class);
    }

    @Override
    public void serialize(Instant value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeString(value.toString());
    }
}