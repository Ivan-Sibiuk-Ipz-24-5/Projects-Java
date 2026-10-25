package tools;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.regex.*;

public class Formatter {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
    private static final DateTimeFormatter T12_FORMAT = DateTimeFormatter.ofPattern("hh:mma (XXX)", Locale.ENGLISH);
    private static final DateTimeFormatter T24_FORMAT = DateTimeFormatter.ofPattern("HH:mm (XXX)", Locale.ENGLISH);

              // format data/time
    public static String formatDateTime(String text) {
        try {
            if (text.startsWith("D(") && text.endsWith(")")) {
                String iso = text.substring(2, text.length() - 1);
                OffsetDateTime dt = OffsetDateTime.parse(iso);
                return dt.format(DATE_FORMAT);
            } else if (text.startsWith("T12(") && text.endsWith(")")) {
                String iso = text.substring(4, text.length() - 1);
                OffsetDateTime dt = OffsetDateTime.parse(iso);
                return dt.format(T12_FORMAT);
            } else if (text.startsWith("T24(") && text.endsWith(")")) {
                String iso = text.substring(4, text.length() - 1);
                OffsetDateTime dt = OffsetDateTime.parse(iso);
                return dt.format(T24_FORMAT);
            }
        } catch (Exception e) {
            return text;
        }
        return text;
    }


    public static String replaceAirportCodes(String line, AirportLookup lookup) {
        if (line == null || line.isEmpty()) return line;

        //  Change *#XXX -> city
        Pattern pCity = Pattern.compile("\\*#([A-Z]{3})");
        Matcher mCity = pCity.matcher(line);
        StringBuffer sb = new StringBuffer();
        while (mCity.find()) {
            String code = mCity.group(1).toUpperCase();
            Airport a = lookup.getByIata(code);
            String replacement = (a != null && a.city != null) ? a.city : "*#" + code;
            mCity.appendReplacement(sb, Matcher.quoteReplacement(replacement));
        }
        mCity.appendTail(sb);
        line = sb.toString();

        //  Change #XXX -> name airoport by IATA
        Pattern pIata = Pattern.compile("#([A-Z]{3})");
        Matcher mIata = pIata.matcher(line);
        sb = new StringBuffer();
        while (mIata.find()) {
            String code = mIata.group(1).toUpperCase();
            Airport a = lookup.getByIata(code);
            String replacement = (a != null && a.name != null) ? a.name : "#" + code;
            mIata.appendReplacement(sb, Matcher.quoteReplacement(replacement));
        }
        mIata.appendTail(sb);
        line = sb.toString();

        //  Change ##XXXX -> name airport by  ICAO
        Pattern pIcao = Pattern.compile("##([A-Z]{4})");
        Matcher mIcao = pIcao.matcher(line);
        sb = new StringBuffer();
        while (mIcao.find()) {
            String code = mIcao.group(1).toUpperCase();
            Airport a = lookup.getByIcao(code);
            String replacement = (a != null && a.name != null) ? a.name : "##" + code;
            mIcao.appendReplacement(sb, Matcher.quoteReplacement(replacement));
        }
        mIcao.appendTail(sb);

        return sb.toString();
    }



    public static List<String> formatRoutes(List<String> routes, AirportLookup lookup) {
        List<String> formatted = new ArrayList<>();
        for (String line : routes) {
            String l = line;
            l = replaceAirportCodes(l, lookup);
            l = formatDateTimeInLine(l);
            formatted.add(l);
        }
        return formatted;
    }


    private static String formatDateTimeInLine(String line) {
        String[] tokens = line.split("\\s+");
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = formatDateTime(tokens[i]);
        }
        return String.join(" ", tokens);
    }
}
