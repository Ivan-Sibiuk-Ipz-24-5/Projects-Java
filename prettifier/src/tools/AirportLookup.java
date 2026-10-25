package tools;

import java.io.*;
import java.util.*;

public class AirportLookup {
    private Map<String, Airport> icaoMap = new HashMap<>();
    private Map<String, Airport> iataMap = new HashMap<>();

    public AirportLookup(String csvPath) throws IOException {
        File f = new File(csvPath);
        if (!f.exists()) throw new FileNotFoundException("Airport lookup not found");

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String header = br.readLine();
            if (header == null) throw new IOException("Airport lookup malformed");


            String[] columns = header.split(",");
            Map<String, Integer> idx = new HashMap<>();
            for (int i = 0; i < columns.length; i++) idx.put(columns[i].trim(), i);

            String line;
            while ((line = br.readLine()) != null) {
                String[] cells = line.split(",", -1);
                if (cells.length < 6) throw new IOException("Airport lookup malformed");
                for (String c : cells) if (c.trim().isEmpty()) throw new IOException("Airport lookup malformed");

                String name = cells[idx.get("name")].trim();
                String iso = cells[idx.get("iso_country")].trim();
                String city = cells[idx.get("municipality")].trim();
                String icao = cells[idx.get("icao_code")].trim();
                String iata = cells[idx.get("iata_code")].trim();

                Airport a = new Airport(name, iso, city, icao, iata);
                if (!icao.isEmpty()) icaoMap.put(icao, a);
                if (!iata.isEmpty()) iataMap.put(iata, a);
            }
        }
    }

    public Airport getByIcao(String icao) {
        if (icao == null) return null;
        return icaoMap.get(icao.trim().toUpperCase());
    }


    public Airport getByIata(String iata) {
        return iataMap.get(iata);
    }
}
