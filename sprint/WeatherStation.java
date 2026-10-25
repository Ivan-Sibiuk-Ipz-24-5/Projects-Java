package sprint;

import java.util.*;

public class WeatherStation {
    private final Map<Integer, String> idToKey = new HashMap<>();
    private final Map<Integer, Double> state = new HashMap<>();

    public WeatherStation() {
        idToKey.put(1, "airTemp");
        idToKey.put(2, "airPressure");
        idToKey.put(7, "precipitation");
        idToKey.put(11, "windSpeed");
        idToKey.put(12, "windDirection");
        idToKey.put(13, "humidity");
        idToKey.put(14, "dewPoint");
        idToKey.put(15, "soilMoisture");
        idToKey.put(22, "cloudCover");
    }

    public void updateState(String message) {
        if (message.isEmpty()) {
            return;
        }
        String[] lines = message.split("\n");
        for (String line : lines) {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0]);
            if (!idToKey.containsKey(id)) {
                continue;
            }
            Double val;
            if (parts[1].equals("NULL")) {
                val = null;
            } else {
                val = Double.parseDouble(parts[1]);
            }
            state.put(id, val);
        }
    }

    public String getState() {
        StringBuilder sb = new StringBuilder();
        List<Integer> sortedIds = new ArrayList<>(idToKey.keySet());
        Collections.sort(sortedIds);
        for (Integer id : sortedIds) {
            String key = idToKey.get(id);
            Double val = state.get(id);
            sb.append(key).append(":");
            if (val == null) {
                sb.append("NULL");
            } else {
                sb.append(val);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void clearState() {
        state.clear();
    }
}