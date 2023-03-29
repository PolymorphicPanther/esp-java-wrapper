package org.jesp.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Class for Day Stages
 *
 * @param stages - stages
 */
@JsonDeserialize(using = StageSerializer.class)
public record DayStages(Stage[] stages) {
}

class StageSerializer extends StdDeserializer<DayStages> {
    protected StageSerializer(Class<?> vc) {
        super(vc);
    }

    protected StageSerializer() {
        super(DayStages.class);
    }

    @Override
    public DayStages deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        var node = p.getCodec().readTree(p);
        var stagesStr = node.toString();

        var stages = new ObjectMapper().readValue(stagesStr, String[][].class);

        var outputStages = new ArrayList<Stage>(8);
        for (String[] stage : stages) {
            var slots = new ArrayList<Slot>(3);
            for (String s : stage) {
                var arr = s.split("-");
                slots.add(new Slot(arr[0], arr[1]));
            }
            outputStages.add(new Stage(slots.toArray(new Slot[0])));
        }

        var stagesArr = outputStages.toArray(new Stage[0]);
        return new DayStages(stagesArr);
    }
}
